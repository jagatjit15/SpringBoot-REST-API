package com.masaifir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masaifir.module.LoginSession;

@Repository
public interface LoginSessionRepository extends JpaRepository<LoginSession, Integer>{
	
	public LoginSession findBySessionId(String sessionId);
	
	public LoginSession findByMobileNumber(String mobileNumber);

}
