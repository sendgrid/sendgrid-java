package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(Include.NON_DEFAULT)
public class Personalization {
	@JsonProperty("to")
	private List<Email> tos;
	@JsonProperty("cc")
	private List<Email> ccs;
	@JsonProperty("bcc")
	private List<Email> bccs;
	@JsonProperty("subject")
	private String subject;
	@JsonProperty("headers")
	private Map<String, String> headers;
	@JsonProperty("substitutions")
	private Map<String, String> substitutions;
	@JsonProperty("custom_args")
	private Map<String, String> customArgs;
	@JsonProperty("send_at")
	private long sendAt;

	@JsonProperty("to")
	public List<Email> getTos() {
		return this.tos;
	}

	public Personalization addTo(final Email email) {
		if (this.tos == null) {
			this.tos = new ArrayList<>();
		}
		this.tos.add(new Email()
				.setEmail(email.getName())
				.setName(email.getName()));
		return this;
	}

	@JsonProperty("cc")
	public List<Email> getCcs() {
		return this.ccs;
	}

	public Personalization addCc(final Email email) {
		if (this.ccs == null) {
			this.ccs = new ArrayList<>();
		}
		this.ccs.add(new Email()
				.setEmail(email.getName())
				.setName(email.getName()));
		return this;
	}

	@JsonProperty("bcc")
	public List<Email> getBccs() {
		return this.bccs;
	}

	public Personalization addBcc(final Email email) {
		if (this.bccs == null) {
			this.bccs = new ArrayList<>();
		}
		this.bccs.add(new Email()
				.setEmail(email.getName())
				.setName(email.getName()));
		return this;
	}

	@JsonProperty("subject")
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	@JsonProperty("headers")
	public Map<String, String> getHeaders() {
		return this.headers;
	}

	public Personalization addHeader(final String key, final String value) {
		if (this.headers == null) {
			this.headers = new HashMap<>();
		}
		this.headers.put(key, value);
		return this;
	}

	@JsonProperty("substitutions")
	public Map<String, String> getSubstitutions() {
		return this.substitutions;
	}

	public Personalization addSubstitution(final String key, final String value) {
		if (this.substitutions == null) {
			this.substitutions = new HashMap<>();
		}
		this.substitutions.put(key, value);
		return this;
	}

	@JsonProperty("custom_args")
	public Map<String, String> getCustomArgs() {
		return this.customArgs;
	}

	public Personalization addCustomArg(final String key, final String value) {
		if (this.customArgs == null) {
			this.customArgs = new HashMap<>();
		}
		this.customArgs.put(key, value);
		return this;
	}

	@JsonProperty("send_at")
	public long sendAt() {
		return this.sendAt;
	}

	public Personalization setSendAt(final long sendAt) {
		this.sendAt = sendAt;
		return this;
	}
}