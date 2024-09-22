package com.skhanal5.backend.repository;

import com.skhanal5.backend.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

	Optional<User> findByEmailAddress(String emailAddress);
}
