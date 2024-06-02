package com.sendgrid.exception;

public class ApiConnectionException extends SendgridException {

    private static final long serialVersionUID = 6354388724599793830L;

    public ApiConnectionException(final String message) {
        super(message);
    }

    public ApiConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
