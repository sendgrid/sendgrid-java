import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Set data residency to navigate to a region/edge.
// Currently supported: "global", "eu"


public class Example {
  public static void main(String[] args) throws IOException {
    try {

      final Mail helloWorld = buildHelloEmail();

      Request request = new Request();
      request.setEndpoint("mail/send");
      request.setBody(helloWorld.build());
      request.setMethod(Method.POST);

      // sending to global data residency
      Sendgrid sg = buildSendgridObj("global");
      Response response = sg.api(request);
      System.out.println("Sending to hostname: " + sg.getHost());
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());

      // sending to EU data residency
      Sendgrid sg = buildSendgridObj("eu");
      Response response = sg.api(request);
      System.out.println("Sending to hostname: " + sg.getHost());
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());

      // not configuring any region defaults to global
      Sendgrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Response response = sg.api(request);
      System.out.println("Sending to hostname: " + sg.getHost());
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());

    } catch (IOException ex) {
      throw ex;
    }
  }

  public static Mail buildHelloEmail() {
    Email from = new Email("test@example.com");
    String subject = "Hello World from the Twilio SendGrid Java Library";
    Email to = new Email("test@example.com");
    Content content = new Content("text/plain", "some text here");
    // Note that when you use this constructor an initial personalization object
    // is created for you. It can be accessed via
    // mail.personalization.get(0) as it is a List object
    Mail mail = new Mail(from, subject, to, content);
    Email email = new Email("test2@example.com");
    mail.personalization.get(0).addTo(email);

    return mail;
  }

  public static Sendgrid buildSendgridObj(String region){
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    sg.setDataResidency(region);
    return sg;

  }
}

