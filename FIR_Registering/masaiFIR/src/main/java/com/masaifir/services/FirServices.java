package com.masaifir.services;

import com.masaifir.dtos.FirDto;
import com.masaifir.exception.LoginException;

public interface FirServices {
	
	public String fileAnFirAgainstCrime(FirDto fir, String sessionUid) throws LoginException;

}
