package com.codeline.food_delivery_platform.DTO.Response;

import com.codeline.food_delivery_platform.Entities.Customer;
import com.codeline.food_delivery_platform.Entities.CustomerAddress;
import lombok.Data;

@Data
public class CustomerAddressResponseDTO {

    private String street;
    private String city;
    private String building;
    private Integer customerId;


    public static CustomerAddressResponseDTO fromEntity(CustomerAddress address){
        CustomerAddressResponseDTO dto = new CustomerAddressResponseDTO();
        dto.street = address.getStreet();
        dto.city = address.getCity();
        dto.building = address.getBuilding();
        dto.customerId = address.getCustomer().getId();
        return dto;
    }
}
