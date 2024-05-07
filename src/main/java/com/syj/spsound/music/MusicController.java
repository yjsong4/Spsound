package com.syj.spsound.music;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syj.spsound.music.dto.Choice;
import com.syj.spsound.music.dto.Count;
import com.syj.spsound.music.dto.SearchResult;
import com.syj.spsound.music.service.MusicService;
import com.syj.spsound.spotify.service.SpotifyService;

import jakarta.servlet.http.HttpSession;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

@RequestMapping("/spsound")
@Controller
public class MusicController {
	
	@Autowired
	private MusicService musicService;

	@Autowired
	private SpotifyService spotifyService;
	
	@GetMapping("/select-genre-view")
	public String genre(HttpSession session, Model model) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<Choice> genreList = musicService.getGenreList(userId);
		
		model.addAttribute("genreList", genreList);
		
		return "music/genre";
	}
	
	@GetMapping("/select-artist-view")
	public String artist(HttpSession session, Model model) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<Choice> artistList = musicService.getArtistList(userId);
		
		model.addAttribute("artistList", artistList);
		
		return "music/artist";
	}
	
	@GetMapping("/main-view")
	public String mainPage() {
		
		return "music/main";
	}
	
	@GetMapping("/tracklist-view")
	public String tracklist(@RequestParam("keyword") String keyword, Model model) throws ParseException, SpotifyWebApiException, IOException {
		
		List<SearchResult> searchResultList = spotifyService.searchByKeyword(keyword);
		
		model.addAttribute("searchResultList", searchResultList);
		
		return "music/tracklist";
	}
	
	@GetMapping("/playlist-view")
	public String playlist(HttpSession session, Model model) throws ParseException, SpotifyWebApiException, IOException {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<SearchResult> playlist = spotifyService.getPlaylist(userId);
		
		model.addAttribute("playlist", playlist);
		
		return "music/playlist";
	}

	@GetMapping("/discover-view")
	public String discoverGenre(HttpSession session, Model model) {
		
		int myId = (Integer)session.getAttribute("userId");
		int idsByGenre = 0;
		
		List<Count> genreCountList = musicService.getUserByGenre(myId);
		List<Count> idsByGenreCount = new ArrayList<>();
		
		for(Count countByGenre:genreCountList) {
			
			idsByGenre = countByGenre.getUserId();
			
			if(myId != idsByGenre) {
				countByGenre.setUserId(idsByGenre);
				idsByGenreCount.add(countByGenre);
			}
		}
		model.addAttribute("idsByGenreCount", idsByGenreCount);
		
		int idsByArtist = 0;
		
		List<Count> artistCountList = musicService.getUserByArtist(myId);
		List<Count> idsByArtistCount = new ArrayList<>();
		
		for(Count countByArtist:artistCountList) {
			
			idsByArtist = countByArtist.getUserId();
			
			if(myId != idsByArtist) {
				countByArtist.setUserId(idsByArtist);
				idsByArtistCount.add(countByArtist);
			}
		}
		model.addAttribute("idsByArtistCount", idsByArtistCount);
		
		return "music/discover";
	}

	@GetMapping("/othersPlaylists-view")
	public String othersPlaylists(@RequestParam("userId") int userId, Model model) throws ParseException, SpotifyWebApiException, IOException {
		
		List<SearchResult> othersPlaylists = spotifyService.getPlaylist(userId);
		
		model.addAttribute("othersPlaylists", othersPlaylists);
				
		return "music/othersPlaylists";
	}
	
	@GetMapping("/artistTopTrack-view")
	public String artistTopTrack(HttpSession session, Model model) throws ParseException, SpotifyWebApiException, IOException {
		
		int userId = (Integer)session.getAttribute("userId");

		List<SearchResult> artistTopTrackList = spotifyService.getArtistTopTrack(userId);
		
		model.addAttribute("artistTopTrackList", artistTopTrackList);
		
		return "music/artistTopTrack";
	}
	
	@GetMapping("/relatedArtists-view")
	public String relatedArtists(HttpSession session, Model model) throws ParseException, SpotifyWebApiException, IOException {
		
		int userId = (Integer)session.getAttribute("userId");

		List<SearchResult> relatedArtistsList = spotifyService.getRelatedArtists(userId);
		
		model.addAttribute("relatedArtistsList", relatedArtistsList);
		
		return "music/relatedArtists";
	}
}
