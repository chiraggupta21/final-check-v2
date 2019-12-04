package com.cognizant.finalCheck.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.finalCheck.model.Movie;


public interface MovieRepository extends JpaRepository<Movie, Integer>{


	@Query(value="select m from Movie m where m.active=1 and m.boxOffice< CURRENT_Date()")
	List<Movie> getallMovieCustomer();
}
