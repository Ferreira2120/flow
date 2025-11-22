package br.com.fiap.flow.domain.exceptions;

public class ExceptionEntity extends RuntimeException {
    public ExceptionEntity(String message) {
        super(message);
    }
}
