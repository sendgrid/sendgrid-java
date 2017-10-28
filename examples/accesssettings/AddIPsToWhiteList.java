package accesssettings;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

/**
 * Add one or more IPs to the whitelist
 * POST /access_settings/whitelist
 */
public class AddIPsToWhiteList {
    public static void main(String[] args) throws IOException {
        try {
            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
            Request request = new Request();
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
}
