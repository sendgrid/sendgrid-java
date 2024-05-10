package com.sendgrid.base;

import com.sendgrid.http.RestClient;

public interface Deleter<T> {
    T delete();
    T delete(final RestClient client);
}
