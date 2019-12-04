package com.cognizant.finalCheck.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.finalCheck.model.Favourite;
import com.cognizant.finalCheck.model.FavouriteItem;
import com.cognizant.finalCheck.model.Movie;


public interface FavouriteItemRepository extends JpaRepository<FavouriteItem, Integer>{

	FavouriteItem findByMovie(Movie movie);
	
	FavouriteItem findByFavouriteAndMovie(Favourite favourite,Movie movie);
}