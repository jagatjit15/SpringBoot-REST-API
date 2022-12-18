package com.masaifir.services.implementations;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaifir.dtos.FirDto;
import com.masaifir.exception.LoginException;
import com.masaifir.module.FIR;
import com.masaifir.module.LoginSession;
import com.masaifir.module.User;
import com.masaifir.repository.FirRepository;
import com.masaifir.repository.LoginSessionRepository;
import com.masaifir.repository.UserRepository;
import com.masaifir.services.FirServices;

@Service
public class FirServiceImpl implements FirServices{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginSessionRepository sessionRepository;
	
	@Autowired
	private FirRepository firRepo;

	@Override
	public String fileAnFirAgainstCrime(FirDto fir, String sessionUid) throws LoginException {
		
		LoginSession existingSession = sessionRepository.findBySessionId(sessionUid);
		
		if(existingSession != null) {
			
			User user = userRepository.findByMobileNumber(existingSession.getMobileNumber());
			
			List<FIR> firLists = user.getFirList();
			
			FIR newFir = new FIR();
			
			newFir.setCrimeDetail(fir.getCrimeDetail());
			newFir.setPoliceStation(fir.getPoliceStation());
			newFir.setTimeStamp(LocalDateTime.now());
			
			firLists.add(newFir);
			
			newFir.setUser(user);
			
			
			firRepo.save(newFir);
			
			return "Fir filed";
			
		}
		
		throw new LoginException("login required");
		
	}

}
