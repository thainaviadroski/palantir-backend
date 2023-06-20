package net.palantir.palantirbackend.repository;

import net.palantir.palantirbackend.domain.Profile;
import net.palantir.palantirbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByUser(User idUser);
}
