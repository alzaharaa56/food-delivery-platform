package com.codeline.food_delivery_platform.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem extends BaseClass {
    private String name;
    private String description;
    private Double price;

    private Boolean isAvailable;
    private Boolean isVegetarian;

    private Integer calories;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "menuItem")
    private List<ComboMeal> comboMeals;

    @OneToMany(mappedBy = "menuItem")
    private  List<OrderItem> orderItems;
}