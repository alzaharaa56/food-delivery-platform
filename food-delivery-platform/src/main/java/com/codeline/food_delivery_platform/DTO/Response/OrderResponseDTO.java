package com.codeline.food_delivery_platform.DTO.Response;


import com.codeline.food_delivery_platform.DTO.Summary.CustomerSummaryDTO;
import com.codeline.food_delivery_platform.DTO.Summary.RestaurantSummaryDTO;
import com.codeline.food_delivery_platform.Entities.Order;

public class OrderResponseDTO {
    private Integer id;
    private double totalAmount;
    private String status;

    private CustomerSummaryDTO customer;
    private RestaurantSummaryDTO restaurant;

    public static OrderResponseDTO fromEntity(Order o) {
        OrderResponseDTO dto = new OrderResponseDTO();

        dto.id = o.getId();
        dto.totalAmount = o.getTotalAmount();
        dto.status = o.getStatus().name();

        dto.customer = CustomerSummaryDTO.fromEntity(o.getCustomer());
        dto.restaurant = RestaurantSummaryDTO.fromEntity(o.getRestaurant());

        return dto;
    }
}
