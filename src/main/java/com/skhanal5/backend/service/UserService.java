package com.skhanal5.backend.service;

import com.skhanal5.backend.model.AccountDetails;
import com.skhanal5.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired private UserRepository userRepository;

	@Autowired private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var maybeUser = userRepository.findByEmailAddress(username);
		if (maybeUser.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		var user = maybeUser.get();
		return User.builder().username(user.getEmailAddress()).password(user.getPassword()).build();
	}

	public void registerNewUser(AccountDetails accountDetails) {
		var user = new com.skhanal5.backend.entity.User(accountDetails);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}
