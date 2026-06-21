package com.codeline.food_delivery_platform.entities;

import jakarta.persistence.*;

import lombok.Data;

import java.util.Date;

public class Order extends BaseEntity{
    private String orderCode;
    private Date orderDate;
    private String status;
    private Double subtotal;
    private Double deliveryFee;
    private Double discountAmount;
    private Double totalAmount;
    private String deliveryNotes;
}
