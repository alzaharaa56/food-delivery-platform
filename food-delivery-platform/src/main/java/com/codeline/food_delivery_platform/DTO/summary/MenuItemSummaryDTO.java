package com.codeline.food_delivery_platform.DTO.summary;


import com.codeline.food_delivery_platform.Entities.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItemSummaryDTO {
    private Integer id;
    private String name;
    private Double price;

    public static MenuItemSummaryDTO fromEntity(MenuItem item) {
        if (item == null) return null;

        return MenuItemSummaryDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .build();
    }
}
