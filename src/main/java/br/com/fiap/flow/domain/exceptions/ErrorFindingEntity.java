package br.com.fiap.flow.domain.exceptions;

public class ErrorFindingEntity extends RuntimeException {
    public ErrorFindingEntity(String message) {
        super(message);
    }
    public ErrorFindingEntity(String message, Throwable cause) {
        super(message, cause);
    }
}
