package io.compiler.core.exceptions;

public class UFABCSemanticException extends RuntimeException{
    private static final String ANSI_RED   = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    
    public UFABCSemanticException(String message) {
        super(ANSI_RED + "Error: " + message + ANSI_RESET); // Define a cor na mensagem
    }
}
