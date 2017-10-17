If you have a non-library SendGrid issue, please contact our [support team](https://support.sendgrid.com).

If you can't find a solution below, please open an [issue](https://github.com/sendgrid/sendgrid-java/issues).


## Table of Contents

* [Migrating from v2 to v3](#migrating)
* [Continue Using v2](#v2)
* [Testing v3 /mail/send Calls Directly](#testing)
* [Versions](#versions)
* [Environment Variables and Your SendGrid API Key](#environment)
* [Using the Package Manager](#package-manager)
* [Android Compatibility](#android)
* [Viewing the Request Body](#request-body)

<a name="migrating"></a>
## Migrating from v2 to v3

Please review [our guide](https://sendgrid.com/docs/Classroom/Send/v3_Mail_Send/how_to_migrate_from_v2_to_v3_mail_send.html) on how to migrate from v2 to v3.

<a name="v2"></a>
## Continue Using v2

[Here](https://github.com/sendgrid/sendgrid-java/tree/b64988f85474e04e9d75e17860d64ffacda1cdff) is the last working version with v2 support.

### via Maven w/ Gradle

Add the following to your build.gradle file in the root of your project.

```groovy
...
dependencies {
  ...
  compile 'com.sendgrid:sendgrid-java:2.2.2'
}

repositories {
  mavenCentral()
}
...
```

### via jar file

You can just drop the jar file in. It's a fat jar - it has all the dependencies built in.

[sendgrid-java.jar](http://repo1.maven.org/maven2/com/sendgrid/sendgrid-java/2.2.2/sendgrid-java-2.2.2-jar.jar)

<a name="testing"></a>
## Testing v3 /mail/send Calls Directly

[Here](https://sendgrid.com/docs/Classroom/Send/v3_Mail_Send/curl_examples.html) are some cURL examples for common use cases.

<a name="versions"></a>
## Versions

We follow the MAJOR.MINOR.PATCH versioning scheme as described by [SemVer.org](http://semver.org). Therefore, we recommend that you always pin (or vendor) the particular version you are working with to your code and never auto-update to the latest version. Especially when there is a MAJOR point release, since that is guaranteed to be a breaking change. Changes are documented in the [CHANGELOG](https://github.com/sendgrid/sendgrid-java/blob/master/CHANGELOG.md) and [releases](https://github.com/sendgrid/sendgrid-java/releases) section.

<a name="environment"></a>
## Environment Variables and Your SendGrid API Key

All of our examples assume you are using [environment variables](https://github.com/sendgrid/sendgrid-java#setup-environment-variables) to hold your SendGrid API key.

If you choose to add your SendGrid API key directly (not recommended):

`System.getenv("SENDGRID_API_KEY")`

becomes

`"SENDGRID_API_KEY"`

In the first case SENDGRID_API_KEY is in reference to the name of the environment variable, while the second case references the actual SendGrid API Key.

<a name="package-manager"></a>
## Using the Package Manager

We upload this library to [Maven](http://repo1.maven.org/maven2/com/sendgrid/sendgrid-java/) whenever we make a release. This allows you to use [maven and gradle](https://maven.apache.org/) for easy installation.

In most cases we recommend you download the latest version of the library, but if you need a different version, please use:

```groovy
...
dependencies {
  ...
  compile 'com.sendgrid:sendgrid-java:X.X.X'
}

repositories {
  mavenCentral()
}
...
```

<a name="android"></a>
## Android Compatibility

Since Android SDK 23, HttpClient is no longer supported. Some workarounds can be found [here](http://stackoverflow.com/questions/32153318/httpclient-wont-import-in-android-studio).

We have an issue to remove that dependency [here](https://github.com/sendgrid/java-http-client/issues/2), please upvote to move it up the queue.

<a name="request-body"></a>
## Viewing the Request Body

When debugging or testing, it may be useful to exampine the raw request body to compare against the [documented format](https://sendgrid.com/docs/API_Reference/api_v3.html).

You can do this right before you call `request.setBody(mail.build())` like so:

```java
System.out.println(mail.build());
```