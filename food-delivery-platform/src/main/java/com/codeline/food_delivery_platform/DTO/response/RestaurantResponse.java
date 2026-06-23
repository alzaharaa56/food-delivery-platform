package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.Entities.Restaurant;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;

@Getter
@Setter
public class RestaurantResponse {
    private Integer id;
    private String name;
    private String description;
    private String cuisineType;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private Double minOrderAmount;
    private Double deliveryFee;
    private Boolean acceptingOrders;


    public static RestaurantResponse fromEntity(Restaurant restaurant) {
        RestaurantResponse response = new RestaurantResponse();
        response.setId(restaurant.getId());
        response.setName(restaurant.getName());
        response.setDescription(restaurant.getDescription());
        response.setCuisineType(restaurant.getCuisineType());
        response.setOpeningTime(restaurant.getOpeningTime());
        response.setClosingTime(restaurant.getClosingTime());
        response.setMinOrderAmount(restaurant.getMinOrderAmount());
        response.setDeliveryFee(restaurant.getDeliveryFee());
        response.setAcceptingOrders(restaurant.getAcceptingOrders());
        return response;
    }
}
