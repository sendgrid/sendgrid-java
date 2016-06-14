import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.Client;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Retrieve email statistics by browser. 
// GET /browsers/stats


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "browsers/stats";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("end_date", "2016-04-01");
      queryParams.put("aggregated_by", "day");
      queryParams.put("browsers", "test_string");
      queryParams.put("limit", "test_string");
      queryParams.put("offset", "test_string");
      queryParams.put("start_date", "2016-01-01");
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

