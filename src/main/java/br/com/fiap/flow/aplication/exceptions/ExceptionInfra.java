package br.com.fiap.flow.aplication.exceptions;

public class ExceptionInfra extends RuntimeException {
    public ExceptionInfra(String message) {
        super(message);
    }
    public ExceptionInfra(String message, Throwable cause) {
        super(message, cause);
    }
}
