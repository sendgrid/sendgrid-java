First, follow the [Twilio Setup](twilio-setup.md) guide for creating a Twilio account and setting up environment variables with the proper credentials.

Then, initialize the Twilio Email Client.

```java
TwilioEmail mailClient = new TwilioEmail(System.getenv("TWILIO_API_KEY"), System.getenv("TWILIO_API_SECRET"));
// or
TwilioEmail mailClient = new TwilioEmail(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));
```

This client has the same interface as the `SendGrid` client.
