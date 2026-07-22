package com.devLucas.MeuFinanceiro.service.exceptions;

import java.io.Serial;

public class LengthException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public LengthException(String message) {
        super(message);
    }
}
