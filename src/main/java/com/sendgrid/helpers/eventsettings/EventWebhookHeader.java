package com.sendgrid.helpers.eventsettings;

public enum EventWebhookHeader {
    SIGNATURE("X-Twilio-Email-Event-Webhook-Signature"), TIMESTAMP("X-Twilio-Email-Event-Webhook-Timestamp");

    public String name;

    EventWebhookHeader(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
