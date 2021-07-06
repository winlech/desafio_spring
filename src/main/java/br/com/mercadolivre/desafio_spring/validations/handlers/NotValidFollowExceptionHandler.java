package br.com.mercadolivre.desafio_spring.validations.handlers;

import br.com.mercadolivre.desafio_spring.validations.exceptions.NotValidFollowException;
import br.com.mercadolivre.desafio_spring.validations.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotValidFollowExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotValidFollowException.class)
    public ResponseEntity<?> handleUserNotFoundExceptionHandler(NotValidFollowException exception) {
        return ResponseEntity.badRequest().build();
    }
}
