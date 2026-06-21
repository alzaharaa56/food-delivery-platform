package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.ComboMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComboMealRepository extends JpaRepository<ComboMeal, Integer> {
    @Query("select c from ComboMeal c join c.menuItem m where m.id = :menuItemId AND c.isActive = true")
    List<ComboMeal> findByMenuItemId(@Param("menuItemId") Integer menuItemId);

}
