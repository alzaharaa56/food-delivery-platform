package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {


    @Query("SELECT m FROM MenuItem m WHERE m.restaurant.id = :restaurantId AND m.isActive = true AND m.isAvailable = true")
List<MenuItem> findActiveMenuByRestaurantId(@Param("restaurantId") Integer restaurantId);
}