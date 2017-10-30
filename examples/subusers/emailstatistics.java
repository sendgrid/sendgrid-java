// Retrieve email statistics for your subusers.
// GET /subusers/stats


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("subusers/stats");
      request.addQueryParam("end_date", "2016-04-01");
      request.addQueryParam("aggregated_by", "day");
      request.addQueryParam("limit", "1");
      request.addQueryParam("offset", "1");
      request.addQueryParam("start_date", "2016-01-01");
      request.addQueryParam("subusers", "test_string");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}
//////////////////////////////////////////////////////////////////
// Retrieve the monthly email statistics for a single subuser
// GET /subusers/{subuser_name}/stats/monthly


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("subusers/{subuser_name}/stats/monthly");
      request.addQueryParam("date", "test_string");
      request.addQueryParam("sort_by_direction", "asc");
      request.addQueryParam("limit", "1");
      request.addQueryParam("sort_by_metric", "test_string");
      request.addQueryParam("offset", "1");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}
////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////
//  Retrieve the totals for each email statistic metric for all subusers.
// GET /subusers/stats/sums


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("subusers/stats/sums");
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


