# SendGrid-Java

This Java module allows you to quickly and easily send emails through SendGrid using Java.

[![BuildStatus](https://travis-ci.org/sendgrid/sendgrid-java.svg?branch=master)](https://travis-ci.org/sendgrid/sendgrid-java)
[![BuildStatus](https://maven-badges.herokuapp.com/maven-central/com.sendgrid/sendgrid-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.sendgrid/sendgrid-java)

### Warning

Version ``2.x.x``, behaves differently in the ``addTo`` method. In the past this method defaulted to using the ``SMTPAPI`` header. Now you must explicitly call the ``addSmtpApiTo`` method. More on the ``SMTPAPI`` section.

```java
// SendGridExample.java
import com.sendgrid.*;

public class SendGridExample {
  public static void main(String[] args) {
    SendGrid sendgrid = new SendGrid("SENDGRID USERNAME", "SENDGRID_PASSWORD");

    SendGrid.Email email = new SendGrid.Email();
    email.addTo("example@example.com");
    email.setFrom("other@example.com");
    email.setSubject("Hello World");
    email.setText("My first email with SendGrid Java!");

    try {
      SendGrid.Response response = sendgrid.send(email);
      System.out.println(response.getMessage());
    }
    catch (SendGridException e) {
      System.err.println(e);
    }
  }
}
```
Compile and run this example with

```bash
$ javac -classpath sendgrid-2.2.1-jar.jar:. SendGridExample.java && java -classpath sendgrid-2.2.1-jar.jar:. SendGridExample
```

## Installation

Choose your installation method - Maven w/ Gradle (recommended), Maven or Jar file.

### via Maven w/ Gradle

Add the following to your build.gradle file in the root of your project.

```groovy
...
dependencies {
  ...
  compile 'com.sendgrid:sendgrid-java:2.2.1'
}

repositories {
  mavenCentral()
}
...
```

Then import the library - in the file appropriate to your Java project.

```java
import com.sendgrid.SendGrid;
```

### via Maven

```
mvn install
```

### via jar file

You can just drop the jar file in. It's a fat jar - it has all the dependencies built in.

[sendgrid-java.jar](https://sendgrid-open-source.s3.amazonaws.com/sendgrid-java/sendgrid-java.jar)

```java
import com.sendgrid.*;
```

## Usage

To begin using this library, initialize the SendGrid object with your SendGrid credentials OR a SendGrid API Key. API Key is the preferred method. API Keys are in beta. To configure API keys, visit https://sendgrid.com/beta/settings/api_keys.

```java
import com.sendgrid.SendGrid;
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
// or
SendGrid sendgrid = new SendGrid("sendgrid_api_key");
```

Add your message details.

```java
Email email = new Email();
email.addTo("example@example.com");
email.addToName("Example Guy");
email.setFrom("other@example.com");
email.setSubject("Hello World");
email.setText("My first email through SendGrid");
```

Send it.

```java
sendgrid.send(email);
```

### To

#### addTo

```java
email.addTo("foo@example.com");
// or
email.addTo(new String[]{"foo@other.com", "bar@other.com"});
// or
email.addTo("foo.bar@other.com", "Foo Bar");
```

#### setTo

```java
email.setTo(new String[]{"foo@other.com", "bar@other.com"});
```

#### addToName

```java
email.addToName("Foo");
// or
email.addToName(new String[]{"Foo", "Bar"});
```

#### setToName

```java
email.setToName(new String[]{"Foo", "Bar"});
```

#### addCc

```java
email.addCc("foo@example.com");
// or
email.addCc(new String[]{"foo@other.com", "bar@other.com"});
```

#### setCc

```java
email.setCc(new String[]{"foo@other.com", "bar@other.com"});
```

#### addBcc

```java
email.addBcc("foo@example.com");
// or
email.addBcc(new String[]{"foo@other.com", "bar@other.com"});
```

#### setBcc

```java
email.setBcc(new String[]{"foo@other.com", "bar@other.com"});
```

### From

#### setFrom

```java
email.setFrom("other@example.com");
```

#### setFromName

```java
email.setFromName("Other Dude");
```

#### setReplyTo

```java
email.setReplyTo("no-reply@nowhere.com");
```

#### setSubject

```java
email.setSubject("Hello World");
```

#### setText

```java
email.setText("This is some text of the email.");
```

#### setHtml

```java
email.setHtml("<h1>My first email through SendGrid");
```

### Attachments

#### addAttachment

```java
email.addAttachment("text.txt", "contents");
// or
email.addAttachment("image.png", new File("./image.png"));
// or
email.addAttachment("text.txt", new InputStream(new File("./file.txt")));
```

### Content IDs

#### addContentId

```java
// First, add an attachment
email.addAttachment("image.png", new File("./image.png"));
// Map the name of the attachment to an ID
email.addContentId("image.png", "ID_IN_HTML")
// Map the ID in the HTML
email.setHtml("<html><body>TEXT BEFORE IMAGE<img src=\"cid:ID_IN_HTML\"></img>AFTER IMAGE</body></html>")
```

### Proxy Server Setup

```java
SendGrid sendgrid = new SendGrid("SENDGRID USERNAME", "SENDGRID_PASSWORD");
HttpHost proxy = new HttpHost("server", 3128);
CloseableHttpClient http = HttpClientBuilder.create().setProxy(proxy).setUserAgent("sendgrid/" + sendgrid.getVersion() + ";java").build();
sendgrid.setClient(http);
```

## [X-SMTPAPI](http://sendgrid.com/docs/API_Reference/SMTP_API/index.html)

The mail object extends the SMTPAPI object which is found in [SMTPAPI-Java](https://github.com/sendgrid/smtpapi-java).

```java
email.getSMTPAPI();
```

### Recipients

#### addSmtpApiTo

```java
email.addSmtpApiTo("foo@example.com");
// or
email.addSmtpApiTo(new String[]{"foo@other.com", "bar@other.com"});
```

### [Substitutions](http://sendgrid.com/docs/API_Reference/SMTP_API/substitution_tags.html)

#### addSubstitution

```java
email.addSubstitution("key", "value");

JSONObject subs = header.getSubstitutions();
```

#### addSubstitutions

```java
email.addSubstititions("key", new String[]{"value1", "value2"});

JSONObject subs = header.getSubstititons();
```

#### setSubstitutions

```java
email.setSubstitutions(new JSONObject("JSON Object"));

JSONObject subs = header.getSubstitutions();
```

### [Unique Arguments](http://sendgrid.com/docs/API_Reference/SMTP_API/unique_arguments.html)

#### addUniqueAarg

```java
email.addUniqueAarg("key", "value");
// or
Map map = new HashMap<String, String>();
map.put("unique", "value");
email.setUniqueArgs(map);
// or
JSONObject map = new JSONObject();
map.put("unique", "value");
email.setUniqueArgs(map);
// or
email.setUniqueArgs(map);

JSONObject args = email.getUniqueArgs();
```

### [Categories](http://sendgrid.com/docs/API_Reference/SMTP_API/categories.html)

#### addCategory

```java
email.addCategory("category");

String[] cats = email.getCategories();
```

### [Sections](http://sendgrid.com/docs/API_Reference/SMTP_API/section_tags.html)

#### addSection

```java
email.addSection("key", "section");

JSONObject sections = email.getSections();
```

### [Filters / Apps](http://sendgrid.com/docs/API_Reference/SMTP_API/apps.html)

You can enable and configure Apps.

#### addFilter

```java
email.addFilter("filter", "setting", "value");
email.addFilter("filter", "setting", 1);

JSONObject filters = email.getFilters();
```

Example enabling bcc app:

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.addFilter("bcc", "enabled", 1);
sendgrid.addFilter("bcc", "email", "example@example.com");
```

### [ASM - Advanced Supression Manager](https://sendgrid.com/docs/User_Guide/advanced_suppression_manager.html)

#### setASMGroupId

```java
email.setASMGroupId(1);
```

### [Schedule Sending](https://sendgrid.com/docs/API_Reference/SMTP_API/scheduling_parameters.html)

#### setSendAt

```java
email.setSendAt(1409348513);
```

### [Templates](https://sendgrid.com/docs/API_Reference/Web_API_v3/Template_Engine/index.html)

#### setTemplateId

```java
email.setTemplateId("abc123-def456");
```

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request

## Running Tests

The existing tests in the `src/test` directory can be run using gradle with the following command:

```bash
$ ./gradlew test -i
```

## Generating the jar

```bash
$ ./gradlew build
```

## Example App

We have an example app using this library. This can be helpful to get a grasp on implementing it in your own app.

[github.com/scottmotte/sendgrid-java-example](http://github.com/scottmotte/sendgrid-java-example)

## License

Licensed under the MIT License.
