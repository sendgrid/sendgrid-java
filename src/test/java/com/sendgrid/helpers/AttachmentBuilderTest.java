package com.sendgrid.helpers;

import com.sendgrid.Attachments;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

public class AttachmentBuilderTest {

    @Test
    public void testCreateAttachments() {
        String fileName = "book.txt";
        String type = "text/plain";
        String content = "This test checks if the builder works fine";
        InputStream contentStream = new ByteArrayInputStream(content.getBytes(Charset.forName("UTF-8")));
        String contentId = "someId";
        String dispositon = "someDisposition";

        Attachments attachments = new Attachments.Builder(fileName, contentStream)
                .withType(type)
                .withContentId(contentId)
                .withDisposition(dispositon)
                .build();

        Assert.assertEquals(attachments.getType(), type);
        Assert.assertEquals(attachments.getFilename(), fileName);
        Assert.assertEquals(attachments.getContentId(), contentId);
        Assert.assertEquals(attachments.getDisposition(), dispositon);
        Assert.assertEquals(attachments.getContent(), Base64.encodeBase64String(content.getBytes(Charset.forName("UTF-8"))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAttachmentsMissingRequiredFileNameParam() {
        String content = "This test checks if the builder works fine";
        InputStream contentStream = new ByteArrayInputStream(content.getBytes(Charset.forName("UTF-8")));
        Attachments attachments = new Attachments.Builder(null, contentStream).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAttachmentsMissingRequiredContentParam() {
        String type = "text";
        String content = null;
        Attachments attachments = new Attachments.Builder(type, content).build();
    }
}
