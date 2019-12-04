package com.cognizant.finalCheck.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.cognizant.finalCheck.Service.AppUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable().httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/authenticate")
		.hasAnyRole("USER","ADMIN")
		.antMatchers("/users")
		.anonymous()
		.antMatchers(HttpMethod.GET,"/movie")
		.permitAll()
		.antMatchers(HttpMethod.PUT,"/movie")
		.hasRole("ADMIN")
		.antMatchers("/favourite/**")
		.hasAnyRole("USER")
		.anyRequest()
		.authenticated()
		.and()
		.addFilter(new JwtAuthorization(authenticationManager()));
	}
//	@Bean
//	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//		LOGGER.info("Start");
//		List<UserDetails> userDetailsList = new ArrayList<>();
//		userDetailsList.add(User.withUsername("john").password(passwordEncoder().encode("12345678")).roles("USER").build());
//		userDetailsList.add(User.withUsername("admin").password(passwordEncoder().encode("23456789")).roles("ADMIN").build());
//		
//		LOGGER.info("END");
//		return new InMemoryUserDetailsManager(userDetailsList);
//	}

	
}
