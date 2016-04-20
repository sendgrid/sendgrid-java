package com.sendgrid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class FooterSetting {
    @JsonProperty("enable") private boolean enable;
    @JsonProperty("text") private String text;
    @JsonProperty("html") private String html;
    
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    public void setHtml(String html) {
        this.html = html;
    }
    
    @JsonProperty("html")
    public String getHtml() {
        return html;
    }
}