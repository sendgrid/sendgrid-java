import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;

public class FileAttachmentExample {

    // Small 1x1 PNG image embedded directly; no local image file is required.
    private static final String IMAGE_BASE64 =
            "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAADElEQVR42mOQanoEAAI4AX++PQw4AAAAAElFTkSuQmCC";

    public static void main(String[] args) throws IOException {
        attachment();
    }

    public static void attachment() throws IOException {
        String apiKey = System.getenv("SENDGRID_API_KEY");
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalStateException(
                    "Set the SENDGRID_API_KEY environment variable.");
        }

        String fromAddress = "sender@example.com";
        String toAddress = "recipient@example.com";

        Mail mail = new Mail(
                new Email(fromAddress),
                "SendGrid Java: File attachment example",
                new Email(toAddress),
                new Content("text/plain",
                        "Please find the attached image."));

        Attachments attachment = new Attachments();
        attachment.setContent(IMAGE_BASE64);
        attachment.setType("image/png");
        attachment.setFilename("mail.png");
        attachment.setDisposition("attachment");
        mail.addAttachments(attachment);

        sendEmail(apiKey, mail);
    }

    private static void sendEmail(String apiKey, Mail mail)
            throws IOException {
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
    }
}
