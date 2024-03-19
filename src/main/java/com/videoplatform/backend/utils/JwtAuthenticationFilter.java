package com.videoplatform.backend.utils;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// retrieve the auth header
		// should be a fall back mechanism if user blocks cookies
		// final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		String token = null;
		final String userEmail;
		
		if (request.getCookies() != null) {
			for(Cookie cookie: request.getCookies()) {
				if(cookie.getName().equals("token")) {
					token = cookie.getValue();
				}
			}
		}
		
		// check token has text and token has Bearer
//		if (!StringUtils.hasText(authHeader) ||  (StringUtils.hasText(authHeader) && !authHeader.startsWith("Bearer "))) {
//			filterChain.doFilter(request, response);
//			return;
//		}
		// check if token is present in cookie
		if (token == null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//final String token = authHeader.split(" ")[1].trim();
		userEmail = jwtUtils.extractUsername(token);
		
		// user is not connected yet
		if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
			// validate token
			if(jwtUtils.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
					userDetails,
					null,
					userDetails.getAuthorities()
				);
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
