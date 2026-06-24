package com.codeline.food_delivery_platform.DTO.Request;

import com.codeline.food_delivery_platform.Entities.Customer;
import com.codeline.food_delivery_platform.Utils.HelperUtils;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "\\+?[0-9]{8,15}")
    private String phone;
    @NotBlank
    private String passwordHash;


    public static Customer toEntity(CustomerRequestDTO dto){
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setCustomerCode(HelperUtils.generateCode("CUST"));
        customer.setPasswordHash(dto.getPasswordHash());
        return customer;
    }

}
