package com.videoplatform.backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.videoplatform.backend.repository.UserRepository;

@Configuration
public class ApplicationConfig {
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new UserDetailsService() {
//			@Autowired
//			private UserRepository repository;
//			
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//				return repository
//						.findByEmail(username)
//						.orElseThrow(() -> new UsernameNotFoundException("user not found"));
//			}
//		};
//	}
}
