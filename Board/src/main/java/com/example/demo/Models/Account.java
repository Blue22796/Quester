package com.example.demo.Models;

import java.util.Collection;

import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Account implements UserDetails{
	
	@Id
	@Setter
	@Getter
	private long id;
	@Column(unique = true)
	
	@NaturalId
	@Setter
	@Getter
	private String mail;
	@Setter
	@Getter
	private String password;
	
	@Setter
	@Getter
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public Account(UserDto user) {
		this.password = user.getPassword();
		this.mail = user.getMail();
		this.user = new User();
		this.user.setUsername(user.getUsername());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return mail;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
