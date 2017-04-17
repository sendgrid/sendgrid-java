package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
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
		return this.enable;
	}

	public void setEnable(final boolean enable) {
		this.enable = enable;
	}

	@JsonProperty("utm_source")
	public String getCampaignSource() {
		return this.campaignSource;
	}

	public GoogleAnalyticsSetting setCampaignSource(final String campaignSource) {
		this.campaignSource = campaignSource;
		return this;
	}

	@JsonProperty("utm_term")
	public String getCampaignTerm() {
		return this.campaignTerm;
	}

	public GoogleAnalyticsSetting setCampaignTerm(final String campaignTerm) {
		this.campaignTerm = campaignTerm;
		return this;
	}

	@JsonProperty("utm_content")
	public String getCampaignContent() {
		return this.campaignContent;
	}

	public GoogleAnalyticsSetting setCampaignContent(final String campaignContent) {
		this.campaignContent = campaignContent;
		return this;
	}

	@JsonProperty("utm_campaign")
	public String getCampaignName() {
		return this.campaignName;
	}

	public GoogleAnalyticsSetting setCampaignName(final String campaignName) {
		this.campaignName = campaignName;
		return this;
	}

	@JsonProperty("utm_medium")
	public String getCampaignMedium() {
		return this.campaignMedium;
	}

	public GoogleAnalyticsSetting setCampaignMedium(final String campaignMedium) {
		this.campaignMedium = campaignMedium;
		return this;
	}
}