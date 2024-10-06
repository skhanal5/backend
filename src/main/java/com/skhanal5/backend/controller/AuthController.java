package com.skhanal5.backend.controller;

import com.skhanal5.backend.model.AccountDetails;
import com.skhanal5.backend.model.LoginDetails;
import com.skhanal5.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

	@Autowired AuthenticationManager authenticationManager;

	@Autowired UserService service;

	@PostMapping("/register")
	public String addUser(@RequestBody AccountDetails accountDetails) {
		service.registerNewUser(accountDetails);
		return "Created user";
	}

	@PostMapping("/login")
	public String loginUser(@RequestBody LoginDetails loginDetails) {
		Authentication authRequest =
				UsernamePasswordAuthenticationToken.unauthenticated(
						loginDetails.getEmailAddress(), loginDetails.getPassword());

		Authentication authResponse = this.authenticationManager.authenticate(authRequest);
		return authResponse.toString();
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<String> handleRepositoryExceptions(Exception e) {
		return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
