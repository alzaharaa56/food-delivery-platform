package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.ComboMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ComboMealRepository extends JpaRepository<ComboMeal, Integer> {

    @Query(value = "SELECT * FROM combo_meal WHERE restaurant_id = :restaurantId AND is_active = true AND is_available = true", nativeQuery = true)
List<ComboMeal> findActiveCombosByRestaurantId(@Param("restaurantId") Integer restaurantId);
}
