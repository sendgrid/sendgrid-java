package com.sendgrid.helpers.eventwebhook;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import org.junit.Assert;
import org.junit.Test;

public class EventWebhookTest {
    @Test
    public void testVerifySignature() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException,
            SignatureException, InvalidKeySpecException {

        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        String testPublicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE0wuSSQf427N670xAsZ5vKZcyA0d9+/YyGnLDN4mv11ikucYzBOSyPQlfKkWSD1mS7zYzljgt9iWw7jUFVrwFjg==";
        String testPayload = "[{\"email\":\"example@test.com\",\"timestamp\":1581532164,\"smtp-id\":\"<14c5d75ce93.dfd.64b469@ismtpd-555>\",\"event\":\"processed\",\"category\":\"cat facts\",\"sg_event_id\":\"sg_event_id\",\"sg_message_id\":\"sg_message_id\"},\n{\"email\":\"example@test.com\",\"timestamp\":1581532164,\"smtp-id\":\"<14c5d75ce93.dfd.64b469@ismtpd-555>\",\"event\":\"deferred\",\"category\":\"cat facts\",\"sg_event_id\":\"sg_event_id\",\"sg_message_id\":\"sg_message_id\",\"response\":\"400 try again later\",\"attempt\":\"5\"},\n{\"email\":\"example@test.com\",\"timestamp\":1581532164,\"smtp-id\":\"<14c5d75ce93.dfd.64b469@ismtpd-555>\",\"event\":\"delivered\",\"category\":\"cat facts\",\"sg_event_id\":\"sg_event_id\",\"sg_message_id\":\"sg_message_id\",\"response\":\"250 OK\"}]\n";
        String testSignature = "MEUCIQDrZLnEUsPfG6x2GLo7W6V8CJVqnQKs6PEfHKF4k8/rhQIgNmInuCti7RtcJMASqxHKnhNzPAmdIYCwJNTEk7E/nlY=";
        String testTimestamp = "1587162873";

        boolean isValidSignature = EventWebhook.VerifySignature(testPublicKey, testPayload, testSignature,
                testTimestamp);

        Assert.assertTrue(isValidSignature);
    }
}
