package subusers.examples;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class Example5 {

	public static void executeTest() throws IOException{
		
		 try {
		      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		      Request request = new Request();
		      request.setMethod(Method.GET);
		      request.setEndpoint("subusers/stats/monthly");
		      request.addQueryParam("subuser", "test_string");
		      request.addQueryParam("limit", "1");
		      request.addQueryParam("sort_by_metric", "test_string");
		      request.addQueryParam("offset", "1");
		      request.addQueryParam("date", "test_string");
		      request.addQueryParam("sort_by_direction", "asc");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
	}
}
