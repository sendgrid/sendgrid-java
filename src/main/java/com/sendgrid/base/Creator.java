package com.sendgrid.base;

import com.sendgrid.http.RestClient;
public interface Creator<T> {
    T create();
    T create(final RestClient client);
}
