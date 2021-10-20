# Personalizations

This example goes over how to send multiple emails using personalizations with the helper class. 

A similar example can be found in `examples/helpers/mail/MultipleEmailsMultipleRecipients.java`, and further documentation can be found [here](https://docs.sendgrid.com/for-developers/sending-email/personalizations).

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        final Mail mail = new Mail();

        // Note that the domain of the from addresses should be the same
        mail.setFrom(new Email("test@example.com", "Example User"));
        mail.setSubject("I'm the original subject");
        mail.addContent(new Content("text/plain", "and this is some content"));
        mail.addContent(new Content("text/html", "<strong>and this is some content</strong>"));
        
        final Personalization personalization1 = new Personalization();
        personalization1.addTo(new Email("test1@example.com", "Example User1"));
        personalization1.addCc(new Email("test2@example.com", "Example User2"));
        mail.addPersonalization(personalization1);

        final Personalization personalization2 = new Personalization();
        personalization2.addTo(new Email("test3@example.com", "Example User3"));
        personalization2.setFrom(new Email("test4@example.com", "Example User4"));
        personalization2.setSubject(new Subject("I'm the personalized subject"));
        personalization2.addBcc(new Email("test5@example.com", "Example User5"));
        mail.addPersonalization(personalization2);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}
```