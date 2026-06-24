package com.codeline.food_delivery_platform.Controllers;

import com.codeline.food_delivery_platform.dto.request.RestaurantRequest;
import com.codeline.food_delivery_platform.dto.response.RestaurantResponse;
import com.codeline.food_delivery_platform.dto.summary.RestaurantSummaryResponse;
import com.codeline.food_delivery_platform.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestBody RestaurantRequest request) {
        return ResponseEntity.ok(restaurantService.createRestaurant(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable Integer id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @GetMapping
    public ResponseEntity<List<RestaurantSummaryResponse>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurantsSummary());
    }
}