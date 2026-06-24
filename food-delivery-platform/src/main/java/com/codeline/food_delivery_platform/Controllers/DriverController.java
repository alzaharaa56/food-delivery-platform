package com.codeline.food_delivery_platform.Controllers;

import com.codeline.food_delivery_platform.dto.request.DriverRegisterRequest;
import com.codeline.food_delivery_platform.dto.response.DriverResponse;
import com.codeline.food_delivery_platform.dto.summary.DriverSummaryResponse;
import com.codeline.food_delivery_platform.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @PostMapping("/register")
    public ResponseEntity<DriverResponse> registerDriver(@RequestBody DriverRegisterRequest request) {
        return ResponseEntity.ok(driverService.registerDriver(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DriverResponse> getDriverById(@PathVariable Integer id) {
        return ResponseEntity.ok(driverService.getDriverById(id));
    }
    @GetMapping("/available")
    public ResponseEntity<List<DriverSummaryResponse>> getAllAvailableDriversSummary() {
        return ResponseEntity.ok(driverService.getAllAvailableDriversSummary());
    }
}

