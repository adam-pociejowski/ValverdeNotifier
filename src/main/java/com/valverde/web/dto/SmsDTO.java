package com.valverde.web.dto;

import lombok.Data;

@Data
public class SmsDTO {

    private String to;

    private String message;

}