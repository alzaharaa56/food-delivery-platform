package com.codeline.food_delivery_platform.Services;

import com.codeline.food_delivery_platform.dto.request.CustomerRegisterRequest;
import com.codeline.food_delivery_platform.dto.response.CustomerResponse;
import com.codeline.food_delivery_platform.dto.summary.CustomerSummaryResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse registerCustomer(CustomerRegisterRequest request);

    CustomerResponse getCustomerById(Integer id);

    List<CustomerSummaryResponse> getAllCustomersSummary();
}
