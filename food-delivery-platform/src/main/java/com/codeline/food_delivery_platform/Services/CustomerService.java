package com.codeline.food_delivery_platform.Services;

import com.codeline.food_delivery_platform.dtos.CustomerRequestDTO;
import com.codeline.food_delivery_platform.Entities.Customer;
import com.codeline.food_delivery_platform.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer registerCustomer(CustomerRequestDTO requestDTO) {

        Customer customer = Customer.builder()
                .name(requestDTO.getName())
                .email(requestDTO.getEmail())
                .phone(requestDTO.getPhone())
                .status("ACTIVE")
                .build();

        return customerRepository.save(customer);
    }
}
