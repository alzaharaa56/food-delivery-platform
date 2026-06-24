package com.codeline.food_delivery_platform.Services;

import com.codeline.food_delivery_platform.DTO.Request.RestaurantRequestDTO;
import com.codeline.food_delivery_platform.DTO.Response.MenuItemResponseDTO;
import com.codeline.food_delivery_platform.DTO.Response.RestaurantResponseDTO;
import com.codeline.food_delivery_platform.Entities.ComboMeal;
import com.codeline.food_delivery_platform.Entities.MenuItem;
import com.codeline.food_delivery_platform.Entities.Restaurant;
import com.codeline.food_delivery_platform.Entities.RestaurantOwner;
import com.codeline.food_delivery_platform.Exceptions.ResourceNotFoundException;
import com.codeline.food_delivery_platform.Repositories.ComboMealRepository;
import com.codeline.food_delivery_platform.Repositories.MenuItemRepository;
import com.codeline.food_delivery_platform.Repositories.RestaurantOwnerRepository;
import com.codeline.food_delivery_platform.Repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;
    private final ComboMealRepository comboMealRepository;

    public RestaurantResponseDTO createRestaurant(RestaurantRequestDTO dto, Integer ownerId) {
        Restaurant restaurant = dto.toEntity(new RestaurantOwner(ownerId));
        restaurant.setAcceptingOrders(true);
        restaurant.setCreatedDate(LocalDateTime.now());
        restaurant.setUpdatedDate(LocalDateTime.now());
        Restaurant saved = restaurantRepository.save(restaurant);
        return RestaurantResponseDTO.fromEntity(saved);
    }

    public RestaurantResponseDTO toggleAcceptingOrders(Integer restaurantId, boolean status) {
        Restaurant restaurant = findActiveRestaurant(restaurantId);
        restaurant.setAcceptingOrders(status);
        restaurant.setUpdatedDate(LocalDateTime.now());
        restaurantRepository.save(restaurant);
        return RestaurantResponseDTO.fromEntity(restaurant);
    }

    public RestaurantResponseDTO updateDeliveryFee(Integer restaurantId, double newFee) {
        Restaurant restaurant = findActiveRestaurant(restaurantId);
        restaurant.setDeliveryFee(newFee);
        restaurant.setUpdatedDate(LocalDateTime.now());
        restaurantRepository.save(restaurant);
        return RestaurantResponseDTO.fromEntity(restaurant);
    }

    public List<RestaurantResponseDTO> getRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findByCuisineTypeIgnoreCase(cuisine)
                .stream().map(RestaurantResponseDTO::fromEntity).toList();
    }

    public List<RestaurantResponseDTO> getRestaurantsUnderDeliveryFee(double maxFee) {
        return restaurantRepository.findByDeliveryFeeLessThanEqual(maxFee)
                .stream().map(RestaurantResponseDTO::fromEntity).toList();
    }

    public List<MenuItemResponseDTO> getMenuForRestaurant(Integer restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId)
                .stream().map(MenuItemResponseDTO::fromEntity).toList();
    }

    public void bulkUpdateMenuItemPrices(Integer restaurantId, double percentageIncrease) {
        List<MenuItem> items = menuItemRepository.findByRestaurantId(restaurantId);
        for (MenuItem item : items) {
            item.setPrice(item.getPrice() * (1 + percentageIncrease / 100));
            item.setUpdatedDate(LocalDateTime.now());
            menuItemRepository.save(item);
        }
    }

    private Restaurant findActiveRestaurant(Integer id) {
        return restaurantRepository.findById(id)
                .filter(Restaurant::isActive)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
    }
}