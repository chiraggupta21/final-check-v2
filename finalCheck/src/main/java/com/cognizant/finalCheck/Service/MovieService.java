package com.cognizant.finalCheck.Service;

import java.util.List;

import com.cognizant.finalCheck.model.Movie;


public interface MovieService {
	
	List<Movie> getallMovieService();
	Movie getByidService(int id);
	void editMovieService(Movie movie);
	List<Movie> getallMovieCustomerService();

}
