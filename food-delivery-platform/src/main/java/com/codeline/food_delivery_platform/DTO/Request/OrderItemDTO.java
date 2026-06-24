package com.codeline.food_delivery_platform.DTO.Request;

import com.codeline.food_delivery_platform.Entities.MenuItem;
import com.codeline.food_delivery_platform.Entities.OrderItem;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    @NotNull
    private MenuItem Item;

    @PositiveOrZero
    private double price;

    @Min(1)
    private int quantity;

    public static OrderItem toEntity(OrderItemDTO dto){
        OrderItem orderItem = new OrderItem();
        orderItem.setMenuItem(dto.getItem());
        orderItem.setUnitPrice(dto.getPrice());
        orderItem.setQuantity(dto.getQuantity());

        return orderItem;
    }
}
