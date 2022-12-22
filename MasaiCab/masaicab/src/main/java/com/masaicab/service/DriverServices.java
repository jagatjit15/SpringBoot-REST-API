package com.masaicab.service;

import com.masaicab.exception.DriverException;
import com.masaicab.module.Driver;

public interface DriverServices {
	
	public String driverRegistrationService(Driver driverDetails)throws DriverException;

}
