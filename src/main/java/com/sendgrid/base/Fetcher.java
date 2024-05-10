package com.sendgrid.base;

import com.sendgrid.http.RestClient;

public interface Fetcher<T> {
    T fetch();
    T fetch(final RestClient client);
}
