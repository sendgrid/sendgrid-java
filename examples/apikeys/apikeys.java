import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

//////////////////////////////////////////////////////////////////
// Create API keys
// POST /api_keys


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.POST);
      request.setEndpoint("api_keys");
      request.setBody("{\"sample\":\"data\",\"scopes\":[\"mail.send\",\"alerts.create\",\"alerts.read\"],\"name\":\"My API Key\"}");
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
// Retrieve all API Keys belonging to the authenticated user
// GET /api_keys


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("api_keys");
      request.addQueryParam("limit", "1");
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
// Update the name & scopes of an API Key
// PUT /api_keys/{api_key_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.PUT);
      request.setEndpoint("api_keys/{api_key_id}");
      request.setBody("{\"scopes\":[\"user.profile.read\",\"user.profile.update\"],\"name\":\"A New Hope\"}");
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
// Update API keys
// PATCH /api_keys/{api_key_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.PATCH);
      request.setEndpoint("api_keys/{api_key_id}");
      request.setBody("{\"name\":\"A New Hope\"}");
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
// Retrieve an existing API Key
// GET /api_keys/{api_key_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("api_keys/{api_key_id}");
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
// Delete API keys
// DELETE /api_keys/{api_key_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.DELETE);
      request.setEndpoint("api_keys/{api_key_id}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}

