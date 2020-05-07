import com.sendgrid.helpers.eventwebhook.EventWebhook;
import java.security.PublicKey;
import java.security.Security;
import java.security.interfaces.ECPublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Example {

    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        try {
            String publicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEEDr2LjtURuePQzplybdC+u4CwrqDqBaWjcMMsTbhdbcwHBcepxo7yAQGhHPTnlvFYPAZFceEu/1FwCM/QmGUhA==";
            String payload = "{\"category\":\"example_payload\",\"event\":\"test_event\",\"message_id\":\"message_id\"}";
            String signature = "MEUCIQCtIHJeH93Y+qpYeWrySphQgpNGNr/U+UyUlBkU6n7RAwIgJTz2C+8a8xonZGi6BpSzoQsbVRamr2nlxFDWYNH2j/0=";
            String timestamp = "1588788367";
            EventWebhook ew = new EventWebhook();
            ECPublicKey ellipticCurvePublicKey = ew.ConvertPublicKeyToECDSA(publicKey);
            boolean valid = ew.VerifySignature(ellipticCurvePublicKey, payload, signature, timestamp);
            System.out.println("Valid Signature: " + valid);
        } catch (Exception exception) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, "something went wrong", exception);
        }
    }
}
