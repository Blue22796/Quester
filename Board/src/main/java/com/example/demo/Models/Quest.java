package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Quest {
	@Setter
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Setter
	@Getter
	private String title;
	@Setter
	@Getter
	private String description;
	@OneToOne
	@Getter
	@Setter
	private User author;
}
