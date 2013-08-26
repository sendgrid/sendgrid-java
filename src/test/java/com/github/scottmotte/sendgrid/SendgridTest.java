package com.github.scottmotte.sendgrid;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class SendgridTest {
  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";
  
  @Test
  public void testSetTo() {
    Sendgrid sendgrid = new Sendgrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.setTo(email);

    assertEquals(sendgrid.getTo(), email); 
  }

  @Test
  public void testSetBcc() {
    Sendgrid sendgrid = new Sendgrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.setBcc(email);

    assertEquals(sendgrid.getBcc(), email); 
  }
 
  @Test
  public void testSetFrom() {
    Sendgrid sendgrid = new Sendgrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.setFrom(email);

    assertEquals(sendgrid.getFrom(), email); 
  }

  @Test
  public void testSetSubject() {
    Sendgrid sendgrid = new Sendgrid(USERNAME, PASSWORD);

    String subject = "This is a subject";
    sendgrid.setSubject(subject);

    assertEquals(sendgrid.getSubject(), subject); 
  }

  @Test
  public void testSetText() {
    Sendgrid sendgrid = new Sendgrid(USERNAME, PASSWORD);

    String text = "This is some email text.";
    sendgrid.setText(text);

    assertEquals(sendgrid.getText(), text); 
  }

  @Test
  public void testSetHtml() {
    Sendgrid sendgrid = new Sendgrid(USERNAME, PASSWORD);

    String html = "This is some email text.";
    sendgrid.setHtml(html);

    assertEquals(sendgrid.getHtml(), html); 
  }

  @Test
  public void testAddFile() {
    Sendgrid sendgrid = new Sendgrid(USERNAME, PASSWORD);

    File file = new File(getClass().getResource("/test.txt").getFile());
    sendgrid.addFile(file);

    assertThat(sendgrid.getFiles(), hasItems(file)); 
  }

  @Test
  public void testAddMultipleFiles() {
    Sendgrid sendgrid = new Sendgrid(USERNAME, PASSWORD);

    File file = new File(getClass().getResource("/test.txt").getFile());
    File file2 = new File(getClass().getResource("/image.png").getFile());

    sendgrid.addFile(file);
    sendgrid.addFile(file2);

    assertThat(sendgrid.getFiles(), hasItems(file, file2)); 
  }

//  @Test
//  public void testSendSuccess() {
//    String result = Sendgrid
//            .withCredentials(USERNAME, PASSWORD)
//            .from(FROM_EMAIL)
//            .to(TO_EMAIL)
//            .withSubject("This is a test subject")
//            .withText("This is a test text.")
//            .send();
//    assertEquals("{\"message\":\"success\"}", result);
//  }
//
//  @Test
//  public void testSendSuccessBcc() {
//    String result = Sendgrid
//            .withCredentials(USERNAME, PASSWORD)
//            .from(FROM_EMAIL)
//            .to(TO_EMAIL)
//            .bcc(TO_ANOTHER_EMAIL)
//            .withSubject("This is a test subject")
//            .withText("This is a test text.")
//            .send();
//    assertEquals("{\"message\":\"success\"}", result);
//  }
//
//  @Test
//  public void testSendSuccessWithAttachment() {
//    File attachment = new File(getClass().getResource("/test.txt").getFile());
//    String result = Sendgrid
//            .withCredentials(USERNAME, PASSWORD)
//            .from(FROM_EMAIL)
//            .to(TO_EMAIL)
//            .withSubject("This is a test subject")
//            .withText("This is a test text.")
//            .withAttachment(attachment)
//            .send();
//    assertEquals("{\"message\":\"success\"}", result);
//  }
//
//  @Test
//  public void testSendSuccessWithMultipleRecipients() {
//    String result = Sendgrid
//            .withCredentials(USERNAME, PASSWORD)
//            .from(FROM_EMAIL)
//            .to(TO_EMAIL, TO_ANOTHER_EMAIL)
//            .withSubject("This is a test subject")
//            .withText("This is a test text.")
//            .send();
//    assertEquals("{\"message\":\"success\"}", result);
//  }
//
//  @Test
//  public void testSendWithoutFrom() {
//    String result = Sendgrid
//            .withCredentials(USERNAME, PASSWORD)
//            .to(TO_EMAIL)
//            .withSubject("This is a test subject")
//            .withText("This is a test text.")
//            .send();
//    assertEquals("{\"message\": \"error\", \"errors\": [\"Empty from email address (required)\"]}", result);
//  }
}
