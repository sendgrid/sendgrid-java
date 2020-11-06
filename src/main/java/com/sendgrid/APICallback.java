package com.sendgrid;

/**
 * An interface describing a callback mechanism for the asynchronous, rate limit aware API
 * connection.
 */
public interface APICallback {

  /**
   * Callback method in case of an error.
   *
   * @param ex the error that was thrown.
   */
  void error(Exception ex);

  /**
   * Callback method in case of a valid response.
   *
   * @param response the valid response.
   */
  void response(Response response);
}
