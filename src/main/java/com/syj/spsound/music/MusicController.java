package com.syj.spsound.music;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {
	
	@GetMapping("/spsound/select-genre-view")
	public String genre() {
		
		return "music/genre";
	}
	
	@GetMapping("/spsound/select-artist-view")
	public String artist() {
		
		return "music/artist";
	}

}
