package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Hands-on 5: "Create authentication service that returns JWT".
 *
 * POST /authenticate  with JSON { "username": "...", "password": "..." }
 *   - valid   -> 200 with { "token": "<jwt>" }
 *   - invalid -> 401
 *
 * The returned token is then sent as  Authorization: Bearer <jwt>  on the
 * protected endpoints (e.g. /countries).
 */
@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final JwtUtil jwtUtil;
    private final String validUsername;
    private final String validPassword;

    public AuthController(JwtUtil jwtUtil,
                          @Value("${app.jwt.username}") String validUsername,
                          @Value("${app.jwt.password}") String validPassword) {
        this.jwtUtil = jwtUtil;
        this.validUsername = validUsername;
        this.validPassword = validPassword;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        LOGGER.info("START authenticate(username={})", username);

        if (validUsername.equals(username) && validPassword.equals(password)) {
            String token = jwtUtil.generateToken(username);
            LOGGER.info("END authenticate() - token issued");
            return ResponseEntity.ok(Map.of("token", token));
        }

        LOGGER.warn("Authentication failed for username={}", username);
        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
}
