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

You can mount repositories in the `/mnt/sendgrid-java` and `/mnt/java-http-client` directories to use them instead of the default Twilio SendGrid libraries. Read on for more info.

<a name="Testing"></a>
# Testing
Testing is easy!  
1. Run the container: `docker run -it sendgrid/sendgrid-java`
2. `cd sendgrid-java`
3. run `./gradlew test`

![SendGrid Logo](https://github.com/sendgrid/sendgrid-python/raw/master/twilio_sendgrid_logo.png)

