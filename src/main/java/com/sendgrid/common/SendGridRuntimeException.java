package com.sendgrid.common;

public class SendGridRuntimeException extends RuntimeException {

  public SendGridRuntimeException(String message) {
    super(message);
  }

  public SendGridRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }
}
