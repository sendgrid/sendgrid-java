FROM store/oracle/serverjre:8

ENV OAI_SPEC_URL="https://raw.githubusercontent.com/sendgrid/sendgrid-oai/master/oai_stoplight.json"

RUN yum install -y git 

WORKDIR /root

# Set up default Twilio SendGrid env
WORKDIR /root/sources
RUN git clone https://github.com/sendgrid/sendgrid-java.git
WORKDIR /root
RUN ln -s /root/sources/sendgrid-java

# Use older gradle commands to support the gradle version in the wrapper
RUN sed -i 's/implementation/compile/g' /root/sendgrid-java/build.gradle
RUN sed -i 's/testImplementation/testCompile/g' /root/sendgrid-java/build.gradle

COPY entrypoint.sh entrypoint.sh
RUN chmod +x entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]
CMD ["--mock"]
