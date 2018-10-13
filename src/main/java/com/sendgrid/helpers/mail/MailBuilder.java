package com.sendgrid;

import java.util.List;

public final class MailBuilder {

    private Email from;
    private String subject;
    private String templateId;
    private long sendAt;
    private String batchId;
    private String ipPoolId;
    private MailSettings mailSettings;
    private TrackingSettings trackingSettings;
    private Email replyTo;
    private List<Attachments> attachments;

    private MailBuilder() {
    }

    public static MailBuilder aMail() {
        return new MailBuilder();
    }

    public MailBuilder withFrom(Email from) {
        this.from = from;
        return this;
    }

    public MailBuilder withFrom(String email, String name) {
        return withFrom(new Email(email, name));
    }

    public MailBuilder withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public MailBuilder withTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public MailBuilder withSendAt(long sendAt) {
        this.sendAt = sendAt;
        return this;
    }

    public MailBuilder withBatchId(String batchId) {
        this.batchId = batchId;
        return this;
    }

    public MailBuilder withIpPoolId(String ipPoolId) {
        this.ipPoolId = ipPoolId;
        return this;
    }

    public MailBuilder withMailSettings(MailSettings mailSettings) {
        this.mailSettings = mailSettings;
        return this;
    }

    public MailBuilder withTrackingSettings(TrackingSettings trackingSettings) {
        this.trackingSettings = trackingSettings;
        return this;
    }

    public MailBuilder withReplyTo(Email replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    public MailBuilder withReplyTo(String email, String name) {
        return withReplyTo(new Email(email, name));
    }

    public MailBuilder withAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Mail build() {
        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setSubject(subject);
        mail.setTemplateId(templateId);
        mail.setSendAt(sendAt);
        mail.setBatchId(batchId);
        mail.setIpPoolId(ipPoolId);
        mail.setMailSettings(mailSettings);
        mail.setTrackingSettings(trackingSettings);
        mail.setReplyTo(replyTo);
        mail.attachments = attachments;
        return mail;
    }
}
