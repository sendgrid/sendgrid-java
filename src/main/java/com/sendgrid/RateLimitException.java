package com.sendgrid;

/**
 * An exception thrown when the maximum number of retries have occurred, and the API calls are still
 * rate limited.
 */
public class RateLimitException extends Exception {

  private final Request request;
  private final int retryCount;

  /**
   * Construct a new exception.
   *
   * @param request the originating request object.
   * @param retryCount the number of times a retry was attempted.
   */
  public RateLimitException(Request request, int retryCount) {
    this.request = request;
    this.retryCount = retryCount;
  }

  /**
   * Get the originating request object.
   *
   * @return the request object.
   */
  public Request getRequest() {
    return this.request;
  }

  /**
   * Get the number of times the action was attempted.
   *
   * @return the retry count.
   */
  public int getRetryCount() {
    return this.retryCount;
  }
}
