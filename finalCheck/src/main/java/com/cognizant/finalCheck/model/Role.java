package com.cognizant.finalCheck.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ro_id")
	private int id;
	
	@Column(name="ro_name")
	private String name;

	
	@ManyToMany
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="ur_ro_id"),inverseJoinColumns=@JoinColumn(name="ur_us_id"))
	private Set<User> userList;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
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
	
	

}
