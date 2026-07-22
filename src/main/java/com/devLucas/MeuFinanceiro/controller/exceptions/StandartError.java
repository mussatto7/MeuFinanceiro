package com.devLucas.MeuFinanceiro.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class StandartError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandartError() {
    }

    ;

}
