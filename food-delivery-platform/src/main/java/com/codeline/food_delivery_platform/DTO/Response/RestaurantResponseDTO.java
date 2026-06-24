package com.codeline.food_delivery_platform.DTO.Response;

import com.codeline.food_delivery_platform.Entities.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponseDTO {
    private Integer id;
    private String name;
    private String description;
    private String cuisineType;
    private double deliveryFee;
    private boolean acceptingOrders;

    public static RestaurantResponseDTO fromEntity(Restaurant r) {
        return new RestaurantResponseDTO(
                r.getId(), r.getName(), r.getDescription(),
                r.getCuisineType(), r.getDeliveryFee(), r.isAcceptingOrders()
        );
    }
}
