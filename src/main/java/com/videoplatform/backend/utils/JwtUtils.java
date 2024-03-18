package com.videoplatform.backend.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	 private static final long serialVersionUID = -2550185165626007488L;
	 public static final long JWT_TOKEN_VALIDITY = 12 * 30 * 24 * 60 * 60;

//   @Value("${jwt.secret}")
	 
	 
	 public static String generateToken(String username) {
		 return Jwts.builder()
				 .setSubject(username)
				 .setIssuedAt(new Date())
				 .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				 .signWith(SignatureAlgorithm.ES512, "MYSECRET")
				 .compact();
	 }
	 
	 public String getUsernameFromJwt(String token) {
		 return Jwts.parser()
				 .setSigningKey("MYSECRET")
				 .parseClaimsJws(token)
				 .getBody()
				 .getSubject();
				 
	 }
	 
	 
	 public Date getExpirationDateFromToken(String token) {
		 return Jwts.parser()
				 .setSigningKey("MYSECRET")
				 .parseClaimsJws(token)
				 .getBody()
				 .getExpiration();
	 }
	 
	 private Boolean isTokenExpired(String token) {
		 Date tokenExpiration = getExpirationDateFromToken(token);
		 return tokenExpiration.before(new Date());
	 }
	 
	 
	 
	 
	 
	 
}
