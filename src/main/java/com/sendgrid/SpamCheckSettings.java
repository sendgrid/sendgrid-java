package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable model of the spam checking setting.
 * This allows for email contents to be checked against
 * criteria set out, to prevent spam.
 */
@JsonInclude(Include.NON_NULL)
public class SpamCheckSettings {

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("threshold")
    private int spamThreshold;

    @JsonProperty("post_to_url")
    private String postToUrl;

    /**
     * Gets whether spam checking has been enabled.
     *
     * @return {@code true} if spam checking has been enabled;
     *         {@code false} otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Sets whether spam checking has been enabled.
     *
     * @param enable {@code true} if spam checking has been enabled;
     *               {@code false} otherwise.
     * @return {@code this} for chaining.
     */
    public SpamCheckSettings enable(boolean enable) {
        this.enable = enable;
        return this;
    }

    /**
     * Gets the the threshold used to determine if your content
     * qualifies as spam on a scale from 1 to 10, with 10 being 
     * most strict, or most likely to be considered as spam.
     *
     * @return the threshold.
     */
    @JsonProperty("threshold")
    public int getSpamThreshold() {
        return spamThreshold;
    }

    /**
     * Sets the spam check threshold.
     *
     * @param spamThreshold the threshold.
     * @return {@code this} for chaining.
     */
    public SpamCheckSettings spamThreshold(int spamThreshold) {
        this.spamThreshold = spamThreshold;
        return this;
    }

    /**
     * Gets the Inbound Parse URL that you would like a copy of
     * your email along with the spam report to be sent to.
     *
     * @return a URL.
     */
    @JsonProperty("post_to_url")
    public String getPostToUrl() {
        return postToUrl;
    }

    /**
     * Sets the Inbound Parse URL.
     *
     * @param postToUrl a URL.
     * @return {@code this} for chaining.
     */
    public SpamCheckSettings postToUrl(String postToUrl) {
        this.postToUrl = postToUrl;
        return this;
    }
}
