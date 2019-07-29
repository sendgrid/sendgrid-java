FROM store/oracle/serverjre:8

ENV OAI_SPEC_URL="https://raw.githubusercontent.com/sendgrid/sendgrid-oai/master/oai_stoplight.json"

RUN yum install -y git 

WORKDIR /root

# install Prism
ADD https://raw.githubusercontent.com/stoplightio/prism/master/install install.sh
RUN chmod +x ./install.sh && \
    ./install.sh && \
    rm ./install.sh

# Set up default Twilio SendGrid env
WORKDIR /root/sources
RUN git clone https://github.com/sendgrid/sendgrid-java.git
WORKDIR /root
RUN ln -s /root/sources/sendgrid-java

COPY entrypoint.sh entrypoint.sh
RUN chmod +x entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]
CMD ["--mock"]
