package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.entities.CorporateOrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorporateOrderItemResponse {

    private Integer id;
    private String itemName;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;

    public static CorporateOrderItemResponse fromEntity(CorporateOrderItem item) {
        CorporateOrderItemResponse response = new CorporateOrderItemResponse();
        response.setId(item.getId());
        response.setItemName(item.getMenuItem().getName());
        response.setQuantity(item.getQuantity());
        response.setUnitPrice(item.getUnitPrice());
        response.setTotalPrice(item.getTotalPrice());
        return response;
    }
}
