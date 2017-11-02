import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

/* Remove one or more IPs from the whitelist
 DELETE /access_settings/whitelist
 */

public class DeleteAccessSettings extends Example {

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
        DeleteAccessSettings deleteAccessSettings = new DeleteAccessSettings();
        deleteAccessSettings.run();
    }
}