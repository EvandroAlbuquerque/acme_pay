package br.com.acmepay;

public class EmailAlreadyExistsException extends Exception{

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
