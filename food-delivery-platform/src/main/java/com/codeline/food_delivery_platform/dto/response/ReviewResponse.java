package com.codeline.food_delivery_platform.dto.response;

import com.codeline.food_delivery_platform.entities.Review;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReviewResponse {
    private Integer id;
    private String targetType;
    private Integer rating;
    private String comment;
    private String customerName;
    public static ReviewResponse fromEntity(Review review) {
        ReviewResponse response = new ReviewResponse();
        response.setId(review.getId());
        response.setTargetType(review.getTargetType());
        response.setRating(review.getRating());
        response.setComment(review.getComment());
        response.setCustomerName(review.getCustomer().getFirstName() + " " + review.getCustomer().getLastName());
        return response;
    }
}

