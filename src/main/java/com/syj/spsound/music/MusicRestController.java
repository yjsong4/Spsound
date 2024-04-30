package com.syj.spsound.music;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syj.spsound.music.dto.SearchResult;
import com.syj.spsound.music.service.MusicService;
import com.syj.spsound.spotify.service.SpotifyService;

import jakarta.servlet.http.HttpSession;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

@RequestMapping("/music")
@RestController
public class MusicRestController {
	
	@Autowired
	private MusicService musicService;
	
	@Autowired
	private SpotifyService spotifyService;
	
//	private static final String accessToken = "BQDcSFF1JUi3-lWhBkr2wsAMBHQxsPTGr7U7a0fHPJ1j6S8C6Lszp8vz61fRPodN29VvH9oGrm7nbVJwxA1qQTKmiSYK09Oe_7iZaHIyyFJY3xxV3i0";
//	private static final String keyword = "Pop";  // artist, year, album, genre, track ...

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
	
	@GetMapping("/spotify/search")
	public List<SearchResult> search(@RequestParam("keyword") String keyword) throws ParseException, SpotifyWebApiException, IOException {

		return spotifyService.searchByKeyword(keyword);
	}
	
	@PostMapping("/add/keyword")
	public Map<String, String> addKeyword(
			@RequestParam("keyword") String keyword
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = musicService.addKeyword(userId, keyword);
				
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@PostMapping("/add/playlist")
	public Map<String, String> addPlaylist(
			@RequestParam("musicId") String musicId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = musicService.addPlaylist(userId, musicId);
				
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}

//	@GetMapping("/musicids")
//	public List<SearchResult> musicId(HttpSession session) throws ParseException, SpotifyWebApiException, IOException {
//		
//		int userId = (Integer)session.getAttribute("userId");
//		
//		return spotifyService.getPlaylist(userId);
//	}
	
	@DeleteMapping("/delete/playlist")
	public Map<String, String> deletePlaytist(
			@RequestParam("musicId") String musicId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = musicService.deletePlaylist(userId, musicId);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;		
	}
	
}
