package com.devsuperior.bds02.Infra;

import com.devsuperior.bds02.Infra.exception.DatabaseException;
import com.devsuperior.bds02.Infra.exception.ResourceNotFoundException;
import com.devsuperior.bds02.Infra.exception.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> error404(
            ResourceNotFoundException e, HttpServletRequest http){

        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Não encontrado");
        error.setMessage(e.getMessage());
        error.setPath(http.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dataBase(
            DatabaseException e, HttpServletRequest http){

        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Problema com Database");
        error.setMessage(e.getMessage());
        error.setPath(http.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> notfound(NoSuchElementException e, HttpServletRequest http){
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Não achou");
        error.setMessage(e.getMessage());
        error.setPath(http.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
