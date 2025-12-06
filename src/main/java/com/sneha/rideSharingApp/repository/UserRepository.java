package com.sneha.rideSharingApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sneha.rideSharingApp.model.User;
import java.util.Optional;

/**
 * Repository for User document.
 * Provides built-in CRUD + custom query methods.
 */
public interface UserRepository extends MongoRepository<User, String> {

    // Fetch user by username (used during login/JWT authentication)
    Optional<User> findByUsername(String username);

    // Check if a username already exists (used in registration)
    boolean existsByUsername(String username);
}
