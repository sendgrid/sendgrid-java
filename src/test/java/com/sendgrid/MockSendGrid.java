package com.sendgrid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MockSendGrid extends SendGrid {
  Request request;

  public MockSendGrid(String apiKey) {
    super(apiKey);
  }

  public Response makeCall(Request request) throws IOException {
    this.request = request;
    Response response = new Response();
    response.setStatusCode(200);
    response.setBody("{\"message\":\"success\"}");
    Map<String, String> headers = new HashMap<>();
    headers.put("Test", "Header");
    response.setHeaders(headers);
    return response;
  }

  public Request getRequest() {
    return this.request;
  }
}