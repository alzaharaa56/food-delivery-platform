package com.codeline.food_delivery_platform.Services;

import com.codeline.food_delivery_platform.dto.request.RestaurantOwnerRegisterRequest;
import com.codeline.food_delivery_platform.dto.response.RestaurantOwnerResponse;
import com.codeline.food_delivery_platform.entities.RestaurantOwner;
import com.codeline.food_delivery_platform.exceptions.ResourceNotFoundException;
import com.codeline.food_delivery_platform.repositories.RestaurantOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantOwnerServiceImpl implements RestaurantOwnerService {

    @Autowired
    private RestaurantOwnerRepository ownerRepository;

    @Override
    public RestaurantOwnerResponse registerOwner(RestaurantOwnerRegisterRequest request) {

        if (ownerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already registered!");
        }

        String mockPasswordHash = "hashed_" + request.getPassword();
        RestaurantOwner owner = request.toEntity(mockPasswordHash);

        RestaurantOwner savedOwner = ownerRepository.save(owner);

        return RestaurantOwnerResponse.fromEntity(savedOwner);
    }

    @Override
    public RestaurantOwnerResponse getOwnerById(Integer id) {

        RestaurantOwner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant Owner not found with id: " + id));
        return RestaurantOwnerResponse.fromEntity(owner);
    }

    @Override
    public List<RestaurantOwnerResponse> getAllOwners() {
        return ownerRepository.findAll().stream()
                .map(RestaurantOwnerResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
