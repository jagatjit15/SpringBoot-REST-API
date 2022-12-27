package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.Service.APIUserServiceImpl;
import com.api.model.UserDisplay;
import com.api.model.UserInput;

@RestController
@RequestMapping("/api")
public class UserAPIController {
	
	@Autowired
	private APIUserServiceImpl userService;
	
	public UserAPIController(APIUserServiceImpl userService) {
		this.userService = userService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<UserDisplay> getUserByIdHandler(@RequestParam("Id") Long id){
		
		return new ResponseEntity<>(userService.getUserDataById(id), HttpStatus.OK);
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserDisplay> registerUserHandler(@RequestBody UserInput user){
		
		return new ResponseEntity<UserDisplay>(userService.PostUserData(user), HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<UserDisplay[]> getAllUsersHandler(){
		
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
		
	}

}
