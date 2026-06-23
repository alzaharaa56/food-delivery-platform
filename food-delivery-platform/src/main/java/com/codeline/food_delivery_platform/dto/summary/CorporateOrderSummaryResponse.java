package com.codeline.food_delivery_platform.dto.summary;

import com.codeline.food_delivery_platform.entities.CorporateOrder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CorporateOrderSummaryResponse {
    private Integer id;
    private String corporateCode;
    private String companyName;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;

    public static CorporateOrderSummaryResponse fromEntity(CorporateOrder order) {
        CorporateOrderSummaryResponse summary = new CorporateOrderSummaryResponse();
        summary.setId(order.getId());
        summary.setCorporateCode(order.getCorporateCode());
        summary.setCompanyName(order.getCompanyName());
        summary.setOrderDate(order.getOrderDate());
        summary.setStatus(order.getStatus());
        summary.setTotalAmount(order.getTotalAmount());
        return summary;
    }
}
