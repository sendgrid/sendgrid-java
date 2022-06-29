![SendGrid Logo](twilio_sendgrid_logo.png)

[![BuildStatus](https://github.com/sendgrid/sendgrid-java/actions/workflows/test-and-deploy.yml/badge.svg)](https://github.com/sendgrid/sendgrid-java/actions/workflows/test-and-deploy.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.sendgrid/sendgrid-java.svg)](http://mvnrepository.com/artifact/com.sendgrid/sendgrid-java)
[![Twitter Follow](https://img.shields.io/twitter/follow/sendgrid.svg?style=social&label=Follow)](https://twitter.com/sendgrid)
[![GitHub contributors](https://img.shields.io/github/contributors/sendgrid/sendgrid-java.svg)](https://github.com/sendgrid/sendgrid-java/graphs/contributors)
[![Open Source Helpers](https://www.codetriage.com/sendgrid/sendgrid-java/badges/users.svg)](https://www.codetriage.com/sendgrid/sendgrid-java)
[![MIT licensed](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

**This library allows you to quickly and easily use the Twilio SendGrid Web API v3 via Java.**

Version 3.X.X of this library provides full support for all Twilio SendGrid [Web API v3](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html) endpoints, including the new [v3 /mail/send](https://sendgrid.com/blog/introducing-v3mailsend-sendgrids-new-mail-endpoint).

This library represents the beginning of a new path for Twilio SendGrid. We want this library to be community driven and Twilio SendGrid led. We need your help to realize this goal. To help make sure we are building the right things in the right order, we ask that you create [issues](https://github.com/sendgrid/sendgrid-java/issues) and [pull requests](CONTRIBUTING.md) or simply upvote or comment on existing issues or pull requests.

**If you need help using SendGrid, please check the [Twilio SendGrid Support Help Center](https://support.sendgrid.com).**

# Table of Contents

* [Installation](#installation)
* [Quick Start](#quick-start)
* [Usage](#usage)
* [Use Cases](#use-cases)
* [Announcements](#announcements)
* [How to Contribute](#contribute)
* [Troubleshooting](#troubleshooting)
* [About](#about)
* [Support](#support)
* [License](#license)

<a name="installation"></a>
# Installation

## Prerequisites

- Java 8 or 11
- The Twilio SendGrid service, starting at the [free level](https://sendgrid.com/free?source=sendgrid-java) to send up to 40,000 emails for the first 30 days, then send 100 emails/day free forever or check out [our pricing](https://sendgrid.com/pricing?source=sendgrid-java).

## Setup Environment Variables

Update the development environment with your [SENDGRID_API_KEY](https://app.sendgrid.com/settings/api_keys), for example:

1. Copy the sample environment file to a new file
```bash
cp .env_sample .env
```
2. Edit the new `.env` to add your API key
3. Source the `.env` file to set the variable in the current session
```bash
source .env
```

## Install Package

Choose your installation method - Maven w/ Gradle (recommended), Maven or Jar file.

### via Maven w/ Gradle

Add the following to your build.gradle file in the root of your project.

```groovy
...
dependencies {
  ...
  implementation 'com.sendgrid:sendgrid-java:4.9.3'
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

[sendgrid-java.jar](https://github.com/sendgrid/sendgrid-java/releases/download/4.9.3/sendgrid-java.jar)

## Dependencies

- [Java-HTTP-Client](https://github.com/sendgrid/java-http-client)

<a name="quick-start"></a>
# Quick Start

## Hello Email

The following is the minimum needed code to send an email with the [/mail/send Helper](src/main/java/com/sendgrid/helpers) ([here](examples/helpers/mail/Example.java#L30) is a full example):

### With Mail Helper Class

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    Email from = new Email("test@example.com");
    String subject = "Sending with Twilio SendGrid is Fun";
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

The `Mail` constructor creates a [personalization object](https://sendgrid.com/docs/Classroom/Send/v3_Mail_Send/personalizations.html) for you. [Here](examples/helpers/mail/Example.java#L221) is an example of how to add to it.

### Without Mail Helper Class

The following is the minimum needed code to send an email without the /mail/send Helper ([here](examples/mail/mail.java#L54) is a full example):

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
      request.setBody("{\"personalizations\":[{\"to\":[{\"email\":\"test@example.com\"}],\"subject\":\"Sending with Twilio SendGrid is Fun\"}],\"from\":{\"email\":\"test@example.com\"},\"content\":[{\"type\":\"text/plain\",\"value\": \"and easy to do anywhere, even with Java\"}]}");
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

- [Twilio SendGrid Docs](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html)
- [Library Usage Docs](USAGE.md)
- [Example Code](examples)
- [How-to: Migration from v2 to v3](https://sendgrid.com/docs/Classroom/Send/v3_Mail_Send/how_to_migrate_from_v2_to_v3_mail_send.html)
- [v3 Web API Mail Send Helper](src/main/java/com/sendgrid/helpers) - build a request object payload for a v3 /mail/send API call.


<a name="use-cases"></a>
# Use Cases

[Examples of common API use cases](use-cases), such as how to send an email with a transactional template.

<a name="announcements"></a>
# Announcements

All updates to this library are documented in our [CHANGELOG](CHANGELOG.md) and [releases](https://github.com/sendgrid/sendgrid-java/releases).

<a name="contribute"></a>
# How to Contribute

We encourage contribution to our libraries (you might even score some nifty swag), please see our [CONTRIBUTING](CONTRIBUTING.md) guide for details.

Quick links:

- [Feature Request](CONTRIBUTING.md#feature-request)
- [Bug Reports](CONTRIBUTING.md#submit-a-bug-report)
- [Improvements to the Codebase](CONTRIBUTING.md#improvements-to-the-codebase)

<a name="troubleshooting"></a>
# Troubleshooting

Please see our [troubleshooting guide](TROUBLESHOOTING.md) for common library issues.

<a name="about"></a>
# About

sendgrid-java is maintained and funded by Twilio SendGrid, Inc. The names and logos for sendgrid-java are trademarks of Twilio SendGrid, Inc.

<a name="support"></a>
# Support

If you need help installing or using the library, please check the [Twilio SendGrid Support Help Center](https://support.sendgrid.com).

# License

[The MIT License (MIT)](LICENSE)
