package com.codeline.food_delivery_platform.DTO.Response;

import com.codeline.food_delivery_platform.DTO.Summary.RestaurantSummaryDTO;
import com.codeline.food_delivery_platform.Entities.Restaurant;

public class RestaurantResponseDTO {

    private Integer id;
    private String name;
    private String cuisineType;
    private double deliveryFee;
    private boolean acceptingOrders;

    public static RestaurantResponseDTO fromEntity(Restaurant r) {
        RestaurantResponseDTO dto = new RestaurantResponseDTO();
        dto.id = r.getId();
        dto.name = r.getName();
        dto.cuisineType = r.getCuisineType();
        dto.deliveryFee = r.getDeliveryFee();
        dto.acceptingOrders = r.getAcceptingOrders();
        return dto;
    }
}
