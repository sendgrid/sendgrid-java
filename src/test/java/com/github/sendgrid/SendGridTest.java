package com.github.sendgrid;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class SendGridTest {
    private static final String USERNAME = "username";

    private static final String PASSWORD = "password";

    private SendGrid sendgrid;

    @Before
    public void setUp() {
        sendgrid = new SendGrid(USERNAME, PASSWORD);
    }

    @After
    public void tearDown() {
        sendgrid = null;
    }

    @Test
    public void sanityTestSend() {
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
        String email = "email@example.com";
        sendgrid.addTo(email);

        assertThat(sendgrid.getTos(), hasItems(email));
    }

    @Test
    public void testAddToName() {
        String name = "Example Guy";
        sendgrid.addToName(name);

        assertThat(sendgrid.getToNames(), hasItems(name));
    }

    @Test
    public void testSetBcc() {
        String email = "email@example.com";
        sendgrid.setBcc(email);

        assertEquals(sendgrid.getBcc(), email);
    }

    @Test
    public void testSetFrom() {
        String email = "email@example.com";
        sendgrid.setFrom(email);

        assertEquals(sendgrid.getFrom(), email);
    }

    @Test
    public void testSetFromName() {
        String name = "Example Guy";
        sendgrid.setFromName(name);

        assertEquals(sendgrid.getFromName(), name);
    }

    @Test
    public void testSetReplyTo() {
        String email = "email@example.com";
        sendgrid.setReplyTo(email);

        assertEquals(sendgrid.getReplyTo(), email);
    }

    @Test
    public void testSetSubject() {
        String subject = "This is a subject";
        sendgrid.setSubject(subject);

        assertEquals(sendgrid.getSubject(), subject);
    }

    @Test
    public void testSetText() {
        String text = "This is some email text.";
        sendgrid.setText(text);

        assertEquals(sendgrid.getText(), text);
    }

    @Test
    public void testSetHtml() {
        String html = "This is some email text.";
        sendgrid.setHtml(html);

        assertEquals(sendgrid.getHtml(), html);
    }

    @Test
    public void testAddFile() throws FileNotFoundException {
        File file = new File(getClass().getResource("/test.txt").getFile());
        sendgrid.addFile(file);

        assertEquals(sendgrid.getAttachments().get(0).name, file.getName());
    }

    @Test
    public void testAddFileFromString() throws FileNotFoundException {
        try {
            InputStream is = new FileInputStream(getClass().getResource("/test.txt").getFile());
            is.close();

            SendGrid.Attachment attachment1 = new SendGrid.Attachment("filename.txt", is);
            sendgrid.addFile(attachment1);
            assertThat(sendgrid.getAttachments(), hasItems(attachment1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddMultipleFiles() throws FileNotFoundException {
        File file1 = new File(getClass().getResource("/test.txt").getFile());
        File file2 = new File(getClass().getResource("/image.png").getFile());

        sendgrid.addAttachment(file1);
        sendgrid.addFile(file2);

        assertEquals(sendgrid.getAttachments().get(0).name, file1.getName());
        assertEquals(sendgrid.getAttachments().get(1).name, file2.getName());
    }

    @Test
    public void testAddHeader() throws JSONException {
        sendgrid.addHeader("key", "value");
        sendgrid.addHeader("other", "other-value");

        assertEquals(sendgrid.getHeaders().get("key"), "value");
        assertEquals(sendgrid.getHeaders().get("other"), "other-value");
    }

    @Test
    public void testAddFilter_single_filter() throws Exception {
        final String expected = "{\"filters\":{\"sendgridApp\":{\"settings\":{\"enabled\":1}}}}";

        sendgrid.addFilter("sendgridApp", "enabled", 1);

        final String actual = (String) sendgrid.getHeaders().get("X-SMTPAPI");

        assertEquals(expected, actual);
    }

    @Test
    public void testAddFilter_multiple_filter() throws Exception {
        final String expected = "{\"filters\":{\"sendgridApp\":{\"settings\":{\"enabled\":1,\"pizza\":1}},\"ganalytics\":{\"settings\":{\"enabled\":1}}}}";

        sendgrid.addFilter("sendgridApp", "enabled", 1);
        sendgrid.addFilter("ganalytics", "enabled", 1);
        sendgrid.addFilter("sendgridApp", "pizza", 1);

        final String actual = (String) sendgrid.getHeaders().get("X-SMTPAPI");

        assertEquals(expected, actual);
    }

    @Test
    public void testAddFilter_multiple_duplicate_filters() throws Exception {
        final String expected = "{\"filters\":{\"sendgridApp\":{\"settings\":{\"enabled\":1,\"pizza\":1}},\"ganalytics\":{\"settings\":{\"enabled\":1}}}}";

        sendgrid.addFilter("sendgridApp", "enabled", 1);
        sendgrid.addFilter("sendgridApp", "enabled", 1);
        sendgrid.addFilter("ganalytics", "enabled", 1);
        sendgrid.addFilter("sendgridApp", "pizza", 1);

        final String actual = (String) sendgrid.getHeaders().get("X-SMTPAPI");

        assertEquals(expected, actual);
    }

    @Test
    public void testAddCategory_single_category() throws Exception {
        final String expected = "{\"category\":[\"category1\"]}";

        sendgrid.addCategory("category1");

        final String actual = (String) sendgrid.getHeaders().get("X-SMTPAPI");

        assertEquals(expected, actual);
    }

    @Test
    public void testAddCategory_multiple_categories() throws Exception {
        final String expected = "{\"category\":[\"category1\",\"category2\",\"category3\"]}";

        sendgrid.addCategory("category1");
        sendgrid.addCategory("category2");
        sendgrid.addCategory("category3");

        final String actual = (String) sendgrid.getHeaders().get("X-SMTPAPI");

        assertEquals(expected, actual);
    }

    @Test
    public void testAddCategory_multiple_duplicate_categories() throws Exception {
        final String expected = "{\"category\":[\"category1\",\"category2\"]}";

        sendgrid.addCategory("category1");
        sendgrid.addCategory("category2");
        sendgrid.addCategory("category2");

        final String actual = (String) sendgrid.getHeaders().get("X-SMTPAPI");

        assertEquals(expected, actual);
    }
}
