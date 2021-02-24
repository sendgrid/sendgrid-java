package com.sendgrid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is the base interface to the Twilio SendGrid Web API.
 */
public abstract class BaseInterface implements SendGridAPI {

  private static final String VERSION = "4.7.2";

  private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";
  private static final int RATE_LIMIT_RESPONSE_CODE = 429;
  private static final int THREAD_POOL_SIZE = 8;

  private ExecutorService pool;

  /**
   * The host to which to connect.
   */
  private String host;

  /**
   * The API version.
   */
  private String version;

  /**
   * The HTTP client.
   */
  private Client client;

  /**
   * The request headers container.
   */
  private Map<String, String> requestHeaders;

  /**
   * The number of times to try after a rate limit.
   */
  private int rateLimitRetry;

  /**
   * The number of milliseconds to sleep between retries.
   */
  private int rateLimitSleep;

  /**
   * The subuser to be impersonated.
   */
  private String subuser;

  /**
   * Construct a new API wrapper.
   */
  public BaseInterface() {
    this.client = new Client();
  }

  /**
   * Construct a new API wrapper.
   *
   * @param test is true if you are unit testing
   */
  public BaseInterface(final Boolean test) {
    this.client = new Client(test);
  }

  /**
   * Construct a new API wrapper.
   *
   * @param client the Client to use (allows to customize its configuration)
   */
  public BaseInterface(final Client client) {
    this.client = client;
  }

  /**
   * Initialize the client.
   *
   * @param auth authorization header value
   * @param host the base URL for the API
   */
  public void initialize(final String auth, final String host) {
    this.host = host;
    this.version = "v3";
    this.requestHeaders = new HashMap<>();
    this.requestHeaders.put("Authorization", auth);
    this.requestHeaders.put("User-Agent", USER_AGENT);
    this.requestHeaders.put("Accept", "application/json");
    this.rateLimitRetry = 5;
    this.rateLimitSleep = 1100;

    this.pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
  }

  /**
   * Get the current library version.
   *
   * @return the current version
   */
  public String getLibraryVersion() {
    return VERSION;
  }

  /**
   * Get the API version.
   *
   * @return the current API version
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Set the API version.
   *
   * @param version the new version
   */
  public void setVersion(final String version) {
    this.version = version;
  }

  /**
   * Get the request headers.
   *
   * @return the request headers
   */
  public Map<String, String> getRequestHeaders() {
    return this.requestHeaders;
  }

  /**
   * Add/update a request header.
   *
   * @param key   the header key
   * @param value the header value
   * @return the new set of request headers
   */
  public Map<String, String> addRequestHeader(final String key, final String value) {
    this.requestHeaders.put(key, value);
    return getRequestHeaders();
  }

  /**
   * Remove a request header.
   *
   * @param key the header key to remove
   * @return the new set of request headers
   */
  public Map<String, String> removeRequestHeader(final String key) {
    this.requestHeaders.remove(key);
    return getRequestHeaders();
  }

  /**
   * Get the host.
   *
   * @return the host
   */
  public String getHost() {
    return this.host;
  }

  /**
   * Set the host.
   *
   * @param host the new host
   */
  public void setHost(final String host) {
    this.host = host;
  }

  /**
   * Get the maximum number of retries on a rate limit response.
   * The default is 5.
   *
   * @return the number of retries on a rate limit
   */
  public int getRateLimitRetry() {
    return this.rateLimitRetry;
  }

  /**
   * Set the maximum number of retries on a rate limit response.
   *
   * @param rateLimitRetry the maximum retry count
   */
  public void setRateLimitRetry(final int rateLimitRetry) {
    this.rateLimitRetry = rateLimitRetry;
  }

  /**
   * Get the duration of time (in milliseconds) to sleep between
   * consecutive rate limit retries. The Twilio SendGrid API enforces
   * the rate limit to the second. The default value is 1.1 seconds.
   *
   * @return the sleep duration
   */
  public int getRateLimitSleep() {
    return this.rateLimitSleep;
  }

  /**
   * Set the duration of time (in milliseconds) to sleep between
   * consecutive rate limit retries.
   *
   * @param rateLimitSleep the sleep duration
   */
  public void setRateLimitSleep(final int rateLimitSleep) {
    this.rateLimitSleep = rateLimitSleep;
  }

  /**
   * Impersonate subuser for subsequent requests
   *
   * @param subuser the subuser to be impersonated
   */
  public void addImpersonateSubuser(final String subuser) {
    this.subuser = subuser;
    this.addRequestHeader("on-behalf-of", subuser);
  }

  /**
   * Stop Impersonating the subuser
   */
  public void removeImpersonateSubuser() {
    this.subuser = null;
    this.removeRequestHeader("on-behalf-of");
  }

  /**
   * Get the impersonated subuser or null if empty
   *
   * @return the impersonated subuser
   */
  public String getImpersonateSubuser() {
    return this.subuser;
  }

  /**
   * Makes the call to the Twilio SendGrid API, override this method for testing.
   *
   * @param request the request to make
   * @return the response object
   * @throws IOException in case of a network error
   */
  public Response makeCall(final Request request) throws IOException {
    return client.api(request);
  }

  /**
   * Class api sets up the request to the Twilio SendGrid API, this is main interface.
   *
   * @param request the request object
   * @return the response object
   * @throws IOException in case of a network error
   */
  public Response api(final Request request) throws IOException {
    final Request req = new Request();

    req.setMethod(request.getMethod());
    req.setBaseUri(this.host);
    req.setEndpoint("/" + version + "/" + request.getEndpoint());
    req.setBody(request.getBody());

    req.getHeaders().putAll(this.requestHeaders);
    req.getHeaders().putAll(request.getHeaders());
    req.getQueryParams().putAll(request.getQueryParams());

    return makeCall(req);
  }

  /**
   * Attempt an API call. This method executes the API call asynchronously
   * on an internal thread pool. If the call is rate limited, the thread
   * will retry up to the maximum configured time.
   *
   * @param request the API request
   */
  public void attempt(final Request request) {
    this.attempt(request, new APICallback() {
      @Override
      public void error(final Exception ex) {
      }

      public void response(final Response r) {
      }
    });
  }

  /**
   * Attempt an API call. This method executes the API call asynchronously
   * on an internal thread pool. If the call is rate limited, the thread
   * will retry up to the maximum configured time. The supplied callback
   * will be called in the event of an error, or a successful response.
   *
   * @param request  the API request
   * @param callback the callback
   */
  public void attempt(final Request request, final APICallback callback) {
    this.pool.execute(new Runnable() {
      @Override
      public void run() {
        Response response;

        // Retry until the retry limit has been reached.
        for (int i = 0; i < rateLimitRetry; ++i) {
          try {
            response = api(request);
          } catch (IOException ex) {
            // Stop retrying if there is a network error.
            callback.error(ex);
            return;
          }

          // We have been rate limited.
          if (response.getStatusCode() == RATE_LIMIT_RESPONSE_CODE) {
            try {
              Thread.sleep(rateLimitSleep);
            } catch (InterruptedException ex) {
              // Can safely ignore this exception and retry.
            }
          } else {
            callback.response(response);
            return;
          }
        }

        // Retries exhausted. Return error.
        callback.error(new RateLimitException(request, rateLimitRetry));
      }
    });
  }
}
