package net.palantir.palantirbackend.rest;

import net.palantir.palantirbackend.domain.User;
import net.palantir.palantirbackend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public ResponseEntity<?> login(@RequestBody User u) {
        User user = userRepository.findByEmailAndPass(u.getEmail(), u.getPass());

        if (u.getEmail().equalsIgnoreCase(user.getEmail()) && u.getPass().equals(user.getPass())) {
            System.out.println("Entrou aqui");
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        System.out.println(u.toString());
        return new ResponseEntity<>("Nao funcionou" + user.toString(), HttpStatus.EXPECTATION_FAILED);
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
