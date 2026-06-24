
package com.codeline.food_delivery_platform.services;

import com.codeline.food_delivery_platform.dto.request.DriverRegisterRequest;
import com.codeline.food_delivery_platform.dto.response.DriverResponse;
import com.codeline.food_delivery_platform.dto.summary.DriverSummaryResponse;
import com.codeline.food_delivery_platform.entities.DeliveryDriver;
import com.codeline.food_delivery_platform.exceptions.ResourceNotFoundException;
import com.codeline.food_delivery_platform.repositories.DeliveryDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DeliveryDriverRepository deliveryDriverRepository;

    @Override
    public DriverResponse registerDriver(DriverRegisterRequest request) {
        DeliveryDriver driver = new DeliveryDriver();
        driver.setFirstName(request.getFirstName());
        driver.setLastName(request.getLastName());
        driver.setVehicleType(request.getVehicleType());
        driver.setVehiclePlate(request.getVehiclePlate());
        driver.setPasswordHash("hashed_" + request.getPassword());
        driver.setEmail(request.getEmail());
        driver.setPhone(request.getPhone());

        DeliveryDriver savedDriver = deliveryDriverRepository.save(driver);
        return DriverResponse.fromEntity(savedDriver);
    }

    @Override
    public DriverResponse getDriverById(Integer id) {
        DeliveryDriver driver = deliveryDriverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + id));
        return DriverResponse.fromEntity(driver);
    }

    @Override
    public List<DriverSummaryResponse> getAllAvailableDriversSummary() {
        return deliveryDriverRepository.findAll().stream()
                .map(DriverSummaryResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
