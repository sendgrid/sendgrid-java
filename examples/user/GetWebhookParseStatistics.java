//////////////////////////////////////////////////////////////////
// Retrieves Inbound Parse Webhook statistics.
// GET /user/webhooks/parse/stats


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.GET);
      request.setEndpoint("user/webhooks/parse/stats");
      request.addQueryParam("aggregated_by", "day");
      request.addQueryParam("limit", "test_string");
      request.addQueryParam("start_date", "2016-01-01");
      request.addQueryParam("end_date", "2016-04-01");
      request.addQueryParam("offset", "test_string");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}