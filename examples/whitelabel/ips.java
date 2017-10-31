import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Create an IP whitelabel
// POST /whitelabel/ips


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.POST);
      request.setEndpoint("whitelabel/ips");
      request.setBody("{\"ip\":\"192.168.1.1\",\"domain\":\"example.com\",\"subdomain\":\"email\"}");
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
// Retrieve all IP whitelabels
// GET /whitelabel/ips


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("whitelabel/ips");
      request.addQueryParam("ip", "test_string");
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
// Retrieve an IP whitelabel
// GET /whitelabel/ips/{id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("whitelabel/ips/{id}");
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
// Delete an IP whitelabel
// DELETE /whitelabel/ips/{id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.DELETE);
      request.setEndpoint("whitelabel/ips/{id}");
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
// Validate an IP whitelabel
// POST /whitelabel/ips/{id}/validate


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.POST);
      request.setEndpoint("whitelabel/ips/{id}/validate");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}
