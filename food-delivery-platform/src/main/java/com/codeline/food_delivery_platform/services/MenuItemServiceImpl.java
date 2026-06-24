package com.codeline.food_delivery_platform.services;

import com.codeline.food_delivery_platform.dto.request.MenuItemRequest;
import com.codeline.food_delivery_platform.dto.response.MenuItemResponse;
import com.codeline.food_delivery_platform.dto.summary.MenuItemSummaryResponse;
import com.codeline.food_delivery_platform.entities.MenuItem;
import com.codeline.food_delivery_platform.entities.Restaurant;
import com.codeline.food_delivery_platform.exceptions.ResourceNotFoundException;
import com.codeline.food_delivery_platform.repositories.MenuItemRepository;
import com.codeline.food_delivery_platform.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public MenuItemResponse createMenuItem(MenuItemRequest request) {

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + request.getRestaurantId()));

        MenuItem menuItem = new MenuItem();
        menuItem.setName(request.getName());
        menuItem.setDescription(request.getDescription());
        menuItem.setPrice(request.getPrice());
        menuItem.setIsAvailable(request.getIsVegetarian() != null ? request.getIsVegetarian() : true);
        menuItem.setRestaurant(restaurant);

        MenuItem savedItem = menuItemRepository.save(menuItem);
        return MenuItemResponse.fromEntity(savedItem);
    }

    @Override
    public MenuItemResponse getMenuItemById(Integer id) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item not found with id: " + id));
        return MenuItemResponse.fromEntity(menuItem);
    }

    @Override
    public List<MenuItemSummaryResponse> getMenuItemsByRestaurant(Integer restaurantId) {

        return menuItemRepository.findAll().stream()
                .filter(item -> item.getRestaurant() != null && item.getRestaurant().getId().equals(restaurantId))
                .map(MenuItemSummaryResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
