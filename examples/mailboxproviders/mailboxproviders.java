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

##################################################
# Retrieve email statistics by mailbox provider. #
# GET /mailbox_providers/stats #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "mailbox_providers/stats";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("end_date", "2016-04-01");
      queryParams.put("mailbox_providers", "test_string");
      queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      queryParams.put("start_date", "2016-01-01");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

