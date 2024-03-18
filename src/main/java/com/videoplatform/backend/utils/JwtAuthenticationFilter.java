package com.videoplatform.backend.utils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.videoplatform.backend.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if (!StringUtils.hasText(authHeader) ||  (StringUtils.hasText(authHeader) && !authHeader.startsWith("Bearer "))) {
			filterChain.doFilter(request, response);
			return;
		}
		
		final String token = authHeader.split(" ")[1].trim();
//		final String userEmail = jwtUtils.getUsernameFromJwt(token);
		
		
	}

}
