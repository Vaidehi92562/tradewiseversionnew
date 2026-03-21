package com.tradewise.controller;

import com.tradewise.dto.LoginRequest;
import com.tradewise.dto.RegisterRequest;
import com.tradewise.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}