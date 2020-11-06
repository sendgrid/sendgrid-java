package com.sendgrid.helpers.eventwebhook;

/**
 * This enum lists headers that get posted to the webhook. Read the docs for
 * more details: https://sendgrid.com/docs/for-developers/tracking-events/event.
 */
public enum EventWebhookHeader {
    SIGNATURE("X-Twilio-Email-Event-Webhook-Signature"), TIMESTAMP("X-Twilio-Email-Event-Webhook-Timestamp");

    public final String name;

    EventWebhookHeader(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
