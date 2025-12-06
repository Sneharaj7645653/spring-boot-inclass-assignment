package com.sneha.rideSharingApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sneha.rideSharingApp.model.Ride;
import java.util.List;

public interface RideRepository extends MongoRepository<Ride, String> {
    List<Ride> findByStatus(String status);
    List<Ride> findByUserId(String userId);
}
