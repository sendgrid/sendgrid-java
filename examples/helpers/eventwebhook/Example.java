import com.sendgrid.helpers.eventwebhook.EventWebhook;
import com.sendgrid.helpers.eventwebhook.EventWebhookHeader;
import com.twilio.security.RequestValidator;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import spark.Route;

import java.security.Security;
import java.security.interfaces.ECPublicKey;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.post;

public class Example {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        final Route webhookHandler = (req, res) -> {
            try {
                final String publicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE83T4O/n84iotIvIW4mdBgQ/7dAfSmpqIM8kF9mN1flpVKS3GRqe62gw+2fNNRaINXvVpiglSI8eNEc6wEA3F+g==";

                final String signature = req.headers(EventWebhookHeader.SIGNATURE.toString());
                final String timestamp = req.headers(EventWebhookHeader.TIMESTAMP.toString());
                final byte[] requestBody = req.bodyAsBytes();

                final EventWebhook ew = new EventWebhook();
                final ECPublicKey ellipticCurvePublicKey = ew.ConvertPublicKeyToECDSA(publicKey);
                final boolean valid = ew.VerifySignature(ellipticCurvePublicKey, requestBody, signature, timestamp);
                System.out.println("Valid Signature: " + valid);

                if (valid) {
                    res.status(204);
                } else {
                    res.status(403);
                }

                return null;
            } catch (final Exception exception) {
                res.status(500);
                return exception.toString();
            }
        };

        post("/sendgrid/webhook", webhookHandler);
    }
}
