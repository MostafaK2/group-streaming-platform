package com.videoplatform.backend.utils;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtils {
	public static final long JWT_TOKEN_VALIDITY = 12 * 30 * 24 * 60 * 60;
	
	@Value("${jwt.secret}")
	private static final String SECRET_KEY = "lB+ntA6Pvg4TjcqRepueLRRJ1mEffJb8reAZ38+OdXcdVQ7CZyuJMImSUua+6nscNk+3KlMnO2xfCmHIBLlyFyyr";
	// @Value("${jwt.secret}")
	@Value("${jwt.cookieExpiry}")
	private int cookieExpiry;

	public String extractUsername(String token) {
		try {
			return extractClaim(token, Claims::getSubject);
		} catch (Exception e) {
			return null;
		}

	}

	public Date extractExpirationDate(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public boolean isTokenExpired(String token) {
		return extractExpirationDate(token).before(new Date());
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (userDetails != null && username.equals(userDetails.getUsername()))
				&& !isTokenExpired(token);
	}

	public String generateToken(UserDetails userDetails) {
		return Jwts
				.builder()
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	private Claims extractAllClaims(String token) {
		try {
			return Jwts.parserBuilder()
					.setSigningKey(getSignInKey())
					.build()
					.parseClaimsJws(token)
					.getBody();
		} catch (MalformedJwtException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

		return Keys.hmacShaKeyFor(keyBytes);
	}

	// add token refresh after

}
