package com.sendgrid;

import com.sendgrid.Client;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
  * Class SendGrid allows for quick and easy access to the SendGrid API.
  */
public class SendGrid {
  private static final String VERSION = "3.0.0";
  private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";

  private String apiKey;
  private String host;
  private String version;
  private Client client;
  private Map<String,String> requestHeaders;

  /**
    * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
    */
  public SendGrid(String apiKey) {
    this.client = new Client();
    initializeSendGrid(apiKey);
  }

  /**
    * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
    * @param test is true if you are unit testing
    */
  public SendGrid(String apiKey, Boolean test) {
    this.client = new Client(test);
    initializeSendGrid(apiKey);
  }

  public void initializeSendGrid(String apiKey) {
    this.apiKey = apiKey;
    this.host = "api.sendgrid.com";
    this.version = "v3";
    this.requestHeaders = new HashMap<String, String>();
    this.requestHeaders.put("Authorization", "Bearer " + apiKey);
    this.requestHeaders.put("User-agent", USER_AGENT);
    this.requestHeaders.put("Accept", "application/json");
  }

  public String getLibraryVersion() {
    return this.VERSION;
  }

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Map<String,String> getRequestHeaders() {
    return this.requestHeaders;
  }

  public Map<String,String> addRequestHeader(String key, String value) {
    this.requestHeaders.put(key, value);
    return getRequestHeaders();
  }

  public Map<String,String> removeRequestHeader(String key) {
    this.requestHeaders.remove(key);
    return getRequestHeaders();
  }

  public String getHost() {
    return this.host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  /**
    * Class makeCall makes the call to the SendGrid API, override this method for testing.
    */
  public Response makeCall(Request request) throws IOException {
    Response response = new Response();
    try {
      response = client.api(request);
    } catch (IOException ex) {
      throw ex;
    }
    return response;
  }

  /**
    * Class api sets up the request to the SendGrid API, this is main interface.
    */
  public Response api(Request request) throws IOException {
    Request req = new Request();
    req.setMethod(request.getMethod());
    req.setBaseUri(this.host);
    req.setEndpoint("/" + version + "/" + request.getEndpoint());
    req.setBody(request.getBody());
    for (String headerKey : this.requestHeaders.keySet()) {
      req.addHeader(headerKey, this.requestHeaders.get(headerKey));
    }
    for (String queryParamKey : request.getQueryParams().keySet()) {
      req.addQueryParam(queryParamKey, request.getQueryParams().get(queryParamKey));
    }

    return makeCall(req);
  }
}
