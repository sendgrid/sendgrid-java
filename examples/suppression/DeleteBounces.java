import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Delete bounces
// DELETE /suppression/bounces

public class DeleteBounces {
    public static void main(String[] args) throws IOException {
        try {
            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
            Request request = new Request();
            request.setMethod(Method.DELETE);
            request.setEndpoint("suppression/bounces");
            request.setBody("{\"emails\":[\"example@example.com\",\"example2@example.com\"],\"delete_all\":true}");
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}