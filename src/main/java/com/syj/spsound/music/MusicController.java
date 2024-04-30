package com.syj.spsound.music;

import java.io.IOException;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syj.spsound.music.dto.Choice;
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
	public String genre(
			Model model
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<Choice> genreList = musicService.getGenreList(userId);
		
		model.addAttribute("genreList", genreList);
		
		return "music/genre";
	}
	
	@GetMapping("/select-artist-view")
	public String artist(
			Model model
			, HttpSession session) {
		
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
	public String playlist(Model model, HttpSession session) throws ParseException, SpotifyWebApiException, IOException {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<SearchResult> playlist = spotifyService.getPlaylist(userId);
		
		model.addAttribute("playlist", playlist);
		
		return "music/playlist";
	}
	
	@GetMapping("/discover-view")
	public String discover() {
		
		return "music/discover";
	}

}
