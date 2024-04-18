package com.syj.spsound.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.syj.spsound.music.service.MusicService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MusicController {
	
	@Autowired
	private MusicService musicService;
	
	@GetMapping("/spsound/select-genre-view")
	public String genre(
			HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		musicService.getGenreList(userId);
		
		return "music/genre";
	}
	
	@GetMapping("/spsound/select-artist-view")
	public String artist() {
		
		return "music/artist";
	}
	
	@GetMapping("/spsound/main-view")
	public String mainPage() {
		
		return "music/main";
	}

}
