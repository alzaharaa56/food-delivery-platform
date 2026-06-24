package com.codeline.food_delivery_platform.controllers;

import com.codeline.food_delivery_platform.dto.request.MenuItemRequest;
import com.codeline.food_delivery_platform.dto.response.MenuItemResponse;
import com.codeline.food_delivery_platform.dto.summary.MenuItemSummaryResponse;
import com.codeline.food_delivery_platform.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping
    public ResponseEntity<MenuItemResponse> createMenuItem(@RequestBody MenuItemRequest request) {
        return ResponseEntity.ok(menuItemService.createMenuItem(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemResponse> getMenuItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(menuItemService.getMenuItemById(id));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<MenuItemSummaryResponse>> getMenuItemsByRestaurant(@PathVariable Integer restaurantId) {
        return ResponseEntity.ok(menuItemService.getMenuItemsByRestaurant(restaurantId));
    }
}
