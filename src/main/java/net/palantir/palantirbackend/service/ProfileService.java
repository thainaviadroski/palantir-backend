package net.palantir.palantirbackend.service;

import net.palantir.palantirbackend.domain.Profile;
import net.palantir.palantirbackend.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

	private final ProfileRepository profileRepository;

	public ProfileService(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	public Optional<Profile> getProfile(Long id) {
		return profileRepository.findById(id);
	}
}
