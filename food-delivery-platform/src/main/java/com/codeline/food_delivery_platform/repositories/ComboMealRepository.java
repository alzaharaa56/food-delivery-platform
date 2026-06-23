package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.ComboMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ComboMealRepository extends JpaRepository<ComboMeal, Integer> {

@Query("SELECT c FROM ComboMeal c WHERE c.restaurant.id = :restaurantId AND c.isActive = true AND c.isAvailable = true")
List<ComboMeal> findActiveCombosByRestaurantId(@Param("restaurantId") Integer restaurantId);
}
