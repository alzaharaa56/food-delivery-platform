package com.codeline.food_delivery_platform.Services;

import com.codeline.food_delivery_platform.dto.request.RestaurantOwnerRegisterRequest;
import com.codeline.food_delivery_platform.dto.response.RestaurantOwnerResponse;
import java.util.List;

public interface RestaurantOwnerService {
    RestaurantOwnerResponse registerOwner(RestaurantOwnerRegisterRequest request);

    RestaurantOwnerResponse getOwnerById(Integer id);

    List<RestaurantOwnerResponse> getAllOwners();
}
