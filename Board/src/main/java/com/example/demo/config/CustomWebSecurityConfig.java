package com.example.demo.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfig{
	
	private final AuthenticationProvider authenticationProvider;
	
	@Bean
	public AuthenticationManager manager(AuthenticationManagerBuilder builder) {
		return new ProviderManager(authenticationProvider);	
	}
	
	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				(request)->request.requestMatchers("/api/v1/user/*").permitAll()
				.anyRequest().hasAuthority("Bomb"))
		.formLogin(
				form->form.usernameParameter("mail").passwordParameter("password")
				.loginPage("/api/v1/user/signin").loginProcessingUrl("/api/v1/user/login")
				.successForwardUrl("/api/v1/quests").failureUrl("/api/v1/user/fail").permitAll())
		.authenticationProvider(this.authenticationProvider).csrf(csrf->csrf.disable());
		
		return http.build();
	}

	@Bean 
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = XPSPasswordEncoder.getInstance();
		return encoder;
	}
}
