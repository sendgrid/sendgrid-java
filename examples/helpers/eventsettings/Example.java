import com.sendgrid.helpers.eventsettings.EventWebhook;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Example {

    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchProviderException, SignatureException, InvalidKeySpecException {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        try {
            String publicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE5Ii1BRQHaQn4TDnWLjSSXtZS7QaZlHncC+4qc9mxFI5LGq82ijP6747JcE+8xtDIYuvs2DcdNPm9kC9cyyni6w==";
            String payload = "helloworld";
            String signature = "MEQCIB3bJQOarffIdM7+MEee+kYAdoViz6RUoScOASwMcXQxAiAcrus/j853JUlVm5qIRfbKBJwJq89znqOTedy3RetXLQ==";
            String timestamp = "1587100636";
            boolean valid = EventWebhook.VerifySignature(publicKey, payload, signature, timestamp);
            System.out.println("Valid Signature: " + valid);
        } catch (Exception exception) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, "something went wrong", exception);
        }
    }
}
