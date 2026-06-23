package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, Integer> {


      @Query("SELECT d FROM DeliveryDriver d WHERE d.isOnline = true AND d.isActive = true")
List<DeliveryDriver> findAvailableDrivers();

@Query("SELECT d FROM DeliveryDriver d WHERE d.driverCode = :code AND d.isActive = true")
Optional<DeliveryDriver> findActiveByCode(@Param("code") String code);
}