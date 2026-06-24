package com.codeline.food_delivery_platform.controllers;

import com.codeline.food_delivery_platform.dto.request.OrderRequest;
import com.codeline.food_delivery_platform.dto.response.OrderResponse;
import com.codeline.food_delivery_platform.dto.summary.OrderSummaryResponse;
import com.codeline.food_delivery_platform.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderSummaryResponse>> getCustomerOrderHistory(@PathVariable Integer customerId) {
        return ResponseEntity.ok(orderService.getCustomerOrderHistory(customerId));
    }
}
