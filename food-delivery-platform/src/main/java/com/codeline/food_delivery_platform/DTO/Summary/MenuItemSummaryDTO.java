package com.codeline.food_delivery_platform.DTO.Summary;

import com.codeline.food_delivery_platform.Entities.MenuItem;

public class MenuItemSummaryDTO {

    private Integer id;
    private String name;
    private double price;

    public static MenuItemSummaryDTO fromEntity(MenuItem item) {
        MenuItemSummaryDTO dto = new MenuItemSummaryDTO();
        dto.id = item.getId();
        dto.name = item.getName();
        dto.price = item.getPrice();
        return dto;
    }
}
