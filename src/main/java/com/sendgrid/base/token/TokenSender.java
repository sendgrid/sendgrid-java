package com.sendgrid.base.token;

import com.sendgrid.SG;
import com.sendgrid.base.Sender;
import com.sendgrid.http.RestClient;

public abstract class TokenSender<T> implements Sender<T> {

    @Override
    public T send() {
        return send(SG.getTokenRestClient());
    }

    @Override
    public abstract T send(RestClient client);
}
