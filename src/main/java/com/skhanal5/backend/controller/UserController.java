package com.skhanal5.backend.controller;

import com.skhanal5.backend.model.UserRequest;
import com.skhanal5.backend.repository.UserRepository;
import com.skhanal5.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired private UserRepository userRepository;

  @PostMapping("/user")
  public String insertUser(@RequestBody UserRequest userRequest) {
    var newUser =
        new User(
            userRequest.getEmailAddress(), userRequest.getFirstName(), userRequest.getLastName());

    userRepository.save(newUser);
    return "Successfully added user";
  }

  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(DataAccessException.class)
  public void handleRepositoryExceptions() {

  }
}
