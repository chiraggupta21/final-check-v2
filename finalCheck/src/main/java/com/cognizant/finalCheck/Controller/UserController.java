package com.cognizant.finalCheck.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.finalCheck.Service.AppUserDetailsService;
import com.cognizant.finalCheck.exception.UserAlreadyExistsException;
import com.cognizant.finalCheck.model.User;



@RestController
@RequestMapping("/users")
public class UserController {

	
	
	@Autowired
	private AppUserDetailsService userService;
	
	@PostMapping
	public void signUp(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		 userService.signUp(user);
	}
	@GetMapping
	public boolean userExists(@RequestParam String username) {
		return this.userService.userExists(username);
	}

}
