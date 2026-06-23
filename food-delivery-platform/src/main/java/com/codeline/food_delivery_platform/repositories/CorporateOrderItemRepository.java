package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.CorporateOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateOrderItemRepository extends JpaRepository<CorporateOrderItem, Integer> {
}
