package com.codeline.food_delivery_platform.dto.response;

import com.codeline.food_delivery_platform.entities.Payment;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentResponse {
    private Integer id;
    private String paymentMethod;
    private String status;
    private Double amount;
    private LocalDateTime paymentDate;

    public static PaymentResponse fromEntity(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setId(payment.getId());
        response.setPaymentMethod(payment.getPaymentMethod());
        response.setStatus(payment.getStatus());
        response.setAmount(payment.getAmount());
        response.setPaymentDate(payment.getPaymentDate());
        return response;
    }
}
