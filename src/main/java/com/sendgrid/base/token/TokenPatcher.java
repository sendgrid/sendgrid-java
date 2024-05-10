package com.sendgrid.base.token;

import com.sendgrid.SG;
import com.sendgrid.base.Patcher;
import com.sendgrid.http.RestClient;

public abstract class TokenPatcher<T> implements Patcher<T> {

    @Override
    public T patch() {
        return patch(SG.getTokenRestClient());
    }

    @Override
    public abstract T patch(RestClient client);
}
