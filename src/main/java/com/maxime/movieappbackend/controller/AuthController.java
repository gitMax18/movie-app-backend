package com.maxime.movieappbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxime.movieappbackend.dto.auth.RegisterRequestDto;
import com.maxime.movieappbackend.dto.auth.UserDto;
import com.maxime.movieappbackend.response.Response;
import com.maxime.movieappbackend.service.authenticationService.AuthenticationService;

// @CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public Response<String> register(@RequestBody RegisterRequestDto request) {
        String token = authenticationService.register(request);
        return new Response<String>(HttpStatus.CREATED.value(), "User created", token);
    }

    @PostMapping("/login")
    public Response<String> authenticate(@RequestBody RegisterRequestDto request) {
        String token = authenticationService.authenticate(request);
        return new Response<String>(HttpStatus.OK.value(), "User authentified", token);
    }

    @GetMapping("/user")
    public Response<UserDto> getUser() {
        UserDto user = authenticationService.getUser();
        return new Response<UserDto>(HttpStatus.OK.value(), "User authentified", user);
    }
}
