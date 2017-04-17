package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class MailSettings {
	@JsonProperty("bcc")
	private BccSettings bccSettings;
	@JsonProperty("bypass_list_management")
	private Setting bypassListManagement;
	@JsonProperty("footer")
	private FooterSetting footerSetting;
	@JsonProperty("sandbox_mode")
	private Setting sandBoxMode;
	@JsonProperty("spam_check")
	private SpamCheckSetting spamCheckSetting;

	@JsonProperty("bcc")
	public BccSettings getBccSettings() {
		return this.bccSettings;
	}

	public MailSettings setBccSettings(final BccSettings bccSettings) {
		this.bccSettings = bccSettings;
		return this;
	}

	@JsonProperty("bypass_list_management")
	public Setting getBypassListManagement() {
		return this.bypassListManagement;
	}

	public MailSettings setBypassListManagement(final Setting bypassListManagement) {
		this.bypassListManagement = bypassListManagement;
		return this;
	}

	@JsonProperty("footer")
	public FooterSetting getFooterSetting() {
		return this.footerSetting;
	}

	public MailSettings setFooterSetting(final FooterSetting footerSetting) {
		this.footerSetting = footerSetting;
		return this;
	}

	@JsonProperty("sandbox_mode")
	public Setting getSandBoxMode() {
		return this.sandBoxMode;
	}

	public MailSettings setSandboxMode(final Setting sandBoxMode) {
		this.sandBoxMode = sandBoxMode;
		return this;
	}

	@JsonProperty("spam_check")
	public SpamCheckSetting getSpamCheck() {
		return this.spamCheckSetting;
	}

	public MailSettings setSpamCheckSetting(final SpamCheckSetting spamCheckSetting) {
		this.spamCheckSetting = spamCheckSetting;
		return this;
	}
}