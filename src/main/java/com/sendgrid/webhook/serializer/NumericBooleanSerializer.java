package com.sendgrid.webhook.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sendgrid.common.SendGridRuntimeException;
import java.io.IOException;

public class NumericBooleanSerializer extends JsonDeserializer<Boolean> {

  @Override
  public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {
    String value = jsonParser.getValueAsString();
    if ("1".equals(value)) {
      return true;
    } else if ("0".equals(value)) {
      return false;
    } else {
      throw new SendGridRuntimeException(
          String.format("invalid boolean value at field [%s]: %s", jsonParser.getCurrentName(), value));
    }
  }
}
