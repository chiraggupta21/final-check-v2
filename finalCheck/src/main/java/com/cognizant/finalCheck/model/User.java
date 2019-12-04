package com.cognizant.finalCheck.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="us_id")
	private int userid;
	@Column(name="us_name")
	private String username;
	@Column(name="us_password")
	private String password;
	@Column(name="us_firstName")
	private String firstName;
	@Column(name="us_lastName")
	private String lastName;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role",
	joinColumns=@JoinColumn(name="ur_us_id"),
	inverseJoinColumns=@JoinColumn(name="ur_ro_id"))
	private Set<Role> rolelist;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int userid, String username, String password, String firstName, String lastName, Set<Role> rolelist) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rolelist = rolelist;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Set<Role> getRolelist() {
		return rolelist;
	}


	public void setRolelist(Set<Role> rolelist) {
		this.rolelist = rolelist;
	}
	
	
	
}
