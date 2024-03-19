package com.videoplatform.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoplatform.backend.dto.AuthenticationRequestDto;
import com.videoplatform.backend.model.User;
import com.videoplatform.backend.repository.UserRepository;
import com.videoplatform.backend.service.UserService;
import com.videoplatform.backend.utils.JsonResponse;
import com.videoplatform.backend.utils.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private JwtUtils jwtUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private HttpServletRequest request;

	@PostMapping("/register")
	public ResponseEntity<?> registerReq(@RequestBody User user) {
		try {
			userService.addUser(user);
			String token = jwtUtil.generateToken(user);
			return ResponseEntity
					.ok()
					.header(HttpHeaders.AUTHORIZATION, token)
					.build();
		} catch (Exception e) {
			String jsonResponse = JsonResponse.createErrorResponse(HttpStatus.CONFLICT, e.getMessage(),
					request.getRequestURI());
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(jsonResponse);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginReq(@RequestBody AuthenticationRequestDto request) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getEmail(), request.getPassword()));

			User user = userRepository.findByEmail(request.getEmail()).orElse(null);
			String token = jwtUtil.generateToken(user);

			return ResponseEntity.ok()
					.header(HttpHeaders.AUTHORIZATION, token).build();
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

	}

}
