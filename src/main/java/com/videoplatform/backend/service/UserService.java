package com.videoplatform.backend.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.videoplatform.backend.model.User;
import com.videoplatform.backend.model.UserType;
import com.videoplatform.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	// creating a new user will always set a new user with unsubscribed
	public void addUser(User user) throws Exception {
		
		Optional<User> u = userRepository.findByEmail(user.getEmail());
		if (u.isEmpty()){
			user.setUserType(UserType.UNSUBSCRIBED);
			user.setUserCreatedAt(LocalDateTime.now());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		}
		else {
			throw new Exception("Email is already associated with a user");
		}	
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
