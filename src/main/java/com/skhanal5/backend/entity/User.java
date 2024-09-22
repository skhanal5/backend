package com.skhanal5.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	protected User() {}

	public User(String emailAddress, String firstName, String lastName) {
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
