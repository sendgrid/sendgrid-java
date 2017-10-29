import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

//////////////////////////////////////////////////////////////////
// Update forward bounce mail settings
// PATCH /mail_settings/forward_bounce


public class UpdateForwardBounceMailSettings {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.PATCH);
      request.setEndpoint("mail_settings/forward_bounce");
      request.setBody("{\"enabled\":true,\"email\":\"example@example.com\"}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}