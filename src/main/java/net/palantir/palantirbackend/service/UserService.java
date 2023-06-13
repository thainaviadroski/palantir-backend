package net.palantir.palantirbackend.service;

import net.palantir.palantirbackend.domain.User;
import net.palantir.palantirbackend.repository.UserRepository;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public void createNewUser(User user) {

		PasswordEncoder pass = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	}

}
