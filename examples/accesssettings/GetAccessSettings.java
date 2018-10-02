import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

/*Retrieve a list of currently whitelisted IPs
GET /access_settings/whitelist
*/

public class GetAccessSettings extends Example{

    private void run() throws IOException {
        try {
            String endPoint = "access_settings/whitelist";
            String body = "{\"ids\":[1,2,3]}";
            Request request = createRequest(Method.DELETE, endPoint, body);
            Response response = execute(request);
            printResponseInfo(response);
        } catch (IOException ex) {
            throw ex;
        }
    }

    public static void main(String[] args) throws IOException {
        GetAccessSettings getAccessSettings = new GetAccessSettings();
        getAccessSettings.run();
    }
}