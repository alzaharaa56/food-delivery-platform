package com.codeline.food_delivery_platform.DTO.Summary;

import com.codeline.food_delivery_platform.Entities.Restaurant;
import lombok.Data;

@Data
public class RestaurantSummaryDTO {

    private Integer id;
    private String name;
    private String cuisineType;

    public static RestaurantSummaryDTO fromEntity(Restaurant r) {
        RestaurantSummaryDTO dto = new RestaurantSummaryDTO();
        dto.id = r.getId();
        dto.name = r.getName();
        dto.cuisineType = r.getCuisineType();
        return dto;
    }

}
