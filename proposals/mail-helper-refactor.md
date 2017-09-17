# Send a Single Email to a Single Recipient

The following code assumes you are storing the API key in an environment variable (recommended). 

This is the minimum code needed to send an email.

```java
import com.sendgrid.*;
import com.sendgrid.helpers.mail.*;

public class SendGridExample {
  public static void main(String[] args) throws SendGridException {
    From from = new From("test@example.com", "Example User");
    To to = new To("test@example.com", "Example User");
    Subject subject = Subject("Sending with SendGrid is Fun");
    PlainTextContent plainTextContent = new PlainTextContent("and easy to do anywhere, even with Java");
    HtmlContent htmlContent = new HtmlContent("<strong>and easy to do anywhere, even with Java</strong>");
    SendGridMessage email = new SendGridMessage(from,
                                                to,
                                                subject,
                                                plainTextContent,
                                                htmlContent);

    SendGrid sendgrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    try {
      SendGridResponse response = sendgrid.send(email);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (SendGridException ex) {
      System.err.println(ex);
      throw ex;
    }
  }
}
```

# Send a Single Email to Multiple Recipients

The following code assumes you are storing the API key in an environment variable (recommended). 

```java
import com.sendgrid.*;
import com.sendgrid.helpers.mail.*;
import java.util.ArrayList;

public class SendGridExample {
  public static void main(String[] args) throws SendGridException {
    From from = new From("test@example.com", "Example User");
    ArrayList<To> tos = new ArrayList<To>();
    tos.add(new To("test1@example.com", "Example User1"));
    tos.add(new To("test2@example.com", "Example User2"));
    tos.add(new To("test3@example.com", "Example User3"));
    Subject subject = Subject("Sending with SendGrid is Fun");
    PlainTextContent plainTextContent = new PlainTextContent("and easy to do anywhere, even with Java");
    HtmlContent htmlContent = new HtmlContent("<strong>and easy to do anywhere, even with Java</strong>");
    SendGridMessage email = new SendGridMessage(from,
                                                tos,
                                                subject,
                                                plainTextContent,
                                                htmlContent);

    SendGrid sendgrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    try {
      SendGridResponse response = sendgrid.send(email);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (SendGridException ex) {
      System.err.println(ex);
      throw ex;
    }
  }
}
```

# Send Multiple Emails to Multiple Recipients

The following code assumes you are storing the API key in an environment variable (recommended). 


```java
import com.sendgrid.*;
import com.sendgrid.helpers.mail.*;
import java.util.ArrayList;

public class SendGridExample {
  public static void main(String[] args) throws SendGridException {
    From from = new From("test@example.com", "Example User");
    ArrayList<To> tos = new ArrayList<To>();
    ArrayList<Substitution> sub = new ArrayList<Substitution>();
    sub.add("-name-", "Alain");
    sub.add("-github-", "http://github.com/ninsuo");
    tos.add(new To("test1@example.com", "Example User1"), sub);
    sub.clear();
    sub.add("-name-", "Elmer");
    sub.add("-github-", "http://github.com/thinkingserious");
    tos.add(new To("test2@example.com", "Example User2"), sub);
    sub.clear();
    sub.add("-name-", "Casey");
    sub.add("-github-", "http://github.com/caseyw");
    tos.add(new To("test3@example.com", "Example User3"), sub);
    // Alternatively, you can pass in a collection of subjects OR add a subject to the `To` object
    Subject subject = Subject("Hi -name-!");
    Substitution globalSubstitution = new Substitution("-time-", "<Current Time>");
    PlainTextContent plainTextContent = new PlainTextContent("Hello -name-, your github is -github-, email sent at -time-");
    HtmlContent htmlContent = new HtmlContent("<strong>Hello -name-, your github is <a href=\"-github-\">here</a></strong> email sent at -time-");
    SendGridMessage email = new SendGridMessage(from,
                                                subject, // or subjects,
                                                tos,
                                                plainTextContent,
                                                htmlContent,
                                                globalSubstition); // or globalSubstitutions

    SendGrid sendgrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    try {
      SendGridResponse response = sendgrid.send(email);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (SendGridException ex) {
      System.err.println(ex);
      throw ex;
    }
  }
}
```

# Kitchen Sink - an example with all settings used

The following code assumes you are storing the API key in an environment variable (recommended). 


```java
import com.sendgrid.*;
import com.sendgrid.helpers.mail.*;
import java.util.ArrayList;

public class SendGridExample {
  public static void main(String[] args) throws SendGridException {
    From from = new From("test@example.com", "Example User");
    To to = new To("test@example.com", "Example User");
    Subject subject = Subject("Sending with SendGrid is Fun");
    PlainTextContent plainTextContent = new PlainTextContent("and easy to do anywhere, even with Java");
    HtmlContent htmlContent = new HtmlContent("<strong>and easy to do anywhere, even with Java</strong>");
    SendGridMessage email = new SendGridMessage(from,
                                                to, // or tos
                                                subject, // or subjects
                                                plainTextContent,
                                                htmlContent);

    // For a detailed description of each of these settings, please see the [documentation](https://sendgrid.com/docs/API_Reference/api_v3.html).
    email.addTo("test1@example.com", "Example User1")
    ArrayList<To> tos = new ArrayList<To>();
    tos.add("test2@example.com", "Example User2");
    tos.add("test3@example.com", "Example User3");
    email.addTos(tos);

    email.addCc("test4@example.com", "Example User4")
    ArrayList<Cc> ccs = new ArrayList<Cc>();
    ccs.add("test5@example.com", "Example User5");
    ccs.add("test6@example.com", "Example User6");
    email.addCcs(ccs);

    email.addBcc("test7@example.com", "Example User7")
    ArrayList<Bcc> bccs = new ArrayList<Bcc>();
    bccs.add("test8@example.com", "Example User8");
    bccs.add("test9@example.com", "Example User9");
    email.addBccs(bccs);

    email.addHeader("X-Test1", "Test1");
    email.addHeader("X-Test2", "Test2");
    ArrayList<Header> headers = new ArrayList<Header>();
    headers.add("X-Test3", "Test3");
    headers.add("X-Test4", "Test4");
    email.addHeaders(headers)

    email.addSubstitution("%name1%", "Example Name 1");
    email.addSubstitution("%city1%", "Denver");
    ArrayList<Substitution> substitutions = new ArrayList<Substitution>();
    substitutions.add("%name2%", "Example Name 2");
    substitutions.add("%city2%", "Orange" );
    email.addSubstitutions(substitutions);

    email.addCustomArg("marketing1", "false");
    email.addCustomArg("transactional1", "true");
    ArrayList<CustomArg> customArgs = new ArrayList<CustomArg>();
    customArgs.add("marketing2", "true");
    customArgs.add("transactional2", "false");
    email.addCustomArgs(customArgs);
            
    email.setSendAt(1461775051);

    // If you need to add more [Personalizations](https://sendgrid.com/docs/Classroom/Send/v3_Mail_Send/personalizations.html), here is an example of adding another Personalization by passing in a personalization index


    email.addTo("test10@example.com", "Example User 10", 1);
    ArrayList<To> tos1 = new ArrayList<To>();
    tos1.add("test11@example.com", "Example User11");
    tos1.add("test12@example.com", "Example User12");
    email.addTos(tos1, 1);

    email.addCc("test13@example.com", "Example User 13", 1);
    ArrayList<Cc> ccs1 = new ArrayList<Cc>();
    ccs1.add("test14@example.com", "Example User14");
    ccs1.add("test15@example.com", "Example User15");
    email.addCcs(ccs1, 1);

    email.addBcc("test16@example.com", "Example User 16", 1);
    ArrayList<Bcc> bccs1 = new ArrayList<Bcc>();
    bccs1.add("test17@example.com", "Example User17");
    bccs1.add("test18@example.com", "Example User18");
    email.addBccs(bccs1, 1);

    email.addHeader("X-Test5", "Test5", 1);
    email.addHeader("X-Test6", "Test6", 1);
    ArrayList<Header> headers1 = new ArrayList<Header>();
    headers1.add("X-Test7", "Test7");
    headers1.add("X-Test8", "Test8");
    email.addHeaders(headers1, 1);

    email.addSubstitution("%name3%", "Example Name 3", 1);
    email.addSubstitution("%city3%", "Redwood City", 1);
    ArrayList<Substitution> substitutions1 = new ArrayList<Substitution>();
    substitutions1.add("%name4%", "Example Name 4");
    substitutions1.add("%city4%", "London");
    var substitutions1 = new Dictionary<string, string>()
    email.addSubstitutions(substitutions1, 1);

    email.addCustomArg("marketing3", "true", 1);
    email.addCustomArg("transactional3", "false", 1);
    ArrayList<CustomArg> customArgs1 = new ArrayList<CustomArg>();
    customArgs1.add("marketing4", "false");
    customArgs1.add("transactional4", "true");
    email.addCustomArgs(customArgs1, 1);

    email.setSendAt(1461775052, 1);

    // The values below this comment are global to entire message

    email.setFrom("test@example.com", "Example User 0");

    email.setSubject("this subject overrides the Global Subject");

    email.setGlobalSubject("Sending with SendGrid is Fun");

    email.addContent(MimeType.TEXT, "and easy to do anywhere, even with C#");
    email.addContent(MimeType.HTML, "<strong>and easy to do anywhere, even with C#</strong>");
    ArrayList<Content> contents = new ArrayList<Content>();
    contents.add("text/calendar", "Party Time!!");
    contents.add("text/calendar2", "Party Time2!!");
    email.addContents(contents);

    email.addAttachment("balance_001.pdf",
                        "base64 encoded string",
                        "application/pdf",
                        "attachment",
                        "Balance Sheet");
    ArrayList<Attachment> attachments = new ArrayList<Attachment>();
    attachments.add("banner.png",
                    "base64 encoded string",
                    "image/png",
                    "inline",
                    "Banner");
    attachments.add("banner2.png",
                    "base64 encoded string",
                    "image/png",
                    "inline",
                    "Banner2");
    email.addAttachments(attachments);

    email.setTemplateId("13b8f94f-bcae-4ec6-b752-70d6cb59f932");

    email.addGlobalHeader("X-Day", "Monday");
    ArrayList<Header> globalHeaders = new ArrayList<Header>();
    globalHeaders.add("X-Month", "January" );
    globalHeaders.add("X-Year", "2017");
    email.addGlobalHeaders(globalHeaders);

    email.addSection("%section1", "Substitution for Section 1 Tag");
    ArrayList<Section> sections = new ArrayList<Section>();
    sections.add("%section2%", "Substitution for Section 2 Tag");
    sections.add("%section3%", "Substitution for Section 3 Tag");
    email.addSections(sections);

    email.addCategory("customer");
    ArrayList<Category> categories = new ArrayList<Category>();
    categories.add("vip");
    categories.add("new_account");
    email.addCategories(categories);

    email.addGlobalCustomArg("campaign", "welcome");
    ArrayList<CustomArg> globalCustomArgs = new ArrayList<CustomArg>();
    globalCustomArgs.add("sequence2", "2");
    globalCustomArgs.add("sequence3", "3");
    email.addGlobalCustomArgs(globalCustomArgs);

    ArrayList<int> asmGroups = new ArrayList<int>();
    asmGroups.add(1);
    asmGroups.add(4);
    asmGroups.add(5);
    email.setAsm(3, asmGroups);

    email.setGlobalSendAt(1461775051);

    email.setIpPoolName("23");

    // This must be a valid [batch ID](https://sendgrid.com/docs/API_Reference/SMTP_API/scheduling_parameters.html)
    //email.setBatchId("some_batch_id");

    email.setBccSetting(true, "test@example.com");

    email.setBypassListManagement(true);

    email.setFooterSetting(true, "Some Footer HTML", "Some Footer Text");

    email.setSandBoxMode(true);

    email.setSpamCheck(true, 1, "https://gotchya.example.com");

    email.setClickTracking(true, false);

    email.setOpenTracking(true, "Optional tag to replace with the open image in the body of the message");

    email.setSubscriptionTracking(true,
                                "HTML to insert into the text / html portion of the message",
                                "text to insert into the text/plain portion of the message",
                                "substitution tag");

    email.setGoogleAnalytics(true,
                            "some campaign",
                            "some content",
                            "some medium",
                            "some source",
                            "some term");

    email.setReplyTo("test+reply@example.com", "Reply To Me");   

    SendGrid sendgrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    try {
      SendGridResponse response = sendgrid.send(email);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (SendGridException ex) {
      System.err.println(ex);
      throw ex;
    }
  }
}
```

# Attachments

The following code assumes you are storing the API key in an environment variable (recommended). 

```java
import com.sendgrid.*;
import com.sendgrid.helpers.mail.*;

public class SendGridExample {
  public static void main(String[] args) throws SendGridException {
    From from = new From("test@example.com", "Example User");
    To to = new To("test@example.com", "Example User");
    Subject subject = Subject("Sending with SendGrid is Fun");
    PlainTextContent plainTextContent = new PlainTextContent("and easy to do anywhere, even with Java");
    HtmlContent htmlContent = new HtmlContent("<strong>and easy to do anywhere, even with Java</strong>");
    SendGridMessage email = new SendGridMessage(from,
                                                to,
                                                subject,
                                                plainTextContent,
                                                htmlContent);
    email.addAttachment("balance_001.pdf",
                        "base64 encoded string",
                        "application/pdf",
                        "attachment",
                        "Balance Sheet");

    SendGrid sendgrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    try {
      SendGridResponse response = sendgrid.send(email);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (SendGridException ex) {
      System.err.println(ex);
      throw ex;
    }
  }
}
```

# Transactional Templates

The following code assumes you are storing the API key in an environment variable (recommended). 

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


```java
import com.sendgrid.*;
import com.sendgrid.helpers.mail.*;

public class SendGridExample {
  public static void main(String[] args) throws SendGridException {
    From from = new From("test@example.com", "Example User");
    To to = new To("test@example.com", "Example User");
    Subject subject = Subject("Sending with SendGrid is Fun");
    PlainTextContent plainTextContent = new PlainTextContent("and easy to do anywhere, even with Java");
    HtmlContent htmlContent = new HtmlContent("<strong>and easy to do anywhere, even with Java</strong>");
    SendGridMessage email = new SendGridMessage(from,
                                                to,
                                                subject,
                                                plainTextContent,
                                                htmlContent);
    // See `Send Multiple Emails to Multiple Recipients` for additional methods for adding substitutions
    email.addSubstitution("-name-", "Example User");
    email.addSubstitution("-city-", "Denver");
    email.setTemplateId("13b8f94f-bcae-4ec6-b752-70d6cb59f932");

    SendGrid sendgrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    try {
      SendGridResponse response = sendgrid.send(email);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (SendGridException ex) {
      System.err.println(ex);
      throw ex;
    }
  }
}
```
