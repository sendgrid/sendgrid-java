package com.sendgrid.helpers.eventsettings;

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
        String testPublicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE5Ii1BRQHaQn4TDnWLjSSXtZS7QaZlHncC+4qc9mxFI5LGq82ijP6747JcE+8xtDIYuvs2DcdNPm9kC9cyyni6w==";
        String testSignature = "MEQCIB3bJQOarffIdM7+MEee+kYAdoViz6RUoScOASwMcXQxAiAcrus/j853JUlVm5qIRfbKBJwJq89znqOTedy3RetXLQ==";
        String testTimestamp = "1587100636";
        String testPayload = "helloworld";

        Boolean isValidSignature = EventWebhook.VerifySignature(testPublicKey, testSignature, testTimestamp,
                testPayload);

        Assert.assertTrue(isValidSignature);
    }
}