import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

import java.io.IOException;

public class MultipleEmailsMultipleRecipients {

  public static void main(String[] args) throws IOException {
    final Mail mail = new Mail();

    mail.setFrom(new Email("test@example.com", "Example User"));
    mail.setSubject("Sending with Twilio SendGrid is Fun");
    mail.setTemplateId("d-12345678901234567890123456789012");

    final Personalization personalization1 = new Personalization();
    personalization1.addTo(new Email("test1@example.com", "Example User1"));
    personalization1.addDynamicTemplateData("name", "Example User1");
    personalization1.addDynamicTemplateData("city", "Denver");
    mail.addPersonalization(personalization1);

    final Personalization personalization2 = new Personalization();
    personalization2.addTo(new Email("test2@example.com", "Example User2"));
    personalization2.addDynamicTemplateData("name", "Example User2");
    personalization2.addDynamicTemplateData("city", "San Francisco");
    mail.addPersonalization(personalization2);

    mail.addContent(new Content("text/plain", "and easy to do anywhere, even with Java"));
    mail.addContent(new Content("text/html", "<strong>and easy to do anywhere, even with Java</strong>"));

    send(mail);
  }

  private static void send(final Mail mail) throws IOException {
    final SendGrid client = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    final Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    request.setBody(mail.build());

    final Response response = client.api(request);
    System.out.println(response.getStatusCode());
    System.out.println(response.getBody());
    System.out.println(response.getHeaders());
  }
}
