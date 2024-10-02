package com.skhanal5.backend.entity;

import com.skhanal5.backend.model.AccountDetails;
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

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	protected User() {}

	public User(AccountDetails accountDetails) {
		this.emailAddress = accountDetails.getEmailAddress();
		this.password = accountDetails.getPassword();
		this.firstName = accountDetails.getFirstName();
		this.lastName = accountDetails.getLastName();
	}
}
