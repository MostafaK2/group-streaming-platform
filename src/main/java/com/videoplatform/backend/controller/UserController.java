package com.videoplatform.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.videoplatform.backend.model.User;
import com.videoplatform.backend.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	private UserService userService;
	
	// Get Mapping
	@GetMapping("user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable String id) {
		try {
			User user = userService.getUserById(id);
			return ResponseEntity.ok(user);
		}
		catch(Exception ex) {
			String errorMessage = ex.getMessage(); // Get the error message from the exception
			String requestURI = request.getRequestURI();
			
		    // Build the custom error response JSON
			 String jsonResponse = "{\n" +
			            "    \"timestamp\": \"" + java.time.LocalDateTime.now() + "\",\n" +
			            "    \"status\": 404,\n" +
			            "    \"error\": \"Not Found\",\n" +
			            "    \"message\": \"" + errorMessage + "\",\n" +
			            "    \"path\": \"" + requestURI + "\"\n" +
			            "}";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonResponse);
		}
		
	}
	
	@PostMapping("user")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	// Post Mappings
}
