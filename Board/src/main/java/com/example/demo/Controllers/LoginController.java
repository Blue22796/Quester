package com.example.demo.Controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Account;
import com.example.demo.Models.UserDto;
import com.example.demo.Repositories.AccountRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoginController {
	
	private final UserDetailsService provider;
	private final AccountRepository repo;
	
	@PostMapping("/api/v1/user/signup")
	public String signup(@RequestBody UserDto user) {
		if(provider.loadUserByUsername(user.getMail())!=null)
			return "Mail is already in use!";
		var acc = new Account(user);
		repo.save(acc);
		return "Success";
	}
	@GetMapping("/api/v1/user/signup")
	public String askData() {
		return "Enter your personal info plz";
	}
	
	@GetMapping("/api/v1/user/fail")
	public String failPage() {
		return "Oh no D:";
	}
	
	@GetMapping("/api/v1/user/signin")
	public Resource loginPage() {
		Resource resource = new ClassPathResource("static/login.html");
		return resource;
	}
}
