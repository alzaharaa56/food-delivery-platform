package com.codeline.food_delivery_platform.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentProcessRequest {

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    @NotNull(message = "Order ID is required")
    private Integer orderId;
}
