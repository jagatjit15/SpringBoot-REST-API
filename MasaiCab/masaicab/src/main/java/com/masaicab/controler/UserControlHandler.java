package com.masaicab.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaicab.dtos.LoginDto;
import com.masaicab.exception.DriverException;
import com.masaicab.exception.LoginException;
import com.masaicab.exception.UserException;
import com.masaicab.module.Driver;
import com.masaicab.module.User;
import com.masaicab.service.UserServices;


@RestController
@RequestMapping("/masaicab/user")
public class UserControlHandler {
	
   
	@Autowired
	private UserServices userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> userRegisterServiceHandler(@Valid @RequestBody User user) throws UserException{
	
	   String response = userService.userRegisterService(user);
	   
	   return new ResponseEntity<>(response, HttpStatus.CREATED);
	

    }
	
	@PostMapping("/login")
	public  ResponseEntity<String> userLoginServiceHandler(@Valid @RequestBody LoginDto loginCredential) throws UserException, LoginException{
		
		String response = userService.userLoginService(loginCredential);
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/findride")
	public ResponseEntity<List<Driver>> userFindAvailableCabHandler(@RequestParam("uid") String sessionUuid) throws LoginException, DriverException{
		
		List<Driver> drivers = userService.userFindAvailableCab(sessionUuid);
		
		return new ResponseEntity<List<Driver>>(drivers, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/book/{driverId}/{xCordinate}/{yCordinate}")
	public ResponseEntity<String> userRideBookingServiceHandler(@PathVariable("driverId") Integer driverId, @PathVariable("xCordinate") 
	                  Integer xCordinate, @PathVariable("yCordinate") Integer yCordinate) throws DriverException{
		
		String response = userService.userRideBookingService(driverId, xCordinate, yCordinate);
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
