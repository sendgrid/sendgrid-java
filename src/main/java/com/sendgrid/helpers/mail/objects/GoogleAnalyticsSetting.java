package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object configuring the tracking provided by Google Analytics.
 */
@JsonInclude(Include.NON_EMPTY)
public class GoogleAnalyticsSetting {

  @JsonProperty("enable")
  private boolean enable;

  @JsonProperty("utm_source")
  private String campaignSource;

  @JsonProperty("utm_term")
  private String campaignTerm;

  @JsonProperty("utm_content")
  private String campaignContent;

  @JsonProperty("utm_campaign")
  private String campaignName;

  @JsonProperty("utm_medium")
  private String campaignMedium;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((campaignContent == null) ? 0 : campaignContent.hashCode());
    result = prime * result + ((campaignMedium == null) ? 0 : campaignMedium.hashCode());
    result = prime * result + ((campaignName == null) ? 0 : campaignName.hashCode());
    result = prime * result + ((campaignSource == null) ? 0 : campaignSource.hashCode());
    result = prime * result + ((campaignTerm == null) ? 0 : campaignTerm.hashCode());
    result = prime * result + (enable ? 1231 : 1237);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    GoogleAnalyticsSetting other = (GoogleAnalyticsSetting) obj;
    if (campaignContent == null) {
      if (other.campaignContent != null) {
        return false;
      }
    } else if (!campaignContent.equals(other.campaignContent)) {
      return false;
    }
    if (campaignMedium == null) {
      if (other.campaignMedium != null) {
        return false;
      }
    } else if (!campaignMedium.equals(other.campaignMedium)) {
      return false;
    }
    if (campaignName == null) {
      if (other.campaignName != null) {
        return false;
      }
    } else if (!campaignName.equals(other.campaignName)) {
      return false;
    }
    if (campaignSource == null) {
      if (other.campaignSource != null) {
        return false;
      }
    } else if (!campaignSource.equals(other.campaignSource)) {
      return false;
    }
    if (campaignTerm == null) {
      if (other.campaignTerm != null) {
        return false;
      }
    } else if (!campaignTerm.equals(other.campaignTerm)) {
      return false;
    }
    if (enable != other.enable) {
      return false;
    }
    return true;
  }
}