package com.codeline.food_delivery_platform.DTO.summary;

import com.codeline.food_delivery_platform.entities.Customer;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomerSummaryResponse {
    private Integer id;
    private String customerCode;
    private String fullName;
    private String phone;

    public static CustomerSummaryResponse fromEntity(Customer customer) {
        CustomerSummaryResponse summary = new CustomerSummaryResponse();
        summary.setId(customer.getId());
        summary.setCustomerCode(customer.getCustomerCode());
        summary.setFullName(customer.getFirstName() + " " + customer.getLastName());
        summary.setPhone(customer.getPhone());
        return summary;
    }
}

