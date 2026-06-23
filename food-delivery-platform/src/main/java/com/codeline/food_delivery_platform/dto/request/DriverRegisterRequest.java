package com.codeline.food_delivery_platform.dto.request;

import com.codeline.food_delivery_platform.entities.DeliveryDriver;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRegisterRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Phone number format is invalid")
    private String phone;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Vehicle type is required")
    private String vehicleType;

    @NotBlank(message = "Vehicle plate number is required")
    private String vehiclePlate;


    public DeliveryDriver toEntity(String passwordHash, String generatedCode) {
        DeliveryDriver driver = new DeliveryDriver();
        driver.setFirstName(this.firstName);
        driver.setLastName(this.lastName);
        driver.setEmail(this.email);
        driver.setPhone(this.phone);
        driver.setPasswordHash(passwordHash);
        driver.setDriverCode(generatedCode);
        driver.setVehicleType(this.vehicleType);
        driver.setVehiclePlate(this.vehiclePlate);
        driver.setIsOnline(false);
        return driver;
    }
}
