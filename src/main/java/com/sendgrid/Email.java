package com.sendgrid;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.sendgrid.smtpapi.SMTPAPI;

public class Email {

    private SMTPAPI smtpapi;

    private ArrayList<String> to;

    private ArrayList<String> toname;

    private ArrayList<String> cc;

    private String from;

    private String fromname;

    private String replyto;

    private String subject;

    private String text;

    private String html;

    private ArrayList<String> bcc;

    private Map<String, InputStream> attachments;

    private Map<String, String> contents;

    private Map<String, String> headers;

    public Email() {
        this.setSmtpapi(new SMTPAPI());
        this.to = new ArrayList<String>();
        this.toname = new ArrayList<String>();
        this.cc = new ArrayList<String>();
        this.bcc = new ArrayList<String>();
        this.attachments = new HashMap<String, InputStream>();
        this.contents = new HashMap<String, String>();
        this.headers = new HashMap<String, String>();
    }

    public Email addTo(String to) {
        this.to.add(to);
        return this;
    }

    public Email addTo(String[] tos) {
        this.to.addAll(Arrays.asList(tos));
        return this;
    }

    public Email addTo(String to, String name) {
        this.addTo(to);
        return this.addToName(name);
    }

    public Email setTo(String[] tos) {
        this.to = new ArrayList<String>(Arrays.asList(tos));
        return this;
    }

    public String[] getTos() {
        return this.to.toArray(new String[this.to.size()]);
    }

    public Email addSmtpApiTo(String to) {
        this.getSmtpapi().addTo(to);
        return this;
    }

    public Email addSmtpApiTo(String[] to) {
        this.getSmtpapi().addTos(to);
        return this;
    }

    public Email addToName(String toname) {
        this.toname.add(toname);
        return this;
    }

    public Email addToName(String[] tonames) {
        this.toname.addAll(Arrays.asList(tonames));
        return this;
    }

    public Email setToName(String[] tonames) {
        this.toname = new ArrayList<String>(Arrays.asList(tonames));
        return this;
    }

    public String[] getToNames() {
        return this.toname.toArray(new String[this.toname.size()]);
    }

    public Email addCc(String cc) {
        this.cc.add(cc);
        return this;
    }

    public Email addCc(String[] ccs) {
        this.cc.addAll(Arrays.asList(ccs));
        return this;
    }

    public Email setCc(String[] ccs) {
        this.cc = new ArrayList<String>(Arrays.asList(ccs));
        return this;
    }

    public String[] getCcs() {
        return this.cc.toArray(new String[this.cc.size()]);
    }

    public Email setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getFrom() {
        return this.from;
    }

    public Email setFromName(String fromname) {
        this.fromname = fromname;
        return this;
    }

    public String getFromName() {
        return this.fromname;
    }

    public Email setReplyTo(String replyto) {
        this.replyto = replyto;
        return this;
    }

    public String getReplyTo() {
        return this.replyto;
    }

    public Email addBcc(String bcc) {
        this.bcc.add(bcc);
        return this;
    }

    public Email addBcc(String[] bccs) {
        this.bcc.addAll(Arrays.asList(bccs));
        return this;
    }

    public Email setBcc(String[] bccs) {
        this.bcc = new ArrayList<String>(Arrays.asList(bccs));
        return this;
    }

    public String[] getBccs() {
        return this.bcc.toArray(new String[this.bcc.size()]);
    }

    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getSubject() {
        return this.subject;
    }

    public Email setText(String text) {
        this.text = text;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public Email setHtml(String html) {
        this.html = html;
        return this;
    }

    public String getHtml() {
        return this.html;
    }

    public Email addSubstitution(String key, String[] val) {
        this.getSmtpapi().addSubstitutions(key, val);
        return this;
    }

    public JSONObject getSubstitutions() {
        return this.getSmtpapi().getSubstitutions();
    }

    public Email addUniqueArg(String key, String val) {
        this.getSmtpapi().addUniqueArg(key, val);
        return this;
    }

    public JSONObject getUniqueArgs() {
        return this.getSmtpapi().getUniqueArgs();
    }

    public Email addCategory(String category) {
        this.getSmtpapi().addCategory(category);
        return this;
    }

    public String[] getCategories() {
        return this.getSmtpapi().getCategories();
    }

    public Email addSection(String key, String val) {
        this.getSmtpapi().addSection(key, val);
        return this;
    }

    public JSONObject getSections() {
        return this.getSmtpapi().getSections();
    }

    public Email addFilter(String filter_name, String parameter_name, String parameter_value) {
        this.getSmtpapi().addFilter(filter_name, parameter_name, parameter_value);
        return this;
    }

    public JSONObject getFilters() {
        return this.getSmtpapi().getFilters();
    }

    public Email setASMGroupId(int val) {
        this.getSmtpapi().setASMGroupId(val);
        return this;
    }

    public Integer getASMGroupId() {
        return this.getSmtpapi().getASMGroupId();
    }

    public Email setSendAt(int sendAt) {
        this.getSmtpapi().setSendAt(sendAt);
        return this;
    }

    public int getSendAt() {
        return this.getSmtpapi().getSendAt();
    }

    public Email addAttachment(String name, File file) throws IOException, FileNotFoundException {
        return this.addAttachment(name, new FileInputStream(file));
    }

    public Email addAttachment(String name, String file) throws IOException {
        return this.addAttachment(name, new ByteArrayInputStream(file.getBytes()));
    }

    public Email addAttachment(String name, InputStream file) throws IOException {
        this.attachments.put(name, file);
        return this;
    }

    public Map<String, InputStream> getAttachments() {
        return this.attachments;
    }

    public Email addContentId(String attachmentName, String cid) {
        this.contents.put(attachmentName, cid);
        return this;
    }

    public Map<String, String> getContentIds() {
        return this.contents;
    }

    public Email addHeader(String key, String val) {
        this.headers.put(key, val);
        return this;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public SMTPAPI getSMTPAPI() {
        return this.getSmtpapi();
    }

    public SMTPAPI getSmtpapi() {
        return smtpapi;
    }

    public void setSmtpapi(SMTPAPI smtpapi) {
        this.smtpapi = smtpapi;
    }
}
