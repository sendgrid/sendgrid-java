package subusers.examples;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class Example7 {

	public static void executeTest() throws IOException{
		try {
		      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		      Request request = new Request();
		      request.setMethod(Method.PATCH);
		      request.setEndpoint("subusers/{subuser_name}");
		      request.setBody("{\"disabled\":false}");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
	}
}
