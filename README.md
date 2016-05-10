[![Travis Badge](https://travis-ci.org/sendgrid/sendgrid-java.svg?branch=master)](https://travis-ci.org/sendgrid/sendgrid-java) [![BuildStatus](https://maven-badges.herokuapp.com/maven-central/com.sendgrid/sendgrid-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.sendgrid/sendgrid-java)

**This library allows you to quickly and easily use the SendGrid Web API via Java.**

**NOTE: The `/mail/send/beta` endpoint is currently in beta!

Since this is not a general release, we do not recommend POSTing production level traffic through this endpoint or integrating your production servers with this endpoint.

When this endpoint is ready for general release, your code will require an update in order to use the official URI.

By using this endpoint, you accept that you may encounter bugs and that the endpoint may be taken down for maintenance at any time. We cannot guarantee the continued availability of this beta endpoint. We hope that you like this new endpoint and we appreciate any [feedback](dx+mail-beta@sendgrid.com) that you can send our way.**

# Installation

Choose your installation method - Maven w/ Gradle (recommended), Maven or Jar file.

### via Maven w/ Gradle

Add the following to your build.gradle file in the root of your project.

```groovy
...
dependencies {
  ...
  compile 'com.sendgrid:sendgrid-java:3.0.0'
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

## Dependencies

- [Java-HTTP-Client](https://github.com/sendgrid/java-http-client)

## Environment Variables

First, get your free SendGrid account [here](https://sendgrid.com/free?source=sendgrid-java).

Next, update your environment with your [SENDGRID_API_KEY](https://app.sendgrid.com/settings/api_keys).

```bash
echo "export SENDGRID_API_KEY='YOUR_API_KEY'" > sendgrid.env
echo "sendgrid.env" >> .gitignore
source ./sendgrid.env
```

# Quick Start

## Hello Email

```java
import com.sendgrid.*;
import java.io.IOException;

Email from = new Email("dx@sendgrid.com");
String subject = "Hello World from the SendGrid Java Library";
Email to = new Email("elmer.thomas@sendgrid.com");
Content content = new Content("text/plain", "some text here");
Mail mail = new Mail(from, subject, to, content);

SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
Request request = new Request();
try {
  request.method = Method.POST;
  request.endpoint = "mail/send/beta";
  request.requestBody = mail.build();
  Response response = sg.api(request);
  System.out.println(response.statusCode);
  System.out.println(response.responseBody);
  System.out.println(response.responseHeaders);
} catch (IOException ex) {
  throw ex;
}
```

## General v3 Web API Usage

```java
import com.sendgrid.*;
import java.io.IOException;

SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
Request request = new Request();
try {
  Request request = new Request;
  request.method = Method.GET;
  request.endpoint = "api_keys";
  Response response = sg.api(request);
  System.out.println(response.statusCode);
  System.out.println(response.responseBody);
  System.out.println(response.responseHeaders);
} catch (IOException ex) {
  throw ex;
}
```

# Announcements

**BREAKING CHANGE as of XXXX.XX.XX**

Version `3.0.0` is a breaking change for the entire library.

Version 3.0.0 brings you full support for all Web API v3 endpoints. We
have the following resources to get you started quickly:

-   [SendGrid
    Documentation](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html)
-   [Usage
    Documentation](https://github.com/sendgrid/sendgrid-java/blob/master/USAGE.md)
-   [Example
    Code](https://github.com/sendgrid/sendgrid-java/blob/master/examples)

Thank you for your continued support!

## Roadmap

[Milestones](https://github.com/sendgrid/sendgrid-java/milestones)

## How to Contribute

We encourage contribution to our libraries, please see our [CONTRIBUTING](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md) guide for details.

* [Feature Request](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#feature_request)
* [Bug Reports](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#submit_a_bug_report)
* [Improvements to the Codebase](https://github.com/sendgrid/sendgrid-java/blob/master/CONTRIBUTING.md#improvements_to_the_codebase)

## Usage

- [SendGrid Docs](https://sendgrid.com/docs/API_Reference/index.html)
- [v3 Web API](https://github.com/sendgrid/sendgrid-java/blob/master/USAGE.md)
- [Example Code](https://github.com/sendgrid/sendgrid-java/blob/master/examples)
- [v3 Web API Mail Send Helper]()

## Unsupported Libraries

- [Official and Unsupported SendGrid Libraries](https://sendgrid.com/docs/Integrate/libraries.html)

# About

![SendGrid Logo]
(https://assets3.sendgrid.com/mkt/assets/logos_brands/small/sglogo_2015_blue-9c87423c2ff2ff393ebce1ab3bd018a4.png)

sendgrid-java is guided and supported by the SendGrid [Developer Experience Team](mailto:dx@sendgrid.com).

sendgrid-java is maintained and funded by SendGrid, Inc. The names and logos for sendgrid-java are trademarks of SendGrid, Inc.
