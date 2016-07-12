import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Create a Sender Identity
// POST /senders


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "senders";
      request.body = "{\"city\":\"Denver\",\"from\":{\"email\":\"from@example.com\",\"name\":\"Example INC\"},\"zip\":\"80202\",\"country\":\"United States\",\"state\":\"Colorado\",\"address_2\":\"Apt. 456\",\"address\":\"123 Elm St.\",\"reply_to\":{\"email\":\"replyto@example.com\",\"name\":\"Example INC\"},\"nickname\":\"My Sender ID\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Get all Sender Identities
// GET /senders


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "senders";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Update a Sender Identity
// PATCH /senders/{sender_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PATCH;
      request.endpoint = "senders/{sender_id}";
      request.body = "{\"city\":\"Denver\",\"from\":{\"email\":\"from@example.com\",\"name\":\"Example INC\"},\"zip\":\"80202\",\"country\":\"United States\",\"state\":\"Colorado\",\"address_2\":\"Apt. 456\",\"address\":\"123 Elm St.\",\"reply_to\":{\"email\":\"replyto@example.com\",\"name\":\"Example INC\"},\"nickname\":\"My Sender ID\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// View a Sender Identity
// GET /senders/{sender_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "senders/{sender_id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Delete a Sender Identity
// DELETE /senders/{sender_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "senders/{sender_id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Resend Sender Identity Verification
// POST /senders/{sender_id}/resend_verification


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "senders/{sender_id}/resend_verification";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

