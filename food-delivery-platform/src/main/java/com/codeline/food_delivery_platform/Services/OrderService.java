package com.codeline.food_delivery_platform.Services;

import com.codeline.food_delivery_platform.dtos.OrderRequestDTO;
import com.codeline.food_delivery_platform.Entities.Customer;
import com.codeline.food_delivery_platform.Entities.Order;
import com.codeline.food_delivery_platform.Entities.OrderItem;
import com.codeline.food_delivery_platform.Entities.Restaurant;
import com.codeline.food_delivery_platform.Repositories.CustomerRepository;
import com.codeline.food_delivery_platform.Repositories.OrderRepository;
import com.codeline.food_delivery_platform.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Order createOrder(OrderRequestDTO requestDTO) {
        Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Restaurant restaurant = restaurantRepository.findById(requestDTO.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Order order = Order.builder()
                .customer(customer)
                .restaurant(restaurant)
                .status("PENDING")
                .build();

        List<OrderItem> orderItems = new ArrayList<>();
        double totalPrice = 0.0;

        for (var itemDTO : requestDTO.getItems()) {
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .itemName(itemDTO.getItemName())
                    .quantity(itemDTO.getQuantity())
                    .price(itemDTO.getPrice())
                    .build();

            orderItems.add(orderItem);
            totalPrice += itemDTO.getPrice() * itemDTO.getQuantity();
        }

        order.setOrderItems(orderItems);
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }
}
