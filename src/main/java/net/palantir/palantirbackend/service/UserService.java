package net.palantir.palantirbackend.service;

import net.palantir.palantirbackend.domain.User;
import net.palantir.palantirbackend.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {

	private final UserRepository userRepository;


	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean isUserExists(String email) {
		User u = userRepository.findOneByEmail(email);
		if (u == null) {
			return false;
		}
		return true;
	}

}
