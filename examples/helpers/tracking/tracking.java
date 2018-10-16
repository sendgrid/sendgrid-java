import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;

//////////////////////////////////////////////////////////////////
// Update Subscription Tracking Settings using a helper
// PATCH /tracking_settings/subscription

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.PATCH);
      request.setEndpoint("tracking_settings/subscription");

      SubscriptionTracking st = new SubscriptionTracking();
      st.setEnabled(true);
      st.setHtmlContent("This is html1 <% Hello %>");
      st.setPlainContent("This is text body1 <% Hello %>");
      st.setCustomLandingPageUrl("http://www.youtube.com/hello/");
      st.setSendGridLandingPageHtml("This is your landing page. Now go.");
      st.setReplacementTag("<ab></ab>");

      request.setBody(st.build());
      Response response = sg.api(request);

      ObjectMapper mapper = new ObjectMapper();
      SubscriptionTracking st1 = mapper.readValue(response.getBody(), SubscriptionTracking.class);

      System.out.println(response.getStatusCode());
      System.out.println("-----------------------------------------");
      System.out.println(st1.getEnabled());
      System.out.println(st1.getHtmlContent());
      System.out.println(st1.getPlainContent());
      System.out.println(st1.getCustomLandingPageUrl());
      System.out.println(st1.getSendGridLandingPageHtml());
      System.out.println(st1.getReplacementTag());
      System.out.println("----------------------------------------");
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}
