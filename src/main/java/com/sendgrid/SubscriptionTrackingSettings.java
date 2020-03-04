package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A subscription tracking setting object. Subscription tracking 
 * allows you to insert a subscription management link at the 
 * bottom of the text and html bodies of your email. If you 
 * would like to specify the location of the link within your 
 * email, you may use the substitution_tag.
 */
@JsonInclude(Include.NON_NULL)
public class SubscriptionTrackingSettings {

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("text")
    private String text;

    @JsonProperty("html")
    private String html;

    @JsonProperty("substitution_tag")
    private String substitutionTag;

    /**
     * Gets whether subscription tracking has been enabled.
     *
     * @return {@code true} if subscription tracking has been enabled;
     *         {@code false} otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Sets whether subscription tracking is enabled.
     *
     * @param enable {@code true} if subscription tracking is to be enabled;
     *               {@code false} otherwise.
     * @return {@code this} for chaining.
     */
    public SubscriptionTrackingSettings enable(boolean enable) {
        this.enable = enable;
        return this;
    }

    /**
     * Gets the plain text to be appended to the email, with the
     * subscription tracking link. You may control where 
     * the link is by using the tag {@code <% %>}.
     *
     * @return the plain text.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /** 
     * Sets the plain text.
     *
     * @param text the plain text.
     * @return {@code this} for chaining.
     */
    public SubscriptionTrackingSettings text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Gets the HTML to be appended to the email, with the
     * subscription tracking link. You may control where 
     * the link is by using the tag {@code <% %>}.
     *
     * @return the HTML.
     */
    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    /**
     * Sets the HTML.
     *
     * @param html the HTML.
     * @return {@code this} for chaining.
     */
    public SubscriptionTrackingSettings html(String html) {
        this.html = html;
        return this;
    }

    /**
     * Gets the tag that will be replaced with the
     * unsubscribe URL. for example: {@code [unsubscribe_url]}.
     * If this parameter is used, it will override both 
     * the text and html parameters. The URL of the link 
     * will be placed at the substitution tag’s location, 
     * with no additional formatting.
     *
     * @return the substitution tag.
     */
    @JsonProperty("substitution_tag")
    public String getSubstitutionTag() {
        return substitutionTag;
    }

    /**
     * Sets the substitution tag.
     *
     * @param substitutionTag the substitution tag.
     * @return {@code this} for chaining.
     */
    public SubscriptionTrackingSettings substitutionTag(String substitutionTag) {
        this.substitutionTag = substitutionTag;
        return this;
    }
}
