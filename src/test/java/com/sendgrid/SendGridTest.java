package com.sendgrid;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.*;

public class SendGridTest {

  private final String SENDGRID_API_KEY = "";

  @Test
  public void dropboxUpload() throws IOException {
    Email from = new Email("example@example.com");
    String subject = "Sending with SendGrid is Fun";
    Email to = new Email("example@example.com");
    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
    Mail mail = new Mail(from, subject, to, content);
    mail.addDropboxAttachment("www.dropbox.com/s/w5cbrfd0cn8iax0/Systems_Development_Life_Cycle.jpg?dl=0");

    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    request.setBody(mail.build());

    Response response = sg.api(request);
    Assert.assertEquals(202, response.getStatusCode());
  }
}
