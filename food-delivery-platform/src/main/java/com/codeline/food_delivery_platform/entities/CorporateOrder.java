package com.codeline.food_delivery_platform.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "corporate_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorporateOrder extends BaseEntity {

    @Column(name = "corporate_code", nullable = false)
    private String corporateCode;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "cost_center", nullable = false)
    private String costCenter;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "corporateOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CorporateOrderItem> corporateOrderItems = new ArrayList<>();
}