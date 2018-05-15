# Supported tags and respective `Dockerfile` links
 - `v1.0.0`, `latest` [(Dockerfile)](https://github.com/sendgrid/sendgrid-java/blob/master/docker/Dockerfile)

# Quick reference
Build the image using this command `docker build -t sendgrid/sendgrid-java -f Dockerfile .`

 - **Where to get help:**
   [Contact SendGrid Support](https://support.sendgrid.com/hc/en-us)

 - **Where to file issues:**
   https://github.com/sendgrid/sendgrid-java/issues

 - **Where to get more info:**
   [USAGE.md](https://github.com/sendgrid/sendgrid-java/blob/master/docker/USAGE.md)

 - **Maintained by:**
   [SendGrid Inc.](https://sendgrid.com)

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

# About

sendgrid-java is guided and supported by the SendGrid [Developer Experience Team](mailto:dx@sendgrid.com).

sendgrid-java is maintained and funded by SendGrid, Inc. The names and logos for sendgrid-java are trademarks of SendGrid, Inc.

![SendGrid Logo](https://uiux.s3.amazonaws.com/2016-logos/email-logo%402x.png)
