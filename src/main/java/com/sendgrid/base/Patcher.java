package com.sendgrid.base;

import com.sendgrid.http.RestClient;

public interface Patcher<T> {
    T patch();
    T patch(final RestClient client);
}
