package com.sendgrid.http.auth;

import com.sendgrid.http.Request;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenStrategy implements AuthStrategy {
    private final String token;
    @Override
    public void applyAuth(Request request) {
        request.addHeader("Authorization", "Bearer " + token);
    }
}
