package com.sendgrid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class SpamCheckSetting {
    @JsonProperty("enable") private boolean enable;
    @JsonProperty("threshold") private int spamThreshold;
    @JsonProperty("post_to_url") private String postToUrl;
    
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }
    
    public void setSpamThreshold(int spamThreshold) {
        this.spamThreshold = spamThreshold;
    }
    
    @JsonProperty("threshold")
    public int getSpamThreshold() {
        return spamThreshold;
    }
    
    public void setPostToUrl(String postToUrl) {
        this.postToUrl = postToUrl;
    }
    
    @JsonProperty("post_to_url")
    public String getPostToUrl() {
        return postToUrl;
    }
}