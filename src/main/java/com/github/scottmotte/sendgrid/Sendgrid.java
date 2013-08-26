package com.github.scottmotte.sendgrid;

import com.github.kevinsawicki.http.HttpRequest;
import java.io.File;
import java.util.ArrayList;

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
  private ArrayList<File> files = new ArrayList<File>();

  
  public Sendgrid(String username, String password) {
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
    request.part(PARAM_TO,        this.getTo());
    request.part(PARAM_FROM,      this.getFrom());
    request.part(PARAM_SUBJECT,   this.getSubject());

    if (text != null) {
      request.part(PARAM_TEXT,    this.getText());
    }
    if (html != null) {
      request.part(PARAM_HTML,    this.getHtml());
    }

//    if (to != null) {
//      for (String s : to) {
//        request.part(PARAM_TO, s);
//      }
//    }
    if (this.getBcc() != null) {
      request.part(PARAM_BCC, this.getBcc());
    }
    if (files != null) {
      for (File file:files) {
        System.out.println(file.getName());
        request.part(String.format(PARAM_FILES, file.getName()), file);
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

  public ArrayList<File> getFiles() {
    return this.files;
  }

  public Sendgrid setTo(String to) {
    this.to = to;
    return this;
  }

  public Sendgrid setFrom(String email) {
    this.from = email;
    return this;
  }

  public Sendgrid setBcc(String bcc) {
    this.bcc = bcc;
    return this;
  }

  public Sendgrid setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public Sendgrid setText(String text) {
    this.text = text;
    return this;
  }

  public Sendgrid setHtml(String html) {
    this.html = html;
    return this;
  }

  public Sendgrid addFile(File file) {
    this.files.add(file);
    return this;
  }
}
