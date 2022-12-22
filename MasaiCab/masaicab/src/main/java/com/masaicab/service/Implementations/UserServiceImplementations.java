package com.masaicab.service.Implementations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaicab.dtos.LoginDto;
import com.masaicab.exception.DriverException;
import com.masaicab.exception.LoginException;
import com.masaicab.exception.UserException;
import com.masaicab.module.Driver;
import com.masaicab.module.LoginSession;
import com.masaicab.module.User;
import com.masaicab.repository.DriverRepository;
import com.masaicab.repository.LoginSessionRepository;
import com.masaicab.repository.UserRepository;
import com.masaicab.service.UserServices;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImplementations implements UserServices{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private LoginSessionRepository sessionRepo;
	
	@Autowired
	private DriverRepository driverRepo;
	
	

	@Override
	public String userRegisterService(User user) throws UserException {
		
		User existingUser = userRepo.findByMobileNumber(user.getMobileNumber());
		
		if(existingUser != null) throw new UserException("User already Registered with mobile number");
		
		
		userRepo.save(user);
		
		return "User register successfull";
		
	}

	@Override
	public String userLoginService(LoginDto loginCredential) throws UserException, LoginException {

		User existingUser = userRepo.findByMobileNumber(loginCredential.getMobile());
		
		if(existingUser == null) throw new LoginException("User already login");
		
		if(existingUser.getPassword().equals(loginCredential.getPassword())) {
			
			LoginSession session = new LoginSession();
			
			session.setMobileNumber(loginCredential.getMobile());
			session.setTimeStamp(LocalDateTime.now());
			
			String uuid = RandomString.make(8);
			
			session.setSessionId(uuid);
			
			sessionRepo.save(session);
			
			return session.getSessionId();
			
		}
		
		throw new LoginException("Incorect user credential");
		
	}

	@Override
	public List<Driver> userFindAvailableCab(String sessionUuid) throws LoginException, DriverException {
		
		LoginSession existSession = sessionRepo.findBySessionId(sessionUuid);
		
		if(existSession != null) {
			
			List<Driver> availableDrivers = new ArrayList<>();
			
			User existingUser = userRepo.findByMobileNumber(existSession.getMobileNumber());
			
			Integer[] userCordinates = existingUser.getCurrentPosition();
			
			List<Driver> drivers = driverRepo.findAll();
			
			if(drivers.isEmpty()) throw new DriverException("No driver presents");
			
			
			for(Driver driver : drivers) {
				
				Integer distance = findDistance(userCordinates, driver.getCurrentPosition());
				
				if(distance <= 5)
					availableDrivers.add(driver);
				
				
			}
			
			if(availableDrivers.isEmpty())throw new DriverException("No driver available in your location");
				
				
			return availableDrivers;
			
		}
		
		throw new LoginException("Login required");
		
	}

	@Override
	public String userRideBookingService(Integer driverId, Integer xCordinate, Integer yCordinate)
			throws DriverException {
		
		Optional<Driver> optional = driverRepo.findById(driverId);
		
		if(optional.isPresent()) {
			
			Driver existDriver = optional.get();
			
			Integer[] cordinates = existDriver.getCurrentPosition();
			
			cordinates[0] = xCordinate;
			cordinates[1] = yCordinate;
			
			existDriver.setCurrentPosition(cordinates);
			
			driverRepo.save(existDriver);
			
			return "ride booked";
			
		}
		
		throw new DriverException("No driver present with this Id "+ driverId);
		
	}

	
	
//	 finding distance
	
	public Integer findDistance(Integer[] userCordinates, Integer[] driverCordinates) {
		
		int x1 = userCordinates[0];
		int y1 = userCordinates[1];
		
		int x2 = driverCordinates[0];
		int y2 = driverCordinates[1];
		
		int d = (int) Math.sqrt(Math.pow((x2 - x1),2)+ Math.pow((y2 - y1),2));
		
		return d;
	}
	
	
	
	
	
	
	
}
