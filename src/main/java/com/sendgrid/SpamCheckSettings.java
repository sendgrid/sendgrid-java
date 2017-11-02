package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A setting object that allows you to test the content of 
 * your email for spam.
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
     * Determines if this setting is enabled.
     * @return true if spam checking is enabled, false otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Set if this setting is enabled.
     * @param enable true if spam checking is enabled, false otherwise.
     * @return this object.
     */
    public SpamCheckSettings enable(boolean enable) {
        this.enable = enable;
        return this;
    }

    /**
     * Get the the threshold used to determine if your content 
     * qualifies as spam on a scale from 1 to 10, with 10 being 
     * most strict, or most likely to be considered as spam.
     * @return the threshold.
     */
    @JsonProperty("threshold")
    public int getSpamThreshold() {
        return spamThreshold;
    }

    /**
     * Set the spam check threshold.
     * @param spamThreshold the threshold.
     * @return this object.
     */
    public SpamCheckSettings spamThreshold(int spamThreshold) {
        this.spamThreshold = spamThreshold;
        return this;
    }

    /**
     * Get the Inbound Parse URL that you would like a copy of 
     * your email along with the spam report to be sent to.
     * @return a URL.
     */
    @JsonProperty("post_to_url")
    public String getPostToUrl() {
        return postToUrl;
    }

    /**
     * Set the Inbout Parse URL.
     * @param postToUrl a URL.
     * @return this object.
     */
    public SpamCheckSettings postToUrl(String postToUrl) {
        this.postToUrl = postToUrl;
        return this;
    }
}
