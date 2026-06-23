package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.Entities.Customer;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CustomerResponse {
    private String customerCode;
    private String fullName;
    private String email;
    private String phone;
    private Integer loyaltyPoints;
    private List<AddressResponse> addresses;


    public static CustomerResponse fromEntity(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setCustomerCode(customer.getCustomerCode());
        response.setFullName(customer.getFirstName() + " " + customer.getLastName());
        response.setEmail(customer.getEmail());
        response.setPhone(customer.getPhone());
        response.setLoyaltyPoints(customer.getLoyaltyPoints());

        if (customer.getAddresses() != null) {
            response.setAddresses(customer.getAddresses().stream()
                    .filter(addr -> addr.getIsActive())
                    .map(AddressResponse::fromEntity)
                    .collect(Collectors.toList()));
        }
        return response;
    }
}
