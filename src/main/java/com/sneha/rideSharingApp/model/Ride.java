package com.sneha.rideSharingApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Represents a ride in the ride-sharing system.
 * Status: REQUESTED / ACCEPTED / COMPLETED
 */
@Document(collection = "rides")
public class Ride {

    @Id
    private String id;

    private String userId;      // Passenger who requested the ride
    private String driverId;    // Driver assigned (nullable)
    private String pickupLocation;
    private String dropLocation;
    private String status;      // REQUESTED / ACCEPTED / COMPLETED
    private Date createdAt;

    // Default constructor
    public Ride() {}

    // Parameterized constructor
    public Ride(String userId, String driverId, String pickupLocation, String dropLocation, String status, Date createdAt) {
        this.userId = userId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
