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
            String publicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEqTxd43gyp8IOEto2LdIfjRQrIbsd4SXZkLW6jDutdhXSJCWHw8REntlo7aNDthvj+y7GjUuFDb/R1NGe1OPzpA==";
            String payload = "[{\"email\":\"example@test.com\",\"timestamp\":1583532164,\"smtp-id\":\"<14c5d75ce93.dfd.64b469@ismtpd-555>\",\"event\":\"processed\",\"category\":\"cat facts\",\"sg_event_id\":\"sg_event_id\",\"sg_message_id\":\"sg_message_id\"}]";
            String signature = "MEUCIB3PweCEFCNC0kCi6XFmlDSeFV9INyue8XmKejxu6OrKAiEAguMqCpe/5HpuK21G/+QxcZSKQm3lzM4YAblVHAhoXeU=";
            String timestamp = "1587162961";
            EventWebhook ew = new EventWebhook();
            ECPublicKey ellipticCurvePublicKey = ew.ConvertPublicKeyToECDSA(publicKey);
            boolean valid = ew.VerifySignature(ellipticCurvePublicKey, payload, signature, timestamp);
            System.out.println("Valid Signature: " + valid);
        } catch (Exception exception) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, "something went wrong", exception);
        }
    }
}
