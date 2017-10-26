package com.sendgrid.webhook;

public enum EventTypeEnum {
  PROCESSED("processed"),
  DROPPED("dropped"),
  DELIVERED("delivered"),
  DEFERRED("deferred"),
  BOUNCE("bounce"),
  OPEN("open"),
  CLICK("click"),
  SPAMREPORT("spamreport"),
  UNSUBSCRIBE("unsubscribe"),
  GROUP_UNSUBSCRIBE("group_unsubscribe"),
  GROUP_RESUBSCRIBE("group_resubscribe");

  private final String event;

  EventTypeEnum(String event) {
    this.event = event;
  }

  public String getEvent() {
    return event;
  }
}
