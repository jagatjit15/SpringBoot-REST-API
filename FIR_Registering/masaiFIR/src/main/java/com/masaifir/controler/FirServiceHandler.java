package com.masaifir.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaifir.dtos.FirDto;
import com.masaifir.exception.LoginException;
import com.masaifir.services.FirServices;

@RestController
@RequestMapping("/masaifir/user")
public class FirServiceHandler {
	
	@Autowired
	private FirServices service;
	
	
	@PostMapping("/fir")
	public ResponseEntity<String> registerFirHandler(@Valid @RequestBody FirDto fir, @RequestParam("uuid") String sessionUuid) throws LoginException{
		
		String response = service.fileAnFirAgainstCrime(fir, sessionUuid);
		
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
		
	}
	

}
