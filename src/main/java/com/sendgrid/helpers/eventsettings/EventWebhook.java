package com.sendgrid.helpers.eventsettings;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * This class allows you to easily use the Event Webhook feature.
 * Read the docs for more details: https://sendgrid.com/docs/for-developers/tracking-events/event.
 */
public class EventWebhook {

    /**
     * Verify signed event webhook requests.
     *
     * @param publicKey: your verification key under Mail Settings
     * @param signature: value obtained from the 'X-Twilio-Email-Event-Webhook-Signature' header
     * @param timestamp: value obtained from the 'X-Twilio-Email-Event-Webhook-Timestamp' header
     * @param payload:   event payload in the request body
     */
    public static boolean VerifySignature(String publicKey, String signature, String timestamp, String payload)
            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException,
            InvalidKeySpecException {

        // prepend the payload with the timestamp
        String payloadWithTimestamp = timestamp + payload;

        // generate the public key
        byte[] publicKeyInBytes = Base64.getDecoder().decode(publicKey);
        KeyFactory factory = KeyFactory.getInstance("ECDSA", "BC");
        java.security.PublicKey ecPublicKey = (ECPublicKey) factory
                .generatePublic(new X509EncodedKeySpec(publicKeyInBytes));

        // create the signature object
        Signature s = Signature.getInstance("SHA256withECDSA", "BC");
        s.initVerify(ecPublicKey);
        s.update(payloadWithTimestamp.getBytes());

        // decode the signature
        byte[] signatureInBytes = Base64.getDecoder().decode(signature);

        // verify the signature
        return s.verify(signatureInBytes);
    }
}