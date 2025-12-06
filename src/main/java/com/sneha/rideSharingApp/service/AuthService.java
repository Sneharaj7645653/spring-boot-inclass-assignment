package com.sneha.rideSharingApp.service;

import com.sneha.rideSharingApp.dto.*;
import com.sneha.rideSharingApp.model.User;
import com.sneha.rideSharingApp.repository.UserRepository;
import com.sneha.rideSharingApp.util.JwtUtil;
import com.sneha.rideSharingApp.exception.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepo, BCryptPasswordEncoder encoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo; this.encoder = encoder; this.jwtUtil = jwtUtil;
    }

    public void register(RegisterRequest req){
        if(userRepo.existsByUsername(req.getUsername())) throw new BadRequestException("Username taken");
        User u = new User();
        u.setUsername(req.getUsername());
        u.setPassword(encoder.encode(req.getPassword()));
        u.setRole(req.getRole());
        userRepo.save(u);
    }

    public AuthResponse login(LoginRequest req){
        var user = userRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));
        if(!encoder.matches(req.getPassword(), user.getPassword()))
            throw new BadRequestException("Invalid credentials");
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        return new AuthResponse(token);
    }
}
