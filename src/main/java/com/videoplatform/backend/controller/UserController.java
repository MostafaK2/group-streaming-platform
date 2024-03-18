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
import com.videoplatform.backend.utils.JsonResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("test")
	public String hello() {
		return "hello";
	}
	
	/**
	 * Retrieves a user by their unique identifier
	 * 
	 * @param String id
	 * @return The user object if found, otherwise returns a JSON response with an error message.
	 * @apiNote GET Request
	 * 
	 */
	@GetMapping("user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable String id) {
		try {
			User user = userService.getUserById(id);
			return ResponseEntity
					.ok(user);
		}
		catch(Exception e) {
			String jsonResponse = JsonResponse.createErrorResponse(HttpStatus.NOT_FOUND, e.getMessage(), request.getRequestURI());
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(jsonResponse);
		}
		
	}
	
	/**
	 * Adds a new user while ensuring uniqueness of email addresses.
	 * 
	 * @param user
	 * @return  ResponseEntity<?> Returns a response entity indicating success or failure.
	 * @apiNote POST Request
	 * 
	 */
	@PostMapping("user")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			userService.addUser(user);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			String jsonResponse = JsonResponse.createErrorResponse(HttpStatus.CONFLICT, e.getMessage(), request.getRequestURI());
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(jsonResponse);
		}		
	}
	
	// Delete Mapping
	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
	
	
	
}
