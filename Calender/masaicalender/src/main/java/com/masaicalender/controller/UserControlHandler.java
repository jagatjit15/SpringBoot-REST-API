package com.masaicalender.controller;import com.masaicalender.dtos.LoginDto;import com.masaicalender.dtos.UserDto;import com.masaicalender.exceptions.EventNotFoundException;import com.masaicalender.exceptions.LoginException;import com.masaicalender.exceptions.UserNotFound;import com.masaicalender.module.Event;import com.masaicalender.services.Implementation.ServicesImplementations;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import javax.validation.Valid;import java.util.List;@RestController@RequestMapping("/masaicalender")public class UserControlHandler {    @Autowired    private ServicesImplementations service;    @PostMapping("/register")    public ResponseEntity<String> userRegistrationHandler(@Valid @RequestBody UserDto user) throws UserNotFound {        String msg = service.userRegistration(user);        return new ResponseEntity<>(msg, HttpStatus.CREATED);    }    @PostMapping("/login")    public ResponseEntity<String> userLoginHandler(@Valid @RequestBody LoginDto user) throws UserNotFound, LoginException {        String msg = service.userLogin(user);        return new ResponseEntity<>(msg, HttpStatus.OK);    }    @GetMapping("/event/{type}")    public ResponseEntity<List<Event>> eventGetByTypeHandler(@PathVariable String type, @RequestParam String emailId) throws LoginException, UserNotFound, EventNotFoundException {        List<Event> eventList = service.userEventsByType(type, emailId);        return new ResponseEntity<>(eventList, HttpStatus.OK);    }    @PutMapping("/user")    public ResponseEntity<String> updateUserDetailsHandler(@Valid @RequestBody UserDto user) throws LoginException, UserNotFound{        String msg = service.userUpdateDetails(user);        return new ResponseEntity<>(msg, HttpStatus.OK);    }}