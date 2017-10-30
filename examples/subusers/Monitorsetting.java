// Update Monitor Settings for a subuser
// PUT /subusers/{subuser_name}/monitor


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.PUT);
      request.setEndpoint("subusers/{subuser_name}/monitor");
      request.setBody("{\"frequency\":500,\"email\":\"example@example.com\"}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}

