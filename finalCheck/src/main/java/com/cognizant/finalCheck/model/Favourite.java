package com.cognizant.finalCheck.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="favourite")
public class Favourite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fa_id")
	private int favourite_id;
	
	@OneToOne
	@JoinColumn(name="fa_us_id")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy="favourite",cascade=CascadeType.ALL)
	private List<FavouriteItem> favouriteItemList;
	
	@Column(name="fa_total")
	private double total = 0;

	public Favourite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Favourite(User user, double total) {
		super();
		this.user = user;
		this.total = total;
	}


	public Favourite(int favourite_id, User user, List<FavouriteItem> favouriteItemList, double total) {
		super();
		this.favourite_id = favourite_id;
		this.user = user;
		this.favouriteItemList = favouriteItemList;
		this.total = total;
	}

	public int getFavourite_id() {
		return favourite_id;
	}

	public void setFavourite_id(int favourite_id) {
		this.favourite_id = favourite_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<FavouriteItem> getFavouriteItemList() {
		return favouriteItemList;
	}

	public void setFavouriteItemList(List<FavouriteItem> favouriteItemList) {
		this.favouriteItemList = favouriteItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
