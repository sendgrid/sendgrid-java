package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class Content {
	@JsonProperty("type")
	private String type;
	@JsonProperty("value")
	private String value;

	public Content() {
	}

	public Content(final String type, final String value) {
		this.setType(type);
		this.setValue(value);
	}

	@JsonProperty("type")
	public String getType() {
		return this.type;
	}

	public Content setType(final String type) {
		this.type = type;
		return this;
	}

	@JsonProperty("value")
	public String getValue() {
		return this.value;
	}

	public Content setValue(final String value) {
		this.value = value;
		return this;
	}
}