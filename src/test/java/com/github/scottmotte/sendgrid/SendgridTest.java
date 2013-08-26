package com.github.scottmotte.sendgrid;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class SendgridTest {
    private static final String FROM_EMAIL = "from@email.to";
    private static final String PASSWORD = "password";
    private static final String TO_ANOTHER_EMAIL = "bcc@email.to";
    private static final String TO_EMAIL = "to@email.to";
    private static final String USERNAME = "username";

    @Test
    public void testSendSuccess() {
        String result = Sendgrid
                .withCredentials(USERNAME, PASSWORD)
                .from(FROM_EMAIL)
                .to(TO_EMAIL)
                .withSubject("This is a test subject")
                .withText("This is a test text.")
                .send();
        assertEquals("{\"message\":\"success\"}", result);
    }

    @Test
    public void testSendSuccessBcc() {
        String result = Sendgrid
                .withCredentials(USERNAME, PASSWORD)
                .from(FROM_EMAIL)
                .to(TO_EMAIL)
                .bcc(TO_ANOTHER_EMAIL)
                .withSubject("This is a test subject")
                .withText("This is a test text.")
                .send();
        assertEquals("{\"message\":\"success\"}", result);
    }

    @Test
    public void testSendSuccessWithAttachment() {
        File attachment = new File(getClass().getResource("/test.txt").getFile());
        String result = Sendgrid
                .withCredentials(USERNAME, PASSWORD)
                .from(FROM_EMAIL)
                .to(TO_EMAIL)
                .withSubject("This is a test subject")
                .withText("This is a test text.")
                .withAttachment(attachment)
                .send();
        assertEquals("{\"message\":\"success\"}", result);
    }

    @Test
    public void testSendSuccessWithMultipleRecipients() {
        String result = Sendgrid
                .withCredentials(USERNAME, PASSWORD)
                .from(FROM_EMAIL)
                .to(TO_EMAIL, TO_ANOTHER_EMAIL)
                .withSubject("This is a test subject")
                .withText("This is a test text.")
                .send();
        assertEquals("{\"message\":\"success\"}", result);
    }

    @Test
    public void testSendWithoutFrom() {
        String result = Sendgrid
                .withCredentials(USERNAME, PASSWORD)
                .to(TO_EMAIL)
                .withSubject("This is a test subject")
                .withText("This is a test text.")
                .send();
        assertEquals("{\"message\": \"error\", \"errors\": [\"Empty from email address (required)\"]}", result);
    }
}
