package com.skhanal5.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AccountDetails {
	@JsonProperty("email_address")
	String emailAddress;

	String password; // hash later

	@JsonProperty("first_name")
	String firstName;

	@JsonProperty("last_name")
	String lastName;
}
