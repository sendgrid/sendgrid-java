package com.sendgrid.webhook.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.Date;

public class TimestampSerializer extends JsonDeserializer<Date> {

  @Override
  public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {
    return new Date(jsonParser.getValueAsLong() * 1000);
  }
}
