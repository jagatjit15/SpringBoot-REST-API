package com.masaifir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masaifir.module.FIR;

@Repository
public interface FirRepository extends JpaRepository<FIR, Integer>{

}
