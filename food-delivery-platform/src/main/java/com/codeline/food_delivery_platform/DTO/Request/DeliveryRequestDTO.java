package com.codeline.food_delivery_platform.DTO.Request;

import com.codeline.food_delivery_platform.Entities.Delivery;
import com.codeline.food_delivery_platform.Entities.DeliveryDriver;
import com.codeline.food_delivery_platform.Entities.Order;
import com.codeline.food_delivery_platform.Enums.DeliveryStatus;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequestDTO {
    @NotNull
    private DeliveryDriver driver;

    @NotNull
    private Order order;

    @Pattern(regexp = "ASSIGNED|PICKED_UP|ON_THE_WAY|DELIVERED|FAILED")
    private DeliveryStatus status;

    public static Delivery toEntity(DeliveryRequestDTO dto){
        Delivery delivery = new Delivery();
        delivery.setDeliveryDriver(dto.getDriver());
        delivery.setOrder(dto.getOrder());
        delivery.setStatus(dto.getStatus());

        return delivery;
    }
}
