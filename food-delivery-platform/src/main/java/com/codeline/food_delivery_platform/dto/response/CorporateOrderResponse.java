package com.codeline.food_delivery_platform.dto.response;

import com.codeline.food_delivery_platform.entities.CorporateOrder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CorporateOrderResponse {
    private Integer id;
    private String corporateCode;
    private String companyName;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;

    public static CorporateOrderResponse fromEntity(CorporateOrder order) {
        CorporateOrderResponse response = new CorporateOrderResponse();
        response.setId(order.getId());
        response.setCorporateCode(order.getCorporateCode());
        response.setCompanyName(order.getCompanyName());
        response.setOrderDate(order.getOrderDate());
        response.setStatus(order.getStatus());
        response.setTotalAmount(order.getTotalAmount());
        return response;
    }
}