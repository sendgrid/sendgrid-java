//////////////////////////////////////////////////////////////////
// Update a parse setting
// PATCH /user/webhooks/parse/settings/{hostname}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.PATCH);
      request.setEndpoint("user/webhooks/parse/settings/{hostname}");
      request.setBody("{\"url\":\"http://newdomain.com/parse\",\"send_raw\":true,\"spam_check\":false}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}