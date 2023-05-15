package com.maxime.movieappbackend.model;

public enum RoleType {
    USER("USER"),
    ADMIN("ADMIN");

    private final String roleType;

    private RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return this.roleType;
    }
}
