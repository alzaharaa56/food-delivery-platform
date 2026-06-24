package com.codeline.food_delivery_platform.DTO.Request;

import com.codeline.food_delivery_platform.Entities.Order;
import com.codeline.food_delivery_platform.Entities.Payment;
import com.codeline.food_delivery_platform.Enums.PaymentMethod;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
    @NotNull
    private Order order;

    @DecimalMin("0.0")
    private double amount;

    @Pattern(regexp = "CARD|CASH|ONLINE")
    private PaymentMethod method;

    public static Payment toEntity(PaymentRequestDTO dto){
        Payment payment = new Payment();
        payment.setOrder(dto.getOrder());
        payment.setAmount(dto.getAmount());
        payment.setPaymentMethod(dto.getMethod());
        return payment;
    }
}
