package com.sendgrid.webhook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.common.SendGridRuntimeException;
import java.io.IOException;
import java.util.List;

public class EventParser {

  public List<Event> parseEvents(String jsonArrayString) {
    ObjectMapper om = new ObjectMapper();
    try {
      return om.readValue(jsonArrayString,
          om.getTypeFactory().constructCollectionType(List.class, Event.class));
    } catch (IOException ie) {
      throw new SendGridRuntimeException("fail to parse webhook events.", ie);
    }
  }
}
