package com.codeline.food_delivery_platform.repositories;

import com.codeline.food_delivery_platform.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query(value = "SELECT * FROM payments WHERE transaction_method = :ref AND is_active = true", nativeQuery = true)
Optional<Payment> findActiveByTransactionRef(@Param("ref") String ref);
}

