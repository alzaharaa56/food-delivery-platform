package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.DTO.summary.MenuItemSummaryDTO;
import com.codeline.food_delivery_platform.Entities.OrderItem;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDTO {
    private Integer id;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private String specialInstructions;

    private MenuItemSummaryDTO menuItem;

    public static OrderItemResponseDTO fromEntity(OrderItem item) {
        if (item == null) return null;

        OrderItemResponseDTO dto = new OrderItemResponseDTO();

        dto.setId(item.getId());
        dto.setQuantity(item.getQuantity());
        dto.setUnitPrice(item.getUnitPrice());
        dto.setTotalPrice(item.getTotalPrice());
        dto.setSpecialInstructions(item.getSpecialInstructions());

        dto.setMenuItem(MenuItemSummaryDTO.fromEntity(item.getMenuItem()));

        return dto;

    }
}