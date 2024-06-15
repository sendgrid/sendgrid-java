package com.sendgrid.http.auth;

import com.sendgrid.http.Request;

public interface AuthStrategy {
    void applyAuth(Request request);
}
