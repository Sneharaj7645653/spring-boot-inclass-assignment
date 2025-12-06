package com.sneha.rideSharingApp.controller;

import com.sneha.rideSharingApp.dto.CreateRideRequest;
import com.sneha.rideSharingApp.service.RideService;
import com.sneha.rideSharingApp.model.Ride;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RideController {
    private final RideService rideService;
    public RideController(RideService rideService){ this.rideService = rideService; }

    @PostMapping("/rides")
    public ResponseEntity<Ride> createRide(@Valid @RequestBody CreateRideRequest req, Authentication auth){
        // auth.getPrincipal() is username (as set in filter)
        String username = (String) auth.getPrincipal();
        // You might need a way to map username -> userId. For simplicity, store username as userId or fetch from UserRepo.
        // Here we assume username equals userId, or fetch ID using UserRepository (implement as needed).
        String userId = username; // replace with actual user id lookup if needed
        Ride created = rideService.createRide(userId, req.getPickupLocation(), req.getDropLocation());
        return ResponseEntity.ok(created);
    }

    @PostMapping("/rides/{rideId}/complete")
    public ResponseEntity<Ride> completeRide(@PathVariable String rideId){
        Ride r = rideService.completeRide(rideId);
        return ResponseEntity.ok(r);
    }

    @GetMapping("/user/rides")
    public ResponseEntity<List<Ride>> getMyRides(Authentication auth){
        String username = (String) auth.getPrincipal();
        String userId = username; // or resolve
        return ResponseEntity.ok(rideService.getUserRides(userId));
    }
}
