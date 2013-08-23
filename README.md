# sendgrid-java

This Java module allows you to quickly and easily send emails through SendGrid using Java.

```java
Sendgrid sendgrid = new Sendgrid("sendgrid_username", "sendgrid_password");

sendgrid.setTo("example@example.com");
sendgrid.setFrom("other@example.com");
sendgrid.setSubject("Hello World");
sendgrid.setText("My first email through SendGrid");

sendgrid.send();
```

## Installation

## Usage

## Development

### Generating the jar

```bash
gradle jar
```

(If you don't have gradle install it. If on a mac, you can run `brew install gradle`) 

