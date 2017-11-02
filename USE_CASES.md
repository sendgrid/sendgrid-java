This documentation provides examples for specific use cases. Please [open an issue](https://github.com/sendgrid/sendgrid-java/issues) or make a pull request for any use cases you would like us to document here. Thank you!

# Table of Contents

* [Transactional Templates](#transactional_templates)
* [How to Setup a Domain Whitelabel](#domain_whitelabel)
* [How to View Email Statistics](#email_stats)

<a name="transactional-templates"></a>
# Transactional Templates

For this example, we assume you have created a [transactional template](https://sendgrid.com/docs/User_Guide/Transactional_Templates/index.html). Following is the template content we used for testing.

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
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Response response = new Mail()
            .from("test@example.com")
            .subject("I'm replacing the subject tag")
            .to( 
                new Email()
                    .email("test@example.com")
            ).content(
                new Content()
                    .type(ContentType.TEXT_HTML)
                    .value("I'm replacing the <strong>body tag</strong>")
            ).personalization(
                new Personalization()
                    .substitution("-name-", "Example User")
                    .substitution("-city-", "Denver")
            ).templateId("13b8f94f-bcae-4ec6-b752-70d6cb59f932")
            .send(sg);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    }
}
```

## Without Mail Helper Class

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody("{\"personalizations\":[{\"to\":[{\"email\":\"test@example.com\"}],\"substitutions\":{\"-name-\":\"Example User\",\"-city-\":\"Denver\"},\"subject\":\"Hello World from the SendGrid Java Library!\"}],\"from\":{\"email\":\"test@example.com\"},\"content\":[{\"type\":\"text/html\",\"value\": \"I'm replacing the <strong>body tag</strong>\"}],\"template_id\": \"13b8f94f-bcae-4ec6-b752-70d6cb59f932\"}");

        Response response = sg.send(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    }
}
```

<a name="domain_whitelabel"></a>
# How to Setup a Domain Whitelabel

You can find documentation for how to setup a domain whitelabel via the UI [here](https://sendgrid.com/docs/Classroom/Basics/Whitelabel/setup_domain_whitelabel.html) and via API [here](https://github.com/sendgrid/sendgrid-java/blob/master/USAGE.md#whitelabel).

Find more information about all of SendGrid's whitelabeling related documentation [here](https://sendgrid.com/docs/Classroom/Basics/Whitelabel/index.html).

<a name="email_stats"></a>
# How to View Email Statistics

You can find documentation for how to view your email statistics via the UI [here](https://app.sendgrid.com/statistics) and via API [here](https://github.com/sendgrid/sendgrid-java/blob/master/USAGE.md#stats).

Alternatively, we can post events to a URL of your choice via our [Event Webhook](https://sendgrid.com/docs/API_Reference/Webhooks/event.html) about events that occur as SendGrid processes your email.

