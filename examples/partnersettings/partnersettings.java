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

##################################################
# Returns a list of all partner settings. #
# GET /partner_settings #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "partner_settings";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("limit", "1");
    queryParams.put("offset", "1");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Updates New Relic partner settings. #
# PATCH /partner_settings/new_relic #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PATCH;
      request.endpoint = "partner_settings/new_relic";
      request.requestBody = "{\"enable_subuser_statistics\":true,\"enabled\":true,\"license_key\":\"\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Returns all New Relic partner settings. #
# GET /partner_settings/new_relic #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "partner_settings/new_relic";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

