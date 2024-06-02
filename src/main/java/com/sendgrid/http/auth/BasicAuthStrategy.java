package com.sendgrid.http.auth;

import com.sendgrid.http.Request;
import lombok.RequiredArgsConstructor;

import java.util.Base64;

@RequiredArgsConstructor
public class BasicAuthStrategy implements AuthStrategy {
    private final String username;
    private final String password;

    @Override
    public void applyAuth(Request request) {
        String basicAuthValue = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        //requestBuilder.addHeader("Authorization", "Basic " + basicAuthValue);
    }
}
