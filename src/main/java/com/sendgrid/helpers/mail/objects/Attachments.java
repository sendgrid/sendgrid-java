package com.sendgrid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class Attachments {
    @JsonProperty("content") private String content;
    @JsonProperty("type") private String type;
    @JsonProperty("filename") private String filename;
    @JsonProperty("disposition") private String disposition;
    @JsonProperty("content_id") private String contentId;

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("content") 
    public String getContent() {
        return content;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("type") 
    public String getType() {
        return type;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("filename") 
    public String getFilename() {
        return filename;
    }
    
    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    @JsonProperty("disposition") 
    public String getDisposition() {
        return disposition;
    }
    
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    @JsonProperty("content_id") 
    public String getContentId() {
        return contentId;
    }
}