package com.codeline.food_delivery_platform.Services;

import com.codeline.food_delivery_platform.Entities.Restaurant;
import com.codeline.food_delivery_platform.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> searchRestaurants(String cuisine, String keyword) {
        return restaurantRepository.searchByCuisineAndKeyword(cuisine, keyword);
    }
}