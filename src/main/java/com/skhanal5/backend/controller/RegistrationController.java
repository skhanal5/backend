package com.skhanal5.backend.controller;

import com.skhanal5.backend.model.LoginDetails;
import com.skhanal5.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

	@Autowired private UserRepository userRepository;

	@PostMapping("/register")
	public String addUser(@RequestBody UserDetails userDetails) {

		return "Added new user";
	}

	private String hashPasswords() {}

	@PostMapping("/login")
	public String loginUser(@RequestBody LoginDetails loginDetails) {
		var result =
				userRepository.findByEmailAddressAndPassword(
						loginDetails.getEmailAddress(), loginDetails.getPassword());
		if (result.isEmpty()) {
			throw new IllegalStateException("Failed to retrieve user");
		}
		var user = result.get();
		return "Found user: " + user.getId();
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataAccessException.class)
	public void handleRepositoryExceptions() {}
}
