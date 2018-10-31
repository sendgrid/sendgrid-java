package com.sendgrid;

import java.io.IOException;
import java.util.Map;

public interface SendGridAPI {

  /**
   * Initializes Twilio SendGrid
   *
   * @param apiKey is your Twilio SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   */
  void initializeSendGrid(String apiKey);

  /**
   * Returns the library version
   *
   * @return the library version.
   */
  String getLibraryVersion();

  /**
   * Gets the version.
   *
   * @return returns the version.
   */
  String getVersion();

  /**
   * Sets the version.
   *
   * @param version the Twilio SendGrid version.
   */
  void setVersion(String version);

  /**
   * Gets the request headers.
   *
   * @return returns a map of request headers.
   */
  Map<String, String> getRequestHeaders();

  /**
   * Adds a request headers.
   *
   * @param key the key
   * @param value the value
   * @return returns a map of request headers.
   */
  Map<String, String> addRequestHeader(String key, String value);

  /**
   * Removes a request headers.
   *
   * @param key the key
   * @return returns a map of request headers.
   */
  Map<String, String> removeRequestHeader(String key);

  /**
   * Gets the host.
   *
   * @return returns the host.
   */
  String getHost();

  /**
   * Sets the host.
   *
   * @param host the host to set
   */
  void setHost(String host);

  /**
   * Class makeCall makes the call to the Twilio SendGrid API, override this method for testing.
   *
   * @param request the request
   * @return returns a response.
   * @throws IOException in case of network or marshal error.
   */
  Response makeCall(Request request) throws IOException;

  /**
   * Class api sets up the request to the Twilio SendGrid API, this is main interface.
   *
   * @param request the request
   * @return returns a response.
   * @throws IOException in case of network or marshal error.
   */
  Response api(Request request) throws IOException;
}
