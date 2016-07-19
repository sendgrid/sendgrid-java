[![Travis Badge](https://travis-ci.org/sendgrid/sendgrid-java.svg?branch=master)](https://travis-ci.org/sendgrid/sendgrid-java) [![BuildStatus](https://maven-badges.herokuapp.com/maven-central/com.sendgrid/sendgrid-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.sendgrid/sendgrid-java)

**This library allows you to quickly and easily use the SendGrid Web API via Java.**

# Announcements

**BREAKING CHANGE as of 2016.06.14**

Version `3.X.X` is a breaking change for the entire library.

Version 3.X.X brings you full support for all Web API v3 endpoints. We
have the following resources to get you started quickly:

-   [SendGrid
    Documentation](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html)
-   [Usage
    Documentation](https://github.com/sendgrid/sendgrid-java/tree/master/USAGE.md)
-   [Example
    Code](https://github.com/sendgrid/sendgrid-java/tree/master/examples)
-   [Migration from v2 to v3](https://sendgrid.com/docs/Classroom/Send/v3_Mail_Send/how_to_migrate_from_v2_to_v3_mail_send.html)

Thank you for your continued support!

All updates to this library is documented in our [CHANGELOG](https://github.com/sendgrid/sendgrid-java/blob/master/CHANGELOG.md).

# Installation

## Setup Environment Variables

First, get your free SendGrid account [here](https://sendgrid.com/free?source=sendgrid-java).

Next, update your environment with your [SENDGRID_API_KEY](https://app.sendgrid.com/settings/api_keys).

```bash
echo "export SENDGRID_API_KEY='YOUR_API_KEY'" > sendgrid.env
echo "sendgrid.env" >> .gitignore
source ./sendgrid.env
```
## Install Package

Choose your installation method - Maven w/ Gradle (recommended), Maven or Jar file.

### via Maven w/ Gradle

Add the following to your build.gradle file in the root of your project.

```groovy
...
dependencies {
  ...
  compile 'com.sendgrid:sendgrid-java:3.0.4'
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

[sendgrid-java.jar](http://repo1.maven.org/maven2/com/sendgrid/sendgrid-java/3.0.4/sendgrid-java-3.0.4-jar.jar)

```java
import com.sendgrid.*;
```

## Dependencies

- The SendGrid Service, starting at the [free level](https://sendgrid.com/free?source=sendgrid-java)
- [Java-HTTP-Client](https://github.com/sendgrid/java-http-client)

# Quick Start

## Hello Email

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    Email from = new Email("test@example.com");
    String subject = "Hello World from the SendGrid Java Library";
    Email to = new Email("test@example.com");
    Content content = new Content("text/plain", "some text here");
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    try {
      request.method = Method.POST;
      request.endpoint = "mail/send";
      request.body = mail.build();
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}
```

## General v3 Web API Usage

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    try {
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "api_keys";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}
```

# Usage

- [SendGrid Docs](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html)
- [Usage Docs](https://github.com/sendgrid/sendgrid-java/tree/master/USAGE.md)
- [Example Code](https://github.com/sendgrid/sendgrid-java/tree/master/examples)

## Roadmap

If you are intersted in the future direction of this project, please take a look at our [milestones](https://github.com/sendgrid/sendgrid-java/milestones). We would love to hear your feedback.

## How to Contribute

We encourage contribution to our libraries, please see our [CONTRIBUTING](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md) guide for details.

Quick links:

- [Feature Request](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#feature_request)
- [Bug Reports](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#submit_a_bug_report)
- [Sign the CLA to Create a Pull Request](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#cla)
- [Improvements to the Codebase](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#improvements_to_the_codebase)

# About

sendgrid-java is guided and supported by the SendGrid [Developer Experience Team](mailto:dx@sendgrid.com).

sendgrid-java is maintained and funded by SendGrid, Inc. The names and logos for sendgrid-java are trademarks of SendGrid, Inc.

![SendGrid Logo]
(https://uiux.s3.amazonaws.com/2016-logos/email-logo%402x.png)
