package com.codeline.food_delivery_platform.Controllers;

import com.codeline.food_delivery_platform.DTO.Request.RestaurantRequestDTO;
import com.codeline.food_delivery_platform.DTO.Response.MenuItemResponseDTO;
import com.codeline.food_delivery_platform.DTO.Response.RestaurantResponseDTO;
import com.codeline.food_delivery_platform.Services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/owner/{ownerId}")
    public ResponseEntity<RestaurantResponseDTO> createRestaurant(
            @PathVariable Integer ownerId,
            @Valid @RequestBody RestaurantRequestDTO dto) {
        RestaurantResponseDTO response = restaurantService.createRestaurant(dto, ownerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}/toggle-orders")
    public ResponseEntity<RestaurantResponseDTO> toggleOrders(
            @PathVariable Integer id,
            @RequestParam boolean accepting) {
        RestaurantResponseDTO response = restaurantService.toggleAcceptingOrders(id, accepting);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/fee/{newFee}")
    public ResponseEntity<RestaurantResponseDTO> updateDeliveryFee(
            @PathVariable Integer id,
            @PathVariable double newFee) {
        RestaurantResponseDTO response = restaurantService.updateDeliveryFee(id, newFee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<List<RestaurantResponseDTO>> getByCuisine(@PathVariable String cuisine) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByCuisine(cuisine));
    }

    @GetMapping("/{id}/menu")
    public ResponseEntity<List<MenuItemResponseDTO>> getMenu(@PathVariable Integer id) {
        return ResponseEntity.ok(restaurantService.getMenuForRestaurant(id));
    }
}
