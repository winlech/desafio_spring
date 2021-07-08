package br.com.mercadolivre.desafio_spring.shared.validations.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found");
    }
}
