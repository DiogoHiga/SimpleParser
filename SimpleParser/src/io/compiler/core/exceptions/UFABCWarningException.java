package io.compiler.core.exceptions;

public class UFABCWarningException extends RuntimeException {
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";
    
    public UFABCWarningException(String message) {
        super(ANSI_YELLOW + message + ANSI_RESET); // Define a cor na mensagem
    }
}
