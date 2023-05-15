package com.maxime.movieappbackend.dto.auth;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.maxime.movieappbackend.model.RoleType;
import com.maxime.movieappbackend.model.User;

@Service
public class UserToUserDtoMapper implements Function<User, UserDto> {

    @Override
    public UserDto apply(User userDetails) {
        UserDto user = new UserDto();
        user.setId(userDetails.getId());
        user.setEmail(userDetails.getEmail());
        user.setRole(RoleType.valueOf(userDetails.getRole().toString()));
        return user;
    }

}
