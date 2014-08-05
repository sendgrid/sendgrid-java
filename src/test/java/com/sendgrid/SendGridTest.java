package com.sendgrid;

import org.json.JSONException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItems;

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

    String[] correct = {address, address2};

    assertArrayEquals(correct, email.getTos());
  }

  @Test public void testAddToWithAFrom() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    String fromaddress = "from@mailinator.com";
    email.addTo(address);
    email.setFrom(fromaddress);

    String[] correct = {address};

    assertArrayEquals(correct, email.getTos());
    assertEquals(fromaddress, email.getFrom());

  }

  @Test public void testAddToName() {
    email = new SendGrid.Email();

    String name = "John";
    email.addToName(name);

    String[] correct = {name};

    assertArrayEquals(correct, email.getToNames());
  }

  @Test public void testAddCc() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    email.addCc(address);

    String[] correct = {address};

    assertArrayEquals(correct, email.getCcs());
  }

  @Test public void testSetFrom() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    email.setFrom(address);

    assertEquals(address, email.getFrom());
  }

  @Test public void testSetFromName() {
    email = new SendGrid.Email();

    String fromname = "Uncle Bob";
    email.setFromName(fromname);

    assertEquals(fromname, email.getFromName());
  }

  @Test public void testSetReplyTo() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    email.setReplyTo(address);

    assertEquals(address, email.getReplyTo());
  }

  @Test public void testAddBcc() {
    email = new SendGrid.Email();

    String address = "email@example.com";
    email.addBcc(address);

    String[] correct = {address};

    assertArrayEquals(correct, email.getBccs());
  }

  @Test public void testSetSubject() {
    email = new SendGrid.Email();

    String subject = "This is a subject";
    email.setSubject(subject);

    assertEquals(subject, email.getSubject());
  }

  @Test public void testSetText() {
    email = new SendGrid.Email();

    String text = "This is some email text.";
    email.setText(text);

    assertEquals(text, email.getText());
  }

  @Test public void testSetHtml() {
    email = new SendGrid.Email();

    String html = "This is some email text.";
    email.setHtml(html);

    assertEquals(html, email.getHtml());
  }

  @Test public void testAddHeader() {
    email = new SendGrid.Email();

    email.addHeader("key", "value");
    email.addHeader("other", "other-value");

    Map<String, String> correct = new HashMap<String, String>();
    correct.put("key", "value");
    correct.put("other", "other-value");

    assertEquals(correct, email.getHeaders());
  }
}