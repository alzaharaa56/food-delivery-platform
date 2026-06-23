package com.codeline.food_delivery_platform.DTO.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CorporateOrderRequest {

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Cost center is required")
    private String costCenter;

    @NotNull(message = "Restaurant ID is required")
    private Integer restaurantId;

    @NotEmpty(message = "Corporate order must contain items")
    @Valid
    private List<CorporateOrderItemRequest> items;
}
