[![Travis Badge](https://travis-ci.org/sendgrid/sendgrid-java.svg?branch=master)](https://travis-ci.org/sendgrid/sendgrid-java)
[![Email Notifications Badge](https://dx.sendgrid.com/badge/java)](https://dx.sendgrid.com/newsletter/java)

**NEW:** Subscribe to email [notifications](https://dx.sendgrid.com/newsletter/java) for releases and breaking changes.

**This library allows you to quickly and easily use the SendGrid Web API v3 via Java.**

Version 3.X.X of this library provides full support for all SendGrid [Web API v3](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html) endpoints, including the new [v3 /mail/send](https://sendgrid.com/blog/introducing-v3mailsend-sendgrids-new-mail-endpoint).

This library represents the beginning of a new path for SendGrid. We want this library to be community driven and SendGrid led. We need your help to realize this goal. To help make sure we are building the right things in the right order, we ask that you create [issues](https://github.com/sendgrid/sendgrid-java/issues) and [pull requests](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md) or simply upvote or comment on existing issues or pull requests.

Please browse the rest of this README for further detail.

We appreciate your continued support, thank you!

# Table of Contents

* [Installation](#installation)
* [Quick Start](#quick_start)
* [Usage](#usage)
* [Use Cases](#use_cases)
* [Announcements](#announcements)
* [Roadmap](#roadmap)
* [How to Contribute](#contribute)
* [Troubleshooting](#troubleshooting)
* [About](#about)

<a name="installation"></a>
# Installation

## Prerequisites

- Java version Oracle JDK 7, 8 or OpenJDK 7
- The SendGrid service, starting at the [free level](https://sendgrid.com/free?source=sendgrid-java)

## Setup Environment Variables

Update the development environment with your [SENDGRID_API_KEY](https://app.sendgrid.com/settings/api_keys), for example:

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
  compile 'com.sendgrid:sendgrid-java:4.1.0'
}

repositories {
  mavenCentral()
}
...
```

### via Maven

```
mvn install
```

### via jar file

You can just drop the jar file in. It's a fat jar - it has all the dependencies built in.

[sendgrid-java-latest.jar](http://dx.sendgrid.com/downloads/sendgrid-java/sendgrid-java-latest.jar)

## Dependencies

- [Java-HTTP-Client](https://github.com/sendgrid/java-http-client)

<a name="quick_start"></a>
# Quick Start

## Hello Email

The following is the minimum needed code to send an email with the [/mail/send Helper](https://github.com/sendgrid/sendgrid-java/tree/master/src/main/java/com/sendgrid/helpers) ([here](https://github.com/sendgrid/sendgrid-java/blob/master/examples/helpers/mail/Example.java#L30) is a full example):

### With Mail Helper Class

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    Email from = new Email("test@example.com");
    String subject = "Sending with SendGrid is Fun";
    Email to = new Email("test@example.com");
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
      throw ex;
    }
  }
}
```

The `Mail` constructor creates a [personalization object](https://sendgrid.com/docs/Classroom/Send/v3_Mail_Send/personalizations.html) for you. [Here](https://github.com/sendgrid/sendgrid-java/blob/master/examples/helpers/mail/Example.java#L221) is an example of how to add to it.

### Without Mail Helper Class

The following is the minimum needed code to send an email without the /mail/send Helper ([here](https://github.com/sendgrid/sendgrid-java/blob/master/examples/mail/mail.java#L54) is a full example):

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
      request.setBody("{\"personalizations\":[{\"to\":[{\"email\":\"test@example.com\"}],\"subject\":\"Sending with SendGrid is Fun\"}],\"from\":{\"email\":\"test@example.com\"},\"content\":[{\"type\":\"text/plain\",\"value\": \"and easy to do anywhere, even with Java\"}]}");
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

## General v3 Web API Usage

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    try {
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("api_keys");
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

<a name="usage"></a>
# Usage

- [SendGrid Docs](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html)
- [Library Usage Docs](https://github.com/sendgrid/sendgrid-java/tree/master/USAGE.md)
- [Example Code](https://github.com/sendgrid/sendgrid-java/tree/master/examples)
- [How-to: Migration from v2 to v3](https://sendgrid.com/docs/Classroom/Send/v3_Mail_Send/how_to_migrate_from_v2_to_v3_mail_send.html)
- [v3 Web API Mail Send Helper](https://github.com/sendgrid/sendgrid-java/tree/master/src/main/java/com/sendgrid/helpers) - build a request object payload for a v3 /mail/send API call.


<a name="use_cases"></a>
# Use Cases

[Examples of common API use cases](https://github.com/sendgrid/sendgrid-java/blob/master/USE_CASES.md), such as how to send an email with a transactional template.

<a name="announcements"></a>
# Announcements

Please see our announcement regarding [breaking changes](https://github.com/sendgrid/sendgrid-java/issues/140). Your support is appreciated!

All updates to this library are documented in our [CHANGELOG](https://github.com/sendgrid/sendgrid-java/blob/master/CHANGELOG.md) and [releases](https://github.com/sendgrid/sendgrid-java/releases). You may also subscribe to email [release notifications](https://dx.sendgrid.com/newsletter/java) for releases and breaking changes.

<a name="roadmap"></a>
# Roadmap

If you are interested in the future direction of this project, please take a look at our open [issues](https://github.com/sendgrid/sendgrid-java/issues) and [pull requests](https://github.com/sendgrid/sendgrid-java/pulls). We would love to hear your feedback.

<a name="contribute"></a>
# How to Contribute

We encourage contribution to our libraries (you might even score some nifty swag), please see our [CONTRIBUTING](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md) guide for details.

Quick links:

- [Feature Request](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#feature_request)
- [Bug Reports](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#submit_a_bug_report)
- [Sign the CLA to Create a Pull Request](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#cla)
- [Improvements to the Codebase](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#improvements_to_the_codebase)

<a name="troubleshooting"></a>
# Troubleshooting

Please see our [troubleshooting guide](https://github.com/sendgrid/sendgrid-java/blob/master/TROUBLESHOOTING.md) for common library issues.

<a name="about"></a>
# About

sendgrid-java is guided and supported by the SendGrid [Developer Experience Team](mailto:dx@sendgrid.com).

sendgrid-java is maintained and funded by SendGrid, Inc. The names and logos for sendgrid-java are trademarks of SendGrid, Inc.

![SendGrid Logo](https://uiux.s3.amazonaws.com/2016-logos/email-logo%402x.png)
