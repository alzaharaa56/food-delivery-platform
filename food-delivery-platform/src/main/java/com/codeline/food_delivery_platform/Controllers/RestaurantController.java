package com.codeline.food_delivery_platform.Controllers;

import com.codeline.food_delivery_platform.Entities.Restaurant;
import com.codeline.food_delivery_platform.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(restaurantService.saveRestaurant(restaurant), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurants(
            @RequestParam(required = false, defaultValue = "") String cuisine,
            @RequestParam(required = false, defaultValue = "") String keyword) {

        List<Restaurant> results = restaurantService.searchRestaurants(cuisine, keyword);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
