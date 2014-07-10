package com.sendgrid;

import org.json.JSONObject;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.*;
import com.sendgrid.smtpapi.SMTPAPI;
import com.mashape.unirest.http.JsonNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SendGrid {
  private String username;
  private String password;
  private String url;
  private String port;
  private String endpoint;

  public SendGrid(String username, String password) {
    this.username = username;
    this.password = password;
    this.url = "https://api.sendgrid.com";
    this.endpoint = "/api/mail.send.json";
  }

  public SendGrid setUrl(String url) {
    this.url = url;
    return this;
  }

  public SendGrid setEndpoint(String endpoint) {
    this.endpoint = endpoint;
    return this;
  }

  public SendGrid.Response send(Email email) throws SendGridException {
    try {
      HttpResponse<JsonNode> res = Unirest.post(this.url + this.endpoint)
      .fields(email.toWebFormat()).field("api_user", this.username).field("api_key", this.password).asJson();
      return new SendGrid.Response(res.getCode(), res.getBody());
    } catch (UnirestException e) {
      throw new SendGridException(e);
    }
  }

  public static class Email {
    private static final String PARAM_TO          = "to[%d]";
    private static final String PARAM_TONAME      = "toname[%d]";
    private static final String PARAM_FROM        = "from";
    private static final String PARAM_FROMNAME    = "fromname";
    private static final String PARAM_REPLYTO     = "replyto";
    private static final String PARAM_BCC         = "bcc[%d]";
    private static final String PARAM_SUBJECT     = "subject";
    private static final String PARAM_HTML        = "html";
    private static final String PARAM_TEXT        = "text";
    private static final String PARAM_FILES       = "files[%s]";
    private static final String PARAM_XSMTPAPI    = "x-smtpapi";
    private static final String PARAM_HEADERS     = "headers";

    private SMTPAPI smtpapi;
    private ArrayList<String> to;
    private ArrayList<String> toname;
    private String from;
    private String fromname;
    private String replyto;
    private String subject;
    private String text;
    private String html;
    private ArrayList<String> bcc;
    private Map attachments;
    private Map headers;

    public Email () {
      this.smtpapi = new SMTPAPI();
      this.to = new ArrayList<String>();
      this.toname = new ArrayList<String>();
      this.bcc = new ArrayList<String>();
      this.attachments = new HashMap();
      this.headers = new HashMap();
    }

    public Email addTo(String to) {
      this.smtpapi.addTo(to);
      this.to.add(to);
      return this;
    }

    public Email addTos(String[] tos) {
      this.smtpapi.addTos(tos);
      this.to.addAll(Arrays.asList(tos));
      return this;
    }

    public Email setTos(String[] tos) {
      this.smtpapi.setTos(tos);
      this.to = new ArrayList(Arrays.asList(tos));
      return this;
    }

    public String[] getTos() {
      return this.to.toArray(new String[this.to.size()]);
    }

    public Email addToName(String toname) {
      this.toname.add(toname);
      return this;
    }

    public Email addToNames(String[] tonames) {
      this.toname.addAll(Arrays.asList(tonames));
      return this;
    }

    public Email setToNames(String[] tonames) {
      this.toname = new ArrayList(Arrays.asList(tonames));
      return this;
    }

    public String[] getToNames() {
      return this.toname.toArray(new String[this.toname.size()]);
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

    public Email addBccs(String[] bccs) {
      this.bcc.addAll(Arrays.asList(bccs));
      return this;
    }

    public Email setBccs(String[] bccs) {
      this.bcc = new ArrayList(Arrays.asList(bccs));
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

    public Email dropSMTPITos() {
      JSONObject oldHeader = new JSONObject(this.smtpapi.jsonString());
      oldHeader.remove("to");
      this.smtpapi = new SMTPAPI(oldHeader);
      return this;
    }

    public Email addSubstitution(String key, String[] val) {
      this.smtpapi.addSubstitutions(key, val);
      return this;
    }

    public JSONObject getSubstitutions() {
      return this.smtpapi.getSubstitutions();
    }

    public Email addUniqueArg(String key, String val) {
      this.smtpapi.addUniqueArg(key, val);
      return this;
    }

    public JSONObject getUniqueArgs() {
      return this.smtpapi.getUniqueArgs();
    }

    public Email addCategory(String category) {
      this.smtpapi.addCategory(category);
      return this;
    }

    public String[] getCategories() {
      return this.smtpapi.getCategories();
    }

    public Email addSection(String key, String val) {
      this.smtpapi.addSection(key, val);
      return this;
    }

    public JSONObject getSections() {
      return this.smtpapi.getSections();
    }

    public Email addFilter(String filter_name, String parameter_name, String parameter_value) {
      this.smtpapi.addFilter(filter_name, parameter_name, parameter_value);
      return this;
    }

    public JSONObject getFilters() {
      return this.smtpapi.getFilters();
    }

    public Email addAttachment(String name, File file) {
      this.attachments.put(name, file);
      return this;
    }

    public Email addAttachment(String name, String file) {
      this.attachments.put(name, file);
      return this;
    }

    public Email addAttachment(String name, InputStream file) {
      Scanner scanner = new Scanner(file, "UTF-8");
      String buffer = new String();
      while (scanner.hasNextLine()) {
        buffer += scanner.nextLine();
      }
      scanner.close();
      return this.addAttachment(name, buffer);
    }

    public Email addHeader(String key, String val) {
      this.headers.put(key, val);
      return this;
    }

    public Map getHeaders() {
      return this.headers;
    }

    public SMTPAPI getSMTPAPI() {
      return this.smtpapi;
    }

    public Map toWebFormat() {
      Map body = new HashMap();

      for (int i = 0; i < this.to.size(); i++)
        body.put(String.format(PARAM_TO, i), this.to.get(i));

      for (int i = 0; i < this.toname.size(); i++)
        body.put(String.format(PARAM_TONAME, i), this.toname.get(i));

      for (int i = 0; i < this.bcc.size(); i++)
        body.put(String.format(PARAM_BCC, i), this.bcc.get(i));

      if (this.from != null && !this.from.isEmpty())
        body.put(PARAM_FROM, this.from);

      if (this.fromname != null && !this.fromname.isEmpty())
        body.put(PARAM_FROMNAME, this.fromname);

      if (this.replyto != null && !this.replyto.isEmpty())
        body.put(PARAM_REPLYTO, this.replyto);

      if (this.subject != null && !this.subject.isEmpty())
        body.put(PARAM_SUBJECT, this.subject);

      if (this.text != null && !this.text.isEmpty())
        body.put(PARAM_TEXT, this.text);

      if (this.html != null && !this.html.isEmpty())
        body.put(PARAM_HTML, this.html);

      if (!this.headers.isEmpty())
        body.put(PARAM_HEADERS, new JSONObject(this.headers).toString());

      if (!this.smtpapi.jsonString().equals("{}"))
        body.put(PARAM_XSMTPAPI, this.smtpapi.jsonString());

      if (this.attachments.size() > 0) {
        Iterator it = this.attachments.entrySet().iterator();
        while (it.hasNext()) {
          Map.Entry entry = (Map.Entry) it.next();
          body.put(String.format(PARAM_FILES, entry.getKey()), entry.getValue());
        }
      }

      return body;
    }
  }

  public static class Response {
    private int code;
    private boolean success;
    private String message;

    public Response(int code, JsonNode body) {
      this.code = code;
      this.success = code == 200;
      this.message = body.toString();
    }

    public int getCode() {
      return this.code;
    }

    public boolean getStatus() {
      return this.success;
    }

    public String getMessage() {
      return this.message;
    }
  }
}
