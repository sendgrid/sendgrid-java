## With Mail Helper Class

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    Mail mail = new Mail();
    mail.setFrom(new Email("teste@example.com"));
    mail.setTemplateId("d-2c214ac919e84170b21855cc129b4a5f");

    Personalization personalization = new Personalization();
    personalization.addDynamicTemplateData("subject", "Testing Templates");
    personalization.addDynamicTemplateData("name", "Example User");
    personalization.addDynamicTemplateData("city", "Denver");
    personalization.addTo(new Email("test@example.com"));
    mail.addPersonalization(personalization);
            
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

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    Email from = new Email("test@example.com");
    String subject = "I'm replacing the subject tag";
    Email to = new Email("test@example.com");
    Content content = new Content("text/html", "I'm replacing the <strong>body tag</strong>");
    Mail mail = new Mail(from, subject, to, content);
    mail.personalization.get(0).addSubstitution("-name-", "Example User");
    mail.personalization.get(0).addSubstitution("-city-", "Denver");
    mail.setTemplateId("13b8f94f-bcae-4ec6-b752-70d6cb59f932");

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