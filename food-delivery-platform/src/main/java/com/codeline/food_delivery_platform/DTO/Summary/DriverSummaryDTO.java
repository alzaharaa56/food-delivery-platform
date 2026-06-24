package com.codeline.food_delivery_platform.DTO.Summary;

import com.codeline.food_delivery_platform.Entities.DeliveryDriver;

public class DriverSummaryDTO {

    private Integer id;
    private String name;

    public static DriverSummaryDTO fromEntity(DeliveryDriver deliveryDriver){
        DriverSummaryDTO dto = new DriverSummaryDTO();
        dto.id=deliveryDriver.getId();
        dto.name=deliveryDriver.getFirstName();
        return dto;
    }
}
