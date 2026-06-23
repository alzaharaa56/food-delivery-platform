package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner, Integer> {

     Optional<RestaurantOwner> findByEmail(String email);


      @Query("SELECT o FROM RestaurantOwner o WHERE o.email = :email AND o.isActive = true")
Optional<RestaurantOwner> findActiveByEmail(@Param("email") String email);
}