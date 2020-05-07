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
            String publicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEqTxd43gyp8IOEto2LdIfjRQrIbsd4SXZkLW6jDutdhXSJCWHw8REntlo7aNDthvj+y7GjUuFDb/R1NGe1OPzpA==";
            String payload = "[{\"email\":\"example@test.com\",\"timestamp\":1583532164,\"smtp-id\":\"<14c5d75ce93.dfd.64b469@ismtpd-555>\",\"event\":\"processed\",\"category\":\"cat facts\",\"sg_event_id\":\"sg_event_id\",\"sg_message_id\":\"sg_message_id\"}]";
            String signature = "MEUCIB3PweCEFCNC0kCi6XFmlDSeFV9INyue8XmKejxu6OrKAiEAguMqCpe/5HpuK21G/+QxcZSKQm3lzM4YAblVHAhoXeU=";
            String timestamp = "1587162961";
            boolean valid = EventWebhook.VerifySignature(publicKey, payload, signature, timestamp);
            System.out.println("Valid Signature: " + valid);
        } catch (Exception exception) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, "something went wrong", exception);
        }
    }
}
