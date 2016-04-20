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
    
    public void setBccSettings(BccSettings bccSettings) {
        this.bccSettings = bccSettings;
    }
    
    @JsonProperty("bcc")
    public BccSettings getBccSettings() {
        return bccSettings;
    }

    public void setBypassListManagement(Setting bypassListManagement) {
        this.bypassListManagement = bypassListManagement;
    }
    
    @JsonProperty("bypass_list_management")
    public Setting getBypassListManagement() {
        return bypassListManagement;
    }
    
    public void setFooterSetting(FooterSetting footerSetting) {
        this.footerSetting = footerSetting;
    }
    
    @JsonProperty("footer")
    public FooterSetting getFooterSetting() {
        return footerSetting;
    }
    
    public void setSandboxMode(Setting sandBoxMode) {
        this.sandBoxMode = sandBoxMode;
    }
    
    @JsonProperty("sandbox_mode")
    public Setting getSandBoxMode() {
        return sandBoxMode;
    }
    
    public void setSpamCheckSetting(SpamCheckSetting spamCheckSetting) {
        this.spamCheckSetting = spamCheckSetting;
    }
    
    @JsonProperty("spam_check")
    public SpamCheckSetting getSpamCheck() {
        return spamCheckSetting;
    }
}