package com.api.Service;

import com.api.model.UserDisplay;
import com.api.model.UserInput;

public interface APIServices {
	
	public UserDisplay getUserDataById(Long id);
	
	public UserDisplay PostUserData(UserInput user);
	
	public UserDisplay[] getAllUsers();

}
