package br.com.mercadolivre.desafio_spring.validations.exceptions;

public class NotValidFollowException extends RuntimeException {
    public NotValidFollowException() {
        super("This follow operation is not valid");
    }
}
