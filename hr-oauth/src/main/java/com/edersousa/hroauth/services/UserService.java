package com.edersousa.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersousa.hroauth.entities.User;
import com.edersousa.hroauth.feignclients.UserFeingClient;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeingClient userFeingClient;
	
	public User findByEmail(String email) {
		User user = userFeingClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		
		logger.info("Email found: " + email);
		return user;		
	}
}
