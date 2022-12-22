package com.masaicab.service.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaicab.exception.DriverException;
import com.masaicab.module.Driver;
import com.masaicab.repository.DriverRepository;
import com.masaicab.service.DriverServices;

@Service
public class DriverServicesImplementations implements DriverServices{
	
	
	@Autowired
	private DriverRepository driverRepo;
	

	@Override
	public String driverRegistrationService(Driver driverDetails) throws DriverException {
		
		Driver driver = driverRepo.findByMobileNumber(driverDetails.getMobileNumber());
		
		if(driver != null) throw new DriverException("Driver present with mobilenumber");
		
		driverRepo.save(driverDetails);
		
		return "You become a masaiCabDriver";
		
		
	}

}
