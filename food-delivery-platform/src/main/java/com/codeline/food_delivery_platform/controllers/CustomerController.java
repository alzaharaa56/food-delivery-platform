package com.codeline.food_delivery_platform.controllers;

import com.codeline.food_delivery_platform.dto.request.CustomerRegisterRequest;
import com.codeline.food_delivery_platform.dto.response.CustomerResponse;
import com.codeline.food_delivery_platform.dto.summary.CustomerSummaryResponse;
import com.codeline.food_delivery_platform.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> registerCustomer(@RequestBody CustomerRegisterRequest request) {
        return ResponseEntity.ok(customerService.registerCustomer(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/summary")
    public ResponseEntity<List<CustomerSummaryResponse>> getAllCustomersSummary() {
        return ResponseEntity.ok(customerService.getAllCustomersSummary());
    }
}
