package com.codeline.food_delivery_platform.Repositories;
import com.codeline.food_delivery_platform.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


        @Query("SELECT c FROM Customer c WHERE c.email = :email AND c.isActive = true")
Optional<Customer> findActiveByEmail(@Param("email") String email);


        @Query("SELECT c FROM Customer c WHERE c.customerCode = :code AND c.isActive = true")
Optional<Customer> findActiveByCode(@Param("code") String code);
}
