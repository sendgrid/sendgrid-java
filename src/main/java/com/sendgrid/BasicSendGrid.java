import java.io.IOException;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class Welcome {
	public static void main(String[] args) throws IOException {
		 System.out.println("Hello");
		 Email from = new Email("fromMail@abc.com");
 	 String subject = "Welcome!";
 	 Email to = new Email("toMail@abc.com");
 	 Content content = new Content("text/html","URI");
 	 Mail mail = new Mail(from, subject, to, content);       	
 	 mail.setTemplateId("Template_ID");
 	 SendGrid sg = new SendGrid("API_KEY");
	Request request = new Request();
	try {
		mail.personalization.get(0).addSubstitution("%first_name%", "Prema");
		mail.personalization.get(0).addSubstitution("%mid%", "Prema");
		mail.personalization.get(0).addSubstitution("%STATECOOP-NAME%", "Prema");
		mail.personalization.get(0).addSubstitution("%STATE%", "Prema");
	  request.setMethod(Method.POST);
	  request.setEndpoint("mail/send");
	  request.setBody(mail.build());
	 
	  Response response = sg.api(request);
	  System.out.println(response.getStatusCode());
   System.out.println(response.getBody());
   System.out.println(response.getHeaders());
	} catch (IOException ex) {
		System.out.println(ex);
	}
	}

}
