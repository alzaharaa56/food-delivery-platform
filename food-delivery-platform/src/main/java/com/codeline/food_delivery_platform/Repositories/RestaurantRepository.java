package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


  @Query("SELECT r FROM Restaurant r WHERE " +
"LOWER(r.cuisineType) LIKE LOWER(CONCAT('%', :cuisine, '%')) OR " +
"LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
List<Restaurant> searchByCuisineAndKeyword(@Param("cuisine") String cuisine, @Param("keyword") String keyword);
}
