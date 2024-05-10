package com.sendgrid.base.token;

import com.sendgrid.SG;
import com.sendgrid.base.Updater;
import com.sendgrid.http.RestClient;

public abstract class TokenUpdater<T> implements Updater<T> {

    @Override
    public T update() {
        return update(SG.getTokenRestClient());
    }

    @Override
    public abstract T update(RestClient client);
}
