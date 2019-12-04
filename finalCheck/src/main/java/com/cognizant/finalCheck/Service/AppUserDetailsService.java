package com.cognizant.finalCheck.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.finalCheck.Repository.RoleRepository;
import com.cognizant.finalCheck.Repository.UserRepository;
import com.cognizant.finalCheck.exception.UserAlreadyExistsException;
import com.cognizant.finalCheck.model.Role;
import com.cognizant.finalCheck.model.User;
import com.cognizant.finalCheck.security.AppUser;



@Service
public class AppUserDetailsService implements UserDetailsService {

	AppUser appUser;
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	public AppUserDetailsService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		appUser = new AppUser(user);
		return appUser;
	}

	public boolean userExists(String username) {

		User user = userRepository.findByUsername(username);
		if (user == null)
			return false;
		else
			return true;
	}

	public void signUp(User user) throws UserAlreadyExistsException {
		User newuser=userRepository.findByUsername(user.getUsername());
		if(newuser==null)
		{	
			Role role=roleRepository.findById(2).get();
			Set<Role> rolelist=new HashSet<Role>();
			rolelist.add(role);
			user.setRolelist(rolelist);
			user.setPassword(passwordEncoder().encode(user.getPassword()));
			userRepository.save(user);
		}else
		throw new UserAlreadyExistsException("User is already present");
	}
	
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
