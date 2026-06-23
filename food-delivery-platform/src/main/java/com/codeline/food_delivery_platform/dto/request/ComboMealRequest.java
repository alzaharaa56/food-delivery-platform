package com.codeline.food_delivery_platform.dto.request;

import com.codeline.food_delivery_platform.entities.ComboMeal;
import com.codeline.food_delivery_platform.entities.Restaurant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComboMealRequest {

    @NotBlank(message = "Combo name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be zero or positive")
    private Double price;

    @NotNull(message = "Restaurant ID is required")
    private Integer restaurantId;

    public ComboMeal toEntity(Restaurant restaurant) {
        ComboMeal combo = new ComboMeal();
        combo.setName(this.name);
        combo.setDescription(this.description);
        combo.setPrice(this.price);
        combo.setRestaurant(restaurant);
        combo.setIsAvailable(true);
        return combo;
    }
}
