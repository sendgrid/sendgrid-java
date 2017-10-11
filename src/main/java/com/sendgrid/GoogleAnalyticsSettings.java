package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object configuring the tracking provided by Google Analytics.
 */
@JsonInclude(Include.NON_DEFAULT)
public class GoogleAnalyticsSetting {
  @JsonProperty("enable") private boolean enable;
  @JsonProperty("utm_source") private String campaignSource;
  @JsonProperty("utm_term") private String campaignTerm;
  @JsonProperty("utm_content") private String campaignContent;
  @JsonProperty("utm_campaign") private String campaignName;
  @JsonProperty("utm_medium") private String campaignMedium;
 
  /**
   * Get whether or not this setting is enabled.
   * @return true if enabled, false otherwise.
   */
  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }
  
  /**
   * Set whether or not this setting is enabled.
   * @param enable true if enabled, false otherwise.
   */
  public void setEnable(boolean enable) {
    this.enable = enable;
  }
  
  /**
   * Get the name of the referrer source. 
   * (e.g. Google, SomeDomain.com, or Marketing Email)
   * @return the referrer source.
   */
  @JsonProperty("utm_source")
  public String getCampaignSource() {
    return campaignSource;
  }

  /**
   * Set the name of the referrer source. 
   * @param campaignSource the referrer source.
   */
  public void setCampaignSource(String campaignSource) {
    this.campaignSource = campaignSource;
  }
  
  /**
   * Get the term used to identify any paid keywords.
   * @return the term.
   */
  @JsonProperty("utm_term")
  public String getCampaignTerm() {
    return campaignTerm;
  }

  /**
   * Set the term used to identify any paid keywords.
   * @param campaignTerm the term.
   */
  public void setCampaignTerm(String campaignTerm) {
    this.campaignTerm = campaignTerm;
  }
  
  /**
   * Get the content Used to differentiate your campaign 
   * from advertisements.
   * @return the content.
   */
  @JsonProperty("utm_content")
  public String getCampaignContent() {
    return campaignContent;
  }
  
  /**
   * Set the content Used to differentiate your campaign 
   * from advertisements.
   * @param campaignContent the content.
   */
  public void setCampaignContent(String campaignContent) {
    this.campaignContent = campaignContent;
  }
  
  /**
   * Get the name of the campaign.
   * @return the name.
   */
  @JsonProperty("utm_campaign")
  public String getCampaignName() {
    return campaignName;
  }
  
  /**
   * Set the name of the campaign.
   * @param campaignName the name.
   */
  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }
  
  /**
   * Get the name of the marketing medium. (e.g. Email)
   * @return the medium name.
   */
  @JsonProperty("utm_medium")
  public String getCampaignMedium() {
    return campaignMedium;
  }
  
  /**
   * Set the name of the marketing medium. (e.g. Email)
   * @param campaignMedium the medium name.
   */
  public void setCampaignMedium(String campaignMedium) {
    this.campaignMedium = campaignMedium;
  }
}
