package com.sneha.rideSharingApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO used during user registration request.
 * Validated automatically by Spring using @Valid.
 */
public class RegisterRequest {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, message = "Username must be at least 3 characters long")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    private String password;

    @NotBlank(message = "Role is required (ROLE_USER / ROLE_DRIVER)")
    private String role; // Acceptable values: ROLE_USER, ROLE_DRIVER

    // Default constructor (needed for Spring)
    public RegisterRequest() {}

    // Parameterized constructor — useful for manual object creation
    public RegisterRequest(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters & setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
