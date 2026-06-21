package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query("SELECT c FROM Customer c WHERE c.status = :status")
    List<Customer> findCustomersByStatus(@Param("status") String status);
}

