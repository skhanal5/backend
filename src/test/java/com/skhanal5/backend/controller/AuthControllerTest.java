package com.skhanal5.backend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.skhanal5.backend.ResourceFetcher;
import com.skhanal5.backend.configuration.SecurityConfig;
import com.skhanal5.backend.model.AccountDetails;
import com.skhanal5.backend.repository.UserRepository;
import java.util.Optional;

import com.skhanal5.backend.service.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Import(SecurityConfig.class)
@WebMvcTest(AuthController.class)
public class AuthControllerTest {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserService userService;

	@MockBean
	AuthenticationManager authenticationManager;

	@Test
	void testRegisterUser() throws Exception {
		var requestBody = ResourceFetcher.getResourceFileAsString("registration_request.json");
		mockMvc
				.perform(
						post("/api/v1/register").contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andExpect(status().isOk()) // Update this to created
				.andExpect(content().string("Created user"));
	}

	@Test
	void testLoginUser() throws Exception {
		var requestBody = ResourceFetcher.getResourceFileAsString("login_request.json");
		var user = mock(UserDetails.class);
		when(userService.loadUserByUsername("foo@bar.com"))
				.thenReturn(user);

		mockMvc
				.perform(post("/api/v1/login").contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andExpect(status().isOk())
				.andExpect(
						content().string("Found user: null")); // should return a session/cookie of some sort
	}
}
