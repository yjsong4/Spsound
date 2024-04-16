package com.syj.spsound.music.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MusicRepository {
	
	public int insertGenre(@Param("userId") int userId, @Param("genre") String genre);

	public int selectGenre(@Param("genre") String genre);
}
