package com.masaifir.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaifir.dtos.LoginDto;
import com.masaifir.dtos.UserDto;
import com.masaifir.exception.DataException;
import com.masaifir.exception.LoginException;
import com.masaifir.exception.UserException;
import com.masaifir.module.FIR;
import com.masaifir.services.UserServices;

@RestController
@RequestMapping("/masaifir/user")
public class UserServicesHandler {
	
	@Autowired
	private UserServices service;

	@PostMapping("/register")
	public ResponseEntity<String> userRegistrationHandler(@Valid @RequestBody UserDto user) throws UserException{
		
		String response = service.userRegistration(user);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> userLoginHandler(@Valid @RequestBody LoginDto user) throws UserException, LoginException{
		
		String response = service.userLogin(user);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/user/fir")
	public ResponseEntity<List<FIR>> userFirListHandler(@RequestParam("uuid") String sessionUuid) throws LoginException, DataException{
		
		List<FIR> list = service.getUserFIRfiles(sessionUuid);
		
		return new ResponseEntity<List<FIR>>(list, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/user/fir/{firId}")
    public ResponseEntity<String> firWithdrawHandler(@PathVariable("firId") Integer firId, @RequestParam("uuid") String sessionUuid) throws UserException, LoginException, DataException{
		
		String response = service.withDrawFIRById(sessionUuid, firId);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
		
	}
	

}
