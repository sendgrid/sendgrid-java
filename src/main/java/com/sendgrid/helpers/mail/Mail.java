package com.sendgrid.helpers.mail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sendgrid.helpers.mail.objects.*;

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
  @JsonProperty("from") private Email from;
  @JsonProperty("subject") private String subject;
  @JsonProperty("personalizations") private List<Personalization> personalization;
  @JsonProperty("content") private List<Content> content;
  @JsonProperty("attachments") private List<Attachments> attachments;
  @JsonProperty("template_id") private String templateId;
  @JsonProperty("sections") private Map<String,String> sections;
  @JsonProperty("headers") private Map<String,String> headers;
  @JsonProperty("categories") private List<String> categories;
  @JsonProperty("custom_args") private Map<String,String> customArgs;
  @JsonProperty("send_at") private long sendAt;
  @JsonProperty("batch_id") private String batchId;
  @JsonProperty("asm") private ASM asm;
  @JsonProperty("ip_pool_name") private String ipPoolId;
  @JsonProperty("mail_settings") private MailSettings mailSettings;
  @JsonProperty("tracking_settings") private TrackingSettings trackingSettings;
  @JsonProperty("reply_to") private Email replyTo;

  private static final ObjectMapper SORTED_MAPPER = new ObjectMapper();
  static {
    SORTED_MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
  }

  public Mail() {}

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
  public Email getFrom() {
    return this.from;
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

  @JsonProperty("personalizations")
  public List<Personalization> getPersonalization() {
    return personalization;
  }

  public void addPersonalization(Personalization personalization) {
    if (this.personalization == null) {
      this.personalization = new ArrayList<>();
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
      this.content = new ArrayList<>();
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
      this.attachments = new ArrayList<>();
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
      sections = new HashMap<>();
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
      headers = new HashMap<>();
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
      categories = new ArrayList<>();
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
      customArgs = new HashMap<>();
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
      //ObjectMapper mapper = new ObjectMapper();
      return SORTED_MAPPER.writeValueAsString(this);
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
