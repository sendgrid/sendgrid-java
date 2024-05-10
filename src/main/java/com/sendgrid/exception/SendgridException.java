package com.sendgrid.exception;

public abstract class SendgridException extends RuntimeException {

    private static final long serialVersionUID = 2516935680980388130L;

    public SendgridException(final String message) {
        this(message, null);
    }

    public SendgridException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
