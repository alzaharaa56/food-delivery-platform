package com.codeline.food_delivery_platform.DTO.Request;

import com.codeline.food_delivery_platform.Entities.Restaurant;
import com.codeline.food_delivery_platform.Entities.RestaurantOwner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequestDTO {
    @NotBlank
    private String name;
    @NotBlank private String description;
    @NotBlank private String cuisineType;
    @PositiveOrZero
    private double minOrderAmount;
    @PositiveOrZero private double deliveryFee;

    public Restaurant toEntity(RestaurantOwner owner) {
        Restaurant r = new Restaurant();
        r.setName(name);
        r.setDescription(description);
        r.setCuisineType(cuisineType);
        r.setMinOrderAmount(minOrderAmount);
        r.setDeliveryFee(deliveryFee);
        r.setOwner(owner);
        r.setIsActive(true);
        r.setCreatedDate(LocalDateTime.now());
        r.setUpdatedDate(LocalDateTime.now());
        return r;
    }
}
