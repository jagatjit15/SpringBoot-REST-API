package com.masaicab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masaicab.module.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer>{
	
	

}