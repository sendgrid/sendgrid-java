package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable model of the settings associated with
 * a given {@link Mail}.
 */
@JsonInclude(Include.NON_DEFAULT)
public class MailSettings {

    @JsonProperty("bcc")
    private BCCSettings bccSettings;

    @JsonProperty("bypass_list_management")
    private Setting bypassListManagement;

    @JsonProperty("footer")
    private FooterSettings footerSettings;

    @JsonProperty("sandbox_mode")
    private Setting sandBoxMode;

    @JsonProperty("spam_check")
    private SpamCheckSettings spamCheckSettings;

    /**
     * Gets the BCC settings.
     *
     * @return the BCC settings.
     */
    @JsonProperty("bcc")
    public BCCSettings getBccSettings() {
        return bccSettings;
    }

    /**
     * Sets the BCC settings.
     *
     * @param bccSettings the BCC settings.
     * @return {@code this} for chaining.
     */
    public MailSettings bccSettings(BCCSettings bccSettings) {
        this.bccSettings = bccSettings;
        return this;
    }

    /**
     * A setting that allows you to bypass all unsubscribe 
     * groups and suppressions to ensure that the email is
     * delivered to every single recipient. This should only 
     * be used in emergencies when it is absolutely necessary 
     * that every recipient receives your email.
     *
     * @return the bypass list setting.
     */
    @JsonProperty("bypass_list_management")
    public Setting getBypassListManagement() {
        return bypassListManagement;
    }

    /**
     * Sets the bypass setting.
     *
     * @param bypassListManagement the setting.
     * @return {@code this} for chaining.
     */
    public MailSettings bypassListManagement(Setting bypassListManagement) {
        this.bypassListManagement = bypassListManagement;
        return this;
    }

    /**
     * Gets the the footer settings that you would like included on every email.
     *
     * @return the settings.
     */
    @JsonProperty("footer")
    public FooterSettings getFooterSettings() {
        return footerSettings;
    }

    /**
     * Sets the the footer settings that you would like included on every email.
     *
     * @param footerSettings the settings.
     * @return {@code this} for chaining.
     */
    public MailSettings footerSettings(FooterSettings footerSettings) {
        this.footerSettings = footerSettings;
        return this;
    }

    /**
     * Gets sandbox mode. This allows you to send a test email to
     * ensure that your request body is valid and formatted correctly.
     *
     * @return the sandbox mode setting.
     */
    @JsonProperty("sandbox_mode")
    public Setting getSandBoxMode() {
        return sandBoxMode;
    }

    /**
     * Sets sandbox mode.
     *
     * @param sandBoxMode the sandbox mode setting.
     * @return {@code this} for chaining.
     */
    @JsonProperty("sandbox_mode")
    public MailSettings sandboxMode(Setting sandBoxMode) {
        this.sandBoxMode = sandBoxMode;
        return this;
    }

    /**
     * Gets the spam check settings. This allows you to test the
     * content of your email for spam.
     *
     * @return the spam check settings.
     */
    @JsonProperty("spam_check")
    public SpamCheckSettings getSpamCheckSettings() {
        return spamCheckSettings;
    }

    /**
     * Sets the spam check settings. This allows you to test the
     * content of your email for spam.
     *
     * @param spamCheckSettings the spam check settings.
     * @return {@code this} for chaining.
     */
    public MailSettings spamCheckSettings(SpamCheckSettings spamCheckSettings) {
        this.spamCheckSettings = spamCheckSettings;
        return this;
    }
}
