package com.skhanal5.backend.repository;

import com.skhanal5.backend.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testInsertUser() {
        User user = new User("foo", "bar", "baz");
        userRepository.save(user);

        var searchResult = userRepository.findById(user.getId());

        Assertions.assertTrue(searchResult.isPresent());
        Assertions.assertEquals(user, searchResult.get());
    }

    @Test
    public void testFindByEmailAddress() {
        User user = new User("foo", "bar", "baz");
        userRepository.save(user);

        var searchResult = userRepository.findByEmailAddress(user.getEmailAddress());

        Assertions.assertTrue(searchResult.isPresent());
        Assertions.assertEquals(user, searchResult.get());
    }

}
