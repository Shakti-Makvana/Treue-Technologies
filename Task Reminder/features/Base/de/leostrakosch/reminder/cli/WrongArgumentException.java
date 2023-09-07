package de.leostrakosch.reminder.cli;

public class WrongArgumentException extends Exception {


    public WrongArgumentException() {
    }

    public WrongArgumentException(Throwable e) {
    }

    public WrongArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    public WrongArgumentException(String message) {
        super(message);
    }

    public WrongArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
