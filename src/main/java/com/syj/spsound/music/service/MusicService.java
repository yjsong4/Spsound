package com.syj.spsound.music.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syj.spsound.music.domain.Genre;
import com.syj.spsound.music.dto.Choice;
import com.syj.spsound.music.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository musicRepository;
	
	public int chooseGenre(int userId, String genre) {
	
		return musicRepository.insertGenre(userId, genre);
	}
	
	public List<Genre> getGenreList(int userId) {
		
		List<Choice> ChoiceList = new ArrayList<>();

//		[
//			{"name":"pop", "checked":false}
//			{"name":"kpop", "checked":false}
//			{"name":"jazz", "checked":false}
//		]
		
		
		return musicRepository.selectGenreList(userId);
	}
	
	public Genre getGenreByUserIdAndGenre(int userId, String genre) {
		
		return musicRepository.selectGenre(userId, genre);
	}
	
	public int deleteGenre(int userId, String genre) {
		
		musicRepository.selectGenre(userId, genre);
		
		return musicRepository.deleteGenre(userId, genre);
	}
	
}
