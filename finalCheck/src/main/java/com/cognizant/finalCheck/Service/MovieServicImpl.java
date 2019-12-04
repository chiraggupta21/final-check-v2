package com.cognizant.finalCheck.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.finalCheck.Repository.MovieRepository;
import com.cognizant.finalCheck.model.Movie;

@Service
public class MovieServicImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getallMovieService() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	@Override
	public Movie getByidService(int id) {
		// TODO Auto-generated method stub
		return movieRepository.findById(id).get();
	}

	@Override
	public void editMovieService(Movie movie) {
		// TODO Auto-generated method stub
		movieRepository.save(movie);
	}

	@Override
	public List<Movie> getallMovieCustomerService() {
		// TODO Auto-generated method stub
		return movieRepository.getallMovieCustomer();
	}
	
	

}
