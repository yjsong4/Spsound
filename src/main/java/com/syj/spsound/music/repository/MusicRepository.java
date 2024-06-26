package com.syj.spsound.music.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.syj.spsound.music.domain.Artist;
import com.syj.spsound.music.domain.Genre;
import com.syj.spsound.music.domain.Playlist;
import com.syj.spsound.music.dto.Count;

@Mapper
public interface MusicRepository {
	
	public int insertGenre(@Param("userId") int userId, @Param("genre") String genre);
	
	public List<Genre> selectGenreList(@Param("userId") int userId);
	
	public List<Genre> selectAllGenreList();

	public Genre selectGenre(@Param("userId") int userId, @Param("genre") String genre);
	
	public int deleteGenre(@Param("userId") int userId, @Param("genre") String genre);

	public int insertArtist(@Param("userId") int userId, @Param("artist") String artist, @Param("artistId") String artistId);
	
	public List<Artist> selectArtistList(@Param("userId") int userId);
	
	public Artist selectArtist(@Param("userId") int userId, @Param("artist") String artist);
	
	public int deleteArtist(@Param("userId") int userId, @Param("artist") String artist);
	
	public int insertKeyword(@Param("userId") int userId, @Param("keyword") String keyword);
	
	public int insertPlaylist(@Param("userId") int userId, @Param("musicId") String musicId);
	
	public List<Playlist> selectMusicId(@Param("userId") int userId);
	
	public int deletePlaylist(@Param("userId") int userId, @Param("musicId") String musicId);
	
	public List<Count> countByGenre(@Param("userGenreList") List<Genre> userGenreList);
	
	public List<Count> countByArtist(@Param("userArtistList") List<Artist> userArtistList);
}
