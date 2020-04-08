# Supported tags and respective `Dockerfile` links
 - `v1.0.0`, `latest` [(Dockerfile)](https://github.com/sendgrid/sendgrid-java/blob/master/docker/Dockerfile)

# Quick reference
Due to Oracle's JDK license, you must build this Docker image using the official Oracle image located in the Docker Store. You will need a Docker store account. Once you have an account, you must accept the Oracle license [here](https://store.docker.com/images/oracle-serverjre-8). On the command line, type `docker login` and provide your credentials. You may then build the image using this command `docker build -t sendgrid/sendgrid-java -f Dockerfile .`

 - **Where to get help:**
   [Contact Twilio SendGrid Support](https://support.sendgrid.com/hc/en-us)

 - **Where to file issues:**
   https://github.com/sendgrid/sendgrid-java/issues

 - **Where to get more info:**
   [USAGE.md](https://github.com/sendgrid/sendgrid-java/blob/master/docker/USAGE.md)

 - **Maintained by:**
   [Twilio SendGrid Inc.](https://sendgrid.com)

# Usage examples
 - Most recent version: `docker run -it sendgrid/sendgrid-java`.
 - Your own fork:
   ```sh-session
   $ git clone https://github.com/you/cool-sendgrid-java.git
   $ realpath cool-sendgrid-java
   /path/to/cool-sendgrid-java
   $ docker run -it -v /path/to/cool-sendgrid-java:/mnt/sendgrid-java sendgrid/sendgrid-java
   ```

For more detailed information, see [USAGE.md](https://github.com/sendgrid/sendgrid-java/blob/master/docker/USAGE.md).

![SendGrid Logo](https://github.com/sendgrid/sendgrid-python/raw/master/twilio_sendgrid_logo.png)
