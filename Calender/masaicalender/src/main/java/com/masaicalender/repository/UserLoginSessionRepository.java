package com.masaicalender.repository;import com.masaicalender.module.LoginSession;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;@Repositorypublic interface UserLoginSessionRepository extends JpaRepository<LoginSession, Integer> {    public LoginSession findByEmail(String email);}