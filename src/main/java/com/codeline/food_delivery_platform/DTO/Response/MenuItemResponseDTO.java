package com.codeline.food_delivery_platform.DTO.Response;

import com.codeline.food_delivery_platform.Entities.MenuItem;

public class MenuItemResponseDTO {

    private Integer id;
    private String name;
    private double price;
    private boolean isVegetarian;
    private boolean isAvailable;

    public static MenuItemResponseDTO fromEntity(MenuItem m) {
        MenuItemResponseDTO dto = new MenuItemResponseDTO();
        dto.id = m.getId();
        dto.name = m.getName();
        dto.price = m.getPrice();
        dto.isVegetarian = m.getIsVegetarian();
        dto.isAvailable = m.getIsAvailable();
        return dto;
    }
}