package com.sendgrid.webhook;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

public class EventParserTest {

  private EventParser ep = new EventParser();

  private String readFile(String path) {
    try {
      byte[] encoded = Files.readAllBytes(Paths.get("src/test/java/com/sendgrid/webhook/" + path));
      return new String(encoded, StandardCharsets.UTF_8);
    } catch (IOException ie) {
      throw new RuntimeException(ie);
    }
  }

  @Test
  public void testParseBounceEvent() {
    String json = readFile("testParseBounceEvent.json");
    BounceEvent bounceEvent = (BounceEvent) ep.parseEvents(json).get(0);
    Assert.assertEquals("5.0.0", bounceEvent.getStatus());
  }
}
