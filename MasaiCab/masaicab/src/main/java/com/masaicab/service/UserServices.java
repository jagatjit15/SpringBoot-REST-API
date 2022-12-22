package com.masaicab.service;

import java.util.List;

import com.masaicab.dtos.LoginDto;
import com.masaicab.exception.DriverException;
import com.masaicab.exception.LoginException;
import com.masaicab.exception.UserException;
import com.masaicab.module.Driver;
import com.masaicab.module.User;

public interface UserServices {
	
	
	public String userRegisterService(User user) throws UserException;
	
	public String userLoginService(LoginDto loginCredential) throws UserException, LoginException;
	
	public List<Driver> userFindAvailableCab(String sessionUuid) throws LoginException, DriverException;
	
	public String userRideBookingService(Integer driverId, Integer xCordinate, Integer yCordinate) throws DriverException;
	
	

}
