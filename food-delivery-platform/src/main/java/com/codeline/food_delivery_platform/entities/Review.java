package com.codeline.food_delivery_platform.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity{
    private String targetType;
    private Integer rating;
    private String comment;
}
