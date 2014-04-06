package com.sendgrid;

import org.json.JSONException;
import org.junit.Test;
import org.junit.Before;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;

import com.mashape.unirest.http.exceptions.*;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class SendGridTest {

  Mail mail;

  private static final String USERNAME = System.getenv("SG_USER");
  private static final String PASSWORD = System.getenv("SG_PWD");

  @Before public void initialize() {
    mail = new Mail();
  }

  @Test public void testAddTo() {
    String email = "email@example.com";
    mail.addTo(email);
    assertThat(mail.getTo(), hasItems(email));
  }

  @Test public void testAddToName() {
    String name = "Example Guy";
    mail.addToName(name);
    assertThat(mail.getToName(), hasItems(name));
  }

  @Test public void testAddBcc() {
    String email = "email@example.com";
    mail.addBcc(email);
    assertThat(mail.getBcc(), hasItems(email));
  }

  @Test public void testSetFrom() {
    String email = "email@example.com";
    mail.setFrom(email);
    assertEquals(mail.getFrom(), email);
  }

  @Test public void testSetFromName() {
    String name = "Example Guy";
    mail.setFromName(name);
    assertEquals(mail.getFromName(), name);
  }

  @Test public void testSetReplyTo() {
    String email = "email@example.com";
    mail.setReplyTo(email);
    assertEquals(mail.getReplyTo(), email);
  }

  @Test public void testSetSubject() {
    String subject = "This is a subject";
    mail.setSubject(subject);
    assertEquals(mail.getSubject(), subject);
  }

  @Test public void testSetText() {
    String text = "This is some email text.";
    mail.setText(text);
    assertEquals(mail.getText(), text);
  }

  @Test public void testSetHtml() {
    String html = "This is some email text.";
    mail.setHtml(html);
    assertEquals(mail.getHtml(), html);
  }

  @Test public void testAddAttachment() throws FileNotFoundException {
    File file = new File(getClass().getResource("/test.txt").getFile());
    mail.addAttachment(file, "test.txt");
    assertTrue(mail.getAttachment().keySet().contains("test.txt"));
  }

  @Test public void testSend() throws FileNotFoundException, SendGridException {
    mail.addTo("yamil@sendgrid.com");
    mail.addToName("Yamil");
    mail.setFrom("yamil@sendgrid.com");
    mail.setFromName("Yamil");
    mail.setReplyTo("yamil@sendgrid.com");
    mail.setSubject("Test");
    mail.setText("Test body");
    mail.setHtml("Test body");
    mail.addCategory("-TEST-");
    File file = new File(getClass().getResource("/test.txt").getFile());
    mail.addAttachment(file, "test.txt");
    SendGrid sg = new SendGrid(USERNAME, PASSWORD);
    SendGridResponse resp = sg.send(mail);
    System.out.println(resp.getStatus() + resp.getMessage());
  }

}
