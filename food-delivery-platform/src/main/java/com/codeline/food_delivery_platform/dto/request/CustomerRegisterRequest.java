package com.codeline.food_delivery_platform.dto.request;

import com.codeline.food_delivery_platform.entities.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegisterRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Phone number must be between 8 and 15 digits and can include a leading '+'")
    private String phone;

    @NotBlank(message = "Password is required")
    private String password;


    public Customer toEntity(String passwordHash, String generatedCode) {
        Customer customer = new Customer();
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        customer.setEmail(this.email);
        customer.setPhone(this.phone);
        customer.setPasswordHash(passwordHash); // Passed encrypted password from the Service
        customer.setCustomerCode(generatedCode); // Passed automatically generated code from the Service
        customer.setLoyaltyPoints(0);
        return customer;
    }
}


