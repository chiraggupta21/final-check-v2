package com.cognizant.finalCheck.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="FavouriteItem")
public class FavouriteItem {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fi_id")
	private int favouriteItem_id;
	

	@ManyToOne
	@JoinColumn(name="fi_mo_id")
	private Movie movie;
	
	@Column(name="fi_quantity")
	private int quantity;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="fi_ct_id")
	private Favourite favourite;

	public FavouriteItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	


	public FavouriteItem(int favouriteItem_id, Movie movie, int quantity, Favourite favourite) {
		super();
		this.favouriteItem_id = favouriteItem_id;
		this.movie = movie;
		this.quantity = quantity;
		this.favourite = favourite;
	}
	
	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public int getFavouriteItem_id() {
		return favouriteItem_id;
	}

	public void setFavouriteItem_id(int favouriteItem_id) {
		this.favouriteItem_id = favouriteItem_id;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Favourite getFavourite() {
		return favourite;
	}

	public void setFavourite(Favourite favourite) {
		this.favourite = favourite;
	}
	
	

}
