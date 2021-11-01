package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object representing a collection of different mail settings that you can use to specify how
 * you would like this email to be handled.
 */

@JsonInclude(Include.NON_DEFAULT)
public class MailSettings {

  @JsonProperty("bcc")
  private BccSettings bccSettings;

  @JsonProperty("bypass_list_management")
  private Setting bypassListManagement;

  @JsonProperty("bypass_spam_management")
  private Setting bypassSpamManagement;

  @JsonProperty("bypass_bounce_management")
  private Setting bypassBounceManagement;

  @JsonProperty("bypass_unsubscribe_management")
  private Setting bypassUnsubscribeManagement;

  @JsonProperty("footer")
  private FooterSetting footerSetting;

  @JsonProperty("sandbox_mode")
  private Setting sandBoxMode;

  @JsonProperty("spam_check")
  private SpamCheckSetting spamCheckSetting;

  @JsonProperty("bcc")
  public BccSettings getBccSettings() {
    return bccSettings;
  }

  /**
   * Set the BCC settings.
   *
   * @param bccSettings the BCC settings.
   */
  public void setBccSettings(BccSettings bccSettings) {
    this.bccSettings = bccSettings;
  }

  /**
   * A setting that allows you to bypass all unsubscribe groups and suppressions to ensure that the
   * email is delivered to every single recipient. This should only be used in emergencies when it
   * is absolutely necessary that every recipient receives your email.
   *
   * @return the bypass list setting.
   */

  @JsonProperty("bypass_list_management")
  public Setting getBypassListManagement() {
    return bypassListManagement;
  }

  public void setBypassListManagement(Setting bypassListManagement) {
    this.bypassListManagement = bypassListManagement;
  }

  /**
   * Allows you to bypass the spam report list to ensure that the email is delivered to recipients.
   * Bounce and unsubscribe lists will still be checked; addresses on these other lists will not
   * receive the message.
   *
   * This filter cannot be combined with the bypass_list_management filter.
   * @return the bypass spam setting
   */

  @JsonProperty("bypass_spam_management")
  public Setting getBypassSpamManagement() {
    return bypassSpamManagement;
  }

  public void setBypassSpamManagement(Setting bypassSpamManagement) {
    this.bypassSpamManagement = bypassSpamManagement;
  }

  /**
   * Allows you to bypass the bounce list to ensure that the email is delivered to recipients.
   * Spam report and unsubscribe lists will still be checked; addresses on these other lists
   * will not receive the message.
   *
   * This filter cannot be combined with the bypass_list_management filter.
   * @return the bypass bounce setting
   */
  @JsonProperty("bypass_bounce_management")
  public Setting getBypassBounceManagement() {
    return bypassBounceManagement;
  }
  public void setBypassBounceManagement(Setting bypassBounceManagement) {
    this.bypassBounceManagement = bypassBounceManagement;
  }

  /**
   * Allows you to bypass the global unsubscribe list to ensure that the email is delivered
   * to recipients. Bounce and spam report lists will still be checked; addresses on these
   * other lists will not receive the message. This filter applies only to global unsubscribes
   * and will not bypass group unsubscribes.
   *
   * This filter cannot be combined with the bypass_list_management filter.
   * @return the bypass unsubscribe setting
   */
  @JsonProperty("bypass_unsubscribe_management")
  public Setting getBypassUnsubscribeManagement() {
    return bypassUnsubscribeManagement;
  }

  public void setBypassUnsubscribeManagement(Setting bypassUnsubscribeManagement) {
    this.bypassUnsubscribeManagement = bypassUnsubscribeManagement;
  }

  /**
   * Get the footer settings that you would like included on every email.
   *
   * @return the setting.
   */

  @JsonProperty("footer")
  public FooterSetting getFooterSetting() {
    return footerSetting;
  }

  /**
   * Set the footer settings that you would like included on every email.
   *
   * @param footerSetting the setting.
   */
  public void setFooterSetting(FooterSetting footerSetting) {
    this.footerSetting = footerSetting;
  }

  /**
   * Get sandbox mode. This allows you to send a test email to ensure that your request body is
   * valid and formatted correctly.
   *
   * @return the sandbox mode setting.
   */

  @JsonProperty("sandbox_mode")
  public Setting getSandBoxMode() {
    return sandBoxMode;
  }

  /**
   * Set sandbox mode.
   *
   * @param sandBoxMode the sandbox mode setting.
   */
  @JsonProperty("sandbox_mode")
  public void setSandboxMode(Setting sandBoxMode) {
    this.sandBoxMode = sandBoxMode;
  }

  /**
   * Get the spam check setting. This allows you to test the content of your email for spam.
   *
   * @return the spam check setting.
   */

  @JsonProperty("spam_check")
  public SpamCheckSetting getSpamCheck() {
    return spamCheckSetting;
  }

  /**
   * Set the spam check setting. This allows you to test the content of your email for spam.
   *
   * @param spamCheckSetting the spam check setting.
   */

  public void setSpamCheckSetting(SpamCheckSetting spamCheckSetting) {
    this.spamCheckSetting = spamCheckSetting;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bccSettings == null) ? 0 : bccSettings.hashCode());
    result =
        prime * result + ((bypassListManagement == null) ? 0 : bypassListManagement.hashCode());
    result =
        prime * result + ((bypassSpamManagement == null) ? 0 : bypassSpamManagement.hashCode());
    result =
        prime * result + ((bypassBounceManagement == null) ? 0 : bypassBounceManagement.hashCode());
    result =
        prime * result + ((bypassUnsubscribeManagement == null) ? 0 : bypassUnsubscribeManagement.hashCode());
    result = prime * result + ((footerSetting == null) ? 0 : footerSetting.hashCode());
    result = prime * result + ((sandBoxMode == null) ? 0 : sandBoxMode.hashCode());
    result = prime * result + ((spamCheckSetting == null) ? 0 : spamCheckSetting.hashCode());
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
    MailSettings other = (MailSettings) obj;
    if (bccSettings == null) {
      if (other.bccSettings != null) {
        return false;
      }
    } else if (!bccSettings.equals(other.bccSettings)) {
      return false;
    }
    if (bypassListManagement == null) {
      if (other.bypassListManagement != null) {
        return false;
      }
    } else if (!bypassListManagement.equals(other.bypassListManagement)) {
      return false;
    }
    if (bypassSpamManagement == null) {
      if (other.bypassSpamManagement != null) {
        return false;
      }
    } else if (!bypassSpamManagement.equals(other.bypassSpamManagement)) {
      return false;
    }
    if (bypassBounceManagement == null) {
      if (other.bypassBounceManagement != null) {
        return false;
      }
    } else if (!bypassBounceManagement.equals(other.bypassBounceManagement)) {
      return false;
    }
    if (bypassUnsubscribeManagement == null) {
      if (other.bypassUnsubscribeManagement != null) {
        return false;
      }
    } else if (!bypassUnsubscribeManagement.equals(other.bypassUnsubscribeManagement)) {
      return false;
    }
    if (footerSetting == null) {
      if (other.footerSetting != null) {
        return false;
      }
    } else if (!footerSetting.equals(other.footerSetting)) {
      return false;
    }
    if (sandBoxMode == null) {
      if (other.sandBoxMode != null) {
        return false;
      }
    } else if (!sandBoxMode.equals(other.sandBoxMode)) {
      return false;
    }
    if (spamCheckSetting == null) {
      if (other.spamCheckSetting != null) {
        return false;
      }
    } else if (!spamCheckSetting.equals(other.spamCheckSetting)) {
      return false;
    }
    return true;
  }
}
