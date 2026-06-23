package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

@Query("SELECT d FROM Delivery d WHERE d.trackingCode = :code AND d.isActive = true")
Optional<Delivery> findActiveByTrackingCode(@Param("code") String code);
}
