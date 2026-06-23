package com.codeline.food_delivery_platform.repositories;
import com.codeline.food_delivery_platform.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


        Optional<Customer> findByEmail(String email);

        @Query("SELECT c FROM Customer c WHERE c.email = :email AND c.isActive = true")
        Optional<Customer> findActiveByEmail(@Param("email") String email);

        @Query("SELECT c FROM Customer c WHERE c.customerCode = :code AND c.isActive = true")
        Optional<Customer> findActiveByCode(@Param("code") String code);
}
