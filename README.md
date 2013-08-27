# sendgrid-java

This Java module allows you to quickly and easily send emails through SendGrid using Java.

```java
import com.github.scottmotte.sendgrid.SendGrid;
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");

sendgrid.addTo("example@example.com");
sendgrid.setFrom("other@example.com");
sendgrid.setSubject("Hello World");
sendgrid.setText("My first email through SendGrid");

sendgrid.send();
```

## Installation

There are multiple ways to install this library. I recommend using [Gradle](http://www.gradle.org).

### via Gradle (recommended)

Add the following to your build.gradle file in the root of your project.

```groovy
...

repositories {
  mavenCentral()
  add(new org.apache.ivy.plugins.resolver.URLResolver()) {
    name = 'GitHub'
    addArtifactPattern 'https://github.com/scottmotte/sendgrid-java/raw/v[revision]/repo/com/github/scottmotte/sendgrid/[revision]/sendgrid-[revision]-jar.jar'
  }
}
dependencies {
  ...
  compile 'com.github.scottmotte:sendgrid:0.0.3'
}

...
```

Then import the library - in the file appropriate to your Java project.

```java
import com.github.scottmotte.sendgrid.SendGrid;
```

### via copy/paste

Copy and paste the [SendGrid.java](https://github.com/scottmotte/sendgrid-java/blob/master/src/main/java/com/github/scottmotte/sendgrid/SendGrid.java) file into your project. That file is available here: [https://github.com/scottmotte/sendgrid-java/blob/master/src/main/java/com/github/scottmotte/sendgrid/SendGrid.java](https://github.com/scottmotte/sendgrid-java/blob/master/src/main/java/com/github/scottmotte/sendgrid/SendGrid.java)

Then import the library - in the file appropriate to your Java project.

```java
import com.github.scottmotte.sendgrid.SendGrid;
```

### via Maven

I'd like to get this on Maven. Please [create an issue](https://github.com/scottmotte/sendgrid-java/issues/new) if you'd like to see it on Maven as well. 

## Usage

To begin using this library, initialize the SendGrid object with your SendGrid credentials.

```java
import com.github.scottmotte.sendgrid.SendGrid;
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
```

Add your message details.

```java
sendgrid.addTo("example@example.com");
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

### From

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.setFrom("other@example.com");
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
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.addFile(new File("../path/to/file.txt");
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

### Headers

Headers can be used to add existing SendGrid functionality (like categories or filters) or your own custom headers.

```java
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");
sendgrid.addTo("example@example.com");
...
sendgrid.addHeader("category", "My New Category");
```

If you still absolutely need to use Bcc, you can use `sendgrid.addBcc("email@somewhere.com")`;

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


## License

Licensed under the MIT License.
