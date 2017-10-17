This documentation provides examples for specific use cases. Please [open an issue](https://github.com/sendgrid/sendgrid-java/issues) or make a pull request for any use cases you would like us to document here. Thank you!

# Table of Contents

* [Transactional Templates](#transactional_templates)

<a name="transactional_templates"></a>
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
      request.setBody("{\"personalizations\":[{\"to\":[{\"email\":\"test@example.com\"}],\"substitutions\":{\"-name-\":\"Example User\",\"-city-\":\"Denver\"},\"subject\":\"Hello World from the SendGrid Java Library!\"}],\"from\":{\"email\":\"test@example.com\"},\"content\":[{\"type\":\"text/html\",\"value\": \"I'm replacing the <strong>body tag</strong>\"}],\"template_id\": \"13b8f94f-bcae-4ec6-b752-70d6cb59f932\"}");
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

## Slack-Events-Api-Integration

#### Documentation

- Create a slack app and get a slack application token as shown at this [link](https://api.slack.com/slack-apps).

- Register at sendgrid and get a sendgrid api key as shown at this [link](https://sendgrid.com/docs/Classroom/Send/How_Emails_Are_Sent/api_keys.html).

- Set the system environment variables **SLACK_TOKEN** and **SENDGRID_API_KEY** for storing credentials.

- Register your app's url as a callback url in the slack application and choose the file_comment 
([link](https://api.slack.com/events/file_comment_added)) event to be subscribed.

- Install the app to your slack workspace.

#### A simple Slack Event Handler

```java
public class SlackEventsHandler extends HttpServlet {

  private String SLACK_TOKEN;
  private final SendGridMailSender mailSender;

  public SlackEventsHandler() {
    this.mailSender = new SendGridMailSender();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String body = IOUtils.toString(req.getInputStream(), "UTF-8");

    /**
     * this is slack registry call
     */
    if (body.contains("challenge")) {
      ObjectMapper mapper = new ObjectMapper();
      SlackRegistration slackRegistry = mapper.readValue(body, SlackRegistration.class);

      /**
       * save slack token
       */
      SLACK_TOKEN = slackRegistry.getToken();
      resp.setStatus(200);
      resp.getWriter().write(slackRegistry.getChallenge());
    } else {
      ObjectMapper mapper = new ObjectMapper();
      FileCommentEvent fileCommentEvent = mapper.readValue(body, FileCommentEvent.class);

      if (SLACK_TOKEN.equals(fileCommentEvent.getToken())) {
        if (mailSender.sendEmail(fileCommentEvent.getTeamId(),
          fileCommentEvent.getEvent().getUserId(),
          fileCommentEvent.getEvent().getFileId(),
          fileCommentEvent.getEvent().getComment().getTimestamp(),
          fileCommentEvent.getEvent().getComment().getComment())) {
          resp.setStatus(200);
          resp.getWriter().write("Acknowledge event received");
        } else {
          resp.setStatus(400);
          resp.getWriter().write("Acknowledge event receive failed");
        }
      } else {
        resp.setStatus(400);
        resp.getWriter().write("Acknowledge event receive failed");
      }
    }
  }
}
```

#### A simple mail sender using sendgrid-java

```java
public class SendGridMailSender {
  private static final Logger LOG = LoggerFactory.getLogger(SendGridMailSender.class);
  private static final String FROM_EMAIL_ADDRESS = "admin@slack.com";
  private static final String TO_EMAIL_ADDRESS = "receiver@mail.com";

  public boolean sendEmail(String teamId, String user, String fileId, long timestamp, String fileComment) {
    Email from = new Email(FROM_EMAIL_ADDRESS);
    String subject = String.format("[Slack]New comment in File %s posted by user %s in team %s", fileId, user, teamId);
    Email to = new Email(TO_EMAIL_ADDRESS);
    Content content = new Content("text/plain", fileComment + "\n" + new Timestamp(timestamp).toString());
    Mail mail = new Mail(from, subject, to, content);

    com.sendgrid.SendGrid sg = new com.sendgrid.SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);

      if (response.getStatusCode() == 202) {
        return true;
      } else {
        return false;
      }
    } catch (IOException ex) {
      LOG.error(ex.getMessage());
      return false;
    }
  }
}
```