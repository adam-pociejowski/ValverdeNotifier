package com.valverde.web.rest;

import com.valverde.web.dto.EmailDTO;
import com.valverde.web.dto.SmsDTO;
import com.valverde.service.SmsService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CommonsLog
@RestController
@RequestMapping("/notifier/rest")
public class NotifierRestController {

    @PostMapping("/sms")
    public HttpStatus sendSms(@RequestBody SmsDTO smsDTO) {
        try {
            smsService.sendAsync(smsDTO);
            log.info("Sms successfully added to sending queue.");
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @PostMapping("/email")
    public HttpStatus sendEmail(@RequestBody EmailDTO emailDTO) {
        try {
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Autowired
    public NotifierRestController(SmsService smsService) {
        this.smsService = smsService;
    }

    private final SmsService smsService;
}