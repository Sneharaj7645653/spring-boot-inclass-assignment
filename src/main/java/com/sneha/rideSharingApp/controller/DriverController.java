package com.sneha.rideSharingApp.controller;

import com.sneha.rideSharingApp.model.Ride;
import com.sneha.rideSharingApp.service.RideService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {
    private final RideService rideService;
    public DriverController(RideService rideService){ this.rideService = rideService; }

    @GetMapping("/rides/requests")
    @PreAuthorize("hasAuthority('ROLE_DRIVER')")
    public ResponseEntity<List<Ride>> getRequests(){
        return ResponseEntity.ok(rideService.getPendingRequests());
    }

    @PostMapping("/rides/{rideId}/accept")
    @PreAuthorize("hasAuthority('ROLE_DRIVER')")
    public ResponseEntity<Ride> acceptRide(@PathVariable String rideId, Authentication auth){
        String username = (String) auth.getPrincipal();
        String driverId = username; // or map to actual user id
        Ride r = rideService.acceptRide(rideId, driverId);
        return ResponseEntity.ok(r);
    }
}
