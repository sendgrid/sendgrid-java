package com.sendgrid.helpers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import com.sendgrid.helpers.mail.objects.Content;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;

public class ContentTest {
  private Content content;

  @Before
  public void setUp() {
    this.content = new Content();
  }

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void testForbiddenContentIsRejected() {

    ArrayList<String> sampleApiKeys = new ArrayList<>(
            Arrays.asList(
                    "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",
                    "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"
                    )

    );

    for (String apiKey: sampleApiKeys) {
      exception.expect(IllegalArgumentException.class);
      this.content.setValue("My api key is: " + apiKey);
    }
  }

  @Test
  public void testNormalContentIsAllowed() {
    String message = "I will not send you my api key!";
    this.content.setValue(message);
    Assert.assertEquals(message, this.content.getValue());
  }

}
