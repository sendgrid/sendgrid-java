# SendGrid-Java

This Java module allows you to quickly and easily send emails through SendGrid using Java.

```java
import com.sendgrid.*;
SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");

Mail mail = new Mail();
mail.addTo("example@example.com");
mail.setFrom("other@example.com");
mail.setSubject("Hello World");
mail.setText("My first email through SendGrid");

sendgrid.send(mail);
```

## Installation

There are multiple ways to install this library. I recommend using Maven w/ Gradle.

### via Maven w/ Gradle

Add the following to your build.gradle file in the root of your project.

```groovy
...
dependencies {
  ...
  compile 'com.sendgrid:sendgrid-java:0.2.0'
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

[sendgrid-0.2.0-jar.jar](https://github.com/sendgrid/sendgrid-java/blob/master/repo/com/github/sendgrid/0.2.0/sendgrid-0.2.0-jar.jar?raw=true)

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
Mail mail = new Mail();
mail.addTo("example@example.com");
mail.addToName("Example Guy");
mail.setFrom("other@example.com");
mail.setSubject("Hello World");
mail.setText("My first email through SendGrid");
```

Send it.

```java
sendgrid.send(mail);
```

### To

```java
mail.addTo("example@example.com");
// or
mail.addTos(["other@other.com"]);
// or
mail.setTos(["other@other.com"]);
```

### To Name

```java
mail.addToName("Example Guy");
// or
mail.addToNames(["Other Gal"]);
//or
mail.setToNames(["Other Gal"]);
```

### Bcc

```java
mail.addBcc("yourself@yourself.com");
// or
mail.addBccs(["yourself@yourself.com"]);
// or
mail.setBccs([]"yourself@yourself.com"]);
```


### From

```java
mail.setFrom("other@example.com");
```

### From Name

```java
mail.setFromName("Other Dude");
```

### Reply To

```java
mail.setReplyTo("no-reply@nowhere.com");
```

### Subject

```java
mail.setSubject("Hello World");
```

### Text

```java
mail.setText("This is some text of the email.");
```

### Html

```java
mail.setHtml("<h1>My first email through SendGrid");
```

### Attachments

```java
mail.addAttachment("contents", "text.txt");
// or
mail.addAttachment(new File("./file.txt"), "text.txt");
// or
mail.addAttachment(new InputStream(new File("./file.txt")), "text.txt");
```

## [X-SMTPAPI](http://sendgrid.com/docs/API_Reference/SMTP_API/index.html)

The mail object extends de SMTPAPI object which is found in [STMAPI-Java](https://github.com/sendgrid/smtpapi-java).

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
gradle build
```

## Generating the jar

```bash
gradle build
```

(If you don't have gradle install it. If on a mac, you can run `brew install gradle`) 

## Publishing to Maven

This only works if you have the correct permissions - for admins only basically.

```
gradle uploadArchives
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

We have an example app using this library. This can be helpful to get a grasp on implementing it in your own app. The example below is a [spring](http://www.springsource.org/spring-framework) based application.

[github.com/scottmotte/spring-attack](http://github.com/scottmotte/spring-attack)

## License

Licensed under the MIT License.
