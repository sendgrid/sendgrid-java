package accesssettings;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

/**
 * Retrieve all recent access attempts
 * GET /access_settings/activity
 */
public class RetrieveAllRecentAccessAttempts {
    public static void main(String[] args) throws IOException {
        try {
            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
            Request request = new Request();
            request.setMethod(Method.GET);
            request.setEndpoint("access_settings/activity");
            request.addQueryParam("limit", "1");
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch(IOException ex) {
            throw ex;
        }
    }
}