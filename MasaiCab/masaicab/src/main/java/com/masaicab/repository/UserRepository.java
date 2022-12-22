package com.masaicab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masaicab.module.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByMobileNumber(String mobileNumber);

}

