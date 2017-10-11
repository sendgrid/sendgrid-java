package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object in which you may specify the content of your email. 
 */
@JsonInclude(Include.NON_DEFAULT)
public class Content {

    @JsonProperty("type")
    private String type;

    @JsonProperty("value")
    private String value;

    /**
     * Construct an empty content object.
     */
    public Content() {

    }

    /**
     * Get the mime type of the content you are including 
     * in your email. For example, “text/plain” or “text/html”.
     * @return the mime type.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Set the mime type of the content you are including 
     * in your email. For example, “text/plain” or “text/html”.
     * @param type the mime type.
     */
    public Content type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the actual content of the specified mime type 
     * that you are including in your email.
     * @return the value.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Set the actual content of the specified mime type 
     * that you are including in your email.
     * @param value the value.
     */
    public Content value(String value) {
        this.value = value;
        return this;
    }
}
