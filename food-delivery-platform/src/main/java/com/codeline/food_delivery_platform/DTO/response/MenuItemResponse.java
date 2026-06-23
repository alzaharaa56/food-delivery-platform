package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.Entities.MenuItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemResponse {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Boolean isAvailable;
    private Boolean isVegetarian;
    private Integer calories;


    public static MenuItemResponse fromEntity(MenuItem item) {
        MenuItemResponse response = new MenuItemResponse();
        response.setId(item.getId());
        response.setName(item.getName());
        response.setDescription(item.getDescription());
        response.setPrice(item.getPrice());
        response.setIsAvailable(item.getIsAvailable());
        response.setIsVegetarian(item.getIsVegetarian());
        response.setCalories(item.getCalories());
        return response;
    }
}
