package com.sendgrid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A wrapper for interacting with the SendGrid API.
 */
public class SendGrid {
    /** The current library version. */
    private static final String VERSION = "3.0.0";

    /** The user agent string to return to SendGrid. */
    private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";

    /** The user's API key. */
    private String apiKey;

    /** The SendGrid host to which to connect. */
    private String host;

    /** The API version. */
    private String version;

    /** The HTTP client. */
    private Client client;

    /** The request headers container. */
    private Map<String, String> requestHeaders;

    /**
     * Creates a new SendGrid API wrapper, with the specified API key.
     *
     * @param apiKey the key to use with the SendGrid API. The key can be obtained from
     *               <a href="https://app.sendgrid.com/settings/api_keys">the SendGrid site</a>.
     */
    public SendGrid(String apiKey) {
        this(apiKey, new Client());
    }

    /**
     * Creates a new SendGrid API wrapper, with the specified API key and whether it is running
     * in a unit test.
     *
     * @param apiKey the key to use with the SendGrid API. The key can be obtained from
     *               <a href="https://app.sendgrid.com/settings/api_keys">the SendGrid site</a>.
     * @param test   {@code true} if the wrapper is intended for use within a unit test;
     *               {@code false} otherwise
     */
    public SendGrid(String apiKey, Boolean test) {
        this(apiKey, new Client(test));
    }

    /**
     * Creates a new SendGrid API wrapper, with the specified API key and HTTP client.
     *
     * @param apiKey the key to use with the SendGrid API. The key can be obtained from
     *               <a href="https://app.sendgrid.com/settings/api_keys">the SendGrid site</a>.
     * @param client the HTTP client of which to use to interact with the SendGrid API.
     */
    public SendGrid(String apiKey, Client client) {
        this.client = client;
        this.initializeSendGrid(apiKey);
    }

    /**
     * Populates the necessary fields for the SendGrid API wrapper to be used, with the
     * specified API key.
     *
     * @param apiKey the key to use with the SendGrid API. The key can be obtained from
     *               <a href="https://app.sendgrid.com/settings/api_keys">the SendGrid site</a>.
     */
    public void initializeSendGrid(String apiKey) {
        this.apiKey = apiKey;
        this.host = "api.sendgrid.com";
        this.version = "v3";
        this.requestHeaders = new HashMap<String, String>();
        this.requestHeaders.put("Authorization", "Bearer " + apiKey);
        this.requestHeaders.put("User-agent", USER_AGENT);
        this.requestHeaders.put("Accept", "application/json");
    }

    /**
     * Gets the version of the library currently in use.
     *
     * @return the current library version.
     */
    public String getLibraryVersion() {
        return VERSION;
    }

    /**
     * Gets the version of the SendGrid API the wrapper will be interacting with.
     *
     * @return the current API version (default: v3).
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * Sets the version of the SendGrid API the wrapper will be interacting with.
     * <strong>
     * All further requests to the API will have to take note of this change, as
     * it affects the endpoint of which requests are made to.
     * </strong>
     *
     * @param version the API version.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Gets the headers used when making requests.
     *
     * @return the request headers.
     */
    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    /**
     * Adds a new header to be used when making requests.
     *
     * @param key the header key.
     * @param value the header value.
     * @return the <em>updated</em> request headers.
     */
    public Map<String, String> addRequestHeader(String key, String value) {
        this.requestHeaders.put(key, value);
        return getRequestHeaders();
    }

    /**
     * Removes a header that would have been used when making requests.
     *
     * @param key the header key to remove.
     * @return the <em>updated</em> request headers.
     */
    public Map<String, String> removeRequestHeader(String key) {
        this.requestHeaders.remove(key);
        return getRequestHeaders();
    }

    /**
     * Gets the root API URL to be used when making requests.
     *
     * @return the SendGrid host (default: api.sendgrid.com).
     */
    public String getHost() {
        return this.host;
    }

    /**
     * Sets the root API URL that is used to make requests.
     * <strong>
     * All further requests to the API will have to take note of this change, as
     * it affects the endpoint of which requests are made to.
     * </strong>
     *
     * @param host the new SendGrid host.
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Performs a call to the SendGrid API, with the specified {@link Request}.
     *
     * @param request the request to make.
     * @return the response object.
     * @throws IOException in case of a network error.
     */
    public Response makeCall(Request request) throws IOException {
        return this.client.api(request);
    }

    /**
     * Prepares a {@link Request}, and performs it using {@link #makeCall(Request)}.
     *
     * @param request the request object.
     * @return the response object.
     * @throws IOException in case of a network error.
     */
    public Response send(Request request) throws IOException {
        Request req = new Request();
        req.setMethod(request.getMethod());
        req.setBaseUri(this.host);
        req.setEndpoint("/" + version + "/" + request.getEndpoint());
        req.setBody(request.getBody());
        for (Map.Entry<String, String> header : this.requestHeaders.entrySet()) {
            req.addHeader(header.getKey(), header.getValue());
        }
        for (Map.Entry<String, String> queryParam : request.getQueryParams().entrySet()) {
            req.addQueryParam(queryParam.getKey(), queryParam.getValue());
        }

        return makeCall(req);
    }
}
