package com.devLucas.MeuFinanceiro.controller.exceptions;

import com.devLucas.MeuFinanceiro.service.exceptions.DatabaseException;
import com.devLucas.MeuFinanceiro.service.exceptions.LengthException;
import com.devLucas.MeuFinanceiro.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandartError> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandartError> databaseException(DatabaseException e, HttpServletRequest request) {
        String error = "Falha ao concluir a ação. Campos usuário e/ou email já em uso!";
        HttpStatus status = HttpStatus.CONFLICT;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandartError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String error = "Falha ao concluir a ação. Verifique se os dados foram digitados corretamente!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandartError> httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        String error = "Falha ao concluir a ação. Verifique se os dados foram digitados corretamente!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(LengthException.class)
    public ResponseEntity<StandartError> lengthException(LengthException e, HttpServletRequest request) {
        String error = "Falha ao concluir a ação. Quantidade de caracteres maior que o limite permitido!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
