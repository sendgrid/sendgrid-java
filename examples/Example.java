import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.Client;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Example {
  public static void main(String[] args) throws IOException {
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    sg.setHost("e9sk3d3bfaikbpdq7.stoplight-proxy.io");
    sg.addRequestHeader("X-Test", "test");
    
    // GET
    Request request = new Request();
    try {
      request.method = Method.GET;
      request.endpoint = "api_keys";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("limit", "100");
      queryParams.put("offset", "0");
      request.queryParams = queryParams;
      
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    } finally {
      request.queryParams = null;
    }
    
    // POST
    String apiKeyId = "";
    try {
      request.method = Method.POST;
      request.endpoint = "api_keys";
      request.requestBody = "{\"name\": \"My api Key\",\"scopes\": [\"mail.send\",\"alerts.create\",\"alerts.read\"]}";
      
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
      try {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response.responseBody);
        apiKeyId = json.path("api_key_id").asText(); 
      } catch (IOException ex) {
        throw ex;
      }
    } catch (IOException ex) {
      throw ex;
    } finally {
      request.requestBody = "";
    }
    
    // GET Single
    request.method = Method.GET;
    request.endpoint = "api_keys/" + apiKeyId;
    
    try {
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
    
    // PATCH
    request.method = Method.PATCH;
    request.requestBody = "{\"name\": \"A New Hope\"}";
    
    try {
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    } finally {
      request.requestBody = "";
    }
 
    // PUT
    request.method = Method.PUT;
    request.requestBody =
          "{\"name\": \"A New Hope\",\"scopes\": [\"user.profile.read\",\"user.profile.update\"]}";
    
    try {
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    } finally {
      request.requestBody = "";
    }
    
    // DELETE
    request.method = Method.DELETE;
    
    try {
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}