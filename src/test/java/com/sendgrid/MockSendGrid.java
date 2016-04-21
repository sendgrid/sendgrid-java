package com.sendgrid;

import java.io.IOException;
import java.util.HashMap;

public class MockSendGrid extends SendGrid {
  Request request;
  
  public MockSendGrid(String apiKey) {
    super(apiKey);
  }
  
  public Response makeCall(Request request) throws IOException {
    this.request = request;
    Response response = new Response();
    response.statusCode = 200;
    response.responseBody = "{\"message\":\"success\"}";
    response.responseHeaders = new HashMap<String, String>();
    response.responseHeaders.put("Test", "Header");
    return response;
  }
  
  public Request getRequest() {
    return this.request;
  }
}