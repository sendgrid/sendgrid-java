# SendGrid-Java

This Java module allows you to quickly and easily send emails through SendGrid using Java.

[![BuildStatus](https://travis-ci.org/sendgrid/sendgrid-java.png?branch=master)](https://travis-ci.org/sendgrid/sendgrid-java)

```java
import com.sendgrid.*;
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");

SendGrid.Email email = new SendGrid.Email();
email.addTo("example@example.com");
email.setFrom("other@example.com");
email.setSubject("Hello World");
email.setText("My first email through SendGrid");

try {
  SendGrid.Response response = sendgrid.send(email);
catch (SendGridException e) {
  System.out.println(e);
}
```

## Installation

Choose your installation method - Maven w/ Gradle (recommended) or Jar file.

### via Maven w/ Gradle

Add the following to your build.gradle file in the root of your project.

```groovy
...
dependencies {
  ...
  compile 'com.sendgrid:sendgrid-java:1.0.0'
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

### via jar file

You can just drop the jar file in. It's a fat jar - it has all the dependencies built in.

[sendgrid-java.jar](https://sendgrid-open-source.s3.amazonaws.com/sendgrid-java/sendgrid-java.jar)

```java
import com.sendgrid.*;
```

## Usage

To begin using this library, initialize the SendGrid object with your SendGrid credentials.

```java
import com.sendgrid.SendGrid;
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
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

```java
email.addTo("example@example.com");
// or
email.setTos(["other@other.com"]);
```

### From

```java
email.setFrom("other@example.com");
```

### From Name

```java
email.setFromName("Other Dude");
```

### Reply To

```java
email.setReplyTo("no-reply@nowhere.com");
```

### Subject

```java
email.setSubject("Hello World");
```

### Text

```java
email.setText("This is some text of the email.");
```

### Html

```java
email.setHtml("<h1>My first email through SendGrid");
```

### Attachments

```java
email.addAttachment("text.txt", "contents");
// or
email.addAttachment("image.png", new File("./image.png"));
// or
email.addAttachment("text.txt", new InputStream(new File("./file.txt")));
```

## [X-SMTPAPI](http://sendgrid.com/docs/API_Reference/SMTP_API/index.html)

The mail object extends the SMTPAPI object which is found in [STMAPI-Java](https://github.com/sendgrid/smtpapi-java).

### [Substitutions](http://sendgrid.com/docs/API_Reference/SMTP_API/substitution_tags.html)

```java
header.addSubstitution("key", "value");
// or
header.setSubstitutions("key", ["value1", "value2"]);

JSONObject subs = header.getSubstitutions();
```

### [Unique Arguments](http://sendgrid.com/docs/API_Reference/SMTP_API/unique_arguments.html)

```java
header.addUuniqueAarg("key", "value");
// or
Map map = new HashMap<String, String>();
map.put("unique", "value");
header.setUniqueArgs(map);
// or
JSONObject map = new JSONObject();
map.put("unique", "value");
header.setUniqueArgs(map);

JSONObject args = header.getUniqueArgs();
```
### [Categories](http://sendgrid.com/docs/API_Reference/SMTP_API/categories.html)

```java
header.addCategory("category");
// or
header.addCategory(["categories"]);
// or
header.setCategories(["category1", "category2"]);

String[] cats = header.getCategories();
```

### [Sections](http://sendgrid.com/docs/API_Reference/SMTP_API/section_tags.html)

```java
header.addSection("key", "section");
// or
Map newSec = new HashMap();
newSec.put("-section-", "value");
header.setSections(newSec);
// or
JSONObject newSec = new JSONObject();
newSec.put("-section-", "value");
header.setSections(newSec);

JSONObject sections = header.getSections();
```

### [Filters](http://sendgrid.com/docs/API_Reference/SMTP_API/apps.html)

```java
header.addFilter("filter", "setting", "value");
header.addFilter("filter", "setting", 1);

JSONObject filters = header.getFilters();
```

### Get Headers

```java
String headers = header.jsonString();
```

### Filters/Apps

You can enable and configure Apps.

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.addFilter("bcc", "enabled", 1);
sendgrid.addFilter("bcc", "email", "example@example.com");
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
./gradlew test -i
```

## Generating the jar

```bash
./gradlew build
```

(If you don't have gradle install it. If on a mac, you can run `brew install gradle`) 

## Publishing to Maven

This only works if you have the correct permissions - for admins only basically.

```
./gradlew uploadArchives
```

Login to [Sonatype](https://oss.sonatype.org/index.html#stagingRepositories).

Go to [staging repositories page](https://oss.sonatype.org/index.html#stagingRepositories).

Click 'Close' with the archive selected.

![](https://raw.githubusercontent.com/sendgrid/sendgrid-java/master/maven-help.png)

Wait a few minutes, and refresh the staging repositories page.

Check the box for the SendGrid repo again and this time click 'Release'.

You're all done.

[Further help](https://github.com/sendgrid/sendgrid-java/pull/15).

## Example App

We have an example app using this library. This can be helpful to get a grasp on implementing it in your own app. 

[github.com/scottmotte/sendgrid-java-example](http://github.com/scottmotte/sendgrid-java-example)

## License

Licensed under the MIT License.
