package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class OpenTrackingSetting {
	@JsonProperty("enable")
	private boolean enable;
	@JsonProperty("substitution_tag")
	private String substitutionTag;

	@JsonProperty("enable")
	public boolean getEnable() {
		return this.enable;
	}

	public OpenTrackingSetting setEnable(final boolean enable) {
		this.enable = enable;
		return this;
	}

	@JsonProperty("substitution_tag")
	public String getSubstitutionTag() {
		return this.substitutionTag;
	}

	public OpenTrackingSetting setSubstitutionTag(final String substitutionTag) {
		this.substitutionTag = substitutionTag;
		return this;
	}
}