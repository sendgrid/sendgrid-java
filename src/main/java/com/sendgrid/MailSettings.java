package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object representing a collection of different mail 
 * settings that you can use to specify how you would 
 * like this email to be handled.
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
     * Get the BCC settings.
     * @return the BCC settings.
     */
    @JsonProperty("bcc")
    public BCCSettings getBccSettings() {
        return bccSettings;
    }

    /**
     * Set the BCC settings.
     * @param bccSettings the BCC settings.
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
     * @return the bypass list setting.
     */
    @JsonProperty("bypass_list_management")
    public Setting getBypassListManagement() {
        return bypassListManagement;
    }

    /**
     * Set the bypass setting.
     * @param bypassListManagement the setting.
     */
    public MailSettings bypassListManagement(Setting bypassListManagement) {
        this.bypassListManagement = bypassListManagement;
        return this;
    }

    /**
     * Get the the footer settings that you would like included on every email.
     * @return the settings.
     */
    @JsonProperty("footer")
    public FooterSettings getFooterSettings() {
        return footerSettings;
    }

    /**
     * Set the the footer settings that you would like included on every email.
     * @param footerSettings the settings.
     */
    public MailSettings footerSettings(FooterSettings footerSettings) {
        this.footerSettings = footerSettings;
        return this;
    }

    /**
     * Get sandbox mode. This allows you to send a test email to 
     * ensure that your request body is valid and formatted correctly.
     * @return the sandbox mode setting.
     */
    @JsonProperty("sandbox_mode")
    public Setting getSandBoxMode() {
        return sandBoxMode;
    }

    /**
     * Set sandbox mode. 
     * @param sandBoxMode the sandbox mode setting.
     */
    @JsonProperty("sandbox_mode")
    public MailSettings sandboxMode(Setting sandBoxMode) {
        this.sandBoxMode = sandBoxMode;
        return this;
    }

    /**
     * Get the spam check settings. This allows you to test the 
     * content of your email for spam.
     * @return the spam check settings.
     */
    @JsonProperty("spam_check")
    public SpamCheckSettings getSpamCheckSettings() {
        return spamCheckSettings;
    }

    /**
     * Set the spam check settings. This allows you to test the 
     * content of your email for spam.
     * @param spamCheckSettings the spam check settings.
     */
    public MailSettings spamCheckSettings(SpamCheckSettings spamCheckSettings) {
        this.spamCheckSettings = spamCheckSettings;
        return this;
    }
}
