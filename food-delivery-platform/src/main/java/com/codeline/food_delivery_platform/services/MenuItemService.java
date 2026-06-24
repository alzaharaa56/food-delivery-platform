package com.codeline.food_delivery_platform.services;

import com.codeline.food_delivery_platform.dto.request.MenuItemRequest;
import com.codeline.food_delivery_platform.dto.response.MenuItemResponse;
import com.codeline.food_delivery_platform.dto.summary.MenuItemSummaryResponse;

import java.util.List;

public interface MenuItemService {
MenuItemResponse createMenuItem(MenuItemRequest request);
MenuItemResponse getMenuItemById(Integer id);
List<MenuItemSummaryResponse> getMenuItemsByRestaurant(Integer restaurantId);
}
