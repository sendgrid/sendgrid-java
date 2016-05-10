**This helper allows you to quickly and easily build a Mail object for sending email through SendGrid.**

## Dependencies

- [Jackson](https://github.com/FasterXML/jackson)

# Quick Start

Run the [example]() (make sure you have set your environment variable to include your SENDGRID_API_KEY).

```bash
cd examples/mail
javac -classpath ../examples/jackson-annotations-2.7.0.jar:../examples/jackson-databind-2.7.3.jar:../examples/jackson-core-2.7.3.jar:../../build/libs/sendgrid-3.0.0-jar.jar:. Example.java && java -classpath ../examples/jackson-annotations-2.7.0.jar:../examples/jackson-databind-2.7.3.jar:../examples/jackson-core-2.7.3.jar:../../build/libs/sendgrid-3.0.0-jar.jar:. Example
```

## Usage

- See the example for a complete working example.
- [Documentation]()