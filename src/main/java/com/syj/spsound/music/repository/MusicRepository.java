package com.syj.spsound.music.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.syj.spsound.music.domain.Genre;

@Mapper
public interface MusicRepository {
	
	public int insertGenre(@Param("userId") int userId, @Param("genre") String genre);
	
	public List<Genre> selectGenreList(@Param("userId") int userId);
	
	public Genre selectGenre(@Param("userId") int userId, @Param("genre") String genre);
	
	public int deleteGenre(@Param("userId") int userId, @Param("genre") String genre);
	
	
	public int insertArtist(@Param("userId") int userId, @Param("artist") String artist);
	
	

}
