package com.sendgrid.helpers.eventwebhook;

import java.security.Security;
import java.security.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.Test;

public class EventWebhookTest {
    @Test
    public void testVerifySignature() throws Exception {

        Security.addProvider(new BouncyCastleProvider());

        String testPublicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE0wuSSQf427N670xAsZ5vKZcyA0d9+/YyGnLDN4mv11ikucYzBOSyPQlfKkWSD1mS7zYzljgt9iWw7jUFVrwFjg==";
        String testPayload = "[{\"email\":\"example@test.com\",\"timestamp\":1581532164,\"smtp-id\":\"<14c5d75ce93.dfd.64b469@ismtpd-555>\",\"event\":\"processed\",\"category\":\"cat facts\",\"sg_event_id\":\"sg_event_id\",\"sg_message_id\":\"sg_message_id\"},\n{\"email\":\"example@test.com\",\"timestamp\":1581532164,\"smtp-id\":\"<14c5d75ce93.dfd.64b469@ismtpd-555>\",\"event\":\"deferred\",\"category\":\"cat facts\",\"sg_event_id\":\"sg_event_id\",\"sg_message_id\":\"sg_message_id\",\"response\":\"400 try again later\",\"attempt\":\"5\"},\n{\"email\":\"example@test.com\",\"timestamp\":1581532164,\"smtp-id\":\"<14c5d75ce93.dfd.64b469@ismtpd-555>\",\"event\":\"delivered\",\"category\":\"cat facts\",\"sg_event_id\":\"sg_event_id\",\"sg_message_id\":\"sg_message_id\",\"response\":\"250 OK\"}]\n";
        String testSignature = "MEUCIQDrZLnEUsPfG6x2GLo7W6V8CJVqnQKs6PEfHKF4k8/rhQIgNmInuCti7RtcJMASqxHKnhNzPAmdIYCwJNTEk7E/nlY=";
        String testTimestamp = "1587162873";

        EventWebhook ew = new EventWebhook();
        ECPublicKey ellipticCurvePublicKey = ew.ConvertPublicKeyToECDSA(testPublicKey);
        boolean isValidSignature = ew.VerifySignature(ellipticCurvePublicKey, testPayload, testSignature,
                testTimestamp);

        Assert.assertTrue(isValidSignature);
    }
}
