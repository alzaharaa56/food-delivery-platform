package com.codeline.food_delivery_platform.DTO.Response;

import com.codeline.food_delivery_platform.Entities.DeliveryDriver;

public class DriverResponseDTO {

    private Integer driverId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public static DriverResponseDTO fromEntity(DeliveryDriver d){
        DriverResponseDTO dto = new DriverResponseDTO();
        dto.driverId=d.getId();
        dto.firstName=d.getFirstName();
        dto.lastName=d.getLastName();
        dto.email=d.getEmail();
        dto.phone=d.getPhone();

        return dto;
    }
}
