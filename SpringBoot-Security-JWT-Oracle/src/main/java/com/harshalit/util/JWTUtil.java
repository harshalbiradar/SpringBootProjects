package com.harshalit.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${app.secret}")
	private String secret;
	
	//1. generate token
	
	public String generateToken(String subject) {
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("NareshIT")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secret.getBytes()))
				.compact()
				;
	}
	
	//2. read claims
	public Claims getClaims(String token) {
		return Jwts.parser()
		.setSigningKey(Base64.getEncoder().encode(secret.getBytes()))
		.parseClaimsJws(token)
		.getBody();
	}
	
	//3. read expiredate
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	//4. read subject/username
	public String getUserName(String token) {
		return getClaims(token).getSubject();
	}
	
	//5. validate expiredate
	public boolean isTokenExp(String token) {
		Date expDate = getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}
	
	//6. validate username in token and database , expDate
	public boolean validateToken(String token, String username) {
		String tokenUserName = getUserName(token);
		return username.equals(tokenUserName) && !isTokenExp(token);
	}
	
	
	
	
}
