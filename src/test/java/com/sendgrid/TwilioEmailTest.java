package com.sendgrid;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TwilioEmailTest {

  @Test
  public void testInitialization() {
    final TwilioEmail sg = new TwilioEmail("username", "password");
    Assert.assertEquals("email.twilio.com", sg.getHost());
    Assert.assertEquals("Basic dXNlcm5hbWU6cGFzc3dvcmQ=", sg.getRequestHeaders().get("Authorization"));
  }

  @Test
  public void testConstructWithClient() throws IOException {
    final Client client = mock(Client.class);
    final TwilioEmail sg = new TwilioEmail("username", "password", client);
    final Request request = new Request();

    sg.makeCall(request);
    verify(client).api(request);
  }
}
