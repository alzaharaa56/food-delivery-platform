package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.DTO.summary.RestaurantSummaryDTO;
import com.codeline.food_delivery_platform.Entities.CorporateOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateOrderResponseDTO {
    private Integer id;
    private String corporateCode;
    private String companyName;
    private String costCenter;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private RestaurantSummaryDTO restaurant;

    public static CorporateOrderResponseDTO fromEntity(CorporateOrder cOrder) {
        if (cOrder == null) return null;
        CorporateOrderResponseDTO dto = new CorporateOrderResponseDTO();
        dto.setId(cOrder.getId());
        dto.setCorporateCode(cOrder.getCorporateCode());
        dto.setCompanyName(cOrder.getCompanyName());
        dto.setCostCenter(cOrder.getCostCenter());
        dto.setOrderDate(cOrder.getOrderDate());
        dto.setStatus(cOrder.getStatus());
        dto.setTotalAmount(cOrder.getTotalAmount());
        dto.setRestaurant(RestaurantSummaryDTO.fromEntity(cOrder.getRestaurant()));
        return dto;
    }
}
