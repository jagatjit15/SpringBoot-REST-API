package com.masaicab.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masaicab.exception.DriverException;
import com.masaicab.module.Driver;
import com.masaicab.service.DriverServices;

@RestController
@RequestMapping("/masaicab/driver")
public class DriverControlerHandler {
	
	
	@Autowired
	private DriverServices servisec;
	
	@PostMapping("/register")
	public ResponseEntity<String> driverRegistrationHandler(@Valid @RequestBody Driver driver) throws DriverException {
		
		String response = servisec.driverRegistrationService(driver);
		
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
		
	}
	

}
