package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quester")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private Long id;
	
	@Setter
	@Getter
	private String username;
	
}
