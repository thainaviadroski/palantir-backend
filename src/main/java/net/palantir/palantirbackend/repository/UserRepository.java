package net.palantir.palantirbackend.repository;

import net.palantir.palantirbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    User findByEmail(String email);
    User findByEmailAndPass(String email, String pass);
}
