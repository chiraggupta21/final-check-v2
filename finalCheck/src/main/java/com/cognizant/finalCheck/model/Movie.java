package com.cognizant.finalCheck.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@Column(name="mo_id")
	private int id;
	
	@Column(name="mo_name")
	private String name;
	
	@Column(name="mo_price")
	private float price;
	
	@Column(name="mo_active")
	private boolean active;
	
	@Column(name="mo_box_office")
	private Date boxOffice;
	
	@Column(name="mo_genre")
	private String genre;
	
	@Column(name="mo_has_teaser")
	private boolean hasTeaser;

	@Column(name="mo_image_path")
	private String imageURl;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int id, String name, float price, boolean active, Date boxOffice, String genre, boolean hasTeaser,
			String imageURl) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.boxOffice = boxOffice;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
		this.imageURl = imageURl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(Date boxOffice) {
		this.boxOffice = boxOffice;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	public String getImageURl() {
		return imageURl;
	}

	public void setImageURl(String imageURl) {
		this.imageURl = imageURl;
	}

	
}
