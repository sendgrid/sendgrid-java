# sendgrid-java

This Java module allows you to quickly and easily send emails through SendGrid using Java.

```java
import com.github.sendgrid.SendGrid;
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");

sendgrid.addTo("example@example.com");
sendgrid.setFrom("other@example.com");
sendgrid.setSubject("Hello World");
sendgrid.setText("My first email through SendGrid");

sendgrid.send();
```

## Installation

There are multiple ways to install this library. I recommend using Maven w/ Gradle. 

### via Maven w/ Gradle

Add the following to your build.gradle file in the root of your project.

```groovy
...
dependencies {
  ...
  compile 'com.sendgrid:sendgrid-java:0.1.2'
}

repositories {
  mavenCentral()
}
...
```

Then import the library - in the file appropriate to your Java project.

```java
import com.github.sendgrid.SendGrid;
```

### via jar file

You can just drop the jar file in. It's a fat jar - it has all the dependencies built in.

[sendgrid-0.1.2-jar.jar](https://github.com/sendgrid/sendgrid-java/blob/master/repo/com/github/sendgrid/0.1.2/sendgrid-0.1.2-jar.jar?raw=true)

### via copy/paste

#### Include the SendGrid.java library

Copy and paste the [SendGrid.java](https://github.com/sendgrid/sendgrid-java/blob/master/src/main/java/com/github/sendgrid/SendGrid.java) file into your project. That file is available here: [https://github.com/sendgrid/sendgrid-java/blob/master/src/main/java/com/github/sendgrid/SendGrid.java](https://github.com/sendgrid/sendgrid-java/blob/master/src/main/java/com/github/sendgrid/SendGrid.java)

Then import the library - in the file appropriate to your Java project.

```java
import com.github.sendgrid.SendGrid;
```

#### Include the required dependencies

* You need to include the [http-request library from kevinsawicki](https://github.com/kevinsawicki/http-request).
* You need to include the [json library from chargebee](http://maven-repository.com/artifact/org.json/org.json/chargebee-1.0)

## Example App

There is a [sendgrid-java-example app](https://github.com/scottmotte/sendgrid-java-example) to help jumpstart your development.

## Usage

To begin using this library, initialize the SendGrid object with your SendGrid credentials.

```java
import com.github.sendgrid.SendGrid;
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
```

Add your message details.

```java
sendgrid.addTo("example@example.com");
sendgrid.addToName("Example Guy");
sendgrid.setFrom("other@example.com");
sendgrid.setSubject("Hello World");
sendgrid.setText("My first email through SendGrid");
```

Send it.

```java
sendgrid.send();
```

### To

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
sendgrid.addTo("other@other.com");
```

You can add multiple `to`s as necessary. She will get the email as if it was sent solely to her.

### To Name

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
sendgrid.addToName("Example Guy");
sendgrid.addTo("other@other.com");
sendgrid.addToName("Other Gal");
```

You can add multiple `toname`s as necessary. They should be set in the same array order as the emails. 

### From

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.setFrom("other@example.com");
```

### From Name

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.setFrom("other@example.com");
sendgrid.setFromName("Other Dude");
```

### Reply To 

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.setReplyTo("no-reply@nowhere.com");
```

### Subject

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.setSubject("Hello World");
```

### Text

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.setText("This is some text of the email.");
```

### Html

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.setHtml(<h1>My first email through SendGrid");
```

### Attachments

```java
import java.io.File;
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.addFile(new File("../path/to/file.txt"));
```

If you need to add files from an InputStream (maybe you're on Google App Engine and have the contents in a byte array), here is how.

```java
import java.io.ByteArrayInputStream;
 
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
byte[] contents = somehowGenerateAttachmentContents();

SendGrid.Attachment attachment1 = new SendGrid.Attachment("filename.txt", new ByteArrayInputStream(contents));
sendgrid.addFile(attachment1);

sendgrid.send();
```

### Bcc

Use multiple `addTo`s as a superior alternative to `setBcc`.

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
sendgrid.addTo("other@other.com");
sendgrid.addTo("yourself@yourself.com");
...
```

If you still absolutely need to use Bcc, you can use `sendgrid.addBcc("email@somewhere.com")`;

### Categories

Add up to 10 categories to the object.

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.addCategory("sample_email");
sendgrid.addCategory("dev_test");
```

### Headers

You can add custom headers.

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.addHeader("X-Sent-Using", "SendGrid-API");
sendgrid.addHeader("X-Transport", "web");
```

To add SendGrid style headers for things such as categories or filters, do the following.

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.addHeader("X-SMTPAPI", "{\"category\":\"My New Category\"}");
```

### Filters/Apps

You can enable and configure Apps.

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.addFilter("bcc", "enable", 1);
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
gradle build
```

## Generating the jar

```bash
gradle build
```

(If you don't have gradle install it. If on a mac, you can run `brew install gradle`) 

## Example App

We have an example app using this library. This can be helpful to get a grasp on implementing it in your own app. The example below is a [spring](http://www.springsource.org/spring-framework) based application.

[github.com/scottmotte/spring-attack](http://github.com/scottmotte/spring-attack)

## License

Licensed under the MIT License.
