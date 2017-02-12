package com.ir.learning.poc.jwt;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Calendar;

import org.apache.log4j.Logger;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JsonWebToken {
	
	private static final String SECRET_TOKEN = "dsdasds56756dsd768565sadsa65ddhsahdj";
	private static final Logger LOGGER = Logger.getLogger(JsonWebToken.class);
	
	public static void main(String[] args) {
		
		String jwtToken = generateJwtToken();
		
		String azureIdToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJhdWQiOiIyZDRkMTFhMi1mODE0LTQ2YTctODkwYS0yNzRhNzJhNzMwOWUiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC83ZmU4MTQ0Ny1kYTU3LTQzODUtYmVjYi02ZGU1N2YyMTQ3N2UvIiwiaWF0IjoxMzg4NDQwODYzLCJuYmYiOjEzODg0NDA4NjMsImV4cCI6MTM4ODQ0NDc2MywidmVyIjoiMS4wIiwidGlkIjoiN2ZlODE0NDctZGE1Ny00Mzg1LWJlY2ItNmRlNTdmMjE0NzdlIiwib2lkIjoiNjgzODlhZTItNjJmYS00YjE4LTkxZmUtNTNkZDEwOWQ3NGY1IiwidXBuIjoiZnJhbmttQGNvbnRvc28uY29tIiwidW5pcXVlX25hbWUiOiJmcmFua21AY29udG9zby5jb20iLCJzdWIiOiJKV3ZZZENXUGhobHBTMVpzZjd5WVV4U2hVd3RVbTV5elBtd18talgzZkhZIiwiZmFtaWx5X25hbWUiOiJNaWxsZXIiLCJnaXZlbl9uYW1lIjoiRnJhbmsifQ.";
		
		
		validateJwtToken(jwtToken);
		
		parseAzureId(azureIdToken);
	}

	private static void parseAzureId(String azureIdToken) {
		
		String[] parseToken = azureIdToken.split("\\.");
		
		Decoder urlDecoder = Base64.getUrlDecoder();
		String header = new String(urlDecoder.decode(parseToken[0]));
		String payLoad = new String(urlDecoder.decode(parseToken[1]));
		
		System.out.println("header: " + header);
		System.out.println("header: " + payLoad);
		
		
	}

	private static void validateJwtToken(String jwtToken) {
		// TODO Auto-generated method stub
		String love = (String)Jwts.parser()
			.setSigningKey(SECRET_TOKEN)
			.parseClaimsJws(jwtToken).getBody().get("love");
		System.out.println(love);
		
		 Claims claims = Jwts.parser()
			.setSigningKey(SECRET_TOKEN)
			.parseClaimsJws(jwtToken).getBody();
		 System.out.println("expirtion: " + claims.getExpiration());
		
		
	}

	private static String generateJwtToken() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.MONTH, 1);
		
		String jwtToken = Jwts.builder()
			.setSubject("My First jwt token")
			.setIssuer("Ibrahim")
			.setId("Ibra1234")
			.setExpiration(currentDate.getTime())
			.claim("love", "Saba")
			.claim("name", "Ibrahim")
			.signWith(SignatureAlgorithm.HS256, SECRET_TOKEN)
			.compact();
		
		//LOGGER.info("JWT Token: " + jwtToken);
		System.out.println("JWT Token: " + jwtToken);
		return jwtToken;
	}

}
