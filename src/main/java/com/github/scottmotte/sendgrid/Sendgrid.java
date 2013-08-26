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
  private String[] bcc;
  private File[] file;
  private String from;
  private String html;
  private String subject;
  private String text;
  private String[] to;
  
  public Sendgrid(final String username, final String password) {
    this.username = username;
    this.password = password;
  }

  public Sendgrid bcc(final String... bcc) {
    this.bcc = bcc;
    return this;
  }

  public Sendgrid from(final String email) {
    this.from = email;
    return this;
  }

  public String send() {
    this.web();
  } 

  public String web() {
    HttpRequest request = HttpRequest.post("https://sendgrid.com/api/mail.send.json");

    request.part(PARAM_API_USER, this.username);
    request.part(PARAM_API_KEY, this.password);

    if (from != null) {
      request.part(PARAM_FROM, from);
    }
    if (to != null) {
      for (String s : to) {
        request.part(PARAM_TO, s);
      }
    }
    if (bcc != null) {
      for (String s : bcc) {
        request.part(PARAM_BCC, s);
      }
    }
    if (subject != null) {
      request.part(PARAM_SUBJECT, subject);
    }
    if (text != null) {
      request.part(PARAM_TEXT, text);
    }
    if (html != null) {
      request.part(PARAM_HTML, html);
    }
    if (file != null) {
      for (File f : file) {
        request.part(String.format(PARAM_FILES, f.getName()), f);
      }
    }

    return request.body();
  }

  public Sendgrid to(final String... to) {
    this.to = to;
    return this;
  }

  public Sendgrid withAttachment(final File... file) {
    this.file = file;
    return this;
  }

  public Sendgrid withHtml(final String html) {
    this.html = html;
    return this;
  }

  public Sendgrid withSubject(final String subject) {
    this.subject = subject;
    return this;
  }

  public Sendgrid withText(final String text) {
    this.text = text;
    return this;
  }
}
