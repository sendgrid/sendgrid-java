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


