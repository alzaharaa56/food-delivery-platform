package com.codeline.food_delivery_platform.Controllers;

import com.codeline.food_delivery_platform.dtos.OrderRequestDTO;
import com.codeline.food_delivery_platform.Entities.Order;
import com.codeline.food_delivery_platform.Services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderRequestDTO requestDTO) {
        Order savedOrder = orderService.createOrder(requestDTO);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
