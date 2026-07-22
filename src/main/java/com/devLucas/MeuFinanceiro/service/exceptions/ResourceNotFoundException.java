package com.devLucas.MeuFinanceiro.service.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado com o Id: " + id);
    }
}
