package com.sneha.rideSharingApp.dto;

/**
 * Response containing the generated JWT token after successful login/registration.
 */
public class AuthResponse {

    private String token;

    // Required for serialization/deserialization (Jackson)
    public AuthResponse() {}

    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Setter (optional — remove if you prefer immutability)
    public void setToken(String token) {
        this.token = token;
    }
}
