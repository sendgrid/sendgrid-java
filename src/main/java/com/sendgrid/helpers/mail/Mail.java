package com.sendgrid.helpers.mail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sendgrid.helpers.mail.objects.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Mail builds an object that sends an email through SendGrid.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Mail {
	@JsonProperty("from")
	private Email from;
	@JsonProperty("subject")
	private String subject;
	@JsonProperty("personalizations")
	private List<Personalization> personalization;
	@JsonProperty("content")
	private List<Content> content;
	@JsonProperty("attachments")
	private List<Attachments> attachments;
	@JsonProperty("template_id")
	private String templateId;
	@JsonProperty("sections")
	private Map<String, String> sections;
	@JsonProperty("headers")
	private Map<String, String> headers;
	@JsonProperty("categories")
	private List<String> categories;
	@JsonProperty("custom_args")
	private Map<String, String> customArgs;
	@JsonProperty("send_at")
	private long sendAt;
	@JsonProperty("batch_id")
	private String batchId;
	@JsonProperty("asm")
	private ASM asm;
	@JsonProperty("ip_pool_name")
	private String ipPoolId;
	@JsonProperty("mail_settings")
	private MailSettings mailSettings;
	@JsonProperty("tracking_settings")
	private TrackingSettings trackingSettings;
	@JsonProperty("reply_to")
	private Email replyTo;

	private static final ObjectMapper SORTED_MAPPER = new ObjectMapper();

	static {
		SORTED_MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
	}

	public Mail() {
	}

	public Mail(final Email from, final String subject, final Email to, final Content content) {
		this.setFrom(from);
		this.setSubject(subject);
		this.addPersonalization(new Personalization().addTo(to));
		this.addContent(content);
	}

	@JsonProperty("from")
	public Email getFrom(final Email from) {
		return from;
	}

	public Mail setFrom(final Email from) {
		this.from = from;
		return this;
	}

	@JsonProperty("subject")
	public String getSubject() {
		return this.subject;
	}

	public Mail setSubject(final String subject) {
		this.subject = subject;
		return this;
	}

	@JsonProperty("asm")
	public ASM getASM() {
		return this.asm;
	}

	public Mail setASM(final ASM asm) {
		this.asm = asm;
		return this;
	}

	@JsonProperty("personalizations")
	public List<Personalization> getPersonalization() {
		return this.personalization;
	}

	public Mail addPersonalization(final Personalization personalization) {
		if (this.personalization == null) {
			this.personalization = new ArrayList<>();
		}
		this.personalization.add(personalization);
		return this;
	}

	@JsonProperty("content")
	public List<Content> getContent() {
		return this.content;
	}

	public Mail addContent(final Content content) {
		if (this.content == null) {
			this.content = new ArrayList<>();
		}
		this.content.add(new Content()
				.setType(content.getType())
				.setValue(content.getValue()));
		return this;
	}

	@JsonProperty("attachments")
	public List<Attachments> getAttachments() {
		return this.attachments;
	}

	public Mail addAttachments(final Attachments attachments) {
		if (this.attachments == null) {
			this.attachments = new ArrayList<>();
		}
		this.attachments.add(new Attachments()
				.setContent(attachments.getContent())
				.setType(attachments.getType())
				.setFilename(attachments.getFilename())
				.setDisposition(attachments.getDisposition())
				.setContentId(attachments.getContentId()));
		return this;
	}

	@JsonProperty("template_id")
	public String getTemplateId() {
		return this.templateId;
	}

	public Mail setTemplateId(final String templateId) {
		this.templateId = templateId;
		return this;
	}

	@JsonProperty("sections")
	public Map<String, String> getSections() {
		return this.sections;
	}

	public Mail addSection(final String key, final String value) {
		if (this.sections == null) {
			this.sections = new HashMap<>();
		}
		this.sections.put(key, value);
		return this;
	}

	@JsonProperty("headers")
	public Map<String, String> getHeaders() {
		return this.headers;
	}


	public Mail addHeader(final String key, final String value) {
		if (this.headers == null) {
			this.headers = new HashMap<>();
			this.headers.put(key, value);
		}
		this.headers.put(key, value);
		return this;
	}

	@JsonProperty("categories")
	public List<String> getCategories() {
		return this.categories;
	}

	public Mail addCategory(final String category) {
		if (this.categories == null) {
			this.categories = new ArrayList<>();
		}
		this.categories.add(category);
		return this;
	}

	@JsonProperty("custom_args")
	public Map<String, String> getCustomArgs() {
		return this.customArgs;
	}

	public Mail addCustomArg(final String key, final String value) {
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

	public Mail setSendAt(final long sendAt) {
		this.sendAt = sendAt;
		return this;
	}

	@JsonProperty("batch_id")
	public String getBatchId() {
		return this.batchId;
	}

	public Mail setBatchId(final String batchId) {
		this.batchId = batchId;
		return this;
	}

	@JsonProperty("ip_pool_name")
	public String getIpPoolId() {
		return this.ipPoolId;
	}

	public Mail setIpPoolId(final String ipPoolId) {
		this.ipPoolId = ipPoolId;
		return this;
	}

	@JsonProperty("mail_settings")
	public MailSettings getMailSettings() {
		return this.mailSettings;
	}

	public Mail setMailSettings(final MailSettings mailSettings) {
		this.mailSettings = mailSettings;
		return this;
	}

	@JsonProperty("tracking_settings")
	public TrackingSettings getTrackingSettings() {
		return this.trackingSettings;
	}

	public Mail setTrackingSettings(final TrackingSettings trackingSettings) {
		this.trackingSettings = trackingSettings;
		return this;
	}

	@JsonProperty("reply_to")
	public Email getReplyto() {
		return this.replyTo;
	}

	public Mail setReplyTo(final Email replyTo) {
		this.replyTo = replyTo;
		return this;
	}

	/**
	 * Create a string represenation of the Mail object JSON.
	 */
	public String build() throws IOException {
		try {
			//ObjectMapper mapper = new ObjectMapper();
			return SORTED_MAPPER.writeValueAsString(this);
		} catch (final IOException ex) {
			throw ex;
		}
	}

	/**
	 * Create a string represenation of the Mail object JSON and pretty print it.
	 */
	public String buildPretty() throws IOException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (final IOException ex) {
			throw ex;
		}
	}
}