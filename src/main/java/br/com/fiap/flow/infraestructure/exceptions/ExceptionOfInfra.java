package br.com.fiap.flow.infraestructure.exceptions;

public class ExceptionOfInfra extends RuntimeException{
    public ExceptionOfInfra(String message) {
        super(message);
    }

    public ExceptionOfInfra(String message, Throwable cause) {
        super(message, cause);
    }
}
