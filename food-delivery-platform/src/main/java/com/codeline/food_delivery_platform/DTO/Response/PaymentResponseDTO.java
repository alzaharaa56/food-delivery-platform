package com.codeline.food_delivery_platform.DTO.Response;

import com.codeline.food_delivery_platform.Entities.Payment;
import com.codeline.food_delivery_platform.Enums.PaymentMethod;

public class PaymentResponseDTO {

    private Integer id;
    private double amount;
    private PaymentMethod method;

    public static PaymentResponseDTO fromEntity(Payment p) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.id = p.getId();
        dto.amount = p.getAmount();
        dto.method = p.getPaymentMethod();
        return dto;
    }
}