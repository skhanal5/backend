package com.skhanal5.backend.repository;

import com.skhanal5.backend.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByEmailAddress(String emailAddress);
}
