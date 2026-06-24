package com.codeline.food_delivery_platform.DTO.Request;

import com.codeline.food_delivery_platform.Entities.Customer;
import com.codeline.food_delivery_platform.Entities.Order;
import com.codeline.food_delivery_platform.Entities.Restaurant;
import com.codeline.food_delivery_platform.Enums.OrderStatus;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    @NotNull
    private Customer customer;

    @NotNull
    private Restaurant restaurant;

    @NotEmpty
    private List<@Valid OrderItemDTO> items;

    @Pattern(regexp = "PENDING|PREPARING|READY|OUT_FOR_DELIVERY|DELIVERED|CANCELLED")
    private OrderStatus status;

    public static Order toEntity(OrderRequestDTO dto) {
        Order order = new Order();
        order.setCustomer(dto.getCustomer());
        order.setRestaurant(dto.getRestaurant());
        order.setStatus(dto.getStatus());
        return order;
    }
}
