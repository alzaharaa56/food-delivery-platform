package com.codeline.food_delivery_platform.controllers;

import com.codeline.food_delivery_platform.dto.request.RestaurantOwnerRegisterRequest;
import com.codeline.food_delivery_platform.dto.response.RestaurantOwnerResponse;
import com.codeline.food_delivery_platform.services.RestaurantOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/owners")
public class RestaurantOwnerController {
    @Autowired
    private RestaurantOwnerService restaurantOwnerService;
    @PostMapping("/register")
    public ResponseEntity<RestaurantOwnerResponse> registerOwner(@RequestBody RestaurantOwnerRegisterRequest request) {
        return ResponseEntity.ok(restaurantOwnerService.registerOwner(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantOwnerResponse> getOwnerById(@PathVariable Integer id) {
        return ResponseEntity.ok(restaurantOwnerService.getOwnerById(id));
    }
}
