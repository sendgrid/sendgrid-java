package com.sendgrid.base;

import com.sendgrid.http.RestClient;

public interface Reader<T> {
    T read();
    T read(final RestClient client);
}
