package com.sendgrid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SendGridTest {

  private final String SENDGRID_API_KEY = "";
  
  public Map<String,String> buildDefaultHeaders() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Map<String,String> requestHeaders = new HashMap<String, String>();
    requestHeaders.put("Authorization", "Bearer " + SENDGRID_API_KEY);
    requestHeaders.put("Content-Type", "application/json");
    String USER_AGENT = "sendgrid/" + sg.getLibraryVersion() + ";java";
    requestHeaders.put("User-agent", USER_AGENT);
    return requestHeaders;
  }
  
  @Test
  public void testInitialization() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Assert.assertEquals(sg.getHost(), "api.sendgrid.com");
    Assert.assertEquals(sg.getVersion(), "v3");
    Map<String,String> requestHeaders = buildDefaultHeaders();
    Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);
  }
  
  @Test
  public void testLibraryVersion() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Assert.assertEquals(sg.getLibraryVersion(), "3.0.0");
  }
  
  @Test
  public void testVersion() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    sg.setVersion("v4");
    Assert.assertEquals(sg.getVersion(), "v4");
  }
  
  @Test
  public void testRequestHeaders() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Map<String,String> requestHeaders = buildDefaultHeaders();
    
    sg.addRequestHeader("Test", "one");
    requestHeaders.put("Test", "one");
    Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);
    
    sg.removeRequestHeader("Test");
    requestHeaders.remove("Test");
    Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);
  }
  
  @Test
  public void testHost() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    sg.setHost("api.new.com");
    Assert.assertEquals(sg.getHost(), "api.new.com");
  }
  
  @Test
  public void testApiGet() throws IOException {
    MockSendGrid sg = new MockSendGrid(SENDGRID_API_KEY);
    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "api_keys";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("limit", "100");
    queryParams.put("offset", "0");
    request.queryParams = queryParams;
    sg.api(request);
    Request testRequest = sg.getRequest();
    Assert.assertEquals(request.queryParams, testRequest.queryParams);
    Assert.assertEquals(request.method, testRequest.method);
    Assert.assertEquals("/v3/" + request.endpoint, testRequest.endpoint);
    Map<String,String> requestHeaders = buildDefaultHeaders();
    Assert.assertEquals(requestHeaders, testRequest.requestHeaders);
  }
  
  @Test
  public void testApiPostPutPatch() throws IOException {
    MockSendGrid sg = new MockSendGrid(SENDGRID_API_KEY);
    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "api_keys";
    request.requestBody = "{\"test\":\"request_body\"}";
    sg.api(request);
    Request testRequest = sg.getRequest();
    Assert.assertEquals(request.method, testRequest.method);
    Assert.assertEquals("/v3/" + request.endpoint, testRequest.endpoint);
    Assert.assertEquals(request.requestBody, testRequest.requestBody);
    Map<String,String> requestHeaders = buildDefaultHeaders();
    Assert.assertEquals(requestHeaders, testRequest.requestHeaders);
  }
  
  @Test    
  public void testApiDelete() throws IOException {
    MockSendGrid sg = new MockSendGrid(SENDGRID_API_KEY);
    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "api_keys";
    sg.api(request);
    Request testRequest = sg.getRequest();
    Assert.assertEquals(request.method, testRequest.method);
    Assert.assertEquals("/v3/" + request.endpoint, testRequest.endpoint);
    Map<String,String> requestHeaders = buildDefaultHeaders();
    Assert.assertEquals(requestHeaders, testRequest.requestHeaders);
  }

  @Test
  public void testBuildGradleVersion() throws IOException {
    try {
      SendGrid sg = new SendGrid(SENDGRID_API_KEY);
      BufferedReader br = new BufferedReader(new FileReader("./build.gradle"));
      String line = br.readLine();
      String regex = "version\\s*=\\s*'" + sg.getLibraryVersion() + "'";

      while (line != null) {
        if (line.matches(regex)) {
          br.close();
          return;
        }
        line = br.readLine();
      }
      br.close();
      Assert.assertTrue("build.gradle version does not match", false);
    } catch (FileNotFoundException ex) {
      throw ex;
    } catch (IOException ex) {
      throw ex;
    }

  }
}
