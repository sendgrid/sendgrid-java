package com.sendgrid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
  * Class SendGrid allows for quick and easy access to the SendGrid API.
  */
public class SendGrid implements SendGridAPI {

  private static final String VERSION = "3.0.0";

  /** The user agent string to return to SendGrid. */
  private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";

  /** The user's API key. */
  private String apiKey;

  /** The SendGrid host to which to connect. */
  private String host;

  /** The API version. */
  private String version;

  /** The HTTP client. */
  private Client client;

  /** The request headers container. */
  private Map<String,String> requestHeaders;

  /**
   * Construct a new SendGrid API wrapper.
   * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   */
  public SendGrid(String apiKey) {
    this.client = new Client();
    initializeSendGrid(apiKey);
  }

  /**
   * Construct a new SendGrid API wrapper.
   * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param test is true if you are unit testing
   */
  public SendGrid(String apiKey, Boolean test) {
    this.client = new Client(test);
    initializeSendGrid(apiKey);
  }

  /**
   * Construct a new SendGrid API wrapper.
   * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param client the Client to use (allows to customize its configuration)
   */
  public SendGrid(String apiKey, Client client) {
    this.client = client;
    initializeSendGrid(apiKey);
  }

  /**
   * Initialize the client.
   * @param apiKey the user's API key.
   */
  public void initializeSendGrid(String apiKey) {
    this.apiKey = apiKey;
    this.host = "api.sendgrid.com";
    this.version = "v3";
    this.requestHeaders = new HashMap<String, String>();
    this.requestHeaders.put("Authorization", "Bearer " + apiKey);
    this.requestHeaders.put("User-agent", USER_AGENT);
    this.requestHeaders.put("Accept", "application/json");
  }

  /**
   * Retrieve the current library version.
   * @return the current version.
   */
  public String getLibraryVersion() {
    return this.VERSION;
  }

  /**
   * Get the API version.
   * @return the current API versioin (v3 by default).
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Set the API version.
   * @param version the new version.
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * Obtain the request headers.
   * @return the request headers.
   */
  public Map<String,String> getRequestHeaders() {
    return this.requestHeaders;
  }

  /**
   * Add a new request header.
   * @param key the header key.
   * @param value the header value.
   * @return the new set of request headers.
   */
  public Map<String,String> addRequestHeader(String key, String value) {
    this.requestHeaders.put(key, value);
    return getRequestHeaders();
  }

  /**
   * Remove a request header.
   * @param key the header key to remove.
   * @return the new set of request headers.
   */
  public Map<String,String> removeRequestHeader(String key) {
    this.requestHeaders.remove(key);
    return getRequestHeaders();
  }

  /**
   * Get the SendGrid host (api.sendgrid.com by default).
   * @return the SendGrid host.
   */
  public String getHost() {
    return this.host;
  }

  /**
   * Set the SendGrid host.
   * @param host the new SendGrid host.
   */
  public void setHost(String host) {
    this.host = host;
  }

  /**
   * Class makeCall makes the call to the SendGrid API, override this method for testing.
   * @param request the request to make.
   * @return the response object.
   * @throws IOException in case of a network error.
   */
  public Response makeCall(Request request) throws IOException {
    return client.api(request);
  }

  /**
   * Class api sets up the request to the SendGrid API, this is main interface.
   * @param request the request object.
   * @return the response object.
   * @throws IOException in case of a network error.
   */
  public Response api(Request request) throws IOException {
    Request req = new Request();
    req.setMethod(request.getMethod());
    req.setBaseUri(this.host);
    req.setEndpoint("/" + version + "/" + request.getEndpoint());
    req.setBody(request.getBody());
    for (Map.Entry <String, String> header : this.requestHeaders.entrySet()) {
      req.addHeader(header.getKey(), header.getValue());
    }
    for (Map.Entry <String, String> queryParam : request.getQueryParams().entrySet()) {
      req.addQueryParam(queryParam.getKey(), queryParam.getValue());
    }

    return makeCall(req);
  }
}
