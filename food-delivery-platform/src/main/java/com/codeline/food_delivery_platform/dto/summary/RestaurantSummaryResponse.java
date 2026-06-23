package com.codeline.food_delivery_platform.dto.summary;

import com.codeline.food_delivery_platform.entities.Restaurant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantSummaryResponse {
    private Integer id;
    private String name;
    private String cuisineType;
    private Boolean acceptingOrders;

    public static RestaurantSummaryResponse fromEntity(Restaurant restaurant) {
        RestaurantSummaryResponse summary = new RestaurantSummaryResponse();
        summary.setId(restaurant.getId());
        summary.setName(restaurant.getName());
        summary.setCuisineType(restaurant.getCuisineType());
        summary.setAcceptingOrders(restaurant.getAcceptingOrders());
        return summary;
    }
}
