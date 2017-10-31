import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//////////////////////////////////////////////////////////////////
// List all Subusers
// GET /subusers


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("subusers");
      request.addQueryParam("username", "test_string");
      request.addQueryParam("limit", "1");
      request.addQueryParam("offset", "1");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve Subuser Reputations
// GET /subusers/reputations


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("subusers/reputations");
      request.addQueryParam("usernames", "test_string");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}
//////////////////////////////////////////////////////////////////
// Retrieve monthly stats for all subusers
// GET /subusers/stats/monthly


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("subusers/stats/monthly");
      request.addQueryParam("subuser", "test_string");
      request.addQueryParam("limit", "1");
      request.addQueryParam("sort_by_metric", "test_string");
      request.addQueryParam("offset", "1");
      request.addQueryParam("date", "test_string");
      request.addQueryParam("sort_by_direction", "asc");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}


