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
		
		List<Genre> genreList = new ArrayList<>();

		List<Choice> choiceList = new ArrayList<>();
		
		for(Genre genre:genreList) {

//			genre.setGenre("Pop");
//			genre = new Genre();
//			genre.setGenre("Hip Hop");
//			genre = new Genre();
//			genre.setGenre("Classical");
//			genre = new Genre();
//			genre.setGenre("Latin");
//			genre = new Genre();
//			genre.setGenre("Jazz");
//			genre = new Genre();
//			genre.setGenre("RnB");
//			genre = new Genre();
//			genre.setGenre("Rock");
//			genre = new Genre();
//			genre.setGenre("Soul");
//			genre = new Genre();
//			genre.setGenre("Country");
//			genre = new Genre();
//			genre.setGenre("Acoustic");
//			
//			genreList.add(genre);
			
			for(Choice choice:choiceList) {
				
				choice.setName(genre.getGenre());
				
				List<Genre> myGenre = musicRepository.selectGenreList(userId);
				
				if(myGenre.contains(genre)) {
					choice.setChecked(true);
				}

				choiceList.add(choice);
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
