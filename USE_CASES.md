This document provides examples for specific use cases. Please [open an issue](https://github.com/sendgrid/sendgrid-java/issues) or make a pull request for any use cases you would like us to document here. Thank you!

# Use Cases

* [Send Mail Examples](examples/helpers/mail/Example.java)
  * [Send a Single Email to Multiple Recipients](examples/helpers/mail/SingleEmailMultipleRecipients.java)
  * [Send Multiple Emails to Multiple Recipients](examples/helpers/mail/MultipleEmailsMultipleRecipients.java)
* [Transactional Templates](#transactional-templates)
* [Legacy Templates](#legacy-templates)
* [How to Setup a Domain Authentication](#domain-authentication)
* [How to View Email Statistics](#how-to-view-email-statistics)
* [Send an Email With Twilio Email (Pilot)](#send-an-email-with-twilio-email-pilot)
* [Send an SMS Message](#send-an-sms-message)

# Transactional Templates

For this example, we assume you have created a [transactional template](https://sendgrid.com/docs/User_Guide/Transactional_Templates/index.html) in the UI or via the API. Following is the template content we used for testing.

Template ID (replace with your own):

```text
d-2c214ac919e84170b21855cc129b4a5f
```
Email Subject:

```text
{{subject}}
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
          \"dynamic_template_data\": {\"subject\": \"Testing Templates\",\"name\": \"Example User\", \"city\": \"Denver\"}
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

<a name="domain-authentication"></a>
# How to Setup a Domain Authentication

You can find documentation for how to set up a domain authentication via the UI [here](https://sendgrid.com/docs/ui/account-and-settings/how-to-set-up-domain-authentication/) and via API [here](USAGE.md#sender-authentication).

Find more information about all of Twilio SendGrid's authentication related documentation [here](https://sendgrid.com/docs/ui/account-and-settings/).

# How to View Email Statistics

You can find documentation for how to view your email statistics via the UI [here](https://app.sendgrid.com/statistics) and via API [here](USAGE.md#stats).

Alternatively, we can post events to a URL of your choice via our [Event Webhook](https://sendgrid.com/docs/API_Reference/Webhooks/event.html) about events that occur as Twilio SendGrid processes your email.

# Send an Email With Twilio Email (Pilot)

### 1. Obtain a Free Twilio Account

Sign up for a free Twilio account [here](https://www.twilio.com/try-twilio?source=sendgrid-java).

### 2. Set Up Your Environment Variables

The Twilio API allows for authentication using with either an API key/secret or your Account SID/Auth Token. You can create an API key [here](https://twil.io/get-api-key) or obtain your Account SID and Auth Token [here](https://twil.io/console).

Once you have those, follow the steps below based on your operating system.

#### Linux/Mac

```bash
echo "export TWILIO_API_KEY='YOUR_TWILIO_API_KEY'" > twilio.env
echo "export TWILIO_API_SECRET='YOUR_TWILIO_API_SECRET'" >> twilio.env

# or

echo "export TWILIO_ACCOUNT_SID='YOUR_TWILIO_ACCOUNT_SID'" > twilio.env
echo "export TWILIO_AUTH_TOKEN='YOUR_TWILIO_AUTH_TOKEN'" >> twilio.env
```

Then:

```bash
echo "twilio.env" >> .gitignore
source ./twilio.env
```

#### Windows

Temporarily set the environment variable (accessible only during the current CLI session):

```bash
set TWILIO_API_KEY=YOUR_TWILIO_API_KEY
set TWILIO_API_SECRET=YOUR_TWILIO_API_SECRET

: or

set TWILIO_ACCOUNT_SID=YOUR_TWILIO_ACCOUNT_SID
set TWILIO_AUTH_TOKEN=YOUR_TWILIO_AUTH_TOKEN
```

Or permanently set the environment variable (accessible in all subsequent CLI sessions):

```bash
setx TWILIO_API_KEY "YOUR_TWILIO_API_KEY"
setx TWILIO_API_SECRET "YOUR_TWILIO_API_SECRET"

: or

setx TWILIO_ACCOUNT_SID "YOUR_TWILIO_ACCOUNT_SID"
setx TWILIO_AUTH_TOKEN "YOUR_TWILIO_AUTH_TOKEN"
```

### 3. Initialize the Twilio Email Client

```java
TwilioEmail mailClient = new TwilioEmail(System.getenv("TWILIO_API_KEY"), System.getenv("TWILIO_API_SECRET"));

// or

TwilioEmail mailClient = new TwilioEmail(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));
```

This client has the same interface as the `SendGrid` client.

# Send an SMS Message

First, follow the above steps for creating a Twilio account and setting up environment variables with the proper credentials.

Then, install the Twilio Helper Library by following the [installation steps](https://github.com/twilio/twilio-java#installation).

Finally, send a message.

```java
String accountSid = System.getenv("TWILIO_ACCOUNT_SID");
String authToken = System.getenv("TWILIO_AUTH_TOKEN");

Twilio.init(accountSid, authToken);

Message message = Message.creator(
    new PhoneNumber("+15558881234"),  // To number
    new PhoneNumber("+15559994321"),  // From number
    "Hello world!"                    // SMS body
).create();

System.out.println(message.getSid());
```

For more information, please visit the [Twilio SMS Java documentation](https://www.twilio.com/docs/sms/quickstart/java).
