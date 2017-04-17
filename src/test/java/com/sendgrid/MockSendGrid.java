package com.sendgrid;

import java.io.IOException;
import java.util.HashMap;

public class MockSendGrid extends SendGrid {
  private Request request;

  public MockSendGrid(final String apiKey) {
    super(apiKey);
  }

  public Response makeCall(final Request request) throws IOException {
    this.request = request;
    final Response response = new Response();
    response.statusCode = 200;
    response.body = "{\"message\":\"success\"}";
    response.headers = new HashMap<>();
    response.headers.put("Test", "Header");
    return response;
  }

  public Request getRequest() {
    return this.request;
  }
}