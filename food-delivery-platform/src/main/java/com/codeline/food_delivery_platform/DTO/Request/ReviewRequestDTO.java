package com.codeline.food_delivery_platform.DTO.Request;


import com.codeline.food_delivery_platform.Entities.Customer;
import com.codeline.food_delivery_platform.Entities.Restaurant;
import com.codeline.food_delivery_platform.Entities.Review;
import com.codeline.food_delivery_platform.Enums.ReviewTargetType;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDTO {
    @NotNull
    private Customer customer;

    @NotNull
    private Restaurant restaurant;

    @Min(1)
    @Max(5)
    private Integer rating;

    @NotBlank
    private String comment;

    @Pattern(regexp = "RESTAURANT|DRIVER")
    private ReviewTargetType targetType;

    public static Review toEntity(ReviewRequestDTO dto) {

        Review review = new Review();

        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        review.setCustomer(dto.getCustomer());
        review.setRestaurant(dto.getRestaurant());
        review.setTargetType(dto.getTargetType());

        return review;
    }


}
