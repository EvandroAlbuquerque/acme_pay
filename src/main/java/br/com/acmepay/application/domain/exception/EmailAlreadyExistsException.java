package br.com.acmepay.application.domain.exception;

public class EmailAlreadyExistsException extends Exception{

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
