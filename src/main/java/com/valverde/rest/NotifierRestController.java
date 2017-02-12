package com.valverde.rest;

import com.valverde.dto.EmailDTO;
import com.valverde.dto.SmsDTO;
import com.valverde.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifier/rest")
public class NotifierRestController {

    @PostMapping("/sms")
    public HttpStatus sendSms(@RequestBody SmsDTO smsDTO) {
        try {
            smsService.sendAsync(smsDTO);
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