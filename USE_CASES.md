This documentation provides examples for specific use cases. Please [open an issue](https://github.com/sendgrid/sendgrid-java/issues) or make a pull request for any use cases you would like us to document here. Thank you!

# Table of Contents

* [Transactional Templates](#transactional-templates)
* [Legacy Templates](#legacy-templates)
* [How to Setup a Domain Whitelabel](#domain-whitelabel)
* [How to View Email Statistics](#email-stats)

<a name="transactional-templates"></a>
# (LEGACY) Transactional Templates

IF YOU ARE USING OUR NEW TEMPLATES, PLEASE SEE [THIS ISSUE](https://github.com/sendgrid/sendgrid-java/issues/447).

For this example, we assume you have created a [transactional template](https://sendgrid.com/docs/User_Guide/Transactional_Templates/index.html). Following is the template content we used for testing.

Template ID (replace with your own):

```text
d-2c214ac919e84170b21855cc129b4a5f
```

Template Body:

```html
<html>
  <head>
    <title></title>
  </head>
  <body>
    Hello {{name}},
    <br/><br/>
    I'm glad you are trying out the template feature!
    <br/><br/>
    I hope you are having a great day in {{city}} :)
    <br/><br/>
  </body>
</html>
```

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
        \"from\": {\"email\": \"test@example.com\"},
        \"personalizations\":
        [{
          \"to\": [{\"email\": \"test@example.com\"}],
          \"dynamic_template_data\": {\"name\": \"Example User\", \"city\": \"Denver\"}
        }],
        \"template_id\": \"d-2c214ac919e84170b21855cc129b4a5f\"}");
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

<a name="legacy-templates"></a>
# Legacy Templates

For this example, we assume you have created a [legacy template](https://sendgrid.com/docs/User_Guide/Transactional_Templates/index.html). Following is the template content we used for testing.

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
          \"subject\": \"Hello World from the SendGrid Java Library!\"
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

<a name="domain-whitelabel"></a>
# How to Setup a Domain Whitelabel

You can find documentation for how to setup a domain whitelabel via the UI [here](https://sendgrid.com/docs/Classroom/Basics/Whitelabel/setup_domain_whitelabel.html) and via API [here](https://github.com/sendgrid/sendgrid-java/blob/master/USAGE.md#whitelabel).

Find more information about all of SendGrid's whitelabeling related documentation [here](https://sendgrid.com/docs/Classroom/Basics/Whitelabel/index.html).

<a name="email-stats"></a>
# How to View Email Statistics

You can find documentation for how to view your email statistics via the UI [here](https://app.sendgrid.com/statistics) and via API [here](https://github.com/sendgrid/sendgrid-java/blob/master/USAGE.md#stats).

Alternatively, we can post events to a URL of your choice via our [Event Webhook](https://sendgrid.com/docs/API_Reference/Webhooks/event.html) about events that occur as SendGrid processes your email.

