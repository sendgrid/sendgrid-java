package com.sendgrid.base.token;

import com.sendgrid.SG;
import com.sendgrid.base.Fetcher;
import com.sendgrid.http.RestClient;

public abstract class TokenFetcher<T> implements Fetcher<T> {

    @Override
    public T fetch() {
        return fetch(SG.getTokenRestClient());
    }

    @Override
    public abstract T fetch(RestClient client);
}
