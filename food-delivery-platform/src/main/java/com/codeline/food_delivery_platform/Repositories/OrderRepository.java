package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

@Query("SELECT o FROM Order o WHERE o.orderCode = :code AND o.isActive = true")
Optional<Order> findActiveByCode(@Param("code") String code);

@Query("SELECT o FROM Order o WHERE o.customer.id = :customerId AND o.isActive = true")
List<Order> findActiveOrdersByCustomerId(@Param("customerId") Integer customerId);

@Query("SELECT o FROM Order o WHERE o.restaurant.id = :restaurantId AND o.isActive = true")
List<Order> findActiveOrdersByRestaurantId(@Param("restaurantId") Integer restaurantId);
}
