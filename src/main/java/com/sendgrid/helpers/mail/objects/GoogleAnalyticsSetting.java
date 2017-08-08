package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class GoogleAnalyticsSetting {
  @JsonProperty("enable") private boolean enable;
  @JsonProperty("utm_source") private String campaignSource;
  @JsonProperty("utm_term") private String campaignTerm;
  @JsonProperty("utm_content") private String campaignContent;
  @JsonProperty("utm_campaign") private String campaignName;
  @JsonProperty("utm_medium") private String campaignMedium;
 
  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }
  
  public void setEnable(boolean enable) {
    this.enable = enable;
  }
  
  @JsonProperty("utm_source")
  public String getCampaignSource() {
    return campaignSource;
  }

  public void setCampaignSource(String campaignSource) {
    this.campaignSource = campaignSource;
  }
  
  @JsonProperty("utm_term")
  public String getCampaignTerm() {
    return campaignTerm;
  }

  public void setCampaignTerm(String campaignTerm) {
    this.campaignTerm = campaignTerm;
  }
  
  @JsonProperty("utm_content")
  public String getCampaignContent() {
    return campaignContent;
  }
  
  public void setCampaignContent(String campaignContent) {
    this.campaignContent = campaignContent;
  }
  
  @JsonProperty("utm_campaign")
  public String getCampaignName() {
    return campaignName;
  }
  
  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }
  
  @JsonProperty("utm_medium")
  public String getCampaignMedium() {
    return campaignMedium;
  }
  
  public void setCampaignMedium(String campaignMedium) {
    this.campaignMedium = campaignMedium;
  }
}