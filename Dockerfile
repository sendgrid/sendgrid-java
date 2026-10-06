ARG version=8
FROM maven:3.9-eclipse-temurin-${version}

RUN apt-get update \
    && apt-get install -y --no-install-recommends make \
    && rm -rf /var/lib/apt/lists/*

# Trust the mock server's api.sendgrid.com certificate (see mock-server/).
COPY mock-server/nginx/cert.crt /tmp/api.sendgrid.com.crt
RUN keytool -importcert -noprompt -storepass changeit -alias api.sendgrid.com \
    -file /tmp/api.sendgrid.com.crt -keystore "$(find "$JAVA_HOME" -name cacerts | head -1)"

WORKDIR /app
COPY . .

RUN make install
