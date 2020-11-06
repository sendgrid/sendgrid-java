import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Retrieve sums of email stats for each category [Needs: Stats object defined, has category ID?]
// GET /categories/stats/sums


public class RetrieveSumsForCategories {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("categories/stats/sums");
      request.addQueryParam("end_date", "2016-04-01");
      request.addQueryParam("aggregated_by", "day");
      request.addQueryParam("limit", "1");
      request.addQueryParam("sort_by_metric", "test_string");
      request.addQueryParam("offset", "1");
      request.addQueryParam("start_date", "2016-01-01");
      request.addQueryParam("sort_by_direction", "asc");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}

