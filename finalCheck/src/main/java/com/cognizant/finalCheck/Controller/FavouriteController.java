package com.cognizant.finalCheck.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.finalCheck.Service.FavouriteService;
import com.cognizant.finalCheck.model.Favourite;

@RestController
@RequestMapping("/favourite")
public class FavouriteController {

	@Autowired
	FavouriteService favouriteservice;
	
	@GetMapping
	public Favourite getallCartItem() {
		// TODO Auto-generated method stub
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return favouriteservice.getallFavouritesService(user);
		}
	
	@PostMapping("/{id}")
	public void addCartItem(@PathVariable("id") int id)
	{String user = SecurityContextHolder.getContext().getAuthentication().getName();
	
	favouriteservice.addMovieService(id, user);
	}
	@DeleteMapping("/{id}")
	public void DeleteCartItem(@PathVariable("id") int id)
	{String user = SecurityContextHolder.getContext().getAuthentication().getName();
	
	favouriteservice.deleteFavouriteItemService(id, user);
	}
}
