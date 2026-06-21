package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}