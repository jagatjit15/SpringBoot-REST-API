package com.masaifir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masaifir.module.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByMobileNumber(String mobileNumber);
	
	public boolean existsByMobileNumber(String mobileNumber);

}
