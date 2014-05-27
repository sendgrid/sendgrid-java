package com.sendgrid;

import org.json.JSONObject;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class SendGrid {

  private static final String PARAM_TOS         = "to[%d]";
  private static final String PARAM_TONAMES     = "toname[%d]";
  private static final String PARAM_BCCS        = "bcc[%d]";
  private static final String PARAM_FROM        = "from";
  private static final String PARAM_FROMNAME    = "fromname";
  private static final String PARAM_REPLYTO     = "replyto";
  private static final String PARAM_SUBJECT     = "subject";
  private static final String PARAM_HTML        = "html";
  private static final String PARAM_TEXT        = "text";
  private static final String PARAM_FILES       = "files[%s]";
  private static final String PARAM_HEADERS     = "x-smtpapi";

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

  private Map buildBody(Mail mail) {
    Map body = new HashMap();
    String[] tos = mail.getTos();
    String[] tonames = mail.getToNames();
    String[] bccs = mail.getBccs();
    for (int i = 0; i < tos.length; i++) {
      body.put(String.format(PARAM_TOS, i), tos[i]);
    }
    for (int i = 0; i < tonames.length; i++) {
      body.put(String.format(PARAM_TONAMES, i), tonames[i]);
    }
    for (int i = 0; i < bccs.length; i++) {
      body.put(String.format(PARAM_BCCS, i), bccs[i]);
    }
    if (mail.getFrom().length() > 0) {
      body.put(PARAM_FROM, mail.getFrom());
    }
    if (mail.getFromName().length() > 0) {
      body.put(PARAM_FROMNAME, mail.getFromName());
    }
    if (mail.getReplyTo().length() > 0) {
      body.put(PARAM_REPLYTO, mail.getReplyTo());
    }
    if (mail.getSubject().length() > 0) {
      body.put(PARAM_SUBJECT, mail.getSubject());
    }
    if (mail.getText().length() > 0) {
      body.put(PARAM_TEXT, mail.getText());
    }
    if (mail.getHtml().length() > 0) {
      body.put(PARAM_HTML, mail.getHtml());
    }
    if (mail.getAttachments().size() > 0) {
      Iterator it = mail.getAttachments().entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry entry = (Map.Entry) it.next();
        body.put(String.format(PARAM_FILES, entry.getKey()), entry.getValue());
      }
    }
    body.put(PARAM_HEADERS, mail.jsonString());
    return body;
  }

  public SendGridResponse send(Mail mail) throws SendGridException {
    try {
      HttpResponse<JsonNode> res = Unirest.post(this.url + this.endpoint)
      .fields(this.buildBody(mail)).field("api_user", this.username).field("api_key", this.password).asJson();
      return new SendGridResponse(res.getCode(), res.getBody());
    } catch (UnirestException e) {
      throw new SendGridException(e);
    }
  }

  public class Email {
    // put all the Mail stuff in here
  }

}
