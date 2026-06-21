package com.codeline.food_delivery_platform.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateOrder extends BaseEntity{
    private String corporateCode;
    private String companyName;
    private Double costCenter;
    private Date orderDate;
    private String status;
    private Double totalAmount;
}