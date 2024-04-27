package br.com.acmepay.application.domain.exception;

public class DocumentNotFoundException extends Exception {

    public DocumentNotFoundException(String message) {
        super(message);
    }
}
