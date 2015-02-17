package com.sendgrid;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SendGridTest {
    SendGrid.Email email;

    private static final String USERNAME = "USERNAME";
    private static final String PASSWORD = "PASSWORD";

    @Test
    public void testAddTo() {
        email = new SendGrid.Email();

        String address = "email@example.com";
        String address2 = "email2@example.com";
        email.addTo(address);
        email.addTo(address2);

        String[] correct = {address, address2};

        assertArrayEquals(correct, email.getTos());
    }

    @Test
    public void testAddToWithAFrom() {
        email = new SendGrid.Email();

        String address = "email@example.com";
        String fromaddress = "from@mailinator.com";
        email.addTo(address);
        email.setFrom(fromaddress);

        String[] correct = {address};

        assertArrayEquals(correct, email.getTos());
        assertEquals(fromaddress, email.getFrom());

    }

    @Test
    public void testAddToName() {
        email = new SendGrid.Email();

        String name = "John";
        email.addToName(name);

        String[] correct = {name};

        assertArrayEquals(correct, email.getToNames());
    }

    @Test
    public void testAddCc() {
        email = new SendGrid.Email();

        String address = "email@example.com";
        email.addCc(address);

        String[] correct = {address};

        assertArrayEquals(correct, email.getCcs());
    }

    @Test
    public void testSetFrom() {
        email = new SendGrid.Email();

        String address = "email@example.com";
        email.setFrom(address);

        assertEquals(address, email.getFrom());
    }

    @Test
    public void testSetFromName() {
        email = new SendGrid.Email();

        String fromname = "Uncle Bob";
        email.setFromName(fromname);

        assertEquals(fromname, email.getFromName());
    }

    @Test
    public void testSetReplyTo() {
        email = new SendGrid.Email();

        String address = "email@example.com";
        email.setReplyTo(address);

        assertEquals(address, email.getReplyTo());
    }

    @Test
    public void testAddBcc() {
        email = new SendGrid.Email();

        String address = "email@example.com";
        email.addBcc(address);

        String[] correct = {address};

        assertArrayEquals(correct, email.getBccs());
    }

    @Test
    public void testSetSubject() {
        email = new SendGrid.Email();

        String subject = "This is a subject";
        email.setSubject(subject);

        assertEquals(subject, email.getSubject());
    }

    @Test
    public void testSetText() {
        email = new SendGrid.Email();

        String text = "This is some email text.";
        email.setText(text);

        assertEquals(text, email.getText());
    }

    @Test
    public void testSetHtml() {
        email = new SendGrid.Email();

        String html = "This is some email text.";
        email.setHtml(html);

        assertEquals(html, email.getHtml());
    }

    @Test
    public void testAddHeader() {
        email = new SendGrid.Email();

        email.addHeader("key", "value");
        email.addHeader("other", "other-value");

        Map<String, String> correct = new HashMap<String, String>();
        correct.put("key", "value");
        correct.put("other", "other-value");

        assertEquals(correct, email.getHeaders());
    }

    @Test
    public void testSmtpapiToHeader() {
        email = new SendGrid.Email();

        String[] expected = {"example@email.com"};

        email.getSMTPAPI().addTo(expected[0]);
        String[] result = email.getSMTPAPI().getTos();

        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetTemplates() {
        try {
            List<SendGrid.Template> availableTemplates = new SendGrid(USERNAME, PASSWORD).getTemplates();
            assertNotNull(availableTemplates);
        } catch (SendGridException e) {
            e.printStackTrace();
        }
    }
}
