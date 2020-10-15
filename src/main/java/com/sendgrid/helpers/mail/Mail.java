package com.sendgrid.helpers.mail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sendgrid.helpers.mail.objects.ASM;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.MailSettings;
import com.sendgrid.helpers.mail.objects.Personalization;
import com.sendgrid.helpers.mail.objects.TrackingSettings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Mail builds an object that sends an email through Twilio SendGrid. Note that this object is
 * not thread safe.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Mail {

  /** The email's from field. */
  @JsonProperty("from")
  public Email from;

  /**
   * The email's subject line. This is the global, or “message level”, subject of your email. This
   * may be overridden by personalizations[x].subject.
   */
  @JsonProperty("subject")
  public String subject;

  /**
   * The email's personalization. Each object within personalizations can be thought of as an
   * envelope - it defines who should receive an individual message and how that message should be
   * handled.
   */
  @JsonProperty("personalizations")
  public List<Personalization> personalization;

  /** The email's content. */
  @JsonProperty("content")
  public List<Content> content;

  /** The email's attachments. */
  @JsonProperty("attachments")
  public List<Attachments> attachments;

  /** The email's template ID. */
  @JsonProperty("template_id")
  public String templateId;

  /**
   * The email's sections. An object of key/value pairs that define block sections of code to be
   * used as substitutions.
   */
  @JsonProperty("sections")
  public Map<String, String> sections;

  /** The email's headers. */
  @JsonProperty("headers")
  public Map<String, String> headers;

  /** The email's categories. */
  @JsonProperty("categories")
  public List<String> categories;

  /**
   * The email's custom arguments. Values that are specific to the entire send that will be carried
   * along with the email and its activity data. Substitutions will not be made on custom arguments,
   * so any string that is entered into this parameter will be assumed to be the custom argument
   * that you would like to be used. This parameter is overridden by personalizations[x].custom_args
   * if that parameter has been defined. Total custom args size may not exceed 10,000 bytes.
   */
  @JsonProperty("custom_args")
  public Map<String, String> customArgs;

  /**
   * A unix timestamp allowing you to specify when you want your email to be delivered. This may be
   * overridden by the personalizations[x].send_at parameter. Scheduling more than 72 hours in
   * advance is forbidden.
   */
  @JsonProperty("send_at")
  public long sendAt;

  /**
   * This ID represents a batch of emails to be sent at the same time. Including a batch_id in your
   * request allows you include this email in that batch, and also enables you to cancel or pause
   * the delivery of that batch. For more information, see https://sendgrid.com/docs/API_Reference/Web_API_v3/cancel_schedule_send.
   */
  @JsonProperty("batch_id")
  public String batchId;

  /** The email's unsubscribe handling object. */
  @JsonProperty("asm")
  public ASM asm;

  /** The email's IP pool name. */
  @JsonProperty("ip_pool_name")
  public String ipPoolId;

  /** The email's mail settings. */
  @JsonProperty("mail_settings")
  public MailSettings mailSettings;

  /** The email's tracking settings. */
  @JsonProperty("tracking_settings")
  public TrackingSettings trackingSettings;

  /** The email's reply to address. */
  @JsonProperty("reply_to")
  public Email replyTo;

  private static final ObjectMapper SORTED_MAPPER = new ObjectMapper();

  static {
    SORTED_MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
  }

  private <T> List<T> addToList(T element, List<T> defaultList) {
    if (defaultList != null) {
      defaultList.add(element);
      return defaultList;
    } else {
      List<T> list = new ArrayList<T>();
      list.add(element);
      return list;
    }
  }

  private <K, V> Map<K, V> addToMap(K key, V value, Map<K, V> defaultMap) {
    if (defaultMap != null) {
      defaultMap.put(key, value);
      return defaultMap;
    } else {
      Map<K, V> map = new HashMap<K, V>();
      map.put(key, value);
      return map;
    }
  }

  /** Construct a new Mail object. */
  public Mail() {
    return;
  }

  /**
   * Construct a new Mail object.
   *
   * @param from the email's from address.
   * @param subject the email's subject line.
   * @param to the email's recipient.
   * @param content the email's content.
   */
  public Mail(Email from, String subject, Email to, Content content) {
    this.setFrom(from);
    this.setSubject(subject);
    Personalization personalization = new Personalization();
    personalization.addTo(to);
    this.addPersonalization(personalization);
    this.addContent(content);
  }

  /**
   * Get the email's from address.
   *
   * @return the email's from address.
   */
  @JsonProperty("from")
  public Email getFrom() {
    return this.from;
  }

  /**
   * Set the email's from address.
   *
   * @param from the email's from address.
   */
  public void setFrom(Email from) {
    this.from = from;
  }

  /**
   * Get the email's subject line.
   *
   * @return the email's subject line.
   */
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  /**
   * Set the email's subject line.
   *
   * @param subject the email's subject line.
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Get the email's unsubscribe handling object (ASM).
   *
   * @return the email's ASM.
   */
  @JsonProperty("asm")
  public ASM getASM() {
    return asm;
  }

  /**
   * Set the email's unsubscribe handling object (ASM).
   *
   * @param asm the email's ASM.
   */
  public void setASM(ASM asm) {
    this.asm = asm;
  }

  /**
   * Get the email's personalizations. Content added to the returned list will be included when
   * sent.
   *
   * @return the email's personalizations.
   */
  @JsonProperty("personalizations")
  public List<Personalization> getPersonalization() {
    return personalization;
  }

  /**
   * Add a personalization to the email.
   *
   * @param personalization a personalization.
   */
  public void addPersonalization(Personalization personalization) {
    this.personalization = addToList(personalization, this.personalization);
  }

  /**
   * Get the email's content. Content added to the returned list will be included when sent.
   *
   * @return the email's content.
   */
  @JsonProperty("content")
  public List<Content> getContent() {
    return content;
  }

  /**
   * Add content to this email.
   *
   * @param content content to add to this email.
   */
  public void addContent(Content content) {
    Content newContent = new Content();
    newContent.setType(content.getType());
    newContent.setValue(content.getValue());
    this.content = addToList(newContent, this.content);
  }

  /**
   * Get the email's attachments. Attachments added to the returned list will be included when
   * sent.
   *
   * @return the email's attachments.
   */
  @JsonProperty("attachments")
  public List<Attachments> getAttachments() {
    return attachments;
  }

  /**
   * Add attachments to the email.
   *
   * @param attachments attachments to add.
   */
  public void addAttachments(Attachments attachments) {
    Attachments newAttachment = new Attachments();
    newAttachment.setContent(attachments.getContent());
    newAttachment.setType(attachments.getType());
    newAttachment.setFilename(attachments.getFilename());
    newAttachment.setDisposition(attachments.getDisposition());
    newAttachment.setContentId(attachments.getContentId());
    this.attachments = addToList(newAttachment, this.attachments);
  }

  /**
   * Get the email's template ID.
   *
   * @return the email's template ID.
   */
  @JsonProperty("template_id")
  public String getTemplateId() {
    return this.templateId;
  }

  /**
   * Set the email's template ID.
   *
   * @param templateId the email's template ID.
   */
  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  /**
   * Get the email's sections. Sections added to the returned list will be included when sent.
   *
   * @return the email's sections.
   */
  @JsonProperty("sections")
  public Map<String, String> getSections() {
    return sections;
  }

  /**
   * Add a section to the email.
   *
   * @param key the section's key.
   * @param value the section's value.
   */
  public void addSection(String key, String value) {
    this.sections = addToMap(key, value, this.sections);
  }

  /**
   * Get the email's headers. Headers added to the returned list will be included when sent.
   *
   * @return the email's headers.
   */
  @JsonProperty("headers")
  public Map<String, String> getHeaders() {
    return headers;
  }

  /**
   * Add a header to the email.
   *
   * @param key the header's key.
   * @param value the header's value.
   */
  public void addHeader(String key, String value) {
    this.headers = addToMap(key, value, this.headers);
  }

  /**
   * Get the email's categories. Categories added to the returned list will be included when sent.
   *
   * @return the email's categories.
   */
  @JsonProperty("categories")
  public List<String> getCategories() {
    return categories;
  }

  /**
   * Add a category to the email.
   *
   * @param category the category.
   */
  public void addCategory(String category) {
    this.categories = addToList(category, this.categories);
  }

  /**
   * Get the email's custom arguments. Custom arguments added to the returned list will be included
   * when sent.
   *
   * @return the email's custom arguments.
   */
  @JsonProperty("custom_args")
  public Map<String, String> getCustomArgs() {
    return customArgs;
  }

  /**
   * Add a custom argument to the email.
   *
   * @param key argument's key.
   * @param value the argument's value.
   */
  public void addCustomArg(String key, String value) {
    this.customArgs = addToMap(key, value, this.customArgs);
  }

  /**
   * Get the email's send at time (Unix timestamp).
   *
   * @return the email's send at time.
   */
  @JsonProperty("send_at")
  public long sendAt() {
    return sendAt;
  }

  /**
   * Set the email's send at time (Unix timestamp).
   *
   * @param sendAt the send at time.
   */
  public void setSendAt(long sendAt) {
    this.sendAt = sendAt;
  }

  /**
   * Get the email's batch ID.
   *
   * @return the batch ID.
   */
  @JsonProperty("batch_id")
  public String getBatchId() {
    return batchId;
  }

  /**
   * Set the email's batch ID.
   *
   * @param batchId the batch ID.
   */
  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  /**
   * Get the email's IP pool ID.
   *
   * @return the IP pool ID.
   */
  @JsonProperty("ip_pool_name")
  public String getIpPoolId() {
    return ipPoolId;
  }

  /**
   * Set the email's IP pool ID.
   *
   * @param ipPoolId the IP pool ID.
   */
  public void setIpPoolId(String ipPoolId) {
    this.ipPoolId = ipPoolId;
  }

  /**
   * Get the email's settings.
   *
   * @return the settings.
   */
  @JsonProperty("mail_settings")
  public MailSettings getMailSettings() {
    return mailSettings;
  }

  /**
   * Set the email's settings.
   *
   * @param mailSettings the settings.
   */
  public void setMailSettings(MailSettings mailSettings) {
    this.mailSettings = mailSettings;
  }

  /**
   * Get the email's tracking settings.
   *
   * @return the tracking settings.
   */
  @JsonProperty("tracking_settings")
  public TrackingSettings getTrackingSettings() {
    return trackingSettings;
  }

  /**
   * Set the email's tracking settings.
   *
   * @param trackingSettings the tracking settings.
   */
  public void setTrackingSettings(TrackingSettings trackingSettings) {
    this.trackingSettings = trackingSettings;
  }

  /**
   * Get the email's reply to address.
   *
   * @return the reply to address.
   */
  @JsonProperty("reply_to")
  public Email getReplyto() {
    return replyTo;
  }

  /**
   * Set the email's reply to address.
   *
   * @param replyTo the reply to address.
   */
  public void setReplyTo(Email replyTo) {
    this.replyTo = replyTo;
  }

  /**
   * Create a string representation of the Mail object JSON.
   *
   * @return a JSON string.
   * @throws IOException in case of a JSON marshal error.
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
   * Create a string representation of the Mail object JSON and pretty print it.
   *
   * @return a pretty JSON string.
   * @throws IOException in case of a JSON marshal error.
   */
  public String buildPretty() throws IOException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    } catch (IOException ex) {
      throw ex;
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
    result = prime * result + ((categories == null) ? 0 : categories.hashCode());
    result = prime * result + ((customArgs == null) ? 0 : customArgs.hashCode());
    result = prime * result + ((headers == null) ? 0 : headers.hashCode());
    result = prime * result + ((ipPoolId == null) ? 0 : ipPoolId.hashCode());
    result = prime * result + ((sections == null) ? 0 : sections.hashCode());
    result = prime * result + (int) (sendAt ^ (sendAt >>> 32));
    result = prime * result + ((subject == null) ? 0 : subject.hashCode());
    result = prime * result + ((templateId == null) ? 0 : templateId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Mail other = (Mail) obj;
    if (batchId == null) {
      if (other.batchId != null) {
        return false;
      }
    } else if (!batchId.equals(other.batchId)) {
      return false;
    }
    if (categories == null) {
      if (other.categories != null) {
        return false;
      }
    } else if (!categories.equals(other.categories)) {
      return false;
    }
    if (customArgs == null) {
      if (other.customArgs != null) {
        return false;
      }
    } else if (!customArgs.equals(other.customArgs)) {
      return false;
    }
    if (headers == null) {
      if (other.headers != null) {
        return false;
      }
    } else if (!headers.equals(other.headers)) {
      return false;
    }
    if (ipPoolId == null) {
      if (other.ipPoolId != null) {
        return false;
      }
    } else if (!ipPoolId.equals(other.ipPoolId)) {
      return false;
    }
    if (sections == null) {
      if (other.sections != null) {
        return false;
      }
    } else if (!sections.equals(other.sections)) {
      return false;
    }
    if (sendAt != other.sendAt) {
      return false;
    }
    if (subject == null) {
      if (other.subject != null) {
        return false;
      }
    } else if (!subject.equals(other.subject)) {
      return false;
    }
    if (templateId == null) {
      if (other.templateId != null) {
        return false;
      }
    } else if (!templateId.equals(other.templateId)) {
      return false;
    }
    return true;
  }
}
