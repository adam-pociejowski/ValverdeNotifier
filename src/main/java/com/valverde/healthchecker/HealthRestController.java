package com.valverde.healthchecker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthRestController {

    @GetMapping("/health/status")
    public ResponseEntity<HealthDTO> getHealthPoint() {
        HealthDTO health = new HealthDTO();
        health.setState(HealthState.HEALTHY);
        health.setAppName("ValverdeNotifier");
        return new ResponseEntity<>(health, HttpStatus.OK);
    }
}