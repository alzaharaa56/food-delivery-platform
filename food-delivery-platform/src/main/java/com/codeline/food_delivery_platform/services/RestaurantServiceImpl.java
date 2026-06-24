package com.codeline.food_delivery_platform.services;

import com.codeline.food_delivery_platform.dto.request.RestaurantRequest;
import com.codeline.food_delivery_platform.dto.response.RestaurantResponse;
import com.codeline.food_delivery_platform.dto.summary.RestaurantSummaryResponse;
import com.codeline.food_delivery_platform.entities.Restaurant;
import com.codeline.food_delivery_platform.entities.RestaurantOwner;
import com.codeline.food_delivery_platform.exceptions.ResourceNotFoundException;
import com.codeline.food_delivery_platform.repositories.RestaurantOwnerRepository;
import com.codeline.food_delivery_platform.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantOwnerRepository ownerRepository;
    @Override
    public RestaurantResponse createRestaurant(RestaurantRequest request) {
        RestaurantOwner owner = ownerRepository.findById(request.getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant Owner not found with id: " + request.getOwnerId()));

        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setCuisineType(request.getCuisineType());
        restaurant.setDescription(request.getDescription());
        restaurant.setDeliveryFee(request.getDeliveryFee());
        restaurant.setOwner(owner);

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return RestaurantResponse.fromEntity(savedRestaurant);
    }
    @Override
    public RestaurantResponse getRestaurantById(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
        return RestaurantResponse.fromEntity(restaurant);
    }

    @Override
    public List<RestaurantSummaryResponse> getAllRestaurantsSummary() {
        return restaurantRepository.findAll().stream()
                .map(RestaurantSummaryResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
