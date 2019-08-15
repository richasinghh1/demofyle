package com.example.fyle.security;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.fyle.util.SecurityProperties;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenAuthenticationService {
	private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 5; // 10 days  
	private String tokenPrefix = "Bearer";
	private String headerString = "Authorization";
	public void addAuthentication(HttpServletResponse response, String username) {
		// We generate a token now.
		Properties configuration;
		String secret;
		try {
			configuration = SecurityProperties.loadProperties();
			secret=configuration.get("my-properties.secret").toString();
			String JWT = Jwts.builder()
					.setSubject(username)
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
					.signWith(SignatureAlgorithm.HS512, secret)
					.compact();
			response.addHeader(headerString, tokenPrefix + " " + JWT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Authentication getAuthentication(HttpServletRequest request) {
		Properties configuration;
		String secret;
		try {
			configuration = SecurityProperties.loadProperties();
			secret=configuration.get("my-properties.secret").toString();
			String token = request.getHeader(headerString);
			if (token != null) {
				// parse the token.
				String username = Jwts.parser()
						.setSigningKey(secret)
						.parseClaimsJws(token)
						.getBody()
						.getSubject();
				if (username != null) // we managed to retrieve a user
				{
					return new AuthenticatedUser(username);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}