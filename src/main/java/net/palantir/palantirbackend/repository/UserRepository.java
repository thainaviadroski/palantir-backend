package net.palantir.palantirbackend.repository;

import net.palantir.palantirbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByEmail(String email);
}
