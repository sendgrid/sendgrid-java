package com.sendgrid.base.token;

import com.sendgrid.SG;
import com.sendgrid.base.Reader;
import com.sendgrid.http.RestClient;

public abstract class TokenReader<T> implements Reader<T> {

    @Override
    public T read() {
        return read(SG.getTokenRestClient());
    }

    @Override
    public abstract T read(RestClient client);
}
