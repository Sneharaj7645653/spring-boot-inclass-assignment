package com.sneha.rideSharingApp.service;

import com.sneha.rideSharingApp.model.Ride;
import com.sneha.rideSharingApp.repository.RideRepository;
import com.sneha.rideSharingApp.exception.NotFoundException;
import com.sneha.rideSharingApp.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RideService {
    private final RideRepository rideRepo;
    public RideService(RideRepository rideRepo){ this.rideRepo = rideRepo; }

    public Ride createRide(String userId, String pickup, String drop){
        Ride r = new Ride();
        r.setUserId(userId);
        r.setPickupLocation(pickup);
        r.setDropLocation(drop);
        r.setStatus("REQUESTED");
        r.setCreatedAt(new Date());
        return rideRepo.save(r);
    }

    public List<Ride> getPendingRequests(){ return rideRepo.findByStatus("REQUESTED"); }

    public Ride acceptRide(String rideId, String driverId){
        Ride r = rideRepo.findById(rideId).orElseThrow(() -> new NotFoundException("Ride not found"));
        if(!"REQUESTED".equals(r.getStatus())) throw new BadRequestException("Ride is not REQUESTED");
        r.setDriverId(driverId);
        r.setStatus("ACCEPTED");
        return rideRepo.save(r);
    }

    public Ride completeRide(String rideId){
        Ride r = rideRepo.findById(rideId).orElseThrow(() -> new NotFoundException("Ride not found"));
        if(!"ACCEPTED".equals(r.getStatus())) throw new BadRequestException("Ride must be ACCEPTED to complete");
        r.setStatus("COMPLETED");
        return rideRepo.save(r);
    }

    public List<Ride> getUserRides(String userId){ return rideRepo.findByUserId(userId); }
}
