package com.codeline.food_delivery_platform.DTO.request;

import com.codeline.food_delivery_platform.entities.Restaurant;
import com.codeline.food_delivery_platform.entities.RestaurantOwner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;

@Getter
@Setter
public class RestaurantRequest {

    @NotBlank(message = "Restaurant name is required")
    private String name;

    private String description;

    @NotBlank(message = "Cuisine type is required")
    private String cuisineType;

    @NotNull(message = "Opening time is required")
    private LocalTime openingTime;

    @NotNull(message = "Closing time is required")
    private LocalTime closingTime;

    @NotNull(message = "Minimum order amount is required")
    @PositiveOrZero(message = "Minimum order amount must be zero or positive")
    private Double minOrderAmount;

    @NotNull(message = "Delivery fee is required")
    @PositiveOrZero(message = "Delivery fee must be zero or positive")
    private Double deliveryFee;

    @NotNull(message = "Owner ID is required")
    private Integer ownerId;


    public Restaurant toEntity(RestaurantOwner owner) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(this.name);
        restaurant.setDescription(this.description);
        restaurant.setCuisineType(this.cuisineType);
        restaurant.setOpeningTime(this.openingTime);
        restaurant.setClosingTime(this.closingTime);
        restaurant.setMinOrderAmount(this.minOrderAmount);
        restaurant.setDeliveryFee(this.deliveryFee);
        restaurant.setOwner(owner);
        restaurant.setAcceptingOrders(true);
        return restaurant;
    }
}
