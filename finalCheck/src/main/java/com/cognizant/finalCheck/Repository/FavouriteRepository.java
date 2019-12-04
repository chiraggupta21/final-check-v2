package com.cognizant.finalCheck.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.finalCheck.model.Favourite;
import com.cognizant.finalCheck.model.User;


public interface FavouriteRepository extends JpaRepository<Favourite, Integer>{
	
	Favourite findByUser(User user);
	

}