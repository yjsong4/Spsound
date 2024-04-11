package com.syj.spsound.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.syj.spsound.user.domain.User;

@Mapper
public interface UserRepository {
	
	public int insertUser(
			@Param("email") String email
			, @Param("password") String Password);
	
	public User selectUserByEmailAndPassword(
			@Param("email") String email
			, @Param("password") String Password);
	
	public int selectCountByEmail(@Param("email") String email);

}
