package com.videoplatform.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoplatform.backend.model.User;
import com.videoplatform.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		//System.out.println(user.toString());
		userRepository.save(user);
		
	}
	
	// post mapping
	public User getUserById(String id) {
		User user = userRepository.findById(id).get();	
		return user;
	}
	
	// deleteMapping implementation
	public void deleteUser(String id) {
		userRepository.deleteById(id);
		
	}
	
}
