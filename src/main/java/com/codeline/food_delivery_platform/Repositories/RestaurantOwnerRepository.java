package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner, Integer> {

        @Query("SELECT r FROM RestaurantOwner r WHERE r.id = :id AND r.isActive = true")
Optional<RestaurantOwner> findById(@Param("id") Integer id);

        @Query("SELECT r FROM RestaurantOwner r WHERE r.email = :email AND r.isActive = true")
RestaurantOwner findByEmail(@Param("email") String email);
}
