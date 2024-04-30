package com.syj.spsound.music.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.syj.spsound.music.domain.Artist;
import com.syj.spsound.music.domain.Genre;
import com.syj.spsound.music.domain.Playlist;

@Mapper
public interface MusicRepository {
	
	public int insertGenre(@Param("userId") int userId, @Param("genre") String genre);
	
	public List<Genre> selectGenreList(@Param("userId") int userId);
	
	public Genre selectGenre(@Param("userId") int userId, @Param("genre") String genre);
	
	public int deleteGenre(@Param("userId") int userId, @Param("genre") String genre);

	public int insertArtist(@Param("userId") int userId, @Param("artist") String artist);
	
	public List<Artist> selectArtistList(@Param("userId") int userId);
	
	public Artist selectArtist(@Param("userId") int userId, @Param("artist") String artist);
	
	public int deleteArtist(@Param("userId") int userId, @Param("artist") String artist);
	
	public int insertKeyword(@Param("userId") int userId, @Param("keyword") String keyword);
	
	public int insertPlaylist(@Param("userId") int userId, @Param("musicId") String musicId);
	
	public List<Playlist> selectMusicId(@Param("userId") int userId);
	
	public int deletePlaylist(@Param("userId") int userId, @Param("musicId") String musicId);

}
