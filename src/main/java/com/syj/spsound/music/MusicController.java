package com.syj.spsound.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syj.spsound.music.dto.Choice;
import com.syj.spsound.music.service.MusicService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/spsound")
@Controller
public class MusicController {
	
	@Autowired
	private MusicService musicService;
	
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

}
