package com.codeline.food_delivery_platform.Entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    @Column(name = "order_code", nullable = false, unique = true)
    private String orderCode;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @Column(name = "delivery_fee", nullable = false)
    private Double deliveryFee;

    @Column(name = "discount_amount", nullable = false)
    private Double discountAmount = 0.0;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "delivery_notes")
    private String deliveryNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Delivery delivery;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;


}