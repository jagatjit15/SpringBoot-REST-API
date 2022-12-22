package com.masaicab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masaicab.module.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
	
	public Driver findByMobileNumber(String number);

}

