package com.valverde.healthchecker.rest;

import com.valverde.healthchecker.dto.HealthDTO;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.valverde.healthchecker.enums.HealthState.HEALTHY;

@RestController
@CommonsLog
@RequestMapping("/health")
public class HealthRestController {

    private final static String APP_NAME = "ValverdeNotifier";

    @GetMapping("/status")
    public ResponseEntity<HealthDTO> getHealthPoint() {
        HealthDTO healthDTO = new HealthDTO();
        healthDTO.setAppName(APP_NAME);
        healthDTO.setState(HEALTHY);
        return new ResponseEntity<>(healthDTO, HttpStatus.OK);
    }
}