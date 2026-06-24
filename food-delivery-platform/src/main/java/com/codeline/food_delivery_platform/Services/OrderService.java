package com.codeline.food_delivery_platform.Services;

import com.codeline.food_delivery_platform.dto.request.OrderRequest;
import com.codeline.food_delivery_platform.dto.response.OrderResponse;
import com.codeline.food_delivery_platform.dto.summary.OrderSummaryResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);

    OrderResponse getOrderById(Integer id);

    List<OrderSummaryResponse> getCustomerOrderHistory(Integer customerId);
}
