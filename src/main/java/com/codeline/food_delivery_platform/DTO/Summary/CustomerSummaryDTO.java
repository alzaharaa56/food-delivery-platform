package com.codeline.food_delivery_platform.DTO.Summary;


import com.codeline.food_delivery_platform.Entities.Customer;

public class CustomerSummaryDTO {

    private Integer id;
    private String fullName;
    private int loyaltyPoints;

    public static CustomerSummaryDTO fromEntity(Customer c) {
        CustomerSummaryDTO dto = new CustomerSummaryDTO();
        dto.id = c.getId();
        dto.fullName = c.getFirstName() + " " + c.getLastName();
        dto.loyaltyPoints = c.getLoyaltyPoints();
        return dto;
    }
}
