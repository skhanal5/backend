package com.skhanal5.backend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.skhanal5.backend.ResourceFetcher;
import com.skhanal5.backend.entity.User;
import com.skhanal5.backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired private MockMvc mockMvc;

	@MockBean private UserRepository userRepository;

	@Test
	public void testInsertUserHappyPath() throws Exception {
		var requestBody = ResourceFetcher.getResourceFileAsString("user_request.json");
		var insertedUser = new User("", "", "");
		when(userRepository.save(any())).thenReturn(insertedUser);

		mockMvc
				.perform(post("/api/v1/user").contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andExpect(status().isOk())
				.andExpect(content().string("Successfully added user"));
	}

	@Test
	public void testInsertUserUnhappyPath() throws Exception {
		var requestBody = ResourceFetcher.getResourceFileAsString("user_request.json");
		when(userRepository.save(any())).thenThrow(new DataAccessException("foo") {});

		mockMvc
				.perform(post("/api/v1/user").contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andExpect(status().isInternalServerError());
	}
}
