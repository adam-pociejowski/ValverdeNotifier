package com.valverde.web.rest;

import com.valverde.service.StatisticsService;
import com.valverde.web.dto.SmsDTO;
import com.valverde.web.dto.SmsStatisticsDTO;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CommonsLog
@RestController
@RequestMapping("/rest/statistics")
public class StatisticsRestController {

    @GetMapping("/getstats")
    public ResponseEntity<List<SmsStatisticsDTO>> getSmsStats() {
        try {
            List<SmsStatisticsDTO> stats = statisticsService.getStats();
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Problem with getting sms stats", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Autowired
    public StatisticsRestController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    private final StatisticsService statisticsService;
}
