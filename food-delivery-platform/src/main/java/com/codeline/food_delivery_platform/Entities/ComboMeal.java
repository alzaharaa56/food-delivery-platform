package com.codeline.food_delivery_platform.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "combo_meals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComboMeal extends BaseEntity {

    @Column(name = "combo_name", nullable = false)
    private String comboName;

    @Column(name = "description")
    private String description;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "combo_meal_menu_item",
            joinColumns = @JoinColumn(name = "combo_meal_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> menuItems = new ArrayList<>();
}
