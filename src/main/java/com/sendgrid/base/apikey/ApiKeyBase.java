package com.sendgrid.base.apikey;

import com.sendgrid.ApiKeySendGrid;
import com.sendgrid.constant.ErrorMessages;
import com.sendgrid.http.ApiResponse;
import com.sendgrid.http.ApiKeyRestClient;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public abstract class ApiKeyBase {
    private static final Logger logger = LoggerFactory.getLogger(ApiKeyBase.class);
    public ApiResponse send() {
        logger.debug(String.format(ErrorMessages.DEFAULT_REST_CLIENT, "ApiKeyBase"));
        return send(ApiKeySendGrid.getRestClient());
    }
    public abstract ApiResponse send(final ApiKeyRestClient client);
}
