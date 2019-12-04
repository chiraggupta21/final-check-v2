package com.cognizant.finalCheck.Service;

import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.finalCheck.Repository.FavouriteItemRepository;
import com.cognizant.finalCheck.Repository.FavouriteRepository;
import com.cognizant.finalCheck.Repository.MovieRepository;
import com.cognizant.finalCheck.Repository.UserRepository;
import com.cognizant.finalCheck.model.Favourite;
import com.cognizant.finalCheck.model.FavouriteItem;
import com.cognizant.finalCheck.model.Movie;
import com.cognizant.finalCheck.model.User;


@Service
public class FavouriteServiceImpl implements FavouriteService {

	@Autowired
	FavouriteRepository favouriteRepository;
	@Autowired
	FavouriteItemRepository favouriteItemRepository;
	@Autowired
	AppUserDetailsService appuserdetailsService;
	@Autowired
	MovieRepository menuItemRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public void addMovieService(int id, String username) {
		// TODO Auto-generated method stub
		if (appuserdetailsService.userExists(username)) {
			User user = userRepository.findByUsername(username);
			Favourite cart = favouriteRepository.findByUser(user);
			if (cart == null) {
				cart=new Favourite();
				List<FavouriteItem> cartitemlist = new ArrayList<FavouriteItem>();
				FavouriteItem cartitem = new FavouriteItem();
				cartitem.setMovie(menuItemRepository.findById(id).get());
				cartitem.setQuantity(1);
				cartitem.setFavourite(cart);
				cartitemlist.add(cartitem);
				cart.setFavouriteItemList(cartitemlist);
				cart.setUser(user);
				cart.setTotal(1);
				favouriteRepository.save(cart);
			} else {
				FavouriteItem cartitem=favouriteItemRepository.findByFavouriteAndMovie(cart,menuItemRepository.findById(id).get());
				
					if (cartitem==null) {
						cartitem=new FavouriteItem();
						cartitem.setFavourite(cart);
						cartitem.setQuantity(1);
						cartitem.setMovie(menuItemRepository.findById(id).get());
						
						List<FavouriteItem> cartitemlist=new ArrayList<FavouriteItem>();
						cartitemlist.add(cartitem);
						
						cart.setFavouriteItemList(cartitemlist);
						cart.setTotal(cart.getTotal()+1);
						favouriteRepository.save(cart);
						}
					
//					} else {
//						
//						cartitem.setQuantity(cartitem.getQuantity() + 1);
//						List<FavouriteItem> cartitemlist=new ArrayList<FavouriteItem>();
//						cartitemlist.add(cartitem);
//						
//						cart.setFavouriteItemList(cartitemlist);
//						cart.setTotal(cart.getTotal() +1);
//						favouriteRepository.save(cart);
//					}
			}
		} else {
			System.out.println("User NOt present");
		}
		
	}

	@Override
	public void deleteFavouriteItemService(int id, String username) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		Favourite cart = favouriteRepository.findByUser(user);
		Movie menuitem=menuItemRepository.findById(id).get();
		
		FavouriteItem cartitem=favouriteItemRepository.findByFavouriteAndMovie(cart,menuitem);
		if(cartitem != null) {
			cartitem.setQuantity(cartitem.getQuantity()-1);
			cart.setTotal(cart.getTotal()-1);
			if(cartitem.getQuantity()<=0)
			{
				favouriteItemRepository.delete(cartitem);
			}
			favouriteRepository.save(cart);
		}
	}

	@Override
	public Favourite getallFavouritesService(String username) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		Favourite cart = favouriteRepository.findByUser(user);
		
		return cart;
	}

	
}
