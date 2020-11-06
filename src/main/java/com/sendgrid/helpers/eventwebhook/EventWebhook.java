package com.sendgrid.helpers.eventwebhook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * This class allows you to easily use the Event Webhook feature. Read the docs
 * for more details:
 * https://sendgrid.com/docs/for-developers/tracking-events/event.
 */
public class EventWebhook {
    /**
     * Convert the public key string to a ECPublicKey.
     *
     * @param publicKey: verification key under Mail Settings
     * @return a public key using the ECDSA algorithm
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeySpecException
     */
    public java.security.interfaces.ECPublicKey ConvertPublicKeyToECDSA(String publicKey)
        throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
        byte[] publicKeyInBytes = Base64.getDecoder().decode(publicKey);
        KeyFactory factory = KeyFactory.getInstance("ECDSA", "BC");
        return (ECPublicKey) factory.generatePublic(new X509EncodedKeySpec(publicKeyInBytes));
    }


    /**
     * Verify signed event webhook requests.
     *
     * @param publicKey: elliptic curve public key
     * @param payload:   event payload string in the request body
     * @param signature: value obtained from the
     *                   'X-Twilio-Email-Event-Webhook-Signature' header
     * @param timestamp: value obtained from the
     *                   'X-Twilio-Email-Event-Webhook-Timestamp' header
     * @return true or false if signature is valid
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws IOException
     */
    public boolean VerifySignature(ECPublicKey publicKey, String payload, String signature, String timestamp)
        throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException, IOException {
        return VerifySignature(publicKey, payload.getBytes(), signature, timestamp);
    }

    /**
     * Verify signed event webhook requests.
     *
     * @param publicKey: elliptic curve public key
     * @param payload:   event payload bytes in the request body
     * @param signature: value obtained from the
     *                   'X-Twilio-Email-Event-Webhook-Signature' header
     * @param timestamp: value obtained from the
     *                   'X-Twilio-Email-Event-Webhook-Timestamp' header
     * @return true or false if signature is valid
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws IOException
     */
    public boolean VerifySignature(ECPublicKey publicKey, byte[] payload, String signature, String timestamp)
        throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException, IOException {

        // prepend the payload with the timestamp
        final ByteArrayOutputStream payloadWithTimestamp = new ByteArrayOutputStream();
        payloadWithTimestamp.write(timestamp.getBytes());
        payloadWithTimestamp.write(payload);

        // create the signature object
        final Signature signatureObject = Signature.getInstance("SHA256withECDSA", "BC");
        signatureObject.initVerify(publicKey);
        signatureObject.update(payloadWithTimestamp.toByteArray());

        // decode the signature
        final byte[] signatureInBytes = Base64.getDecoder().decode(signature);

        // verify the signature
        return signatureObject.verify(signatureInBytes);
    }
}
