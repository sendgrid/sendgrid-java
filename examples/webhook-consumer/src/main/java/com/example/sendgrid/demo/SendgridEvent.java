package com.example.sendgrid.demo;

public class SendgridEvent {

    private String email;

    private long timestamp;

    private String smtpId;

    private String event;

    private String category;

    public String getEmail() {
        return email;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSmtpId() {
        return smtpId;
    }

    public String getEvent() {
        return event;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "SendgridEvent{" +
                "email='" + email + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", smtpId='" + smtpId + '\'' +
                ", event='" + event + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
