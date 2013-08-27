package com.github.scottmotte.sendgrid;

import com.github.kevinsawicki.http.HttpRequest;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.File;
import java.util.ArrayList;

public class SendGrid {
  private static final String PARAM_API_USER    = "api_user";
  private static final String PARAM_API_KEY     = "api_key";
  private static final String PARAM_TOS         = "to[]";
  private static final String PARAM_TONAMES     = "toname[]";
  private static final String PARAM_BCC         = "bcc";
  private static final String PARAM_FROM        = "from";
  private static final String PARAM_FROMNAME    = "fromname";
  private static final String PARAM_REPLYTO     = "replyto";
  private static final String PARAM_SUBJECT     = "subject";
  private static final String PARAM_HTML        = "html";
  private static final String PARAM_TEXT        = "text";
  private static final String PARAM_FILES       = "files[%s]";
  private static final String PARAM_HEADERS     = "headers";

  private String username;
  private String password;
  private ArrayList<String> tos = new ArrayList<String>();
  private ArrayList<String> tonames = new ArrayList<String>();
  private String bcc;
  private String from;
  private String fromname;
  private String replyto;
  private String subject;
  private String text;
  private String html;
  private ArrayList<File> files = new ArrayList<File>();
  private JSONObject headers = new JSONObject();
  
  public SendGrid(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String send() {
    return this.web();
  } 

  public String web() {
    HttpRequest request = HttpRequest.post("https://sendgrid.com/api/mail.send.json");

    request.part(PARAM_API_USER,  this.username);
    request.part(PARAM_API_KEY,   this.password);
    for (String to:this.getTos()) {
      request.part(PARAM_TOS,     to);
    }
    for (String toname:this.getToNames()) {
      request.part(PARAM_TONAMES,     toname);
    }
    request.part(PARAM_FROM,      this.getFrom());
    request.part(PARAM_FROMNAME,  this.getFromName());
    if (this.getReplyTo() != null) {
      request.part(PARAM_REPLYTO, this.getReplyTo());
    }
    request.part(PARAM_SUBJECT,   this.getSubject());

    if (this.getText() != null) {
      request.part(PARAM_TEXT,    this.getText());
    }
    if (this.getHtml() != null) {
      request.part(PARAM_HTML,    this.getHtml());
    }
    if (this.getBcc() != null) {
      request.part(PARAM_BCC, this.getBcc());
    }

    for (File file:this.getFiles()) {
      request.part(String.format(PARAM_FILES, file.getName()), file);
    }

    request.part(PARAM_HEADERS,   this.getHeaders().toString());

    return request.body();
  }

  public ArrayList<String> getTos() {
    return this.tos;
  }

  public ArrayList<String> getToNames() {
    return this.tonames;
  }

  public String getBcc() {
    return this.bcc;
  }

  public String getFrom() {
    return this.from;
  }

  public String getFromName() {
    return this.fromname;
  }

  public String getReplyTo() {
    return this.replyto;
  }

  public String getSubject() {
    return this.subject;
  }

  public String getText() {
    return this.text;
  }

  public String getHtml() {
    return this.html;
  }

  public ArrayList<File> getFiles() {
    return this.files;
  }

  public JSONObject getHeaders() {
    return this.headers;
  }

  public SendGrid addTo(String email) {
    this.tos.add(email);
    return this;
  }

  public SendGrid addToName(String name) {
    this.tonames.add(name);
    return this;
  }

  public SendGrid setFrom(String email) {
    this.from = email;
    return this;
  }

  public SendGrid setFromName(String name) {
    this.fromname = name;
    return this;
  }

  public SendGrid setReplyTo(String email) {
    this.replyto = email;
    return this;
  }

  public SendGrid setBcc(String bcc) {
    this.bcc = bcc;
    return this;
  }

  public SendGrid setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public SendGrid setText(String text) {
    this.text = text;
    return this;
  }

  public SendGrid setHtml(String html) {
    this.html = html;
    return this;
  }

  public SendGrid addFile(File file) {
    this.files.add(file);
    return this;
  }

  public SendGrid addHeader(String key, String value) {
    try {
      this.headers.put(key, value);
    } catch(Exception e){
      e.printStackTrace();
    }

    return this;
  }
}
