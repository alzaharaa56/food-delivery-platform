package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.Delivery;
import com.codeline.food_delivery_platform.Enums.DeliveryStatus;
import com.codeline.food_delivery_platform.Enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    @Query("SELECT d FROM Delivery d WHERE d.deliveryDriver.id = :driverId AND d.status = :status AND d.isActive = true")
    List<Delivery> findByDeliveryDriverIdAndStatus(@Param("driverId") Integer driverId, @Param("status") OrderStatus status);

    @Query("SELECT d FROM Delivery d WHERE d.deliveryDriver.id = :driverId AND d.isActive = true")
    List<Delivery> findAllByDriverId(@Param("driverId") Integer driverId);

    @Query("SELECT d FROM Delivery d WHERE d.deliveryDriver.id = :driverId AND d.status =:status  AND d.isActive = true")
    List<Delivery> findActiveDeliveryByDriver(@Param("driverId") Integer driverId,@Param("status") DeliveryStatus status);

    @Query("SELECT d FROM Delivery d WHERE d.status = :status AND d.isActive = true")
    List<Delivery> findAllByStatus(@Param("status") OrderStatus status);

    @Query("SELECT COUNT(d) FROM Delivery d WHERE d.deliveryDriver.id = :driverId AND d.status = :status AND d.isActive = true")
    Long countCompletedDeliveriesByDriver(@Param("driverId") Integer driverId, @Param("status") DeliveryStatus status);
}