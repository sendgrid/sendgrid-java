package com.github.sendgrid;

import com.github.sendgrid.smtpapi.SMTPAPI;


import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Mail extends SMTPAPI {

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

  public Map getAttachment() {
    return this.attachments;
  }

}
