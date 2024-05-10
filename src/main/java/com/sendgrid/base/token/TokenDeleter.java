package com.sendgrid.base.token;

import com.sendgrid.SG;
import com.sendgrid.base.Deleter;
import com.sendgrid.http.RestClient;

public abstract class TokenDeleter<T> implements Deleter<T> {

    @Override
    public T delete() {
        return delete(SG.getTokenRestClient());
    }

    @Override
    public abstract T delete(RestClient client);
}
