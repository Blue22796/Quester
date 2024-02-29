package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


public class CoolAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return new CoolAuthenticationProvider().authenticate(authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return UsernamePasswordAuthenticationToken.class
		          .isAssignableFrom(authentication);
	}


}
