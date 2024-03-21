package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Account;
import com.example.demo.Models.User;
import com.example.demo.Models.UserDto;
import com.example.demo.Repositories.AccountRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoginController {
	
	private final UserDetailsService provider;
	private final AccountRepository repo;
	private final AuthenticationManager auth;
	
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
	public String loginPage() {
		return "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "<title>Dollars BBS</title>\r\n"
				+ "<style>\r\n"
				+ "  body {\r\n"
				+ "    background-color: black;\r\n"
				+ "  }\r\n"
				+ "  img {\r\n"
				+ "    display: block;\r\n"
				+ "    margin-top: 100px;\r\n"
				+ "    margin-right: auto;\r\n"
				+ "    margin-bottom: 50px;\r\n"
				+ "    margin-left: auto;\r\n"
				+ "    width: 400px;\r\n"
				+ "    height: 400px;\r\n"
				+ "  }\r\n"
				+ "  /* removes focus border in Chrome */\r\n"
				+ "  *:focus {\r\n"
				+ "    outline: none;\r\n"
				+ "  }\r\n"
				+ "  #password {\r\n"
				+ "    text-align: center;\r\n"
				+ "    margin-right: auto;\r\n"
				+ "    margin-left: auto;\r\n"
				+ "    display: block;\r\n"
				+ "    background-image: url(images/textfield.png);\r\n"
				+ "    background-repeat: no-repeat;\r\n"
				+ "    background-position: 50% 0%;\r\n"
				+ "    width: 400px;\r\n"
				+ "    height: 200px;\r\n"
				+ "  }\r\n"
				+ "  #textfield {\r\n"
				+ "    width: 160px;\r\n"
				+ "    border: 0;\r\n"
				+ "    margin-top: 5px;\r\n"
				+ "    margin-left: 100px;\r\n"
				+ "  }\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body onload=\"document.forms[0].pw.focus()\">\r\n"
				+ "  <img src=\"https://dollars-bbs.org/images/dollars_logo.jpg\">\r\n"
				+ "  <form id=\"form\" action = \"/api/v1/user/login\" method = \"post\">\r\n"
				+ "    <input type=\"text\" name=\"mail\" id=\"mail\" placeholder=\"Enter email\"><br>\r\n"
				+ "    <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter password\"><br>\r\n"
				+ "    <br><br>\r\n"
				+ "    <input type=\"image\" src=\"https://dollars-bbs.org/images/enter_button.png\" onmouseover=\"this.src='https://dollars-bbs.org/images/enter_button_hover.png'\" onmouseout=\"this.src='https://dollars-bbs.org/images/enter_button.png'\" alt=\"Enter\">\r\n"
				+ "  </form>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>";
	}
}
