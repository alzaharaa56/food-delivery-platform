package com.codeline.food_delivery_platform.DTO.summary;

import com.codeline.food_delivery_platform.Entities.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantSummaryDTO {
    private Integer id;
    private String name;
    private String cuisineType;

    public static RestaurantSummaryDTO fromEntity(Restaurant restaurant){
        if (restaurant == null) return null;

        return RestaurantSummaryDTO.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .cuisineType(restaurant.getCuisineType())
                .build();
    }
}