package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Component
public class CoolAuthenticationProvider implements AuthenticationProvider{

	
	private final UserDetailsService service;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pass = authentication.getCredentials().toString();
		
		UserDetails user = service.loadUserByUsername(username);
		
		if(user==null||!user.getPassword().equals(pass)) 
			throw new AuthenticationCredentialsNotFoundException("Credentials incorrect!");
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();	
		authorities.add(new SimpleGrantedAuthority("Bomb"));
		return new UsernamePasswordAuthenticationToken(username, pass, authorities);		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return UsernamePasswordAuthenticationToken.class
		          .isAssignableFrom(authentication);
	}


}
