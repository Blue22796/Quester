package com.example.demo.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.Models.Account;
import com.example.demo.Repositories.AccountRepository;
import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class CoolUserDetailsProvider implements UserDetailsService{

	private final AccountRepository repo;
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		Account acc = repo.findByMail(mail);
		
		return acc;
	}

}
