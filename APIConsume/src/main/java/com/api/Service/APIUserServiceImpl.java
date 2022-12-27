package com.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.model.UserDisplay;
import com.api.model.UserInput;

@Service
public class APIUserServiceImpl implements APIServices{
	
	@Autowired
	private RestTemplate restTemplate;
	
	String url = "https://jsonplaceholder.typicode.com/";

	@Override
	public UserDisplay getUserDataById(Long id) {
		
		UserDisplay user = restTemplate.getForObject(url+"posts"+"/"+id, UserDisplay.class);

		return user;
		
	}

	@Override
	public UserDisplay PostUserData(UserInput user) {
		
		UserDisplay newUser = restTemplate.postForObject(url+"posts", user, UserDisplay.class);
		
		return newUser;
		
		
	}

	@Override
	public UserDisplay[] getAllUsers() {
		
		UserDisplay[] users = restTemplate.getForObject(url+"posts", UserDisplay[].class);
		
		return users;
		
	}

}
