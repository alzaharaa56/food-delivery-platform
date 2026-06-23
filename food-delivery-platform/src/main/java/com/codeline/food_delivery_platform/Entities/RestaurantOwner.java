package com.codeline.food_delivery_platform.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class RestaurantOwner extends BaseUser{
    private String businessLicenseCode;

    @OneToMany(mappedBy = "restaurantOwner")
    private List<Restaurant> restaurants;
    private @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Phone number must be between 8 and 15 digits") String phone;

    public void setPhone(@NotBlank(message = "Phone number is required") @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Phone number must be between 8 and 15 digits") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Phone number is required") @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Phone number must be between 8 and 15 digits") String getPhone() {
        return phone;
    }
}
