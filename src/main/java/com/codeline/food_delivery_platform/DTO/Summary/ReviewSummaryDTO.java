package com.codeline.food_delivery_platform.DTO.Summary;

import com.codeline.food_delivery_platform.Entities.Review;

public class ReviewSummaryDTO {
    private Integer id;
    private Integer rating;

    public static ReviewSummaryDTO fromEntity(Review review) {

        ReviewSummaryDTO dto = new ReviewSummaryDTO();

        dto.id=review.getId();
        dto.rating=review.getRating();

        return dto;
    }
}
