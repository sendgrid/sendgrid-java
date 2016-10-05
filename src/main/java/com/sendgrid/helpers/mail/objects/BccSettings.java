package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class BccSettings {
	@JsonProperty("enable")
	private boolean enable;
	@JsonProperty("email")
	private String email;

	@JsonProperty("enable")
	public boolean getEnable() {
		return this.enable;
	}

	public BccSettings setEnable(final boolean enable) {
		this.enable = enable;
		return this;
	}

	@JsonProperty("email")
	public String getEmail() {
		return this.email;
	}

	public BccSettings setEmail(final String email) {
		this.email = email;
		return this;
	}
}