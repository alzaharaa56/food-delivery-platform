package com.codeline.food_delivery_platform.DTO.Response;

import com.codeline.food_delivery_platform.DTO.Summary.CustomerSummaryDTO;
import com.codeline.food_delivery_platform.Entities.Customer;
import lombok.Data;

@Data
public class CustomerResponseDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer loyaltyPoints;

    public static CustomerResponseDTO fromEntity(Customer c) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.id = c.getId();
        dto.firstName = c.getFirstName();
        dto.lastName = c.getLastName();
        dto.email = c.getEmail();
        dto.phone = c.getPhone();
        dto.loyaltyPoints=c.getLoyaltyPoints();

        return dto;
    }
}
