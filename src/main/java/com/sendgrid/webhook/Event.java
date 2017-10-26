package com.sendgrid.webhook;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonTypeInfo(use = Id.NAME,
              include = As.PROPERTY,
              property = "event")
@JsonSubTypes({@Type(value = ProcessedEvent.class,
                     name = "processed"),
                  @Type(value = DroppedEvent.class,
                        name = "dropped"),
                  @Type(value = DeliveredEvent.class,
                        name = "delivered"),
                  @Type(value = DeferredEvent.class,
                        name = "deferred"),
                  @Type(value = BounceEvent.class,
                        name = "bounce"),
                  @Type(value = OpenEvent.class,
                        name = "open"),
                  @Type(value = ClickEvent.class,
                        name = "click"),
                  @Type(value = SpamReportEvent.class,
                        name = "spamreport"),
                  @Type(value = UnsubscribeEvent.class,
                        name = "unsubscribe"),
                  @Type(value = GroupUnsubscribeEvent.class,
                        name = "group_unsubscribe"),
                  @Type(value = GroupResubscribeEvent.class,
                        name = "group_resubscribe"),})
public abstract class Event {

  @JsonProperty("event")
  protected String event;
  @JsonProperty("sg_event_id")
  protected String eventId;
  @JsonProperty("sg_message_id")
  protected String messageId;
  @JsonProperty("category")
  protected List<String> categories;
  @JsonIgnore
  protected Map<String, Object> customArguments = new HashMap<>();

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public List<String> getCategories() {
    return categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public Map<String, Object> getCustomArguments() {
    return customArguments;
  }

  @JsonAnySetter
  public void handleUnknown(String name, Object value) {
    customArguments.put(name, value);
  }
}
