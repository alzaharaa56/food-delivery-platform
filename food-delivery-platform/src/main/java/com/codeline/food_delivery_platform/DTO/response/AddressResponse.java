package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.entities.CustomerAddress;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private Integer id;
    private String street;
    private String city;
    private String building;
    private Boolean isDefault;


    public static AddressResponse fromEntity(CustomerAddress address) {
        AddressResponse response = new AddressResponse();
        response.setId(address.getId());
        response.setStreet(address.getStreet());
        response.setCity(address.getCity());
        response.setBuilding(address.getBuilding());
        response.setIsDefault(address.getIsDefault());
        return response;
    }
}
