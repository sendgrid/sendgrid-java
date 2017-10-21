import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Retrieve email statistics by country and state/province.
// GET /geo/stats


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("geo/stats");
      request.addQueryParam("end_date", "2016-04-01");
      request.addQueryParam("country", "US");
      request.addQueryParam("aggregated_by", "day");
      request.addQueryParam("limit", "1");
      request.addQueryParam("offset", "1");
      request.addQueryParam("start_date", "2016-01-01");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}

