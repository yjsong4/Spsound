package com.syj.spsound.music;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syj.spsound.music.service.MusicService;
import com.syj.spsound.spotify.service.SpotifyService;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/music")
@RestController
public class MusicRestController {
	
	@Autowired
	private MusicService musicService;
	
	@Autowired
	private SpotifyService spotifyService;
	
//	private static final String accessToken = "BQDcSFF1JUi3-lWhBkr2wsAMBHQxsPTGr7U7a0fHPJ1j6S8C6Lszp8vz61fRPodN29VvH9oGrm7nbVJwxA1qQTKmiSYK09Oe_7iZaHIyyFJY3xxV3i0";
	private static final String q = "Taylor Swift";

	@PostMapping("/select/genre")
	public Map<String, String> chooseGenre(
			@RequestParam("genre") String genre
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");

		int count = musicService.chooseGenre(userId, genre);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@DeleteMapping("/delete/genre")
	public Map<String, String> deleteGenre(
			@RequestParam("genre") String genre
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = musicService.deleteGenre(userId, genre);

		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@PostMapping("/select/artist")
	public Map<String, String> chooseArtist(
			@RequestParam("artist") String artist
			, HttpSession session) {
		
		int userId = (Integer) session.getAttribute("userId");
		
		int count = musicService.chooseArtist(userId, artist);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@DeleteMapping("/delete/artist")
	public Map<String, String> deleteArtist(
			@RequestParam("artist") String artist
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = musicService.deleteArtist(userId, artist);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;		
	}
	
	@GetMapping("/spotify/token")
	public String token() {
		
		return SpotifyService.accesstoken();	
	}
	
	@GetMapping("/spotify/search")
	public Paging<Track> search() throws ParseException, SpotifyWebApiException, IOException {
		
		SpotifyApi spotifyApi = new SpotifyApi.Builder()
	            .setAccessToken(SpotifyService.accesstoken())
	            .build();
		
//		spotifyApi.setAccessToken(accessToken);
				
		SearchTracksRequest searchTrackRequest = spotifyApi.searchTracks(q)
                .limit(10)
                .build();
		
		Paging<Track> searchResult = searchTrackRequest.execute();
		
		return searchResult;

	}
	
}
