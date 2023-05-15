package com.maxime.movieappbackend.dto.auth;

import com.maxime.movieappbackend.model.RoleType;

public class UserDto {
    private Long id;
    private String email;
    private RoleType role;

    public UserDto() {
    }

    public UserDto(Long id, String email, RoleType role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleType getRole() {
        return this.role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public UserDto id(Long id) {
        setId(id);
        return this;
    }

    public UserDto email(String email) {
        setEmail(email);
        return this;
    }

    public UserDto role(RoleType role) {
        setRole(role);
        return this;
    }

}
