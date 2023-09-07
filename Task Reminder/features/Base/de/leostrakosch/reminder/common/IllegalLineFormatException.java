package de.leostrakosch.reminder.common;

public class IllegalLineFormatException extends Exception {
    public IllegalLineFormatException() {
    }

    public IllegalLineFormatException(String message) {
        super(message);
    }

    public IllegalLineFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalLineFormatException(Throwable cause) {
        super(cause);
    }

    public IllegalLineFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
