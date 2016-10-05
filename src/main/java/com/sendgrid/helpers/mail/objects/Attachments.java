package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class Attachments {
	@JsonProperty("content")
	private String content;
	@JsonProperty("type")
	private String type;
	@JsonProperty("filename")
	private String filename;
	@JsonProperty("disposition")
	private String disposition;
	@JsonProperty("content_id")
	private String contentId;

	@JsonProperty("content")
	public String getContent() {
		return this.content;
	}

	public Attachments setContent(final String content) {
		this.content = content;
		return this;
	}

	@JsonProperty("type")
	public String getType() {
		return this.type;
	}

	public Attachments setType(final String type) {
		this.type = type;
		return this;
	}

	@JsonProperty("filename")
	public String getFilename() {
		return this.filename;
	}

	public Attachments setFilename(final String filename) {
		this.filename = filename;
		return this;
	}

	@JsonProperty("disposition")
	public String getDisposition() {
		return this.disposition;
	}

	public Attachments setDisposition(final String disposition) {
		this.disposition = disposition;
		return this;
	}

	@JsonProperty("content_id")
	public String getContentId() {
		return this.contentId;
	}

	public Attachments setContentId(final String contentId) {
		this.contentId = contentId;
		return this;
	}
}
