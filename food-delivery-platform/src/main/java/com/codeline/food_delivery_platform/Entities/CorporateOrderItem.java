package com.codeline.food_delivery_platform.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "corporate_order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorporateOrderItem extends BaseEntity {

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corporate_order_id", nullable = false)
    private CorporateOrder corporateOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;
}
