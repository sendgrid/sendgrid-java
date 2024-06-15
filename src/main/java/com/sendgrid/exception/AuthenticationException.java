package com.sendgrid.exception;

public class AuthenticationException extends SendgridException {

    private static final long serialVersionUID = -7779574072471080781L;

    public AuthenticationException(final String message) {
        super(message);
    }
}
