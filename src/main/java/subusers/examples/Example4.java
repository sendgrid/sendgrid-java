package subusers.examples;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;


public class Example4 {

	public static void executeTest() throws IOException{
		try {
		      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		      Request request = new Request();
		      request.setMethod(Method.GET);
		      request.setEndpoint("subusers/stats");
		      request.addQueryParam("end_date", "2016-04-01");
		      request.addQueryParam("aggregated_by", "day");
		      request.addQueryParam("limit", "1");
		      request.addQueryParam("offset", "1");
		      request.addQueryParam("start_date", "2016-01-01");
		      request.addQueryParam("subusers", "test_string");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
	}
}
