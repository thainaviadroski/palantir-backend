package net.palantir.palantirbackend.repository;

import net.palantir.palantirbackend.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
