package com.sendgrid;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpError;
import org.mockserver.model.HttpResponse;

import com.sendgrid.SendGrid.Email;
import com.sendgrid.SendGrid.Response;

public class HttpTest {
    private static final String API_KEY = "myapikey1234";
    ClientAndServer mockServer;

    @Before
    public void startProxy() {
        mockServer = startClientAndServer(0);
    }

    @After
    public void stopProxy() {
        mockServer.stop();

    }

    @Test(expected = Exception.class)
    public void testServerDrop() throws InterruptedException, ExecutionException, IOException {
        mockServer.when(request().withPath("/api/mail.send.json"))
                .error(HttpError.error().withDelay(TimeUnit.SECONDS, 3).withDropConnection(true));
        try (SendGrid sg = new SendGrid(API_KEY)) {
            configure(sg).send(simpleMail()).toCompletableFuture().get();
        }

    }

    @Test
    public void testInternalServerError() throws InterruptedException, ExecutionException, IOException {
        mockServer.when(request().withPath("/api/mail.send.json")).respond(HttpResponse.response().withStatusCode(500));
        try (SendGrid sg = new SendGrid(API_KEY)) {
            assertFalse(configure(sg).send(simpleMail()).toCompletableFuture().get().getStatus());
        }
    }

    @Test
    public void testBadRequest() throws InterruptedException, ExecutionException, IOException {
        mockServer.when(request().withPath("/api/mail.send.json")).respond(HttpResponse.response().withStatusCode(400));
        try (SendGrid sg = new SendGrid(API_KEY)) {
            assertFalse(configure(sg).send(simpleMail()).toCompletableFuture().get().getStatus());
        }
    }

    @Test
    public void testOK() throws InterruptedException, ExecutionException, IOException {
        mockServer.when(request().withPath("/api/mail.send.json")).respond(HttpResponse.response().withStatusCode(200));
        try (SendGrid sg = new SendGrid(API_KEY)) {
            assertTrue(configure(sg).send(simpleMail()).toCompletableFuture().get().getStatus());
        }
    }

    private static Email simpleMail() {
        Email mail = new Email();
        mail.addTo("jaja@jaja.com");
        mail.setSubject("This is a test");
        mail.setText("This is the content of the email");
        return mail;
    }

    private SendGrid configure(SendGrid sendGrid) {
        sendGrid.setUrl(String.format("http://127.0.0.1:%d", mockServer.getPort()));
        return sendGrid;
    }

}
