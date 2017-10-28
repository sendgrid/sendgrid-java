import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

public class AccessSettings {
  private static SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
  private static Request request = new Request();
    /**
     * Retrieve all recent access attempts
     * GET /access_settings/activity
     */
    public static void RetrieveAllRecentAccessAttempts() {
      try {
        request.setMethod(Method.GET);
        request.setEndpoint("access_settings/activity");
        request.addQueryParam("limit", "1");
        Response response = sg.api(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
      } catch (IOException ex) {
        throw ex;
      }
    }
  /**
   * Add one or more IPs to the whitelist
   * POST /access_settings/whitelist
   */
  public static void addIPsToWhiteList() {
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("access_settings/whitelist");
      request.setBody("{\"ips\":[{\"ip\":\"192.168.1.1\"},{\"ip\":\"192.*.*.*\"},{\"ip\":\"192.168.1.3/32\"}]}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
  /**
   * Retrieve a list of currently whitelisted IPs
   * GET /access_settings/whitelist
   */
  public static void retrieveWhiteListedIPs() {
    try {
      request.setMethod(Method.GET);
      request.setEndpoint("access_settings/whitelist");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }

  /**
   * Remove one or more IPs from the whitelist
   * DELETE /access_settings/whitelist
   */
  public static void removeIPsFromWhiteList() {
    try {
      Request request = new Request();
      request.setMethod(Method.DELETE);
      request.setEndpoint("access_settings/whitelist");
      request.setBody("{\"ids\":[1,2,3]}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }

  /**
   * Retrieve a specific whitelisted IP
   * GET /access_settings/whitelist/{rule_id}
   */
  public static void retriveSpecificWhiteListedIP() {
    try {
      request.setMethod(Method.GET);
      request.setEndpoint("access_settings/whitelist/{rule_id}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }

  /**
   * Remove a specific IP from the whitelist
   * DELETE /access_settings/whitelist/{rule_id}
   */
  public static void removeSpecificIPFromWhiteList() {
    try {
      request.setMethod(Method.DELETE);
      request.setEndpoint("access_settings/whitelist/{rule_id}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}


