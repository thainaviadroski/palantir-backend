package net.palantir.palantirbackend.rest;

import net.palantir.palantirbackend.domain.Login;
import net.palantir.palantirbackend.domain.User;
import net.palantir.palantirbackend.repository.UserRepository;
import net.palantir.palantirbackend.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    private AuthenticationManager manager;

    private final TokenService tokenService;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @PostMapping(value = "/user", consumes = {"application/json"})
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(400).header("FAIL_CREATE_USER", "E-mail using another user").body(user);
        }
        User u = userRepository.save(user);
        return ResponseEntity
                .created(new URI("/user/" + u.getId()))
                .header("USER_CREATED", "New user created success!")
                .body(u);
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.getUser(), login.getPass());
        Authentication authenticate = this.manager.authenticate(usernamePasswordAuthenticationToken);
        var user = (User) authenticate.getPrincipal();
        return tokenService.genarateToken(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return Optional
                .ofNullable(users)
                .map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> u = userRepository.findById(id);
        return Optional
                .ofNullable(u)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/user")
    public ResponseEntity<User> update(@RequestBody User user) throws URISyntaxException {
        if (userRepository.existsByEmail(user.getEmail()))
            return ResponseEntity.badRequest()
                    .header("FAIL UPDATE", "E-mail in using!")
                    .body(null);

        User u = userRepository.save(user);
        return ResponseEntity
                .ok()
                .header("UPDATE", "User is update!")
                .body(u);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Void> deleteUser(@RequestBody User user) {
        userRepository.delete(user);
        return ResponseEntity
                .ok()
                .header("DELETE", "User deleted from system!")
                .body(null);
    }

}
