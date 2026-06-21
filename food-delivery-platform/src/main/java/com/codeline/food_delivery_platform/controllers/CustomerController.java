package com.codeline.food_delivery_platform.controllers;

import com.codeline.food_delivery_platform.dtos.CustomerRequestDTO;
import com.codeline.food_delivery_platform.entities.Customer;
import com.codeline.food_delivery_platform.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody CustomerRequestDTO requestDTO) {
        Customer savedCustomer = customerService.registerCustomer(requestDTO);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
}
