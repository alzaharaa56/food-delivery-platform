package com.codeline.food_delivery_platform.dto.summary;

import com.codeline.food_delivery_platform.entities.MenuItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemSummaryResponse {
    private Integer id;
    private String name;
    private Double price;

    public static MenuItemSummaryResponse fromEntity(MenuItem item) {
        MenuItemSummaryResponse summary = new MenuItemSummaryResponse();
        summary.setId(item.getId());
        summary.setName(item.getName());
        summary.setPrice(item.getPrice());
        return summary;
    }
}
