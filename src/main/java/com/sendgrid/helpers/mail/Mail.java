package com.sendgrid;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.*;
import java.util.*;

@JsonInclude(Include.NON_DEFAULT)
public class Mail {
    @JsonProperty("from") private Email from;
    @JsonProperty("subject") private String subject;
    @JsonProperty("personalization") private List<Personalization> personalization;
    @JsonProperty("content") private List<Content> content;
    @JsonProperty("attachments") private List<Attachments> attachments;
    @JsonProperty("template_id") private String templateId;
    @JsonProperty("sections") private Map<String,String> sections;
    @JsonProperty("headers") private Map<String,String> headers;
    @JsonProperty("categories") private List<String> categories;
    @JsonProperty("custom_args") private Map<String,String> customArgs;
    @JsonProperty("send_at") private long sendAt;
    @JsonProperty("batch_id") private String batchId;
    @JsonProperty("asm") private ASM asm;
    @JsonProperty("ip_pool_id") private int ipPoolId;
    @JsonProperty("mail_settings") private MailSettings mailSettings;
    @JsonProperty("tracking_settings") private TrackingSettings trackingSettings;
    @JsonProperty("reply_to") private Email replyTo;
    
    public void setFrom(Email from) {
        this.from = from;
    }
    
    @JsonProperty("from")
    public Email getFrom(Email from) {
        return from;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    public void setASM(ASM asm){
        this.asm = asm;
    }
    
    @JsonProperty("asm")
    public ASM getASM() {
        return asm;
    }
    
    @JsonProperty("personalization")
    public List<Personalization> getPersonalization(){
        return personalization;
    }
    
    public void addPersonalization(Personalization personalization){
        if(this.personalization == null){
            this.personalization = new ArrayList<Personalization>();
            this.personalization.add(personalization);
        } else {
            this.personalization.add(personalization);
        }
    }

    @JsonProperty("content")
    public List<Content> getContent(){
        return content;
    }
    
    public void addContent(Content content){
        Content c = new Content();
        c.setType(content.getType());
        c.setValue(content.getValue());
        if(this.content == null){
            this.content = new ArrayList<Content>();
            this.content.add(c);
        } else {
            this.content.add(c);
        }
    }

    @JsonProperty("attachments")
    public List<Attachments> getAttachments(){
        return attachments;
    }
    
    public void addAttachments(Attachments attachments){
        Attachments a = new Attachments();
        a.setContent(attachments.getContent());
        a.setType(attachments.getType());
        a.setFilename(attachments.getFilename());
        a.setDisposition(attachments.getDisposition());
        a.setContentId(attachments.getContentId());
        if(this.attachments == null){
            this.attachments = new ArrayList<Attachments>();
            this.attachments.add(a);
        } else {
            this.attachments.add(a);
        }
    }
    
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
    
    @JsonProperty("template_id")
    public String getTemplateId() {
        return this.templateId;
    }
    
    public void addSection(String key, String value) {
        if(sections == null){
            sections = new HashMap<String,String>();
            sections.put(key, value);
        } else {
            sections.put(key, value);
        }
    }
    
    @JsonProperty("sections")
    public Map<String,String> getSections() {
        return sections;
    }
 
    public void addHeader(String key, String value) {
        if(headers == null){
            headers = new HashMap<String,String>();
            headers.put(key, value);
        } else {
            headers.put(key, value);
        }
    }
    
    @JsonProperty("headers")
    public Map<String,String> getHeaders() {
        return headers;
    }
    
    public void addCategory(String category) {
        if(categories == null){
            categories = new ArrayList<String>();
            categories.add(category);
        } else {
            categories.add(category);
        }        
    }
    
    @JsonProperty("categories") 
    public List<String> getCategories() {
        return categories;
    }
    
    public void addCustomArg(String key, String value) {
        if(customArgs == null){
            customArgs = new HashMap<String,String>();
            customArgs.put(key, value);
        } else {
            customArgs.put(key, value);
        }
    }
    
    @JsonProperty("custom_args")
    public Map<String,String> getCustomArgs() {
        return customArgs;
    }
    
    public void setSendAt(long sendAt) {
        this.sendAt = sendAt;
    }
    
    @JsonProperty("send_at")
    public long sendAt() {
        return sendAt;
    }
    
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
    
    @JsonProperty("batch_id")
    public String getBatchId() {
        return batchId;
    }
    
    public void setIpPoolId(int ipPoolId) {
        this.ipPoolId = ipPoolId;
    }
    
    @JsonProperty("ip_pool_id")
    public int getIpPoolId() {
        return ipPoolId;
    }
    
    public void setMailSettings(MailSettings mailSettings) {
        this.mailSettings = mailSettings;
    }
    
    @JsonProperty("mail_settings")
    public MailSettings getMailSettings() {
        return mailSettings;
    }

    public void setTrackingSettings(TrackingSettings trackingSettings) {
        this.trackingSettings = trackingSettings;
    }
    
    @JsonProperty("tracking_settings")
    public TrackingSettings getTrackingSettings() {
        return trackingSettings;
    }
    
    public void setReplyTo(Email replyTo) {
        this.replyTo = replyTo;
    }
    
    @JsonProperty("reply_to")
    public Email getReplyto() {
        return replyTo;
    }
    
    public String build() throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (IOException ex) {
            throw ex;
        }
    }
}