package com.cognizant.finalCheck.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.finalCheck.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String nsername);
}
