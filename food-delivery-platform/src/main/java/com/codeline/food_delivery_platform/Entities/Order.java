package com.codeline.food_delivery_platform.Entities;

import java.util.Date;

public class Order extends BaseClass {
    private String orderCode;
    private Date orderDate;
    private String status;
    private Double subtotal;
    private Double deliveryFee;
    private Double discountAmount;
    private Double totalAmount;
    private String deliveryNotes;
}
