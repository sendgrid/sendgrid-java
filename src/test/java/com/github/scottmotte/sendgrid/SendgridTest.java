package com.github.scottmotte.sendgrid;

import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;
import org.json.JSONObject;
import org.json.JSONException;

public class SendGridTest {
  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";
  
  @Test public void sanityTestSend() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.addTo(email);
    sendgrid.setFrom(email);
    sendgrid.setSubject("Subject");
    sendgrid.setText("Text");
    sendgrid.setHtml("Html");
    sendgrid.addHeader("key", "value");
    String response = sendgrid.send();

    assertEquals(response, "{\"message\": \"error\", \"errors\": [\"Bad username / password\"]}");
  }

  @Test
  public void testSetTo() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.addTo(email);

    assertThat(sendgrid.getTos(), hasItems(email)); 
  }

  @Test
  public void testSetBcc() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.setBcc(email);

    assertEquals(sendgrid.getBcc(), email); 
  }
 
  @Test
  public void testSetFrom() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.setFrom(email);

    assertEquals(sendgrid.getFrom(), email); 
  }

  @Test
  public void testSetSubject() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String subject = "This is a subject";
    sendgrid.setSubject(subject);

    assertEquals(sendgrid.getSubject(), subject); 
  }

  @Test
  public void testSetText() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String text = "This is some email text.";
    sendgrid.setText(text);

    assertEquals(sendgrid.getText(), text); 
  }

  @Test
  public void testSetHtml() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String html = "This is some email text.";
    sendgrid.setHtml(html);

    assertEquals(sendgrid.getHtml(), html); 
  }

  @Test
  public void testAddFile() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    File file = new File(getClass().getResource("/test.txt").getFile());
    sendgrid.addFile(file);

    assertThat(sendgrid.getFiles(), hasItems(file)); 
  }

  @Test
  public void testAddMultipleFiles() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    File file = new File(getClass().getResource("/test.txt").getFile());
    File file2 = new File(getClass().getResource("/image.png").getFile());

    sendgrid.addFile(file);
    sendgrid.addFile(file2);

    assertThat(sendgrid.getFiles(), hasItems(file, file2)); 
  }

  @Test
  public void testAddHeader() throws JSONException {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    sendgrid.addHeader("key", "value");
    sendgrid.addHeader("other", "other-value");

    assertEquals(sendgrid.getHeaders().get("key"), "value"); 
    assertEquals(sendgrid.getHeaders().get("other"), "other-value"); 
  }
}
