package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable model of the Google Analytics settings.
 * This allows for tracking provided by Google, to be used in
 * emails.
 */
@JsonInclude(Include.NON_NULL)
public class GoogleAnalyticsSettings {

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("utm_source")
    private String campaignSource;

    @JsonProperty("utm_term")
    private String campaignTerm;

    @JsonProperty("utm_content")
    private String campaignContent;

    @JsonProperty("utm_campaign")
    private String campaignName;

    @JsonProperty("utm_medium")
    private String campaignMedium;

    /**
     * Gets whether Google Analytics has been enabled.
     *
     * @return {@code true} if Google Analytics has been enabled;
     *         {@code false} otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Sets whether Google Analytics has been enabled.
     *
     * @param enable {@code true} if Google Analytics has been enabled;
     *               {@code false} otherwise.
     * @return {@code this} for chaining.
     */
    public GoogleAnalyticsSettings enable(boolean enable) {
        this.enable = enable;
        return this;
    }

    /**
     * Get the name of the referrer source - for example: {@code Google},
     * {@code SomeDomain.com}, or {@code Marketing Email}.
     *
     * @return the referrer source.
     */
    @JsonProperty("utm_source")
    public String getCampaignSource() {
        return campaignSource;
    }

    /**
     * Set the name of the referrer source.
     *
     * @param campaignSource the referrer source.
     * @return {@code this} for chaining.
     */
    public GoogleAnalyticsSettings campaignSource(String campaignSource) {
        this.campaignSource = campaignSource;
        return this;
    }

    /**
     * Get the term used to identify any paid keywords.
     *
     * @return the term.
     */
    @JsonProperty("utm_term")
    public String getCampaignTerm() {
        return campaignTerm;
    }

    /**
     * Set the term used to identify any paid keywords.
     *
     * @param campaignTerm the term.
     * @return {@code this} for chaining.
     */
    public GoogleAnalyticsSettings campaignTerm(String campaignTerm) {
        this.campaignTerm = campaignTerm;
        return this;
    }

    /**
     * Get the content used to differentiate your campaign
     * from advertisements.
     *
     * @return the content.
     */
    @JsonProperty("utm_content")
    public String getCampaignContent() {
        return campaignContent;
    }

    /**
     * Set the content used to differentiate your campaign
     * from advertisements.
     *
     * @param campaignContent the content.
     * @return {@code this} for chaining.
     */
    public GoogleAnalyticsSettings campaignContent(String campaignContent) {
        this.campaignContent = campaignContent;
        return this;
    }

    /**
     * Get the name of the campaign.
     *
     * @return the name.
     */
    @JsonProperty("utm_campaign")
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Set the name of the campaign.
     *
     * @param campaignName the name.
     * @return {@code this} for chaining.
     */
    public GoogleAnalyticsSettings campaignName(String campaignName) {
        this.campaignName = campaignName;
        return this;
    }

    /**
     * Get the name of the marketing medium - for example, {@code Email}.
     *
     * @return the medium name.
     */
    @JsonProperty("utm_medium")
    public String getCampaignMedium() {
        return campaignMedium;
    }

    /**
     * Set the name of the marketing medium - for example, {@code Email}.
     *
     * @param campaignMedium the medium name.
     * @return {@code this} for chaining.
     */
    public GoogleAnalyticsSettings campaignMedium(String campaignMedium) {
        this.campaignMedium = campaignMedium;
        return this;
    }
}
