package com.codeline.food_delivery_platform.DTO.response;

import com.codeline.food_delivery_platform.entities.RestaurantOwner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantOwnerResponse {
    private Integer id;
    private String name;
    private String email;

    public static RestaurantOwnerResponse fromEntity(RestaurantOwner owner) {
        RestaurantOwnerResponse response = new RestaurantOwnerResponse();
        response.setId(owner.getId());


        if (owner.getFirstName() != null) {
            String fullName = owner.getFirstName() + (owner.getLastName() != null ? " " + owner.getLastName() : "");
            response.setName(fullName.trim());
        } else {
            response.setName("");
        }

        response.setEmail(owner.getEmail());
        return response;
    }
}