package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.Entities.ComboMeal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComboMealResponse {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Boolean isAvailable;

    public static ComboMealResponse fromEntity(ComboMeal combo) {
        ComboMealResponse response = new ComboMealResponse();
        response.setId(combo.getId());
        response.setName(combo.getName());
        response.setDescription(combo.getDescription());
        response.setPrice(combo.getPrice());
        response.setIsAvailable(combo.getIsAvailable());
        return response;
    }
}