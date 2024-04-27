package br.com.acmepay.application.domain.exception;

public class DocumentAlreadyExistsException extends Exception {

    public DocumentAlreadyExistsException(String message){
        super(message);
    }
}
