package com.sendgrid.helpers.eventwebhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.security.Security;
import java.security.interfaces.ECPublicKey;
import java.util.Collections;
import java.util.List;

public class EventWebhookTest {
    private static class Event {
        public Event(final String email,
                     final String event,
                     final String reason,
                     final String sgEventId,
                     final String sgMessageId,
                     final String smtpId,
                     final long timestamp) {
            this.email = email;
            this.event = event;
            this.reason = reason;
            this.sgEventId = sgEventId;
            this.sgMessageId = sgMessageId;
            this.smtpId = smtpId;
            this.timestamp = timestamp;
        }

        public String email;
        public String event;
        public String reason;
        @JsonProperty("sg_event_id")
        public String sgEventId;
        @JsonProperty("sg_message_id")
        public String sgMessageId;
        @JsonProperty("smtp-id")
        public String smtpId;
        @JsonProperty("timestamp")
        public long timestamp;
    }

    private static final String PUBLIC_KEY = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE83T4O/n84iotIvIW4mdBgQ/7dAfSmpqIM8kF9mN1flpVKS3GRqe62gw+2fNNRaINXvVpiglSI8eNEc6wEA3F+g==";
    private static final String SIGNATURE = "MEUCIGHQVtGj+Y3LkG9fLcxf3qfI10QysgDWmMOVmxG0u6ZUAiEAyBiXDWzM+uOe5W0JuG+luQAbPIqHh89M15TluLtEZtM=";
    private static final String TIMESTAMP = "1600112502";
    private static final List<Event> EVENTS = Collections.singletonList(new Event(
        "hello@world.com",
        "dropped",
        "Bounced Address",
        "ZHJvcC0xMDk5NDkxOS1MUnpYbF9OSFN0T0doUTRrb2ZTbV9BLTA",
        "LRzXl_NHStOGhQ4kofSm_A.filterdrecv-p3mdw1-756b745b58-kmzbl-18-5F5FC76C-9.0",
        "<LRzXl_NHStOGhQ4kofSm_A@ismtpd0039p1iad1.sendgrid.net>",
        1600112492));

    private static String PAYLOAD;

    @BeforeClass
    public static void setUp() throws JsonProcessingException {
        Security.addProvider(new BouncyCastleProvider());
        PAYLOAD = new ObjectMapper().writeValueAsString(EVENTS) + "\r\n";
    }

    @Test
    public void testVerifySignature() throws Exception {
        Assert.assertTrue(verify(
            PUBLIC_KEY,
            PAYLOAD,
            SIGNATURE,
            TIMESTAMP
        ));
    }

    @Test
    public void testBadKey() throws Exception {
        Assert.assertFalse(verify(
            "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEqTxd43gyp8IOEto2LdIfjRQrIbsd4SXZkLW6jDutdhXSJCWHw8REntlo7aNDthvj+y7GjUuFDb/R1NGe1OPzpA==",
            PAYLOAD,
            SIGNATURE,
            TIMESTAMP
        ));
    }

    @Test
    public void testBadPayload() throws Exception {
        Assert.assertFalse(verify(
            PUBLIC_KEY,
            "payload",
            SIGNATURE,
            TIMESTAMP
        ));
    }

    @Test
    public void testBadSignature() throws Exception {
        Assert.assertFalse(verify(
            PUBLIC_KEY,
            PAYLOAD,
            "MEUCIQCtIHJeH93Y+qpYeWrySphQgpNGNr/U+UyUlBkU6n7RAwIgJTz2C+8a8xonZGi6BpSzoQsbVRamr2nlxFDWYNH3j/0=",
            TIMESTAMP
        ));
    }

    @Test
    public void testBadTimestamp() throws Exception {
        Assert.assertFalse(verify(
            PUBLIC_KEY,
            PAYLOAD,
            SIGNATURE,
            "timestamp"
        ));
    }

    private boolean verify(final String publicKey, final String payload, final String signature, final String timestamp) throws Exception {
        final EventWebhook ew = new EventWebhook();
        final ECPublicKey ellipticCurvePublicKey = ew.ConvertPublicKeyToECDSA(publicKey);
        return ew.VerifySignature(ellipticCurvePublicKey, payload, signature, timestamp);
    }
}
