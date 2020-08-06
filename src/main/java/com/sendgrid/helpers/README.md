**This helper allows you to quickly and easily build a Mail object for sending email through Twilio SendGrid.**

## Dependencies

- [Jackson](https://github.com/FasterXML/jackson)

# Quick Start

Run the [example](../../../../../../examples/mail) (make sure you have set your environment variable to include your SENDGRID_API_KEY).

```bash
cd examples/mail
javac -classpath ../../build/libs/sendgrid-4.2.1-jar.jar:. Example.java && java -classpath ../examples/jackson-core-2.9.9.jar:../../build/libs/sendgrid-4.1.0-jar.jar:. Example
```

## Usage

- See the [example](../../../../../../examples/mail) for a complete working example.
- [Documentation](https://sendgrid.com/docs/API_Reference/Web_API_v3/Mail/index.html)
