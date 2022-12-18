package com.masaifir.services.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaifir.dtos.LoginDto;
import com.masaifir.dtos.UserDto;
import com.masaifir.exception.DataException;
import com.masaifir.exception.LoginException;
import com.masaifir.exception.UserException;
import com.masaifir.module.FIR;
import com.masaifir.module.LoginSession;
import com.masaifir.module.User;
import com.masaifir.repository.FirRepository;
import com.masaifir.repository.LoginSessionRepository;
import com.masaifir.repository.UserRepository;
import com.masaifir.services.UserServices;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserServices{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginSessionRepository sessionRepository;
	
	@Autowired
	private FirRepository firRepo;
	

	@Override
	public String userRegistration(UserDto user) throws UserException {
		
			if(validName(user.getFirstName(), user.getLastName()) 
					&& validMobileNumber(user.getMobileNumber())) {
				
				boolean flag = userRepository.existsByMobileNumber(user.getMobileNumber());
				
				if(flag) throw new UserException("User present with mobile number");
				
				User newUser = new User();
				
				newUser.setAddress(user.getAddress());
				newUser.setAge(user.getAge());
				newUser.setFirstName(user.getFirstName());
				newUser.setLastName(user.getLastName());
				newUser.setGender(user.getGender());
				newUser.setMobileNumber(user.getMobileNumber());
				newUser.setPassword(user.getPassword());
					
				userRepository.save(newUser);
				
				return "User Registered Successfully";
				
			}
			
			throw new UserException("Invalid names or mobile number");
		
		
		
	}

	@Override
	public String userLogin(LoginDto login) throws UserException, LoginException {
		
			
			if(validMobileNumber(login.getMobile())) {
				
				 boolean flag = userRepository.existsByMobileNumber(login.getMobile());
					
					if(flag) {
						
						LoginSession exist = sessionRepository.findByMobileNumber(login.getMobile());
						
						if(exist != null) throw new LoginException("User already loggedIn");
						
						LoginSession session = new LoginSession();
						
						session.setMobileNumber(login.getMobile());
						session.setTimeStamp(LocalDateTime.now());
						
						String uuid = RandomString.make(8);
						
						session.setSessionId(uuid);
						
						sessionRepository.save(session);
						
						return "User login SuccessFully. Your Session uuid :-"+ uuid;
						
					}
					
					
					throw new UserException("User not found with mobile number");
			
		}
		
			throw new LoginException("Please enter a valid mobile number");
		
	}

	@Override
	public List<FIR> getUserFIRfiles(String sessionUId) throws LoginException, DataException {

		LoginSession existingSession = sessionRepository.findBySessionId(sessionUId);
			
			if(existingSession == null) throw new LoginException("Login required");
			
			User user = userRepository.findByMobileNumber(existingSession.getMobileNumber());
			
			List<FIR> listOfFir = user.getFirList();
			
			if(listOfFir.isEmpty()) throw new DataException("No fir registered by you");
		
			return listOfFir;
		
	}

	@Override
	public String withDrawFIRById(String sessionUId, Integer firId) throws LoginException, DataException {
		
		LoginSession existingSession = sessionRepository.findBySessionId(sessionUId);
		
		if(existingSession == null) throw new LoginException("Login required");
		
		
		Optional<FIR> optional = firRepo.findById(firId);
		
		if(optional.isPresent()) {
			
			User user = userRepository.findByMobileNumber(existingSession.getMobileNumber());
			
			List<FIR> listOfFir = user.getFirList();
			
			FIR fir = optional.get();
			
			if(checkValididty(fir.getTimeStamp())) {
				
				for(FIR fi : listOfFir) {
					if(fi.getFirId() == firId)
						{
						listOfFir.remove(fi);
						break;
						}
				}
				
				firRepo.delete(fir);
				
				return "Fir withdraw successfully";
				
			}
			
			throw new DataException("Fir filed morethan 24 hours ago can not be withdraw");
			
		}
		
		throw new DataException("No fir found with firId "+firId);
	}
	
	
	
	
	private boolean validName(String firstName, String lastName) {
		
		for(int i = 1; i < 10; i++) {
			
			
			if(firstName.contains(i+"") && lastName.contains(i+""))
				return false;
			
		}
		return true;
	}
	
	
	private boolean validMobileNumber(String mobile) {
		
		int count = 0;
		if(mobile.length() != 10)
			return false;
		
		for(int i = 0; i < 10; i++) {
			
			if(mobile.contains(i+""))
				count++;
			
		}
		if(count != 10)
			return false;
		
		return true;
		
	}
	
	
	
	private boolean checkValididty(LocalDateTime timeStamp) {
		
		if(timeStamp.getHour() > LocalDateTime.now().getHour())
			return false;
		
		return true;
	}
	
	
	
	
	
	
	

}
