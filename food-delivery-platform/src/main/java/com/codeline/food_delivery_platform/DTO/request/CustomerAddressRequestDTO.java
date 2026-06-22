package com.codeline.food_delivery_platform.DTO.request;

import com.codeline.food_delivery_platform.Entities.CustomerAddress;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressRequestDTO {
    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Building Information is required")
    private String building;

    @NotBlank(message = "Default status must be specified")
    private Boolean isDefault;


}
