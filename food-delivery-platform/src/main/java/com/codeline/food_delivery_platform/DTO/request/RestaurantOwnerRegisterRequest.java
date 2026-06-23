package com.codeline.food_delivery_platform.DTO.request;

import com.codeline.food_delivery_platform.entities.RestaurantOwner;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantOwnerRegisterRequest {

    @NotBlank(message = "Owner name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    public RestaurantOwner toEntity(String passwordHash) {
        RestaurantOwner owner = new RestaurantOwner();

        if (this.name != null && this.name.trim().contains(" ")) {
            String[] parts = this.name.split(" ", 2);
            owner.setFirstName(parts[0]);
            owner.setLastName(parts[1]);
        } else {
            owner.setFirstName(this.name);
            owner.setLastName("");
        }

        owner.setEmail(this.email);
        owner.setPasswordHash(passwordHash);
        owner.setPhone("");
        owner.setBusinessLicenseCode("");

        return owner;
    }
}