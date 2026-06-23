package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {


      @Query("SELECT r FROM Restaurant r WHERE r.isActive = true AND r.acceptingOrders = true")
List<Restaurant> findAllActiveAndAcceptingJPA();


      @Query("SELECT r FROM Restaurant r WHERE r.owner.id = :ownerId AND r.isActive = true")
List<Restaurant> findActiveByOwnerId(@Param("ownerId") Integer ownerId);
}
