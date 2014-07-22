package com.sendgrid;

import org.json.JSONObject;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.*;
import com.sendgrid.smtpapi.SMTPAPI;
import com.mashape.unirest.http.JsonNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SendGrid {
  public final String VERSION = "1.0.0";

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
    Unirest.setDefaultHeader("User-Agent", "sendgrid/" + VERSION + ";java");
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
    private static final String PARAM_TO          = "to";
    private static final String PARAM_FROM        = "from";
    private static final String PARAM_FROMNAME    = "fromname";
    private static final String PARAM_REPLYTO     = "replyto";
    private static final String PARAM_BCCS        = "bcc[%d]";
    private static final String PARAM_SUBJECT     = "subject";
    private static final String PARAM_HTML        = "html";
    private static final String PARAM_TEXT        = "text";
    private static final String PARAM_FILES       = "files[%s]";
    private static final String PARAM_XSMTPAPI    = "x-smtpapi";
    private static final String PARAM_HEADERS     = "headers";

    public SMTPAPI smtpapi;
    SMTPAPI header = new SMTPAPI();

    public String to;
    public String from;
    public String fromname;
    public String replyto;
    public String subject;
    public String text;
    public String html;
    public ArrayList<String> bcc = new ArrayList<String>();
    public Map attachments = new HashMap();
    public Map headers = new HashMap();

    public Email () {
      this.smtpapi = new SMTPAPI();
    }

    public Email addTo(String to) {
      this.smtpapi.addTo(to);
      return this;
    }

    public Email setFrom(String from) {
      this.from = from;
      return this;
    }

    public Email setFromName(String fromname) {
      this.fromname = fromname;
      return this;
    }

    public Email setReplyTo(String replyto) {
      this.replyto = replyto;
      return this;
    }

    public Email addBcc(String bcc) {
      this.bcc.add(bcc);
      return this;
    }

    public Email setSubject(String subject) {
      this.subject = subject;
      return this;
    }

    public Email setText(String text) {
      this.text = text;
      return this;
    }

    public Email setHtml(String html) {
      this.html = html;
      return this;
    }

    public Email addSubstitution(String key, String[] val) {
      this.smtpapi.addSubstitutions(key, val);
      return this;
    }

    public Email addUniqueArg(String key, String val) {
      this.smtpapi.addUniqueArg(key, val);
      return this;
    }

    public Email addCategory(String category) {
      this.smtpapi.addCategory(category);
      return this;
    }

    public Email addSection(String key, String val) {
      this.smtpapi.addSection(key, val);
      return this;
    }

    public Email addFilter(String filter_name, String parameter_name, String parameter_value) {
      this.smtpapi.addFilter(filter_name, parameter_name, parameter_value);
      return this;
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

    public Map toWebFormat() {
      Map body = new HashMap();

      // updateMissingTo - There needs to be at least 1 to address,
      // or else the mail won't send.
      if ((this.to == null || this.to.isEmpty()) && this.from != null && !this.from.isEmpty()) {
        String value = this.from;
        body.put(PARAM_TO, value);
      }

      if (this.from != null && !this.from.isEmpty()) {
        String value = this.from;
        body.put(PARAM_FROM, value);
      }

      if (this.fromname != null && !this.fromname.isEmpty()) {
        String value = this.fromname;
        body.put(PARAM_FROMNAME, value);
      }

      if (this.replyto != null && !this.replyto.isEmpty()) {
        String value = this.replyto;
        body.put(PARAM_REPLYTO, value);
      }

      for (int i = 0; i < this.bcc.size(); i++) {
        String key = String.format(PARAM_BCCS, i);
        String value = this.bcc.get(i);
        body.put(key, value);
      }

      if (this.subject != null && !this.subject.isEmpty()) {
        String value = this.subject;
        body.put(PARAM_SUBJECT, value);
      }

      if (this.text != null && !this.text.isEmpty()) {
        String value = this.text;
        body.put(PARAM_TEXT, value);
      }

      if (this.html != null && !this.html.isEmpty()) {
        String value = this.html;
        body.put(PARAM_HTML, value);
      }

      if (!this.headers.isEmpty()) {
        JSONObject json_headers = new JSONObject(this.headers);
        String serialized_headers = json_headers.toString();
        body.put(PARAM_HEADERS, serialized_headers);
      }

      if (!this.smtpapi.jsonString().equals("{}")) {
        String value = this.smtpapi.jsonString();
        body.put(PARAM_XSMTPAPI, value);
      }

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
