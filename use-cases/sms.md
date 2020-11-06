First, follow the [Twilio Setup](twilio-setup.md) guide for creating a Twilio account and setting up environment variables with the proper credentials.

Then, install the Twilio Helper Library by following the [installation steps](https://github.com/twilio/twilio-java#installation).

Finally, send a message.

```java
String accountSid = System.getenv("TWILIO_ACCOUNT_SID");
String authToken = System.getenv("TWILIO_AUTH_TOKEN");
Twilio.init(accountSid, authToken);
Message message = Message.creator(
    new PhoneNumber("+15558881234"),  // To number
    new PhoneNumber("+15559994321"),  // From number
    "Hello world!"                    // SMS body
).create();
System.out.println(message.getSid());
```

For more information, please visit the [Twilio SMS Java documentation](https://www.twilio.com/docs/sms/quickstart/java).
