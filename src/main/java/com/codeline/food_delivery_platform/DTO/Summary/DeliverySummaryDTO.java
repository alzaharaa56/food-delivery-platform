package com.codeline.food_delivery_platform.DTO.Summary;


import com.codeline.food_delivery_platform.Entities.Delivery;
import com.codeline.food_delivery_platform.Enums.DeliveryStatus;

public class DeliverySummaryDTO {

    private Integer id;
    private DeliveryStatus status;
    private DriverSummaryDTO driver;

    public static DeliverySummaryDTO fromEntity(Delivery d){
        DeliverySummaryDTO dto = new DeliverySummaryDTO();
        dto.id = d.getId();
        dto.status = d.getStatus();
        dto.driver = DriverSummaryDTO.fromEntity(d.getDeliveryDriver());

        return dto;
    }

}
