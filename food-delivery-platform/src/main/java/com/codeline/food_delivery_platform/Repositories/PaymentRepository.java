package com.codeline.food_delivery_platform.Repositories;

import com.codeline.food_delivery_platform.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query("SELECT p FROM Payment p WHERE p.transactionRef = :ref AND p.isActive = true")
    Optional<Payment> findActiveByTransactionRef(@Param("ref") String ref);
}

