package com.example.demo.Models;
import lombok.*;

@AllArgsConstructor
public class UserDto {
	@Getter
	private final String username;
	@Getter
	private final String password;
	@Getter
	private final String mail;
}
