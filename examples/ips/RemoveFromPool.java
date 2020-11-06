import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//////////////////////////////////////////////////////////////////
// Remove an IP address from a pool.
// DELETE /ips/pools/{pool_name}/ips/{ip}


public class RemoveIPFromPool {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.DELETE);
      request.setEndpoint("ips/pools/{pool_name}/ips/{ip}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}