package br.com.mercadolivre.desafio_spring.validations.exceptions;

public class NotValidOrderTypeException extends RuntimeException {
    public NotValidOrderTypeException() {
        super("This type of sort is not valid");
    }
}
