package com.example.bilete.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.bilete.model.Utilizator;
import com.example.bilete.repository.UtilizatorRepository;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UtilizatorRepository utilizatorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String parola = loginData.get("parola");

        Map<String, Object> response = new HashMap<>();

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, parola));

            String token = jwtUtil.generateToken(email);

            response.put("token", token);
            response.put("status", "success");
            response.put("email", email);

        } catch (AuthenticationException e) {
            response.put("status", "error");
            response.put("message", "Email sau parolă incorectă");
        }

        return response;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Utilizator user) {
        Map<String, Object> response = new HashMap<>();

        if (utilizatorRepository.findByEmail(user.getEmail()).isPresent()) {
            response.put("status", "error");
            response.put("message", "Există deja un cont cu acest email.");
            return response;
        }

        user.setParola(passwordEncoder.encode(user.getParola()));
        utilizatorRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());
        response.put("status", "success");
        response.put("token", token);
        response.put("user", user.getEmail());

        return response;
    }
}
