package com.valverde.service;

import com.valverde.entity.Sms;
import com.valverde.repository.SmsRepository;
import com.valverde.web.dto.SmsStatisticsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatisticsService {

    public List<SmsStatisticsDTO> getStats() {
        List<Sms> smsHistory = smsRepository.findByOrderByIdDesc();
        List<SmsStatisticsDTO> smsStatistics = new ArrayList<>();
        smsHistory.forEach(sms -> smsStatistics.add(new SmsStatisticsDTO(sms)));
        return smsStatistics;
    }

    @Autowired
    public StatisticsService(SmsRepository smsRepository) {
        this.smsRepository = smsRepository;
    }

    private final SmsRepository smsRepository;
}
