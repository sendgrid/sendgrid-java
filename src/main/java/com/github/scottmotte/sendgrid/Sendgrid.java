package com.github.scottmotte.sendgrid;

import com.github.kevinsawicki.http.HttpRequest;

import java.io.File;

public class Sendgrid {
  private static final String PARAM_API_USER    = "api_user";
  private static final String PARAM_API_KEY     = "api_key";
  private static final String PARAM_BCC         = "bcc";
  private static final String PARAM_FILES       = "files[%s]";
  private static final String PARAM_FROM        = "from";
  private static final String PARAM_HTML        = "html";
  private static final String PARAM_SUBJECT     = "subject";
  private static final String PARAM_TEXT        = "text";
  private static final String PARAM_TO          = "to";

  private String username;
  private String password;
  private String to;
  private String bcc;
  private String from;
  private String subject;
  private String text;
  private String html;
  private File[] file;
  
  public Sendgrid(final String username, final String password) {
    this.username = username;
    this.password = password;
  }

  public String send() {
    return this.web();
  } 

  public String web() {
    HttpRequest request = HttpRequest.post("https://sendgrid.com/api/mail.send.json");

    request.part(PARAM_API_USER, this.username);
    request.part(PARAM_API_KEY, this.password);
    request.part(PARAM_TO, this.getTo());
    request.part(PARAM_FROM, this.getFrom());
    request.part(PARAM_SUBJECT, this.getSubject());

    if (text != null) {
      request.part(PARAM_TEXT, this.getText());
    }
    if (html != null) {
      request.part(PARAM_HTML, this.getHtml());
    }

//    if (to != null) {
//      for (String s : to) {
//        request.part(PARAM_TO, s);
//      }
//    }
    if (this.getBcc() != null) {
      request.part(PARAM_BCC, this.getBcc());
    }
    if (file != null) {
      for (File f : file) {
        request.part(String.format(PARAM_FILES, f.getName()), f);
      }
    }

    return request.body();
  }

  public String getTo() {
    return this.to;
  }

  public String getBcc() {
    return this.bcc;
  }

  public String getFrom() {
    return this.from;
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

  public Sendgrid setTo(final String to) {
    this.to = to;
    return this;
  }

  public Sendgrid setFrom(final String email) {
    this.from = email;
    return this;
  }

  public Sendgrid setBcc(final String bcc) {
    this.bcc = bcc;
    return this;
  }

  public Sendgrid setSubject(final String subject) {
    this.subject = subject;
    return this;
  }

  public Sendgrid setText(final String text) {
    this.text = text;
    return this;
  }

  public Sendgrid setHtml(final String html) {
    this.html = html;
    return this;
  }

  public Sendgrid withAttachment(final File... file) {
    this.file = file;
    return this;
  }
}
