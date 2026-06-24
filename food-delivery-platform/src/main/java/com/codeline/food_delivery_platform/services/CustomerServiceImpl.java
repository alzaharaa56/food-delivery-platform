package com.codeline.food_delivery_platform.services;

import com.codeline.food_delivery_platform.dto.request.CustomerRegisterRequest;
import com.codeline.food_delivery_platform.dto.response.CustomerResponse;
import com.codeline.food_delivery_platform.dto.summary.CustomerSummaryResponse;
import com.codeline.food_delivery_platform.entities.Customer;
import com.codeline.food_delivery_platform.exceptions.ResourceNotFoundException;
import com.codeline.food_delivery_platform.repositories.CustomerRepository;
import com.codeline.food_delivery_platform.utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponse registerCustomer(CustomerRegisterRequest request) {
        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already registered!");
        }

        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setPasswordHash("hashed_" + request.getPassword());

        customer.setCustomerCode(HelperUtils.generateCode("CUS"));

        customer.setCreatedDate(java.time.LocalDateTime.now());
        customer.setIsActive(true);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerResponse.fromEntity(savedCustomer);
    }

    @Override
    public CustomerResponse getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        return CustomerResponse.fromEntity(customer);
    }

    @Override
    public List<CustomerSummaryResponse> getAllCustomersSummary() {
        return customerRepository.findAll().stream()
                .map(CustomerSummaryResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
