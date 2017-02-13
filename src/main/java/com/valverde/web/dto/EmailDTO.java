package com.valverde.web.dto;

import lombok.Data;

@Data
public class EmailDTO {

    private String to;

    private String title;

    private String body;

    private Boolean html;

}