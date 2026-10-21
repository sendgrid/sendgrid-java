import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;

public class ThreadingExample {
    public static void main(String[] args) throws IOException {
        String apiKey = System.getenv("SENDGRID_API_KEY");
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalStateException(
                    "Set the SENDGRID_API_KEY environment variable.");
        }

        String fromAddress = "sender@example.com";
        String toAddress = "recipient@example.com";

        if (args.length == 0) {
            // Step 1: send the first email. Its smtp-id arrives in the "delivered"
            // webhook event, not in this response.
            Mail first = new Mail(
                    new Email(fromAddress),
                    "SendGrid Java: Threading example",
                    new Email(toAddress),
                    new Content("text/plain", "This starts the thread."));
            String sgMessageId = sendEmail(apiKey, first);
            System.out.println("X-Message-Id: " + sgMessageId);
            System.out.println("Find the smtp-id for this message in its delivered "
                    + "webhook event, then run again with it as the argument.");
            return;
        }

        // Step 2: reply using the smtp-id from the delivered webhook event,
        // for example "<abc123@example-ismtpd-10>".
        String smtpId = args[0];
        Mail reply = new Mail(
                new Email(fromAddress),
                "Re: SendGrid Java: Threading example",
                new Email(toAddress),
                new Content("text/plain", "This reply should group with the first email."));
        reply.addHeader("In-Reply-To", smtpId);
        reply.addHeader("References", smtpId);
        sendEmail(apiKey, reply);
    }

    // Returns the X-Message-Id SendGrid assigned to the email.
    private static String sendEmail(String apiKey, Mail mail) throws IOException {
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = new SendGrid(apiKey).api(request);
        System.out.println("HTTP status: " + response.getStatusCode());

        if (response.getStatusCode() < 200
                || response.getStatusCode() >= 300) {
            System.err.println(response.getBody());
            throw new IllegalStateException("Email sending failed.");
        }

        String messageId = response.getHeaders().get("X-Message-Id");
        if (messageId == null) {
            throw new IllegalStateException("SendGrid did not return X-Message-Id.");
        }
        return messageId;
    }
}
