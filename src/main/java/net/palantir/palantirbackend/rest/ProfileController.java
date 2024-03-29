package net.palantir.palantirbackend.rest;

import net.palantir.palantirbackend.domain.Profile;
import net.palantir.palantirbackend.domain.User;
import net.palantir.palantirbackend.repository.ProfileRepository;
import net.palantir.palantirbackend.repository.UserRepository;
import net.palantir.palantirbackend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileController(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/profile")
    public ResponseEntity<?> createProfile(@RequestBody Profile profile) throws URISyntaxException {
        System.out.println(profile.toString());
        User u = userRepository.save(profile.getUser());
        profile.setUser(u);
        Profile p = profileRepository.save(profile);
        return ResponseEntity
                .created(new URI("/profile/" + profile.getId()))
                .header("CREATED NEW PROFILE", "A new created !!")
                .body(p);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Optional<Profile>> getProfile(@PathVariable Long id) {
        Optional<Profile> p = profileService.getProfile(id);
        return Optional.ofNullable(p).map(result -> new ResponseEntity<>(result, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/profile/user")
    public ResponseEntity<Optional<Profile>> getProfileByUser(@RequestBody User user) {
        Optional<Profile> p = profileRepository.findByUser(user);
        return Optional.ofNullable(p).map(result -> new ResponseEntity<>(result, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/profiles")
    private ResponseEntity<List<Profile>> getAllProfile() {
        List<Profile> profiles = profileRepository.findAll();
        return Optional
                .ofNullable(profiles)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile() {
        return null;
    }

    @DeleteMapping("/profile/{id}")
    public void deleteProfile() {

    }

}
