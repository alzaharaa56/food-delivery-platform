package com.codeline.food_delivery_platform.DTO.Response;

import com.codeline.food_delivery_platform.DTO.Summary.CustomerSummaryDTO;
import com.codeline.food_delivery_platform.DTO.Summary.RestaurantSummaryDTO;
import com.codeline.food_delivery_platform.Entities.Review;

public class ReviewResponseDTO {

    private Integer id;

    private Integer rating;

    private String comment;

    private CustomerSummaryDTO customer;

    private RestaurantSummaryDTO restaurant;

    public static ReviewResponseDTO fromEntity(Review review) {

        ReviewResponseDTO dto = new ReviewResponseDTO();
        dto.id=review.getId();
        dto.rating=review.getRating();
        dto.comment=review.getComment();
        dto.customer=CustomerSummaryDTO.fromEntity(review.getCustomer());
        dto.restaurant = RestaurantSummaryDTO.fromEntity(review.getRestaurant());

        return dto;
    }
}