package com.codeline.food_delivery_platform.Services;

import com.codeline.food_delivery_platform.dto.request.DriverRegisterRequest;
import com.codeline.food_delivery_platform.dto.response.DriverResponse;
import com.codeline.food_delivery_platform.dto.summary.DriverSummaryResponse;

import java.util.List;

public interface DriverService {
    DriverResponse registerDriver(DriverRegisterRequest request);

    DriverResponse getDriverById(Integer id);

    List<DriverSummaryResponse> getAllAvailableDriversSummary();
}
