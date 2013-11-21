package com.github.sendgrid;

import org.json.JSONException;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException; 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class SendGridTest {
  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";
  
  @Test public void sanityTestSend() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.addTo(email);
    sendgrid.addToName("Name Guy");
    sendgrid.setFrom(email);
    sendgrid.setFromName("Some Name");
    sendgrid.setReplyTo("no-reply@nowhere.com");
    sendgrid.setSubject("Subject");
    sendgrid.setText("Text");
    sendgrid.setHtml("Html");
    sendgrid.addHeader("key", "value");
    String response = sendgrid.send();

    assertEquals(response, "{\"message\": \"error\", \"errors\": [\"Bad username / password\"]}");
  }

  @Test
  public void testAddTo() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.addTo(email);

    assertThat(sendgrid.getTos(), hasItems(email)); 
  }

  @Test
  public void testAddToName() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String name = "Example Guy";
    sendgrid.addToName(name);

    assertThat(sendgrid.getToNames(), hasItems(name)); 
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
  public void testSetFromName() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String name = "Example Guy";
    sendgrid.setFromName(name);

    assertEquals(sendgrid.getFromName(), name); 
  }

  @Test
  public void testSetReplyTo() {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    String email = "email@example.com";
    sendgrid.setReplyTo(email);

    assertEquals(sendgrid.getReplyTo(), email); 
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
  public void testAddFile() throws FileNotFoundException {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    File file = new File(getClass().getResource("/test.txt").getFile());
    sendgrid.addFile(file);

    assertEquals(sendgrid.getAttachments().get(0).name, file.getName());
  }

  @Test
  public void testAddFileFromString() throws FileNotFoundException {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    //File file = new File(getClass().getResource("/test.txt").getFile());
    InputStream is;
    try {
      is = new FileInputStream(getClass().getResource("/test.txt").getFile());
      is.close(); 

      SendGrid.Attachment attachment1 = new SendGrid.Attachment("filename.txt", is);
      sendgrid.addFile(attachment1);
      assertThat(sendgrid.getAttachments(), hasItems(attachment1));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testAddMultipleFiles() throws FileNotFoundException {
    SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);

    File file1 = new File(getClass().getResource("/test.txt").getFile());
    File file2 = new File(getClass().getResource("/image.png").getFile());

    sendgrid.addAttachment(file1);
    sendgrid.addFile(file2);

    assertEquals(sendgrid.getAttachments().get(0).name, file1.getName());
    assertEquals(sendgrid.getAttachments().get(1).name, file2.getName());
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
