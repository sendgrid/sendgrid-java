You can use Docker to easily try out or test sendgrid-java.

<a name="Quickstart"></a>
# Quickstart

1. Install Docker on your machine.
2. If you have not done so, create a Docker Store account [here](https://store.docker.com/signup?next=%2F)
3. Navigate [here](https://store.docker.com/images/oracle-serverjre-8) and click the "Proceed to Checkout" link (don't worry, it's free).
4. On the command line, execute `docker login` and provide your credentials.
5. Build the Docker image using the command `docker build -t sendgrid/sendgrid-java -f Dockerfile .`
6. Run `docker run -it sendgrid/sendgrid-java`.

<a name="Info"></a>
# Info

This Docker image contains
 - `sendgrid-java`
 - Stoplight's Prism, which lets you try out the API without actually sending email

Run it in interactive mode with `-it`.

You can mount repositories in the `/mnt/sendgrid-java` and `/mnt/java-http-client` directories to use them instead of the default SendGrid libraries. Read on for more info.

<a name="Testing"></a>
# Testing
Testing is easy!  Run the container, `cd sendgrid`, and run `./gradlew test`.

<a name="about"></a>
# About

sendgrid-java is guided and supported by the SendGrid [Developer Experience Team](mailto:dx@sendgrid.com).

sendgrid-java is maintained and funded by SendGrid, Inc. The names and logos for sendgrid-java are trademarks of SendGrid, Inc.

![SendGrid Logo](https://uiux.s3.amazonaws.com/2016-logos/email-logo%402x.png)
