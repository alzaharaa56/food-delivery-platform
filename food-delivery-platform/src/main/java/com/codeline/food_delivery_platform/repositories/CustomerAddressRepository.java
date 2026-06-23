package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {


 @Query("SELECT a FROM CustomerAddress a WHERE a.customer.id = :customerId AND a.isActive = true")
List<CustomerAddress> findActiveAddressesByCustomerId(@Param("customerId") Integer customerId);
}