package net.palantir.palantirbackend.service;

import com.auth0.jwt.algorithms.Algorithm;
import net.palantir.palantirbackend.domain.User;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    public String genarateToken(User user) {
        return JWT.create().withIssuer("Profile")
                .withSubject(user.getEmail()).withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("palantir"));
    }
}
