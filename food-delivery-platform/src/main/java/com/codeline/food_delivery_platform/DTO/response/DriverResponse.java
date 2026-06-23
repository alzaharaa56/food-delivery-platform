package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.entities.DeliveryDriver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverResponse {
    private Integer id;
    private String driverCode;
    private String fullName;
    private String email;
    private String phone;
    private String vehicleType;
    private String vehiclePlate;
    private Boolean isOnline;
    private Double currentLat;
    private Double currentLng;


    public static DriverResponse fromEntity(DeliveryDriver driver) {
        DriverResponse response = new DriverResponse();
        response.setId(driver.getId());
        response.setDriverCode(driver.getDriverCode());
        response.setFullName(driver.getFirstName() + " " + driver.getLastName());
        response.setEmail(driver.getEmail());
        response.setPhone(driver.getPhone());
        response.setVehicleType(driver.getVehicleType());
        response.setVehiclePlate(driver.getVehiclePlate());
        response.setIsOnline(driver.getIsOnline());
        response.setCurrentLat(driver.getCurrentLat());
        response.setCurrentLng(driver.getCurrentLng());
        return response;
    }
}
