package com.codeline.food_delivery_platform.DTO.request;

import com.codeline.food_delivery_platform.Entities.MenuItem;
import com.codeline.food_delivery_platform.Entities.Restaurant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemRequest {

    @NotBlank(message = "Item name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be zero or positive")
    private Double price;

    @NotNull(message = "Vegetarian status is required")
    private Boolean isVegetarian;

    private Integer calories;

    @NotNull(message = "Restaurant ID is required")
    private Integer restaurantId;


    public MenuItem toEntity(Restaurant restaurant) {
        MenuItem item = new MenuItem();
        item.setName(this.name);
        item.setDescription(this.description);
        item.setPrice(this.price);
        item.setIsVegetarian(this.isVegetarian);
        item.setCalories(this.calories);
        item.setRestaurant(restaurant);
        item.setIsAvailable(true);
        return item;
    }
}
