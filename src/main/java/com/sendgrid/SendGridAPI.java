package com.sendgrid;

import java.io.IOException;
import java.util.Map;

public interface SendGridAPI {

  /**
   * Initializes SendGrid
   * 
   * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   */
  public void initializeSendGrid(String apiKey);

  /**
   * Returns the library version
   * 
   * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @return the library version.
   */
  public String getLibraryVersion();

  /**
   * Gets the version.
   *
   * @return returns the version.
   */
  public String getVersion();

  /**
   * Sets the version.
   * 
   * @param version the SendGrid version.
   */
  public void setVersion(String version);

  /**
   * Gets the request headers.
   * @return returns a map of request headers.
   */
  public Map<String, String> getRequestHeaders();

  /**
   * Adds a request headers.
   * 
   * @param key the key
   * @param value the value
   * @return returns a map of request headers.
   */
  public Map<String, String> addRequestHeader(String key, String value);

  /**
   * Removes a request headers.
   * 
   * @param key the key
   * @return returns a map of request headers.
   */
  public Map<String, String> removeRequestHeader(String key);

  /**
   * Gets the host.
   * 
   * @return returns the host.
   */
  public String getHost();

  /**
   * Sets the host.
   * 
   * @param host the host to set
   */
  public void setHost(String host);

  /**
   * Class makeCall makes the call to the SendGrid API, override this method for
   * testing.
   * 
   * @param request
   * @return returns a response.
   * @throws IOException in case of network or marshal error.
   */
  public Response makeCall(Request request) throws IOException;

  /**
   * Class api sets up the request to the SendGrid API, this is main interface.
   * 
   * @param request
   * @return
   * @throws IOException in case of network or marshal error.
   */
  public Response api(Request request) throws IOException;
}
