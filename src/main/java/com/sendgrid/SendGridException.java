package com.sendgrid;

public class SendGridException extends Exception {
    public SendGridException(Exception e) {
        super(e);
    }
}
