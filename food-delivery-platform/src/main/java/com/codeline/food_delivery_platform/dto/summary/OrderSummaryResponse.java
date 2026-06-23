package com.codeline.food_delivery_platform.dto.summary;

import com.codeline.food_delivery_platform.entities.Order;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderSummaryResponse {
    private Integer id;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private String customerName;

    public static OrderSummaryResponse fromEntity(Order order) {
        OrderSummaryResponse summary = new OrderSummaryResponse();
        summary.setId(order.getId());
        summary.setOrderDate(order.getOrderDate());
        summary.setStatus(order.getStatus());
        summary.setTotalAmount(order.getTotalAmount());
        if (order.getCustomer() != null) {
            summary.setCustomerName(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
        }
        return summary;
    }
}
