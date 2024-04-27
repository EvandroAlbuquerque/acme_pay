package br.com.acmepay;

public class DocumentAlreadyExistsException extends Exception {

    public DocumentAlreadyExistsException(String message){
        super(message);
    }
}
