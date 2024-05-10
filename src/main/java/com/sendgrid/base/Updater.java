package com.sendgrid.base;

import com.sendgrid.http.RestClient;

public interface Updater<T> {
    T update();
    T update(final RestClient client);
}
