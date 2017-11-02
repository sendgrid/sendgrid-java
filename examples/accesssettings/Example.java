import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

public class Example {

    protected Request createRequest(Method method, String endPoint, String requestBody) {
        Request request = new Request();
        request.setMethod(method);
        request.setEndpoint(endPoint);
        if (requestBody != null) {
            request.setBody(requestBody);
        }
        return request;
    }

    protected Response execute(Request request) throws IOException {
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Response response = sg.api(request);
        return response;
    }

    protected void printResonseInfo(Response response) {
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    }
}