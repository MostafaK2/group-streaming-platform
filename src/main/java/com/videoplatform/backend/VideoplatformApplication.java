package com.videoplatform.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.videoplatform.backend.model.User;
import com.videoplatform.backend.model.UserType;
import com.videoplatform.backend.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class VideoplatformApplication {
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initialize() {
		
		User u1 = User.builder()
				.email("fred12@gmail.com")
				.password("1234")
				.firstName("fred").lastName("aids")
				.username("fraids").userType(UserType.UNSUBSCRIBED).build();
		
		User u2 = User.builder()
				.email("johnhk1@gmail.com")
				.password("1234")
				.firstName("John").lastName("honk")
				.username("Jhonk").userType(UserType.UNSUBSCRIBED).build();
		
		User u3 = User.builder()
				.email("fredboib@gmail.com")
				.password("Kala")
				.firstName("fred").lastName("bob")
				.username("fred1").userType(UserType.UNSUBSCRIBED).build();
		
		try {
			userService.addUser(u1);
			userService.addUser(u2);
			userService.addUser(u3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		SpringApplication.run(VideoplatformApplication.class, args);
	}

}
