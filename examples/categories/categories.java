import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Retrieve all categories
// GET /categories


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "categories";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("category", "test_string");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve Email Statistics for Categories
// GET /categories/stats


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "categories/stats";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("end_date", "2016-04-01");
      queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("categories", "test_string");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve sums of email stats for each category [Needs: Stats object defined, has category ID?]
// GET /categories/stats/sums


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "categories/stats/sums";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("end_date", "2016-04-01");
      queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("sort_by_metric", "test_string");
      queryParams.put("offset", "1");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("sort_by_direction", "asc");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

