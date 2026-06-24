package com.codeline.food_delivery_platform.services;

import com.codeline.food_delivery_platform.dto.request.RestaurantRequest;
import com.codeline.food_delivery_platform.dto.response.RestaurantResponse;
import com.codeline.food_delivery_platform.dto.summary.RestaurantSummaryResponse;

import java.util.List;

public interface RestaurantService {
    RestaurantResponse createRestaurant(RestaurantRequest request);

    RestaurantResponse getRestaurantById(Integer id);

    List<RestaurantSummaryResponse> getAllRestaurantsSummary();
}
