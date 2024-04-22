package com.syj.spsound.music;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syj.spsound.music.service.MusicService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/music")
@RestController
public class MusicRestController {
	
	@Autowired
	private MusicService musicService;
	
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
	
}
