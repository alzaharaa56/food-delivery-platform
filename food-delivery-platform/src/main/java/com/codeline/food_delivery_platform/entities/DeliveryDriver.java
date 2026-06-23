package com.codeline.food_delivery_platform.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "delivery_drivers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDriver extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "driver_code", nullable = false, unique = true)
    private String driverCode;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    @Column(name = "vehicle_plate", nullable = false)
    private String vehiclePlate;

    @Column(name = "current_lat")
    private Double currentLat;

    @Column(name = "current_lng")
    private Double currentLng;

    @Column(name = "is_online", nullable = false)
    private Boolean isOnline = false;
}
