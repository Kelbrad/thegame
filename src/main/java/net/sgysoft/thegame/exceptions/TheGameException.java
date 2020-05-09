package net.sgysoft.thegame.exceptions;

/**
 * Common root exception of all exceptions in this application
 */
public class TheGameException extends RuntimeException {

    public TheGameException(String message, Object... args) {
        super(String.format(message, args));
    }

    public TheGameException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }

}
