package net.sgysoft.thegame.exceptions;

public class InvalidValueException extends TheGameException {

    public InvalidValueException(String message, Object... args) {
        super(message, args);
    }

    public InvalidValueException(String message, Throwable cause, Object... args) {
        super(message, cause, args);
    }

}
