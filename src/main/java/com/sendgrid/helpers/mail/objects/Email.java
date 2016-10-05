package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class Email {
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;

	public Email() {
	}

	public Email(final String email) {
		this.setEmail(email);
	}

	public Email(final String email, final String name) {
		this(email);
		this.setName(name);
	}

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public Email setName(final String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("email")
	public String getEmail() {
		return this.email;
	}

	public Email setEmail(final String email) {
		this.email = email;
		return this;
	}
}