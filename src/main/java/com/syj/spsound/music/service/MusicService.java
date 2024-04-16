package com.syj.spsound.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syj.spsound.music.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository musicRepository;
	
	public int chooseGenre(int userId, String genre) {
		
		return musicRepository.insertGenre(userId, genre);
	}
	
	public int countGenre(String genre) {
		
		return musicRepository.selectGenre(genre);
		
		
		
	}
	
}
