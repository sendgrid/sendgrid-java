package subusers.examples;
import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class Example1 {
	
	public static void executeTest() throws IOException{
		try {
		      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		      Request request = new Request();
		      request.setMethod(Method.POST);
		      request.setEndpoint("subusers");
		      request.setBody("{\"username\":\"John@example.com\",\"ips\":[\"1.1.1.1\",\"2.2.2.2\"],\"password\":\"johns_password\",\"email\":\"John@example.com\"}");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
	}
	
}
