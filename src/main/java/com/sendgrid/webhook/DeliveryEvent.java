package com.sendgrid.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sendgrid.webhook.serializer.NumericBooleanSerializer;
import com.sendgrid.webhook.serializer.TimestampSerializer;
import java.util.Date;

public class DeliveryEvent extends Event {

  @JsonProperty("email")
  protected String email;
  @JsonProperty("timestamp")
  @JsonDeserialize(using = TimestampSerializer.class)
  protected Date timestamp;
  @JsonProperty("smtp-id")
  protected String smtpId;
  @JsonProperty("ip")
  protected String ip;
  @JsonProperty("tls")
  @JsonDeserialize(using = NumericBooleanSerializer.class)
  protected boolean tls;
  @JsonProperty("cert_err")
  @JsonDeserialize(using = NumericBooleanSerializer.class)
  protected boolean certErr;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getSmtpId() {
    return smtpId;
  }

  public void setSmtpId(String smtpId) {
    this.smtpId = smtpId;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public boolean isTls() {
    return tls;
  }

  public void setTls(boolean tls) {
    this.tls = tls;
  }

  public boolean isCertErr() {
    return certErr;
  }

  public void setCertErr(boolean certErr) {
    this.certErr = certErr;
  }
}
