package com.codeline.food_delivery_platform.services;

import com.codeline.food_delivery_platform.dto.request.OrderRequest;
import com.codeline.food_delivery_platform.dto.response.OrderResponse;
import com.codeline.food_delivery_platform.dto.summary.OrderSummaryResponse;
import com.codeline.food_delivery_platform.entities.Customer;
import com.codeline.food_delivery_platform.entities.Order;
import com.codeline.food_delivery_platform.entities.Restaurant;
import com.codeline.food_delivery_platform.exceptions.ResourceNotFoundException;
import com.codeline.food_delivery_platform.repositories.CustomerRepository;
import com.codeline.food_delivery_platform.repositories.OrderRepository;
import com.codeline.food_delivery_platform.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + request.getCustomerId()));

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + request.getRestaurantId()));

        Order order = new Order();
        order.setCustomer(customer);
        order.setRestaurant(restaurant);


        order.setStatus("PENDING");

        Order savedOrder = orderRepository.save(order);
        return OrderResponse.fromEntity(savedOrder);
    }

    @Override
    public OrderResponse getOrderById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        return OrderResponse.fromEntity(order);
    }

    @Override
    public List<OrderSummaryResponse> getCustomerOrderHistory(Integer customerId) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getCustomer() != null && order.getCustomer().getId().equals(customerId))
                .map(OrderSummaryResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
