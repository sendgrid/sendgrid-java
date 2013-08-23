package com.github.scottmotte.sendgrid;

import com.github.kevinsawicki.http.HttpRequest;

public class Sendgrid {
  protected String username;
  protected String password; 

  private String to       = "";
  private String from     = "";
  private String subject  = "";
  private String text     = "";
  private String html     = "";

  Sendgrid(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public void send() {
    this.web();
  }

  public void web() {
    HttpRequest request = HttpRequest.post("https://sendgrid.com/api/mail.send.json");

    request.part("api_user", this.username);
    request.part("api_key", this.password);
    request.part("to", this.getTo());
    request.part("subject", this.getSubject());
    request.part("from", this.getFrom());
    request.part("text", this.getText());
    request.part("html", this.getHtml());
    
    String response = request.body();

    System.out.println(response);
  }

  public String getTo() {
    return this.to;
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

  public Sendgrid setTo(String email) {
    this.to       = email;

    return this;
  }

  public Sendgrid setFrom(String email) {
    this.from     = email;

    return this;
  }

  public Sendgrid setSubject(String subject) {
    this.subject  = subject;

    return this;
  }

  public Sendgrid setText(String text) {
    this.text     = text;

    return this;
  }

  public Sendgrid setHtml(String html) {
    this.html     = html;

    return this;
  }
}
