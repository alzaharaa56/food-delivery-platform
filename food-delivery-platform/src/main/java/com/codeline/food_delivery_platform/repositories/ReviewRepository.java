package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

@Query("SELECT r FROM Review r WHERE r.restaurant.id = :restaurantId AND r.targetType = 'RESTAURANT' AND r.isActive = true")
List<Review> findActiveReviewsByRestaurantId(@Param("restaurantId") Integer restaurantId);

@Query("SELECT r FROM Review r WHERE r.driver.id = :driverId AND r.targetType = 'DRIVER' AND r.isActive = true")
List<Review> findActiveReviewsByDriverId(@Param("driverId") Integer driverId);
}
