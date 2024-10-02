package com.skhanal5.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDetails {
    @JsonProperty("email_address")
    String emailAddress;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;
}
