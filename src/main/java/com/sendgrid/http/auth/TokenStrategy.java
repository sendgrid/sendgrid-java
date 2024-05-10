package com.sendgrid.http.auth;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenStrategy implements AuthStrategy {
    private final String token;
    @Override
    public void applyAuth() {
        //requestBuilder.addHeader("Authorization", "Bearer " + token);
    }
}
