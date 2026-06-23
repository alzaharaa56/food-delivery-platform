package com.codeline.food_delivery_platform.DTO.response;
import com.codeline.food_delivery_platform.DTO.summary.CustomerSummaryResponse;
import com.codeline.food_delivery_platform.DTO.summary.RestaurantSummaryResponse;
import com.codeline.food_delivery_platform.Entities.Order;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderResponse {
    private Integer id;
    private String orderCode;
    private LocalDateTime orderDate;
    private String status;
    private Double subtotal;
    private Double deliveryFee;
    private Double discountAmount;
    private Double totalAmount;
    private String deliveryNotes;


    private CustomerSummaryResponse customer;
    private RestaurantSummaryResponse restaurant;
    private List<OrderItemResponse> items;

    public static OrderResponse fromEntity(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setOrderCode(order.getOrderCode());
        response.setOrderDate(order.getOrderDate());
        response.setStatus(order.getStatus());
        response.setSubtotal(order.getSubtotal());
        response.setDeliveryFee(order.getDeliveryFee());
        response.setDiscountAmount(order.getDiscountAmount());
        response.setTotalAmount(order.getTotalAmount());
        response.setDeliveryNotes(order.getDeliveryNotes());

        if (order.getCustomer() != null) {
            response.setCustomer(CustomerSummaryResponse.fromEntity(order.getCustomer()));
        }
        if (order.getRestaurant() != null) {
            response.setRestaurant(RestaurantSummaryResponse.fromEntity(order.getRestaurant()));
        }
        if (order.getOrderItems() != null) {
            response.setItems(order.getOrderItems().stream()
                    .map(OrderItemResponse::fromEntity)
                    .collect(Collectors.toList()));
        }
        return response;
    }
}
