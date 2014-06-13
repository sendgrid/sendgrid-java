package com.sendgrid;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SendGridTest {
  SendGrid.Email email;

  private static final String USERNAME = "USERNAME";
  private static final String PASSWORD = "PASSWORD";

  @Test public void testAddTo() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    String address2 = "email2@example.com";
    email.addTo(address);
    email.addTo(address2);

    Map correct = new HashMap();
      correct.put("to[0]", address);
      correct.put("to[1]", address2);

    assertEquals(correct, email.toWebFormat());
  }

  @Test public void testAddToWithAFrom() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    String fromaddress = "from@mailinator.com";
    email.addTo(address);
    email.setFrom(fromaddress);

    Map correct = new HashMap();
    correct.put("from", fromaddress);
    correct.put("to[0]", address);

    assertEquals(correct, email.toWebFormat());

  }

  @Test public void testSetFrom() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    email.setFrom(address);

    Map correct = new HashMap();
    correct.put("from", address);

    assertEquals(correct, email.toWebFormat());
  }  

  @Test public void testSetFromName() {
    email = new SendGrid.Email();

    String fromname = "Uncle Bob";
    email.setFromName(fromname);

    Map correct = new HashMap();
    correct.put("fromname", fromname);

    assertEquals(correct, email.toWebFormat());
  }

  @Test public void testSetReplyTo() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    email.setReplyTo(address);

    Map correct = new HashMap();
    correct.put("replyto", address);

    assertEquals(correct, email.toWebFormat());
  }

  @Test public void testAddBcc() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    email.addBcc(address);

    Map correct = new HashMap();
    correct.put("bcc[0]", address);

    assertEquals(correct, email.toWebFormat());
  }

  @Test public void testSetSubject() {
    email = new SendGrid.Email();

    String subject = "This is a subject";
    email.setSubject(subject);

    Map correct = new HashMap();
    correct.put("subject", subject);

    assertEquals(correct, email.toWebFormat());
  }

  @Test public void testSetText() {
    email = new SendGrid.Email();

    String text = "This is some email text.";
    email.setText(text);

    Map correct = new HashMap();
    correct.put("text", text);

    assertEquals(correct, email.toWebFormat());
  }

  @Test public void testSetHtml() {
    email = new SendGrid.Email();

    String html = "This is some email text.";
    email.setHtml(html);

    Map correct = new HashMap();
    correct.put("html", html);

    assertEquals(correct, email.toWebFormat());
  }

  @Test public void testAddHeader() {
    email = new SendGrid.Email();

    email.addHeader("key", "value");
    email.addHeader("other", "other-value");                           

    Map correct = new HashMap();
    correct.put("headers", "{\"other\":\"other-value\",\"key\":\"value\"}");

    assertEquals(correct, email.toWebFormat());
  }

  @Test public void testAddAttachment() throws FileNotFoundException {

    email = new SendGrid.Email();

    File file = new File(getClass().getResource("/test.txt").getFile());
    email.addAttachment(file, "test.txt");

    Map correct = new HashMap();
    correct.put("files[test.txt]", "This is a test file.");

    assertEquals(correct, email.toWebFormat());
  }

  @Test public void testSend() throws FileNotFoundException, SendGridException {
    email = new SendGrid.Email();
    email.addTo("sendgrid@mailinator.com");
    email.setFrom("sendgrid-from@mailinator.com");
    email.setFromName("Mailinator");
    email.setReplyTo("sendgrid-replyto@mailinator.com");
    email.setSubject("Test");
    email.setText("Test body");
    email.setHtml("Test body");
    email.addCategory("-TEST-");
    File file = new File(getClass().getResource("/test.txt").getFile());
    email.addAttachment(file, "test.txt");
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);
    SendGrid.Response resp = sendgrid.send(email);

    assertEquals("{\"message\":\"error\",\"errors\":[\"Bad username / password\"]}", resp.getMessage());
  }


  @Test public void canAddRecipientToSmtpApi() {
      email = new SendGrid.Email();
      email.addSmtpApiTo("email@example.com");

      Map correct = new HashMap();
      correct.put("x-smtpapi", "{\"to\":[\"email@example.com\"]}");

      assertEquals(correct, email.toWebFormat());
  }
}
