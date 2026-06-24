package com.codeline.food_delivery_platform.DTO.Summary;

import com.codeline.food_delivery_platform.Entities.Payment;
import com.codeline.food_delivery_platform.Enums.PaymentMethod;
import com.codeline.food_delivery_platform.Enums.PaymentStatus;

public class PaymentSummaryDTO {

    private Integer id;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;

    public static PaymentSummaryDTO fromEntity(Payment p) {
        PaymentSummaryDTO dto = new PaymentSummaryDTO();
        dto.id = p.getId();
        dto.amount = p.getAmount();
        dto.method = p.getPaymentMethod();
        dto.status = p.getStatus();
        return dto;
    }
}
