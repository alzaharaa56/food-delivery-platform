package com.codeline.food_delivery_platform.dto.request;

import com.codeline.food_delivery_platform.entities.CustomerAddress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    @NotBlank(message = "Street name is required")
    private String street;

    @NotBlank(message = "City name is required")
    private String city;

    @NotBlank(message = "Building name/number is required")
    private String building;

    @NotNull(message = "Default address status must be specified")
    private Boolean isDefault;


    public CustomerAddress toEntity() {
        CustomerAddress address = new CustomerAddress();
        address.setStreet(this.street);
        address.setCity(this.city);
        address.setBuilding(this.building);
        address.setIsDefault(this.isDefault);
        return address;
    }
}
