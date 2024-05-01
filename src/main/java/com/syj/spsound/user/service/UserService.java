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
	
	public boolean isDuplicateEmail(String email) {
		
		int count = userRepository.selectCountByEmail(email);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public int addUser(String email, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userRepository.insertUser(email, encryptPassword);
	}
	
	public User getUserByEmailAndPassword(String email, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userRepository.selectUserByEmailAndPassword(email, encryptPassword);
	}
	
	public User getUser(int id) {
		
		return userRepository.selectUser(id);
	}
}
