package com.masaicab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaicab.module.LoginSession;

public interface LoginSessionRepository extends JpaRepository<LoginSession, Integer>{
	
	public LoginSession findBySessionId(String sessionId);

}
