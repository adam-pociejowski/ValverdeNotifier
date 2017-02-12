package com.valverde.service;

import com.valverde.dto.SmsDTO;
import com.valverde.entity.Sms;
import com.valverde.enums.State;
import com.valverde.repository.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SmsService {

    public void sendAsync(SmsDTO smsDTO) {
        Date now = new Date();
        Sms sms = new Sms();
        sms.setRecipients(smsDTO.getTo());
        sms.setMessage(smsDTO.getMessage());
        sms.setInsertDate(new Date(now.getTime()));
        sms.setSendAttempts(0);
        sms.setState(State.IN_PROGRESS);
        smsRepository.save(sms);
    }

    public List<Sms> getMessagesToSend() {
        return smsRepository.findByState(State.IN_PROGRESS);
    }

    public void save(Sms sms) {
        smsRepository.save(sms);
    }

    @Autowired
    public SmsService(SmsRepository smsRepository) {
        this.smsRepository = smsRepository;
    }

    private final SmsRepository smsRepository;
}