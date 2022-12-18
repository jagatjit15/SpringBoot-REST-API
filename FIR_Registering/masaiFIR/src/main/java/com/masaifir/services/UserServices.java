package com.masaifir.services;

import java.util.List;

import com.masaifir.dtos.LoginDto;
import com.masaifir.dtos.UserDto;
import com.masaifir.exception.DataException;
import com.masaifir.exception.LoginException;
import com.masaifir.exception.UserException;
import com.masaifir.module.FIR;

public interface UserServices {
	
	
	public String userRegistration(UserDto user) throws UserException;
	
	public String userLogin(LoginDto login) throws UserException, LoginException;
	
	public List<FIR> getUserFIRfiles(String sessionUId) throws LoginException, DataException;
	
	public String withDrawFIRById(String sessionUId, Integer firId) throws LoginException, DataException;
	

}
