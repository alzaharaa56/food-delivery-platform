package com.codeline.food_delivery_platform.DTO.summary;

import com.codeline.food_delivery_platform.entities.DeliveryDriver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverSummaryResponse {
    private Integer id;
    private String driverCode;
    private String fullName;
    private String phone;

    public static DriverSummaryResponse fromEntity(DeliveryDriver driver) {
        DriverSummaryResponse summary = new DriverSummaryResponse();
        summary.setId(driver.getId());
        summary.setDriverCode(driver.getDriverCode());
        summary.setFullName(driver.getFirstName() + " " + driver.getLastName());
        summary.setPhone(driver.getPhone());
        return summary;
    }
}
