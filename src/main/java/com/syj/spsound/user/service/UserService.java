package com.syj.spsound.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syj.spsound.common.EncryptUtils;
import com.syj.spsound.user.domain.User;
import com.syj.spsound.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserByEmailAndPassword(String email, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userRepository.selectUserByEmailAndPassword(email, encryptPassword);
	}
}
