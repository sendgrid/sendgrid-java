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

        String testPublicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEEDr2LjtURuePQzplybdC+u4CwrqDqBaWjcMMsTbhdbcwHBcepxo7yAQGhHPTnlvFYPAZFceEu/1FwCM/QmGUhA==";
        String testPayload = "{\"category\":\"example_payload\",\"event\":\"test_event\",\"message_id\":\"message_id\"}";
        String testSignature = "MEUCIQCtIHJeH93Y+qpYeWrySphQgpNGNr/U+UyUlBkU6n7RAwIgJTz2C+8a8xonZGi6BpSzoQsbVRamr2nlxFDWYNH2j/0=";
        String testTimestamp = "1588788367";

        EventWebhook ew = new EventWebhook();
        ECPublicKey ellipticCurvePublicKey = ew.ConvertPublicKeyToECDSA(testPublicKey);
        boolean isValidSignature = ew.VerifySignature(ellipticCurvePublicKey, testPayload, testSignature,
                testTimestamp);

        Assert.assertTrue(isValidSignature);
    }
}
