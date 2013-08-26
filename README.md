# sendgrid-java

This Java module allows you to quickly and easily send emails through SendGrid using Java.

```java
import com.github.scottmotte.sendgrid.Sendgrid;

Sendgrid sendgrid = new Sendgrid("sendgrid_username", "sendgrid_password");

sendgrid.setTo("example@example.com");
sendgrid.setFrom("other@example.com");
sendgrid.setSubject("Hello World");
sendgrid.setText("My first email through SendGrid");
sendgrid.setHtml("<h1>My first email through SendGrid</h1>");

sendgrid.send();
```

## Installation

There are a number of ways to add this library to your Java project. I recommend using [Gradle](http://www.gradle.org).

#### via Gradle

Add the following to your build.gradle file in the root of your project.

```groovy
...

repositories {
  mavenCentral()
  add(new org.apache.ivy.plugins.resolver.URLResolver()) {
    name = 'GitHub'
    addArtifactPattern 'https://github.com/scottmotte/sendgrid-java/raw/master/repo/com/github/scottmotte/sendgrid/0.0.1/sendgrid-0.0.1-jar.jar'
  }
}
dependencies {
  ...
  compile 'com.github.scottmotte:sendgrid:0.0.1'
}

...
```

Then import the library - in the file appropriate to your Java project.

```java
import com.github.scottmotte.sendgrid.Sendgrid;
```

#### via copy/paste

Copy and paste the [SendGrid.java](https://github.com/scottmotte/sendgrid-java/blob/master/src/main/java/com/github/scottmotte/sendgrid/Sendgrid.java) file into your project. That file is available here: [https://github.com/scottmotte/sendgrid-java/blob/master/src/main/java/com/github/scottmotte/sendgrid/Sendgrid.java](https://github.com/scottmotte/sendgrid-java/blob/master/src/main/java/com/github/scottmotte/sendgrid/Sendgrid.java)

Then import the library - in the file appropriate to your Java project.

```java
import com.github.scottmotte.sendgrid.Sendgrid;
```

#### via Maven

I'd like to get this on Maven. Please [create an issue](https://github.com/scottmotte/sendgrid-java/issues/new) if you'd like to see it on Maven as well. 

## Usage

## Development

### Generating the jar

```bash
gradle jar
```

(If you don't have gradle install it. If on a mac, you can run `brew install gradle`) 

