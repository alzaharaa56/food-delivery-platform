package com.codeline.food_delivery_platform.DTO.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverLocationUpdateRequest {

    @NotNull(message = "Latitude is required")
    private Double currentLat;

    @NotNull(message = "Longitude is required")
    private Double currentLng;
}