package com.valverde.healthchecker;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatDTO {

    private String statName;

    private Object stat;

}