package com.skhanal5.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginDetails {
	@JsonProperty("email_address")
	String emailAddress;

	@JsonProperty("password")
	String password; // hash later
}
