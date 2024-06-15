package com.sendgrid.http.httpclient;

import com.sendgrid.constant.Config;
import com.sendgrid.constant.EnumConstants;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;

public class ApiKeyHttpClient extends HttpClient {

    protected final org.apache.http.client.HttpClient client;

    private boolean isCustomClient;

    /**
     * Create a new HTTP Client.
     */
    public ApiKeyHttpClient() {
        this(DEFAULT_REQUEST_CONFIG);
    }

    /**
     * Create a new HTTP Client with a custom request config.
     *
     * @param requestConfig a RequestConfig.
     */
    public ApiKeyHttpClient(final RequestConfig requestConfig) {
        this(requestConfig, DEFAULT_SOCKET_CONFIG);
    }

    /**
     * Create a new HTTP Client with a custom request and socket config.
     *
     * @param requestConfig a RequestConfig.
     * @param socketConfig  a SocketConfig.
     */
    public ApiKeyHttpClient(final RequestConfig requestConfig, final SocketConfig socketConfig) {
        Collection<BasicHeader> headers = Arrays.asList(
                new BasicHeader("X-Sendgrid-Client", "java-" + Config.VERSION),
                new BasicHeader(HttpHeaders.ACCEPT, "application/json"),
                new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "utf-8")
        );

        String googleAppEngineVersion = System.getProperty("com.google.appengine.runtime.version");
        boolean isGoogleAppEngine = googleAppEngineVersion != null && !googleAppEngineVersion.isEmpty();

        org.apache.http.impl.client.HttpClientBuilder clientBuilder = HttpClientBuilder.create();

        if (!isGoogleAppEngine) {
            clientBuilder.useSystemProperties();
        }

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultSocketConfig(socketConfig);
        /*
         *  Example: Lets say client has one server.
         *  There are 4 servers on edge handling client request.
         *  Each request takes on an average 500ms (2 request per second)
         *  Total number request can be server in a second from a route: 20 * 4 * 2 (DefaultMaxPerRoute * edge servers * request per second)
         */
        connectionManager.setDefaultMaxPerRoute(20);
        connectionManager.setMaxTotal(100);

        client = clientBuilder
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .setDefaultHeaders(headers)
                .setRedirectStrategy(this.getRedirectStrategy())
                .build();
    }

    /**
     * Create a new HTTP Client using custom configuration.
     * @param clientBuilder an HttpClientBuilder.
     */
    public ApiKeyHttpClient(HttpClientBuilder clientBuilder) {
        Collection<BasicHeader> headers = Arrays.asList(
                new BasicHeader("X-Sendgrid-Client", "java-" + Config.VERSION),
                new BasicHeader(HttpHeaders.ACCEPT, "application/json"),
                new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "utf-8")
        );
        isCustomClient = true;

        client = clientBuilder
                .setDefaultHeaders(headers)
                .setRedirectStrategy(this.getRedirectStrategy())
                .build();
    }

    /**
     * Make a request.
     *
     * @param request request to make
     * @return Response of the HTTP request
     */
    public Response makeRequest(final Request request) {

        HttpMethod method = request.getMethod();
        RequestBuilder builder = RequestBuilder.create(method.toString())
                .setUri(request.getUrl())
                .setVersion(HttpVersion.HTTP_1_1)
                .setCharset(StandardCharsets.UTF_8);

        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
        }

        if (request.getBody() != null) {
            HttpEntity entity = new StringEntity(request.getBody(), ContentType.APPLICATION_JSON);
            builder.setEntity(entity);
            builder.addHeader(
                    HttpHeaders.CONTENT_TYPE, EnumConstants.ContentType.JSON.getValue());

        }
        builder.addHeader(HttpHeaders.USER_AGENT, HttpUtility.getUserAgentString(request.getUserAgentExtensions(), isCustomClient));

        HttpResponse response = null;

        try {
            response = client.execute(builder.build());
            HttpEntity entity = response.getEntity();
            return new Response(
                    // Consume the entire HTTP response before returning the stream
                    entity == null ? null : new BufferedHttpEntity(entity).getContent(),
                    response.getStatusLine().getStatusCode(),
                    response.getAllHeaders()
            );
        } catch (IOException e) {
            System.out.println("Exception occurred");
        } finally {
            // Ensure this response is properly closed
            HttpClientUtils.closeQuietly(response);

        }
        return null;
    }
}
