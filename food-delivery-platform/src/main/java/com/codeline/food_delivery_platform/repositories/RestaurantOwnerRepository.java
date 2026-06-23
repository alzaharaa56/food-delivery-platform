package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner, Integer> {

@Query("SELECT o FROM RestaurantOwner o WHERE o.email = :email AND o.isActive = true")
Optional<RestaurantOwner> findActiveByEmail(@Param("email") String email);
}