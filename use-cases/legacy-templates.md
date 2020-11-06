# Legacy Templates

For this example, we assume you have created a [legacy transactional template](https://sendgrid.com/docs/User_Guide/Transactional_Templates/index.html) in the UI or via the API. Following is the template content we used for testing.

Template ID (replace with your own):

```text
13b8f94f-bcae-4ec6-b752-70d6cb59f932
```

Email Subject:

```text
<%subject%>
```

Template Body:

```html
<html>
  <head>
    <title></title>
  </head>
  <body>
    Hello -name-,
    <br /><br/>
    I'm glad you are trying out the template feature!
    <br /><br/>
    <%body%>
    <br /><br/>
    I hope you are having a great day in -city- :)
    <br /><br/>
  </body>
</html>
```

## With Mail Helper Class

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

## Without Mail Helper Class

```java
import com.sendgrid.*;
import java.io.IOException;
public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody("{
        \"personalizations\":
        [{
          \"to\": [{\"email\": \"test@example.com\"}],
          \"substitutions\": {\"-name-\": \"Example User\", \"-city-\": \"Denver\"},
          \"subject\": \"Hello World from the Twilio SendGrid Java Library!\"
        }],
        \"from\": {\"email\": \"test@example.com\"},
        \"content\":
        [{
          \"type\": \"text/html\",
          \"value\": \"I'm replacing the <strong>body tag</strong>\"
        }]
        ,\"template_id\": \"13b8f94f-bcae-4ec6-b752-70d6cb59f932\"}");
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
