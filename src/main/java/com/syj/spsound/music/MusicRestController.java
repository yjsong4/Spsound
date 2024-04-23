package com.syj.spsound.music;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.syj.spsound.common.CreateToken;
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
	
	@GetMapping("/search")
	public String Search() {
		
		String accessToken = CreateToken.accesstoken();
		
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Host", "api.spotify.com");
        headers.add("Content-type", "application/json");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://api.spotify.com/v1/search?type=track&q=" + "peaches", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = (HttpStatus) responseEntity.getStatusCode();
        int status = httpStatus.value(); //상태 코드가 들어갈 status 변수
        String response = responseEntity.getBody();

        return response;
	}	
}
