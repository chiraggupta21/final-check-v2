package com.cognizant.finalCheck.Controller;

import java.awt.MenuItem;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.finalCheck.Service.AppUserDetailsService;
import com.cognizant.finalCheck.Service.MovieService;
import com.cognizant.finalCheck.model.Movie;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@GetMapping
	public List<Movie> getallMenuItem()
	{	
		List<Movie> menuItemList;
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String user=authentication.getName();
		if(user != "anonymousUser") {
			UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
			String role = userDetails.getAuthorities().toArray()[0].toString();
			LOGGER.info(role);
			if(role.equals("ROLE_ADMIN")) {
				menuItemList = this.movieService.getallMovieService();
			}
			else {
				menuItemList = this.movieService.getallMovieCustomerService();
			}
			return menuItemList;
		}
		return this.movieService.getallMovieCustomerService();

	}
	@GetMapping("/{id}")
	public Movie getById(@PathVariable("id") int id)
	{
		return movieService.getByidService(id);
	}
	@PutMapping
	public void editmenuItem(@RequestBody Movie movie)
	{
		movieService.editMovieService(movie);
	}

	
	
}
