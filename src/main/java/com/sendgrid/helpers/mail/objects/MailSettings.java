package com.sendgrid.helpers.mail.objects;

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
}