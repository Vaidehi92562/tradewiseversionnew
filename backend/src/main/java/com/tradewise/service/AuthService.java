package com.tradewise.service;

import com.tradewise.dto.LoginRequest;
import com.tradewise.dto.RegisterRequest;
import com.tradewise.model.User;
import com.tradewise.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, String> register(RegisterRequest request) {
        Map<String, String> response = new HashMap<>();

        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            response.put("status", "ERROR");
            response.put("message", "Email already registered");
            return response;
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        response.put("status", "SUCCESS");
        response.put("message", "User registered successfully");
        return response;
    }

    public Map<String, String> login(LoginRequest request) {
        Map<String, String> response = new HashMap<>();

        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isEmpty()) {
            response.put("status", "ERROR");
            response.put("message", "User not found");
            return response;
        }

        User user = existingUser.get();

        if (!user.getPassword().equals(request.getPassword())) {
            response.put("status", "ERROR");
            response.put("message", "Invalid password");
            return response;
        }

        response.put("status", "SUCCESS");
        response.put("message", "Login successful");
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        return response;
    }
}