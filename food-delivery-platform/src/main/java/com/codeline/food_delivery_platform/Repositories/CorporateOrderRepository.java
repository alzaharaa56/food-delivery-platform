package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.CorporateOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CorporateOrderRepository extends JpaRepository<CorporateOrder, Integer> {

@Query("SELECT co FROM CorporateOrder co WHERE co.corporateCode = :code AND co.isActive = true")
List<CorporateOrder> findActiveByCorporateCode(@Param("code") String code);
}