package com.sendgrid;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SendGridTest {

    @Test
    public void testAddTo() {
        final Email email = new Email();

        String address = "email@example.com";
        String address2 = "email2@example.com";
        email.addTo(address);
        email.addTo(address2);

        String[] correct = { address, address2 };

        assertArrayEquals(correct, email.getTos());
    }

    @Test
    public void testAddToWithAFrom() {
        final Email email = new Email();

        String address = "email@example.com";
        String fromaddress = "from@mailinator.com";
        email.addTo(address);
        email.setFrom(fromaddress);

        String[] correct = { address };

        assertArrayEquals(correct, email.getTos());
        assertEquals(fromaddress, email.getFrom());

    }

    @Test
    public void testAddToName() {
        final Email email = new Email();

        String name = "John";
        email.addToName(name);

        String[] correct = { name };

        assertArrayEquals(correct, email.getToNames());
    }

    @Test
    public void testAddCc() {
        final Email email = new Email();

        String address = "email@example.com";
        email.addCc(address);

        String[] correct = { address };

        assertArrayEquals(correct, email.getCcs());
    }

    @Test
    public void testSetFrom() {
        final Email email = new Email();

        String address = "email@example.com";
        email.setFrom(address);

        assertEquals(address, email.getFrom());
    }

    @Test
    public void testSetFromName() {
        final Email email = new Email();

        String fromname = "Uncle Bob";
        email.setFromName(fromname);

        assertEquals(fromname, email.getFromName());
    }

    @Test
    public void testSetReplyTo() {
        final Email email = new Email();

        String address = "email@example.com";
        email.setReplyTo(address);

        assertEquals(address, email.getReplyTo());
    }

    @Test
    public void testAddBcc() {
        final Email email = new Email();

        String address = "email@example.com";
        email.addBcc(address);

        String[] correct = { address };

        assertArrayEquals(correct, email.getBccs());
    }

    @Test
    public void testSetSubject() {
        final Email email = new Email();

        String subject = "This is a subject";
        email.setSubject(subject);

        assertEquals(subject, email.getSubject());
    }

    @Test
    public void testSetText() {
        final Email email = new Email();

        String text = "This is some email text.";
        email.setText(text);

        assertEquals(text, email.getText());
    }

    @Test
    public void testSetHtml() {
        final Email email = new Email();

        String html = "This is some email text.";
        email.setHtml(html);

        assertEquals(html, email.getHtml());
    }

    @Test
    public void testAddHeader() {
        final Email email = new Email();

        email.addHeader("key", "value");
        email.addHeader("other", "other-value");

        Map<String, String> correct = new HashMap<String, String>();
        correct.put("key", "value");
        correct.put("other", "other-value");

        assertEquals(correct, email.getHeaders());
    }

    @Test
    public void testSmtpapiToHeader() {
        final Email email = new Email();

        String[] expected = { "example@email.com" };

        email.getSMTPAPI().addTo(expected[0]);
        String[] result = email.getSMTPAPI().getTos();

        assertArrayEquals(expected, result);
    }

}
