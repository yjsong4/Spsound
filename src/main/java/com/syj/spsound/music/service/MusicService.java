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
	
	public List<Choice> getGenreList(int userId) {
		
		List<Choice> choiceList = new ArrayList<>();
		
		Choice choice = new Choice();
		choice.setName("Pop");
		choiceList.add(choice);
		choice = new Choice();
		choice.setName("Hip Hop");
		choiceList.add(choice);
		choice = new Choice();
		choice.setName("Classical");
		choiceList.add(choice);
		choice = new Choice();
		choice.setName("Latin");
		choiceList.add(choice);
		choice = new Choice();
		choice.setName("Jazz");
		choiceList.add(choice);
		choice = new Choice();
		choice.setName("RnB");
		choiceList.add(choice);
		choice = new Choice();
		choice.setName("Country");
		choiceList.add(choice);
		choice = new Choice();
		choice.setName("Rock");
		choiceList.add(choice);
		choice = new Choice();
		choice.setName("Soul");
		choiceList.add(choice);
		choice = new Choice();
		choice.setName("Acoustic");
		choiceList.add(choice);
		
		List<Genre> myGenre = musicRepository.selectGenreList(userId);
		
		for(Genre genre:myGenre) {
			
			for(Choice genreChoice:choiceList) {
				
				if(genre.getGenre().equals(genreChoice.getName())) {
					genreChoice.setChecked(true);
				}
			}
		}
		
		return choiceList;
	}
	
	public Genre getGenreByUserIdAndGenre(int userId, String genre) {
		
		return musicRepository.selectGenre(userId, genre);
	}
	
	public int deleteGenre(int userId, String genre) {
		
		musicRepository.selectGenre(userId, genre);
		
		return musicRepository.deleteGenre(userId, genre);
	}
	
	public int chooseArtist(int userId, String artist) {
		
		return musicRepository.insertArtist(userId, artist);
	}
}
