package com.maxime.movieappbackend.service.authenticationService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxime.movieappbackend.Exception.exceptionTypes.RessourceNotFoundException;
import com.maxime.movieappbackend.Exception.exceptionTypes.UniqueConstraintException;
import com.maxime.movieappbackend.dto.auth.RegisterRequestDto;
import com.maxime.movieappbackend.dto.auth.UserDto;
import com.maxime.movieappbackend.dto.auth.UserToUserDtoMapper;
import com.maxime.movieappbackend.model.RoleType;
import com.maxime.movieappbackend.model.User;
import com.maxime.movieappbackend.repository.UserRepository;
import com.maxime.movieappbackend.service.jwt.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserToUserDtoMapper userToUserDtoMapper;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder,
            JwtService jwtService, AuthenticationManager authenticationManager,
            UserToUserDtoMapper userToUserDtoMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userToUserDtoMapper = userToUserDtoMapper;

    }

    public String register(RegisterRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            Map<String, String> details = new HashMap<>();
            details.put("email", request.getEmail() + " already exist");
            throw new UniqueConstraintException("Constraint violation", details);
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(RoleType.USER);
        userRepository.save(user);
        Claims claims = Jwts.claims();
        claims.put("user", userToUserDtoMapper.apply(user));
        String jwtToken = jwtService.generateToken(claims, user);
        return jwtToken;
    }

    public String authenticate(RegisterRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RessourceNotFoundException("user not found"));

        Claims claims = Jwts.claims();
        claims.put("user", userToUserDtoMapper.apply(user));
        String jwtToken = jwtService.generateToken(claims, user);
        return jwtToken;
    }

    public UserDto getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() == null) {
            throw new RessourceNotFoundException("Can get user");
        }

        User user = (User) auth.getPrincipal();
        return userToUserDtoMapper.apply(user);
    }
}
