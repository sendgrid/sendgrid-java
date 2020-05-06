package com.sendgrid;

import java.io.IOException;
import java.util.Map;

public interface SendGridAPI {

  /**
   * Initialize the client.
   *
   * @param auth authorization header value
   * @param host the base URL for the API
   */
  void initialize(final String auth, final String host);

  /**
   * Get the current library version.
   *
   * @return the current version
   */
  String getLibraryVersion();

  /**
   * Get the API version.
   *
   * @return the current API version
   */
  String getVersion();

  /**
   * Set the API version.
   *
   * @param version the new version
   */
  void setVersion(final String version);

  /**
   * Get the request headers.
   *
   * @return the request headers
   */
  Map<String, String> getRequestHeaders();

  /**
   * Add/update a request header.
   *
   * @param key   the header key
   * @param value the header value
   * @return the new set of request headers
   */
  Map<String, String> addRequestHeader(final String key, final String value);

  /**
   * Remove a request header.
   *
   * @param key the header key to remove
   * @return the new set of request headers
   */
  Map<String, String> removeRequestHeader(final String key);

  /**
   * Get the host.
   *
   * @return the host
   */
  String getHost();

  /**
   * Set the host.
   *
   * @param host the new host
   */
  void setHost(final String host);

  /**
   * Makes the call to the Twilio SendGrid API, override this method for testing.
   *
   * @param request the request to make
   * @return the response object
   * @throws IOException in case of a network error
   */
  Response makeCall(final Request request) throws IOException;

  /**
   * Class api sets up the request to the Twilio SendGrid API, this is main interface.
   *
   * @param request the request object
   * @return the response object
   * @throws IOException in case of a network error
   */
  Response api(final Request request) throws IOException;
}
