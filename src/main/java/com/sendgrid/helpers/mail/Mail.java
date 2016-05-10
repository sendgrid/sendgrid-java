package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * Class Mail builds an object that sends an email through SendGrid.
  */
@JsonInclude(Include.NON_DEFAULT)
public class Mail {
  @JsonProperty("from") public Email from;
  @JsonProperty("subject") public String subject;
  @JsonProperty("personalization") public List<Personalization> personalization;
  @JsonProperty("content") public List<Content> content;
  @JsonProperty("attachments") public List<Attachments> attachments;
  @JsonProperty("template_id") public String templateId;
  @JsonProperty("sections") public Map<String,String> sections;
  @JsonProperty("headers") public Map<String,String> headers;
  @JsonProperty("categories") public List<String> categories;
  @JsonProperty("custom_args") public Map<String,String> customArgs;
  @JsonProperty("send_at") public long sendAt;
  @JsonProperty("batch_id") public String batchId;
  @JsonProperty("asm") public ASM asm;
  @JsonProperty("ip_pool_name") public String ipPoolId;
  @JsonProperty("mail_settings") public MailSettings mailSettings;
  @JsonProperty("tracking_settings") public TrackingSettings trackingSettings;
  @JsonProperty("reply_to") public Email replyTo;

  public Mail() {
    return;
  }

  public Mail(Email from, String subject, Email to, Content content)
  {
    this.setFrom(from);
    this.setSubject(subject);
    Personalization personalization = new Personalization();
    personalization.addTo(to);
    this.addPersonalization(personalization);
    this.addContent(content);
  }

  @JsonProperty("from")
  public Email getFrom(Email from) {
    return from;
  }

  public void setFrom(Email from) {
    this.from = from;
  }

  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @JsonProperty("asm")
  public ASM getASM() {
    return asm;
  }

  public void setASM(ASM asm) {
    this.asm = asm;
  }

  @JsonProperty("personalization")
  public List<Personalization> getPersonalization() {
    return personalization;
  }

  public void addPersonalization(Personalization personalization) {
    if (this.personalization == null) {
      this.personalization = new ArrayList<Personalization>();
      this.personalization.add(personalization);
    } else {
      this.personalization.add(personalization);
    }
  }

  @JsonProperty("content")
  public List<Content> getContent() {
    return content;
  }

  public void addContent(Content content) {
    Content newContent = new Content();
    newContent.setType(content.getType());
    newContent.setValue(content.getValue());
    if (this.content == null) {
      this.content = new ArrayList<Content>();
      this.content.add(newContent);
    } else {
      this.content.add(newContent);
    }
  }

  @JsonProperty("attachments")
  public List<Attachments> getAttachments() {
    return attachments;
  }

  public void addAttachments(Attachments attachments) {
    Attachments newAttachment = new Attachments();
    newAttachment.setContent(attachments.getContent());
    newAttachment.setType(attachments.getType());
    newAttachment.setFilename(attachments.getFilename());
    newAttachment.setDisposition(attachments.getDisposition());
    newAttachment.setContentId(attachments.getContentId());
    if (this.attachments == null) {
      this.attachments = new ArrayList<Attachments>();
      this.attachments.add(newAttachment);
    } else {
      this.attachments.add(newAttachment);
    }
  }

  @JsonProperty("template_id")
  public String getTemplateId() {
    return this.templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  @JsonProperty("sections")
  public Map<String,String> getSections() {
    return sections;
  }

  public void addSection(String key, String value) {
    if (sections == null) {
      sections = new HashMap<String,String>();
      sections.put(key, value);
    } else {
      sections.put(key, value);
    }
  }

  @JsonProperty("headers")
  public Map<String,String> getHeaders() {
    return headers;
  }


  public void addHeader(String key, String value) {
    if (headers == null) {
      headers = new HashMap<String,String>();
      headers.put(key, value);
    } else {
      headers.put(key, value);
    }
  }

  @JsonProperty("categories")
  public List<String> getCategories() {
    return categories;
  }

  public void addCategory(String category) {
    if (categories == null) {
      categories = new ArrayList<String>();
      categories.add(category);
    } else {
      categories.add(category);
    }
  }

  @JsonProperty("custom_args")
  public Map<String,String> getCustomArgs() {
    return customArgs;
  }

  public void addCustomArg(String key, String value) {
    if (customArgs == null) {
      customArgs = new HashMap<String,String>();
      customArgs.put(key, value);
    } else {
      customArgs.put(key, value);
    }
  }

  @JsonProperty("send_at")
  public long sendAt() {
    return sendAt;
  }

  public void setSendAt(long sendAt) {
    this.sendAt = sendAt;
  }

  @JsonProperty("batch_id")
  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  @JsonProperty("ip_pool_name")
  public String getIpPoolId() {
    return ipPoolId;
  }

  public void setIpPoolId(String ipPoolId) {
    this.ipPoolId = ipPoolId;
  }

  @JsonProperty("mail_settings")
  public MailSettings getMailSettings() {
    return mailSettings;
  }

  public void setMailSettings(MailSettings mailSettings) {
    this.mailSettings = mailSettings;
  }

  @JsonProperty("tracking_settings")
  public TrackingSettings getTrackingSettings() {
    return trackingSettings;
  }

  public void setTrackingSettings(TrackingSettings trackingSettings) {
    this.trackingSettings = trackingSettings;
  }

  @JsonProperty("reply_to")
  public Email getReplyto() {
    return replyTo;
  }

  public void setReplyTo(Email replyTo) {
    this.replyTo = replyTo;
  }

  /**
  * Create a string represenation of the Mail object JSON.
  */
  public String build() throws IOException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(this);
    } catch (IOException ex) {
      throw ex;
    }
  }

  /**
  * Create a string represenation of the Mail object JSON and pretty print it.
  */
  public String buildPretty() throws IOException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    } catch (IOException ex) {
      throw ex;
    }
  }
}