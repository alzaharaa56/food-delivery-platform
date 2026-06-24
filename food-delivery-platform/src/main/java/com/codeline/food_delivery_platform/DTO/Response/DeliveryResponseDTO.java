package com.codeline.food_delivery_platform.DTO.Response;

import com.codeline.food_delivery_platform.DTO.Summary.OrderSummaryDTO;
import com.codeline.food_delivery_platform.Entities.Delivery;
import com.codeline.food_delivery_platform.Enums.DeliveryStatus;

public class DeliveryResponseDTO {

    private Integer id;
    private DeliveryStatus status;

    private OrderSummaryDTO order;

    public static DeliveryResponseDTO fromEntity(Delivery d) {
        DeliveryResponseDTO dto = new DeliveryResponseDTO();
        dto.id = d.getId();
        dto.status = d.getStatus();

        dto.order = OrderSummaryDTO.fromEntity(d.getOrder());
        //dto.driver = DriverSummaryDTO.fromEntity(d.getDriver());

        return dto;
    }
}
