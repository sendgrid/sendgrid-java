package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class MailSettings {
  @JsonProperty("bcc") private BccSettings bccSettings;
  @JsonProperty("bypass_list_management") private Setting bypassListManagement;
  @JsonProperty("footer") private FooterSetting footerSetting;
  @JsonProperty("sandbox_mode") private Setting sandBoxMode;
  @JsonProperty("spam_check") private SpamCheckSetting spamCheckSetting;

  @JsonProperty("bcc")
  public BccSettings getBccSettings() {
    return bccSettings;
  }
  
  public void setBccSettings(BccSettings bccSettings) {
    this.bccSettings = bccSettings;
  }
  
  @JsonProperty("bypass_list_management")
  public Setting getBypassListManagement() {
    return bypassListManagement;
  }

  public void setBypassListManagement(Setting bypassListManagement) {
    this.bypassListManagement = bypassListManagement;
  }
  
  @JsonProperty("footer")
  public FooterSetting getFooterSetting() {
    return footerSetting;
  }
  
  public void setFooterSetting(FooterSetting footerSetting) {
    this.footerSetting = footerSetting;
  }
  
  @JsonProperty("sandbox_mode")
  public Setting getSandBoxMode() {
    return sandBoxMode;
  }
  
  public void setSandboxMode(Setting sandBoxMode) {
    this.sandBoxMode = sandBoxMode;
  }
  
  @JsonProperty("spam_check")
  public SpamCheckSetting getSpamCheck() {
    return spamCheckSetting;
  }
  
  public void setSpamCheckSetting(SpamCheckSetting spamCheckSetting) {
    this.spamCheckSetting = spamCheckSetting;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bccSettings == null) ? 0 : bccSettings.hashCode());
    result = prime * result + ((bypassListManagement == null) ? 0 : bypassListManagement.hashCode());
    result = prime * result + ((footerSetting == null) ? 0 : footerSetting.hashCode());
    result = prime * result + ((sandBoxMode == null) ? 0 : sandBoxMode.hashCode());
    result = prime * result + ((spamCheckSetting == null) ? 0 : spamCheckSetting.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MailSettings other = (MailSettings) obj;
    if (bccSettings == null) {
      if (other.bccSettings != null)
        return false;
    } else if (!bccSettings.equals(other.bccSettings))
      return false;
    if (bypassListManagement == null) {
      if (other.bypassListManagement != null)
        return false;
    } else if (!bypassListManagement.equals(other.bypassListManagement))
      return false;
    if (footerSetting == null) {
      if (other.footerSetting != null)
        return false;
    } else if (!footerSetting.equals(other.footerSetting))
      return false;
    if (sandBoxMode == null) {
      if (other.sandBoxMode != null)
        return false;
    } else if (!sandBoxMode.equals(other.sandBoxMode))
      return false;
    if (spamCheckSetting == null) {
      if (other.spamCheckSetting != null)
        return false;
    } else if (!spamCheckSetting.equals(other.spamCheckSetting))
      return false;
    return true;
  }
}
