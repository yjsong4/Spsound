package com.syj.spsound.music.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syj.spsound.music.domain.Artist;
import com.syj.spsound.music.domain.Genre;
import com.syj.spsound.music.domain.Playlist;
import com.syj.spsound.music.dto.Choice;
import com.syj.spsound.music.dto.Count;
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
		
		for(Choice genreChoice:choiceList) {
			
			for(Genre genre:myGenre) {
				
				if(genre.getGenre().equals(genreChoice.getName())) {
					genreChoice.setChecked(true);
				}
			}
		}
		
		return choiceList;
	}
	
	public int deleteGenre(int userId, String genre) {
		
		return musicRepository.deleteGenre(userId, genre);
	}
	
	public int chooseArtist(int userId, String artist, String artistId) {
		
		return musicRepository.insertArtist(userId, artist, artistId);
	}
	
	public List<Choice> getArtistList(int userId) {
		
		List<Choice> choiceList = new ArrayList<>();
		
		Choice choice = new Choice();
		choice.setName("Taylor Swift");
		choice.setArtistId("06HL4z0CvFAxyc27GXpf02");
		choiceList.add(choice);
		
		choice = new Choice();
		choice.setName("Tame Impala");
		choice.setArtistId("5INjqkS1o8h1imAzPqGZBb");
		choiceList.add(choice);
		
		choice = new Choice();
		choice.setName("Ariana Grande");
		choice.setArtistId("66CXWjxzNUsdJxJ2JdwvnR");
		choiceList.add(choice);
		
		choice = new Choice();
		choice.setName("Billie Eilish");
		choice.setArtistId("6qqNVTkY8uBg9cP3Jd7DAH");
		choiceList.add(choice);
		
		choice = new Choice();
		choice.setName("Harry Styles");
		choice.setArtistId("6KImCVD70vtIoJWnq6nGn3");
		choiceList.add(choice);
		
		choice = new Choice();
		choice.setName("Beyonce");
		choice.setArtistId("6vWDO969PvNqNYHIOW5v0m");
		choiceList.add(choice);
		
		choice = new Choice();
		choice.setName("SZA");
		choice.setArtistId("7tYKF4w9nC0nq9CsPZTHyP");
		choiceList.add(choice);
		
		choice = new Choice();
		choice.setName("Drake");
		choice.setArtistId("3TVXtAsR1Inumwj472S9r4");
		choiceList.add(choice);
		
		choice = new Choice();
		choice.setName("Justin Bieber");
		choice.setArtistId("1uNFoZAHBGtllmzznpCI3s");
		choiceList.add(choice);
		
		choice = new Choice();
		choice.setName("Bad Bunny");
		choice.setArtistId("4q3ewBCX7sLwd24euuV69X");
		choiceList.add(choice);
		
		List<Artist> myArtist = musicRepository.selectArtistList(userId);
		
		for(Choice artistChoice:choiceList) {
			for(Artist artist: myArtist) {
				
				if(artist.getArtist().equals(artistChoice.getName())) {
					artistChoice.setChecked(true);
				}
			}
		}
		
		return choiceList;
	}
	
	public int deleteArtist(int userId, String artist) {
		
		return musicRepository.deleteArtist(userId, artist);	
	}
	
	public int addKeyword(int userId, String keyword) {
		
		return musicRepository.insertKeyword(userId, keyword);
	}
	
	public int addPlaylist(int userId, String musicId) {
		
		return musicRepository.insertPlaylist(userId, musicId);
	}
	
	public List<String> musicIdList(int userId) {
		
		List<Playlist> playlist =  musicRepository.selectMusicId(userId);
		
		List<String> musicIdList = new ArrayList<>(); 
		
		for(int i = 0; i < playlist.size(); i++) {
			
			String musicId = playlist.get(i).getMusicId();
			
			musicIdList.add(musicId);
		}
		
		return musicIdList;
	}
	
	public int deletePlaylist(int userId, String musicId) {
		
		return musicRepository.deletePlaylist(userId, musicId);
	}
	
	public List<Count> getUserByGenre(int userId) {
		
		return musicRepository.countByGenre(musicRepository.selectGenreList(userId));	
	}
	
	public List<Count> getUserByArtist(int userId) {
		
		return musicRepository.countByArtist(musicRepository.selectArtistList(userId));
	}
	
}