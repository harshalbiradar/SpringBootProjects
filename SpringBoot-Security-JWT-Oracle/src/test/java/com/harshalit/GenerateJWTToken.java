package com.harshalit;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GenerateJWTToken {

	//in spring boot util methods we have to write 

	public String generateToken(String id, String subject, String key) {
		return Jwts.builder().setId(id)// id
				.setSubject(subject)// subject
				.setIssuer("NareshIT")// provider
				.setIssuedAt(new Date(System.currentTimeMillis()))// token gen date
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10))) // valid until?
				.signWith(SignatureAlgorithm.HS256, // signature algo
						Base64.getEncoder().encode(key.getBytes())) // secrete key
				.compact(); // String
	}
	
	public Claims getClaims(String key, String token) {
		 return Jwts.parser()
			.setSigningKey(Base64.getEncoder().encode(key.getBytes())) // secrete key
			.parseClaimsJws(token)
			.getBody();
	}
	
	public String getSubject(String key, String token) {
		return getClaims(key, token).getSubject();
	}
	
	public boolean isValidToken(String key, String token) {
		//expDate > curDate
		return getClaims(key, token)
				.getExpiration()
				.after(new Date(System.currentTimeMillis()));
	}
	
	
	public static void main(String[] args) {

		//String key = "NIT";

		// token generation
/*
		String token = Jwts.builder().setId("A1234")// id
				.setSubject("Harshal")// subject
				.setIssuer("NareshIT")// provider
				.setIssuedAt(new Date(System.currentTimeMillis()))// token gen date
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10))) // valid until?
				.signWith(SignatureAlgorithm.HS256, // signature algo
						Base64.getEncoder().encode(key.getBytes())) // secrete key
				.compact(); // String
		System.out.println("Token: " + token);
*/
		// -----Reading token/parsing token ----
		//get claims
/*		
		Claims c = Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(key.getBytes())) // secrete key
				.parseClaimsJws(token).getBody();
		
		System.out.println(c.getId());
		System.out.println(c.getSubject());
		System.out.println(c.getIssuer());
		System.out.println(c.getIssuedAt());
		System.out.println(c.getExpiration());
*/
		
		String key = "NIT";//never share key
		GenerateJWTToken util = new GenerateJWTToken();
		String token = util.generateToken("H1234", "Harshal", key);
		//String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJBMTIzNCIsInN1YiI6IkhhcnNoYWwiLCJpc3MiOiJOYXJlc2hJVCIsImlhdCI6MTYwOTYxNjgxNywiZXhwIjoxNjA5NjE3NDE3fQ.2lEKKfAjYIvf7vv8k4M4s9zJmzv0pk_KqpJ1ZdFvQS8";
		//select exptime = 1 minute it will expire the token we can't get data
		System.out.println(token);
		System.out.println("-----------------------");
		Claims c = util.getClaims(key, token);
		System.out.println(c.getId());
		System.out.println(c.getSubject());
		System.out.println(c.getIssuer());
		System.out.println(c.getIssuedAt());
		System.out.println(c.getExpiration());
		
		
	}

}
