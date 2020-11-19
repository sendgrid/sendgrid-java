import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

/*Add one or more IPs to the whitelist
POST /access_settings/whitelist
*/

public class CreateAccessSettings extends Example {

    private void run() throws IOException {
        try {
            String endPoint = "access_settings/whitelist";
            String body = "{\"ips\":[{\"ip\":\"192.168.1.1\"},{\"ip\":\"192.*.*.*\"},{\"ip\":\"192.168.1.3/32\"}]}";
            Request request = createRequest(Method.POST, endPoint, body);
            Response response = execute(request);
            printResponseInfo(response);
        } catch (IOException ex) {
            throw ex;
        }
    }

    public static void main(String[] args) throws IOException {
        CreateAccessSettings createAccessSettings = new CreateAccessSettings();
        createAccessSettings.run();
    }
}
