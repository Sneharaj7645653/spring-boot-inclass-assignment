package com.sneha.rideSharingApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a user in the ride-sharing system.
 * Roles: ROLE_USER or ROLE_DRIVER
 */
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String username;
    private String password; // BCrypt hashed
    private String role;     // ROLE_USER or ROLE_DRIVER

    // Default constructor
    public User() {}

    // Parameterized constructor
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
