package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class Setting {
	@JsonProperty("enable")
	private boolean enable;

	@JsonProperty("enable")
	public boolean getEnable() {
		return this.enable;
	}

	public Setting setEnable(final boolean enable) {
		this.enable = enable;
		return this;
	}
}