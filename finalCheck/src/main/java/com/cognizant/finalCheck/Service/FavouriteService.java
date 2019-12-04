package com.cognizant.finalCheck.Service;

import com.cognizant.finalCheck.model.Favourite;

public interface FavouriteService {
	
	void addMovieService(int id,String user);
	void deleteFavouriteItemService(int id,String user);
	Favourite getallFavouritesService(String user);

}
