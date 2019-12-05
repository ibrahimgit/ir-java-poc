package com.ir.learning.poc.jwt;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JsonWebToken {
	
	private static final String SECRET_TOKEN = "dsdasds56756dsd768565sadsa65ddhsahdj";
	private static final Logger LOGGER = Logger.getLogger(JsonWebToken.class);
	
	public static void main(String[] args) {
		
		String jwtToken = generateJwtToken();
		
		String azureIdToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJhdWQiOiIyZDRkMTFhMi1mODE0LTQ2YTctODkwYS0yNzRhNzJhNzMwOWUiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC83ZmU4MTQ0Ny1kYTU3LTQzODUtYmVjYi02ZGU1N2YyMTQ3N2UvIiwiaWF0IjoxMzg4NDQwODYzLCJuYmYiOjEzODg0NDA4NjMsImV4cCI6MTM4ODQ0NDc2MywidmVyIjoiMS4wIiwidGlkIjoiN2ZlODE0NDctZGE1Ny00Mzg1LWJlY2ItNmRlNTdmMjE0NzdlIiwib2lkIjoiNjgzODlhZTItNjJmYS00YjE4LTkxZmUtNTNkZDEwOWQ3NGY1IiwidXBuIjoiZnJhbmttQGNvbnRvc28uY29tIiwidW5pcXVlX25hbWUiOiJmcmFua21AY29udG9zby5jb20iLCJzdWIiOiJKV3ZZZENXUGhobHBTMVpzZjd5WVV4U2hVd3RVbTV5elBtd18talgzZkhZIiwiZmFtaWx5X25hbWUiOiJNaWxsZXIiLCJnaXZlbl9uYW1lIjoiRnJhbmsifQ.";
		
		
		validateJwtToken(jwtToken);
		
		//parseAzureId(azureIdToken);
	}

	private static void parseAzureId(String azureIdToken) {
		
		String[] parseToken = azureIdToken.split("\\.");
		
		Decoder urlDecoder = Base64.getUrlDecoder();
		String header = new String(urlDecoder.decode(parseToken[0]));
		String payLoad = new String(urlDecoder.decode(parseToken[1]));
		
		LOGGER.info("header: " + header);
		LOGGER.info("header: " + payLoad);
		
		
	}

	private static void validateJwtToken(String jwtToken) {
		
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(SECRET_TOKEN)
					.parseClaimsJws(jwtToken).getBody();
			LOGGER.info("Email Address: " + claims.get("emailAddress"));
		} catch (ExpiredJwtException eje) {
			eje.printStackTrace();
		}
		
		
	}

	private static String generateJwtToken() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.DATE, 7);
		
		String jwtToken = Jwts.builder()
			.setSubject("Warranty regsitration verification token")
			.setIssuer("Armstrong Fluid Technologies")
			.setId(UUID.randomUUID().toString())
			.setIssuedAt(new Date())
			.setExpiration(currentDate.getTime())
			.claim("emailAddress", "ibrahim.rashid@tcs.com")
			.signWith(SignatureAlgorithm.HS256, SECRET_TOKEN)
			.compact();
		
		LOGGER.info("JWT Token: " + jwtToken);
		return jwtToken;
	}

}
