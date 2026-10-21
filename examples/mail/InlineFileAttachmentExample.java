import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;

public class InlineFileAttachmentExample {

    private static final String CONTENT_ID = "company-logo";

    // Small 1x1 PNG image embedded directly; no local image file is required.
    private static final String IMAGE_BASE64 =
            "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAADElEQVR42mOQanoEAAI4AX++PQw4AAAAAElFTkSuQmCC";

    public static void main(String[] args) throws IOException {
        inline();
    }

    private static void inline() throws IOException {
        String apiKey = System.getenv("SENDGRID_API_KEY");
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalStateException(
                    "Set the SENDGRID_API_KEY environment variable.");
        }

        String fromAddress = "sender@example.com";
        String toAddress = "recipient@example.com";

        String html = "<!doctype html>"
                + "<html>"
                + "<body>"
                + "<h1>Welcome!</h1>"
                + "<p>This image is embedded in the email:</p>"
                + "<img src=\"cid:company-logo\" alt=\"Company logo\" width=\"96\" />"
                + "</body>"
                + "</html>";

        Mail mail = new Mail(
                new Email(fromAddress),
                "SendGrid Java: Inline image example",
                new Email(toAddress),
                new Content("text/html", html)
        );

        Attachments inlineImage = new Attachments();
        inlineImage.setContent(IMAGE_BASE64);
        inlineImage.setType("image/png");
        inlineImage.setFilename("mail.png");
        inlineImage.setDisposition("inline");
        inlineImage.setContentId(CONTENT_ID);
        mail.addAttachments(inlineImage);

        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = new SendGrid(apiKey).api(request);
        System.out.println("HTTP status: " + response.getStatusCode());
        if (response.getStatusCode() < 200 || response.getStatusCode() > 299) {
            System.err.println(response.getBody());
        }
    }
}
