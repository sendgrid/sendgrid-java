package accesssettings;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

/**
 * Remove a specific IP from the whitelist
 * DELETE /access_settings/whitelist/{rule_id}
 */
public class RemoveSpecificIPFromWhiteList {
    public static void main(String[] args) throws IOException {
        try {
            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
            Request request = new Request();
            request.setMethod(Method.DELETE);
            request.setEndpoint("access_settings/whitelist/{rule_id}");
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch(IOException ex) {
            throw ex;
        }
    }
}
