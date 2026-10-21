import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;
import java.util.UUID;

public class PreventThreadingExample {
    public static void main(String[] args) throws IOException {
        String apiKey = System.getenv("SENDGRID_API_KEY");
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalStateException(
                    "Set the SENDGRID_API_KEY environment variable.");
        }

        String fromAddress = "sender@example.com";
        String toAddress = "recipient@example.com";

        // Gmail groups emails that share a subject into one conversation.
        // A unique X-Entity-Ref-ID header on each email keeps them separate.
        // See https://docs.customer.io/messaging/channels/email/headers/custom-mail-headers/
        for (int i = 1; i <= 3; i++) {
            Mail mail = new Mail(
                    new Email(fromAddress),
                    "Invoice Reminder",
                    new Email(toAddress),
                    new Content("text/plain",
                            "This is email #" + i + ". It should appear as its own conversation."));
            mail.addHeader("X-Entity-Ref-ID", UUID.randomUUID().toString());

            String sgMessageId = sendEmail(apiKey, mail);
            System.out.println("Email #" + i + " sent: " + sgMessageId);
        }

        System.out.println("All emails sent with unique X-Entity-Ref-ID headers.");
        System.out.println("Each should appear as a separate conversation in Gmail.");
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
