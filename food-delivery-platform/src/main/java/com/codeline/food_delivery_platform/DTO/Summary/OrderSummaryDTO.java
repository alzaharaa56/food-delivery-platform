package com.codeline.food_delivery_platform.DTO.Summary;

import com.codeline.food_delivery_platform.Entities.Order;
import com.codeline.food_delivery_platform.Enums.OrderStatus;

public class OrderSummaryDTO {

    private Integer id;
    private double totalAmount;
    private OrderStatus status;

    public static OrderSummaryDTO fromEntity(Order o){
        OrderSummaryDTO dto = new OrderSummaryDTO();
        dto.id= o.getId();
        dto.totalAmount = o.getTotalAmount();
        dto.status = o.getStatus();
        return dto;
    }
}
