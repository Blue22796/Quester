package com.example.demo.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CustomWebSecurityConfig{
	
	private final AuthenticationProvider authenticationProvider;
	private final ApplicationContext context;
	
	
	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception{
		http.authenticationProvider(this.authenticationProvider);
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		var service = new InMemoryUserDetailsManager();
		UserDetails user = User.withUsername("Osama").password("FuckJews").authorities(new String[]{"read","write"}).build();
		service.createUser(user);
		return service;
	}
	@Bean 
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = XPSPasswordEncoder.getInstance();
		return encoder;
	}
}
