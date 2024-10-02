package com.skhanal5.backend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.skhanal5.backend.ResourceFetcher;
import com.skhanal5.backend.entity.User;
import com.skhanal5.backend.model.AccountDetails;
import com.skhanal5.backend.repository.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

	@Autowired MockMvc mockMvc;

	@MockBean UserRepository userRepository;

	@Test
	void testRegisterUser() throws Exception {
		var requestBody = ResourceFetcher.getResourceFileAsString("login_request.json");
		var mockAccountDetails = mock(AccountDetails.class);
		var insertedUser = new User(mockAccountDetails);
		when(userRepository.save(any())).thenReturn(insertedUser);

		mockMvc
				.perform(
						post("/api/v1/register").contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andExpect(status().isOk()) // Update this to created
				.andExpect(content().string("Added new user"));
	}

	@Test
	void testLoginUser() throws Exception {
		var requestBody = ResourceFetcher.getResourceFileAsString("registration_request.json");
		var mockAccountDetails = mock(AccountDetails.class);
		var foundUser = new User(mockAccountDetails);
		when(userRepository.findByEmailAddressAndPassword(any(), any()))
				.thenReturn(Optional.of(foundUser));

		mockMvc
				.perform(post("/api/v1/login").contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andExpect(status().isOk())
				.andExpect(
						content().string("Found user: null")); // should return a session/cookie of some sort
	}
}
