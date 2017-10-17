This documentation provides examples for specific use cases. Please [open an issue](https://github.com/sendgrid/sendgrid-java/issues) or make a pull request for any use cases you would like us to document here. Thank you!

# Table of Contents

* [Transactional Templates](#transactional_templates)
* [Deploy a simple Hello Email app on Heroku](#hello_email_on_heroku)

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

<a name="hello_email_on_heroku"></a>
# Deploy a simple Hello Email app on Heroku

This tutorial explains how to set up a simple "Hello Email" app on Heroku with SendGrid Java SDK.

## Prepare Java Getting Started

"[Getting Started on Heroku with Java](https://devcenter.heroku.com/articles/getting-started-with-java)" is the best document to develop a first Heroku app. The document uses "[java-getting-started](https://github.com/heroku/java-getting-started)" app based on [Spring Boot](https://projects.spring.io/spring-boot/). This app is useful to develop a simple "Hello Email" app.

Please check [the introduction](https://devcenter.heroku.com/articles/getting-started-with-java#introduction) what you need and [set up Herok CLI](https://devcenter.heroku.com/articles/getting-started-with-java#set-up) to run tutorial.

So, let's clone "[java-getting-started](https://github.com/heroku/java-getting-started)" from GitHub.

```sh
$ git clone https://github.com/heroku/java-getting-started.git
```

Run the app on your local enverionment.

```sh
$ cd java-getting-started
$ mvn install
$ heroku local web
```

You can access the index page on [localhost:5000](http://localhost:5000/).

## Edit Code

Add the SendGrid Java SDK dependency to [pom.xml](https://github.com/heroku/java-getting-started/blob/master/pom.xml) in "[java-getting-started](https://github.com/heroku/java-getting-started)".

```xml
<dependency>
    <groupId>com.sendgrid</groupId>
    <artifactId>sendgrid-java</artifactId>
    <version>LATEST</version>
</dependency>
```

In [Main.java](https://github.com/heroku/java-getting-started/blob/master/src/main/java/com/example/Main.java), you can see the following method.

```java
@RequestMapping("/")
String index() {
  return "index";
}
```

The easiest way to write "Hello Email" is adding the code like following. Of course, please change the email address "from" and "to" to your appropriate one.

```java
@RequestMapping("/")
String index() {
    Email from = new Email("from@example.com");
    String subject = "Sending with SendGrid is Fun";
    Email to = new Email("to@example.com");
    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
    Mail mail = new Mail(from, subject, to, content);

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
    }

    return "index";
  }
```

Add and commit to your local repo.

```sh
$ git add *
$ git commit -m "Add Hello Email with SendGrid".
```

You can run this code on your local environment. But you need to set up the environment variable "SENDGRID_API_KEY". The cloned project includes .env file, you can add the variable. See also [the document how to setup it](https://github.com/sendgrid/sendgrid-java#setup-environment-variables).

```txt
ENERGY=20 GeV
SENDGRID_API_KEY=xxxxx
```

Run app again and access the top page. If you can receive the email, it works fine.

## Deploy to Heroku

Before deploy the "Hello Email" app, create an app on Heroku.

```sh
$ heroku create
```

Next, add to "SENDGRID_API_KEY" environment variable to your Heroku app.

```sh
$ heroku config:set SENDGRID_API_KEY=xxxxx
```

Push the local repo to remote. Delopy is done.

```sh
$ git push heroku master
```

Finally, you can see your "Hello Email" app on Heroku the same as your local.

```sh
$ heroku open
```

Check your email!