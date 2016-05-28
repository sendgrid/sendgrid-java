[![Travis Badge](https://travis-ci.org/sendgrid/sendgrid-java.svg?branch=master)](https://travis-ci.org/sendgrid/sendgrid-java) [![BuildStatus](https://maven-badges.herokuapp.com/maven-central/com.sendgrid/sendgrid-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.sendgrid/sendgrid-java)

**This library allows you to quickly and easily use the SendGrid Web API via Java.**

# Announcements

**NOTE: The `/mail/send/beta` endpoint is currently in beta!

Since this is not a general release, we do not recommend POSTing production level traffic through this endpoint or integrating your production servers with this endpoint.

When this endpoint is ready for general release, your code will require an update in order to use the official URI.

By using this endpoint, you accept that you may encounter bugs and that the endpoint may be taken down for maintenance at any time. We cannot guarantee the continued availability of this beta endpoint. We hope that you like this new endpoint and we appreciate any [feedback](dx+mail-beta@sendgrid.com) that you can send our way.**

**BREAKING CHANGE as of XXXX.XX.XX**

Version `3.0.0` is a breaking change for the entire library.

Version 3.0.0 brings you full support for all Web API v3 endpoints. We
have the following resources to get you started quickly:

-   [SendGrid
    Documentation](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html)
-   [Usage
    Documentation](https://github.com/sendgrid/sendgrid-java/tree/v2beta/USAGE.md)
-   [Example
    Code](https://github.com/sendgrid/sendgrid-java/tree/v2beta/examples)

Thank you for your continued support!

All updates to this library is documented in our [CHANGELOG](https://github.com/sendgrid/sendgrid-java/blob/v3beta/CHANGELOG.md).

# Installation

## Environment Variables

First, get your free SendGrid account [here](https://sendgrid.com/free?source=sendgrid-java).

Next, update your environment with your [SENDGRID_API_KEY](https://app.sendgrid.com/settings/api_keys).

```bash
echo "export SENDGRID_API_KEY='YOUR_API_KEY'" > sendgrid.env
echo "sendgrid.env" >> .gitignore
source ./sendgrid.env
```
## TRYING OUT THE V3 BETA MAIL SEND

```bash
git clone -b v3beta --single-branch https://github.com/sendgrid/sendgrid-java.git
cd sendgrid-java
./gradlew build
```

* Update the to and from [emails](https://github.com/sendgrid/sendgrid-java/blob/v3beta/examples/Mail/Example.java#L35).

```bash
cd examples/helpers/mail
javac -classpath ../../examples/dependencies/jackson-annotations-2.7.0.jar:../../examples/dependencies/jackson-databind-2.7.3.jar:../../examples/dependencies/jackson-core-2.7.3.jar:../../../build/libs/sendgrid-3.0.0-jar.jar:. Example.java && java -classpath ../../examples/dependencies/jackson-annotations-2.7.0.jar:../../examples/dependencies/jackson-databind-2.7.3.jar:../../examples/dependencies/jackson-core-2.7.3.jar:../../../build/libs/sendgrid-3.0.0-jar.jar:. Example
```

## TRYING OUT THE V3 BETA WEB API

```bash
git clone -b v3beta --single-branch https://github.com/sendgrid/sendgrid-java.git
```

* Check out the documentation for [Web API v3 endpoints](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html).
* Review the corresponding [examples](https://github.com/sendgrid/sendgrid-python/blob/v3beta/examples).

```bash
cd examples
touch Example.java
```

Add the example you want to test to Example.java, including the headers at the top of the file.

``` bash
javac -classpath ./dependencies/jackson-annotations-2.7.0.jar:./dependencies/jackson-databind-2.7.3.jar:./dependencies/jackson-core-2.7.3.jar:../build/libs/sendgrid-3.0.0-jar.jar:. Example.java && java -classpath ./dependencies/jackson-annotations-2.7.0.jar:./dependencies/jackson-databind-2.7.3.jar:./dependencies/jackson-core-2.7.3.jar:../build/libs/sendgrid-3.0.0-jar.jar:. Example
```

* Check out the documentation for [Web API v3 /mail/send/beta endpoint](https://sendgrid.com/docs/API_Reference/Web_API_v3/Mail/index.html).

## Once we are out of v3 BETA, the following will apply

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

- The SendGrid Service, starting at the [free level](https://sendgrid.com/free?source=sendgrid-java))
- [Java-HTTP-Client](https://github.com/sendgrid/java-http-client)

# Quick Start

## Hello Email

```java
import com.sendgrid.*;
import java.io.IOException;

Email from = new Email("test@example.com");
String subject = "Hello World from the SendGrid Java Library";
Email to = new Email("test@example.com");
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

# Usage

- [SendGrid Docs](https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html)
- [Usage Docs](https://github.com/sendgrid/sendgrid-java/tree/v3beta/USAGE.md)
- [Example Code](https://github.com/sendgrid/sendgrid-java/tree/v3beta/examples)

## Roadmap

If you are intersted in the future direction of this project, please take a look at our [milestones](https://github.com/sendgrid/sendgrid-java/milestones). We would love to hear your feedback.

## How to Contribute

We encourage contribution to our libraries, please see our [CONTRIBUTING](https://github.com/sendgrid/sendgrid-java/blob/v3beta/CONTRIBUTING.md) guide for details.

Quick links:

- [Feature Request](https://github.com/sendgrid/sendgrid-java/blob/v3beta/CONTRIBUTING.md#feature_request)
- [Bug Reports](https://github.com/sendgrid/sendgrid-java/blob/v3beta/CONTRIBUTING.md#submit_a_bug_report)
- [Sign the CLA to Create a Pull Request](https://github.com/sendgrid/sendgrid-java/blob/v3beta/CONTRIBUTING.md#cla)
- [Improvements to the Codebase](https://github.com/sendgrid/sendgrid-java/blob/v3beta/CONTRIBUTING.md#improvements_to_the_codebase)

# About

sendgrid-java is guided and supported by the SendGrid [Developer Experience Team](mailto:dx@sendgrid.com).

sendgrid-java is maintained and funded by SendGrid, Inc. The names and logos for sendgrid-java are trademarks of SendGrid, Inc.

![SendGrid Logo]
(https://assets3.sendgrid.com/mkt/assets/logos_brands/small/sglogo_2015_blue-9c87423c2ff2ff393ebce1ab3bd018a4.png)