package com.github.sendgrid;

import com.github.sendgrid.smtpapi.SMTPAPI;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.util.HashMap;
import java.util.Arrays;
import java.io.InputStream;
import java.util.Iterator;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Mail extends SMTPAPI {

  private static final String PARAM_TOS         = "to[]";
  private static final String PARAM_TONAMES     = "toname[]";
  private static final String PARAM_BCCS        = "bcc[]";
  private static final String PARAM_FROM        = "from";
  private static final String PARAM_FROMNAME    = "fromname";
  private static final String PARAM_REPLYTO     = "replyto";
  private static final String PARAM_SUBJECT     = "subject";
  private static final String PARAM_HTML        = "html";
  private static final String PARAM_TEXT        = "text";
  private static final String PARAM_FILES       = "files[%s]";
  private static final String PARAM_HEADERS     = "headers";
  //private static final String PARAM_DATE        = "date";

  private ArrayList<String> to = new ArrayList<String>();
  private ArrayList<String> toname = new ArrayList<String>();
  private ArrayList<String> bcc = new ArrayList<String>();
  private String from;
  private String fromname;
  private String replyto;
  private String subject;
  private String text;
  private String html;
  private Map attachments = new HashMap();


  public Mail() {

  }

  public Mail addTo(String to) {
    this.to.add(to);
    return this;
  }

  public Mail addTo(String[] tos) {
    this.to.addAll(to);
    return this;
  }

  public Mail setTo(String[] tos) {
    this.to = new ArrayList(Arrays.asList(tos));
    return this;
  }

  public ArrayList<String> getTo() {
    return this.to;
  }

  public Mail addToName(String toname) {
    this.toname.add(toname);
    return this;
  }

  public Mail addToName(String[] tonames) {
    this.toname.addAll(Arrays.asList(tonames));
    return this;
  }

  public Mail setToName(String[] tonames) {
    this.toname = new ArrayList(Arrays.asList(tonames));
    return this;
  }

  public ArrayList<String> getToName() {
    return this.toname;
  }

  public Mail addBcc(String bcc) {
    this.bcc.add(bcc);
    return this;
  }

  public Mail addBcc(String[] bccs) {
    this.bcc.addAll(Arrays.asList(bccs));
    return this;
  }

  public Mail setBcc(String[] bccs) {
    this.bcc = new ArrayList(Arrays.asList(bccs));
    return this;
  }

  public ArrayList<String> getBcc() {
    return this.bcc;
  }

  public Mail setFrom(String from) {
    this.from = from;
    return this;
  }

  public String getFrom() {
    return this.from;
  }

  public Mail setFromName(String fromname) {
    this.fromname = fromname;
    return this;
  }

  public String getFromName() {
    return this.fromname;
  }

  public Mail setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getSubject() {
    return this.subject;
  }

  public Mail setReplyTo(String replyto) {
    this.replyto = replyto;
    return this;
  }

  public String getReplyTo() {
    return this.replyto;
  }

  public Mail setText(String text) {
    this.text = text;
    return this;
  }

  public String getText() {
    return this.text;
  }

  public Mail setHtml(String html) {
    this.html = html;
    return this;
  }

  public String getHtml() {
    return this.html;
  }

  public Mail addAttachment(File file, String name) throws FileNotFoundException {
    return this.addAttachment(new FileInputStream(file), name);
  }

  public Mail addAttachment(String file, String name) {
    this.attachments.put(name, file);
    return this;
  }

  public Mail addAttachment(InputStream file, String name) {
    Scanner scanner = new Scanner(file, "UTF-8");
    String buffer = new String();
    while (scanner.hasNextLine()) {
      buffer += scanner.nextLine();
    }
    return this.addAttachment(buffer, name);
  }

  public Map getAttachments() {
    return this.attachments;
  }

  protected Map buildBody() {
    Map body = new HashMap();
    if (this.to.size() > 0) {
      body.put(PARAM_TOS, this.to);
    }
    if (this.toname.size() > 0) {
      body.put(PARAM_TONAMES, this.toname);
    }
    if (this.bcc.size() > 0) {
      body.put(PARAM_BCCS, this.bcc);
    }
    if (this.from.length() > 0) {
      body.put(PARAM_FROM, this.from);
    }
    if (this.fromname.length() > 0) {
      body.put(PARAM_FROMNAME, this.fromname);
    }
    if (this.replyto.length() > 0) {
      body.put(PARAM_REPLYTO, this.replyto);
    }
    if (this.subject.length() > 0) {
      body.put(PARAM_SUBJECT, this.subject);
    }
    if (this.text.length() > 0) {
      body.put(PARAM_TEXT, this.text);
    }
    if (this.html.length() > 0) {
      body.put(PARAM_HTML, this.html);
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
