package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An object representing a message and its metadata.
 * A personalization can be thought of as an envelope 
 * - it defines who should receive an individual message 
 * and how that message should be handled.
 */
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

    /**
     * Get the to list. This is an array of recipients. Each object 
     * within this array may contain the name, but must always 
     * contain the email, of a recipient.
     * 
     * The maximum number of entries is 1000.
     * 
     * Content added to the returned list will be included when sent.
     * @return the to list.
     */
    @JsonProperty("to")
    public List<Email> getTos() {
        if (tos == null)
            return Collections.<Email>emptyList();
        return tos;
    }

    /**
     * Add a recipient.
     * @param email an email address.
     * @return this object.
     */
    public Personalization to(Email email) {
        Email newEmail = new Email()
            .name(email.getName())
            .email(email.getEmail());

        if (tos == null) {
            tos = new ArrayList<Email>();
            tos.add(newEmail);
        } else {
            tos.add(newEmail);
        }
        return this;
    }

    /**
     * Set the CC list. This is an array of recipients. Each object 
     * within this array may contain the name, but must always 
     * contain the email, of a recipient.
     * 
     * The maximum number of entries is 1000.
     * 
     * Content added to the returned list will be included when sent.
     * @return the CC list.
     */
    @JsonProperty("cc")
    public List<Email> getCcs() {
        if (ccs == null)
            return Collections.<Email>emptyList();
        return ccs;
    }

    /**
     * Add a recipient.
     * @param email an email address.
     * @return this object.
     */
    public Personalization cc(Email email) {
        Email newEmail = new Email()
            .name(email.getName())
            .email(email.getEmail());

        if (ccs == null) {
            ccs = new ArrayList<Email>();
            ccs.add(newEmail);
        } else {
            ccs.add(newEmail);
        }
        return this;
    }

    /**
     * Set the BCC list. This is an array of recipients. Each object 
     * within this array may contain the name, but must always 
     * contain the email, of a recipient.
     * 
     * The maximum number of entries is 1000.
     * 
     * Content added to the returned list will be included when sent.
     * @return the BCC list.
     */
    @JsonProperty("bcc")
    public List<Email> getBccs() {
        if (bccs == null)
            return Collections.<Email>emptyList();
        return bccs;
    }

    /**
     * Add a recipient.
     * @param email an email address.
     * @return this object.
     */
    public Personalization bcc(Email email) {
        Email newEmail = new Email()
            .name(email.getName())
            .email(email.getEmail());

        if (bccs == null) {
            bccs = new ArrayList<Email>();
            bccs.add(newEmail);
        } else {
            bccs.add(newEmail);
        }
        return this;
    }

    /**
     * Get the subject of the email.
     * @return the subject.
     */
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    /**
     * Set the subject of the email.
     * @param subject the subject.
     * @return this object.
     */
    public Personalization subject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Get the headers. The headers are a collection of JSON 
     * key/value pairs allowing you to specify specific handling 
     * instructions for your email. You may not overwrite the 
     * following headers: x-sg-id, x-sg-eid, received, 
     * dkim-signature, Content-Type, Content-Transfer-Encoding, 
     * To, From, Subject, Reply-To, CC, BCC
     * 
     * Content added to the returned list will be included when sent. 
     * @return the headers.
     */
    @JsonProperty("headers")
    public Map<String, String> getHeaders() {
        if (headers == null)
            return Collections.<String, String>emptyMap();
        return headers;
    }

    /**
     * Add a header.
     * @param key the header key.
     * @param value the header value.
     * @return this object.
     */
    public Personalization header(String key, String value) {
        if (headers == null) {
            headers = new HashMap<String, String>();
            headers.put(key, value);
        } else {
            headers.put(key, value);
        }
        return this;
    }

    /**
     * Get the substitusions. Substitutions are a collection of 
     * key/value pairs following the pattern 
     * "substitution_tag":"value to substitute". All are assumed 
     * to be strings. These substitutions will apply to the text 
     * and html content of the body of your email, in addition 
     * to the subject and reply-to parameters. The total 
     * collective size of your substitutions may not exceed 
     * 10,000 bytes per personalization object.
     * 
     * The maximum number of entries is 1000.
     * 
     * Content added to the returned list will be included when sent. 
     * @return the substitutions.
     */
    @JsonProperty("substitutions")
    public Map<String, String> getSubstitutions() {
        if (substitutions == null)
            return Collections.<String, String>emptyMap();
        return substitutions;
    }

    /**
     * Add a substitusion.
     * @param key the key.
     * @param value the value.
     * @return this object.
     */
    public Personalization substitution(String key, String value) {
        if (substitutions == null) {
            substitutions = new HashMap<String, String>();
            substitutions.put(key, value);
        } else {
            substitutions.put(key, value);
        }
        return this;
    }

    /**
     * Get the custom arguments. Values that are specific to 
     * this personalization that will be carried along with 
     * the email and its activity data. Substitutions will
     * not be made on custom arguments, so any string that 
     * is entered into this parameter will be assumed to be 
     * the custom argument that you would like to be used. i
     * May not exceed 10,000 bytes.
     * 
     * Content added to the returned list will be included when sent. 
     * @return the custom arguments.
     */
    @JsonProperty("custom_args")
    public Map<String, String> getCustomArgs() {
        if (customArgs == null)
            return Collections.<String, String>emptyMap();
        return customArgs;
    }

    /**
     * Add a custom argument.
     * @param key the key.
     * @param value the value.
     * @return this object.
     */
    public Personalization customArg(String key, String value) {
        if (customArgs == null) {
            customArgs = new HashMap<String, String>();
            customArgs.put(key, value);
        } else {
            customArgs.put(key, value);
        }
        return this;
    }

    /**
     * Get the send at time. This is a unix timestamp 
     * allowing you to specify when you want your 
     * email to be delivered. Scheduling more than
     * 72 hours in advance is forbidden.
     * @return the send at time.
     */
    @JsonProperty("send_at")
    public long sendAt() {
        return sendAt;
    }

    /**
     * Set the send at time.
     * @param sendAt the send at time (Unix timestamp).
     * @return this object.
     */
    public Personalization sendAt(long sendAt) {
        this.sendAt = sendAt;
        return this;
    }
}
