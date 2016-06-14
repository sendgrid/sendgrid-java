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
    response.body = "{\"message\":\"success\"}";
    response.headers = new HashMap<String, String>();
    response.headers.put("Test", "Header");
    return response;
  }

  public Request getRequest() {
    return this.request;
  }
}