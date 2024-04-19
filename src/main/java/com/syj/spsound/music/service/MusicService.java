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
		
//		[
//			{"name":"pop", "checked":false}
//			{"name":"kpop", "checked":false}
//			{"name":"jazz", "checked":false}
//		]
		
		List<Genre> genreList = new ArrayList<>();
		
		Genre genre1 = new Genre();
		genre1.setGenre("Pop");
		Genre genre2 = new Genre();
		genre2.setGenre("Hip Hop");
		Genre genre3 = new Genre();
		genre3.setGenre("Classical");
		Genre genre4 = new Genre();
		genre4.setGenre("Latin");
		Genre genre5 = new Genre();
		genre5.setGenre("Jazz");
		Genre genre6 = new Genre();
		genre6.setGenre("RnB");
		Genre genre7 = new Genre();
		genre7.setGenre("Country");
		Genre genre8 = new Genre();
		genre8.setGenre("Rock");
		Genre genre9 = new Genre();
		genre9.setGenre("Soul");
		Genre genre10 = new Genre();
		genre10.setGenre("Acoustic");
	
		genreList.add(genre1);
		genreList.add(genre2);
		genreList.add(genre3);
		genreList.add(genre4);
		genreList.add(genre5);
		genreList.add(genre6);
		genreList.add(genre7);
		genreList.add(genre8);
		genreList.add(genre9);
		genreList.add(genre10);
		
		List<Choice> choiceList = new ArrayList<>();
		
		for(Genre genre:genreList) {
			
			// genreList가 특정 조건에서 setter를 통해 true로 바껴야
			
			Choice choice = new Choice();
			
			choice.setName(genre.getGenre());

			
			// 초이스 리스트안에 장르리스트
			// 장르리스트는 레포지토리 이용
	
			//장르리스트 안의 장르가 == 내가 선택한 장르이면 클릭한값으로
			
			if(musicRepository.selectGenreList(userId).contains(genre)) {
				choice.setChecked(true);
			}
						
			choiceList.add(choice);	
		}
		
		return choiceList;
		
//		Choice choice1 = new Choice();
//		Choice choice2 = new Choice();
//		
//		choice1.setName("pop");
//		choice2.setName("jazz");
//
//		choiceList.add(choice1);
//		choiceList.add(choice2);
		
		// return musicRepository.selectGenreList(userId);
	}
	
	public Genre getGenreByUserIdAndGenre(int userId, String genre) {
		
		return musicRepository.selectGenre(userId, genre);
	}
	
	public int deleteGenre(int userId, String genre) {
		
		musicRepository.selectGenre(userId, genre);
		
		return musicRepository.deleteGenre(userId, genre);
	}
	
}
