package com.sendgrid.base.token;

import com.sendgrid.SG;
import com.sendgrid.base.Creator;
import com.sendgrid.http.RestClient;

public abstract class TokenCreator<T> implements Creator<T> {

    @Override
    public T create() {
        return create(SG.getTokenRestClient());
    }

    @Override
    public abstract T create(RestClient client);
}
