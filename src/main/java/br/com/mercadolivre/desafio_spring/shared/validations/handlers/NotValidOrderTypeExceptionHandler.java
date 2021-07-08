package br.com.mercadolivre.desafio_spring.shared.validations.handlers;

import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.NotValidOrderTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotValidOrderTypeExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotValidOrderTypeException.class)
    public ResponseEntity<?> handleNotValidOrderTypeExceptionHandler(NotValidOrderTypeException exception) {
        return ResponseEntity.badRequest().build();
    }
}
