package com.sendgrid;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
  * Class Twilio SendGrid allows for quick and easy access to the Twilio SendGrid API.
  */
public class SendGrid implements SendGridAPI {

  private static final String VERSION = "3.0.0";

  /** The user agent string to return to Twilio SendGrid. */
  private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";
  private static final int RATE_LIMIT_RESPONSE_CODE = 429;
  private static final int THREAD_POOL_SIZE = 8;

  /** The system's environment variables; useful for overriding for testing. */
  // TODO: use an ImmutableMap.
  private Map<String, String> environment = new HashMap<>();

  private ExecutorService pool;

  /** The Twilio SendGrid host to which to connect. */
  private String host;

  /** The API version. */
  private String version;

  /** The HTTP client. */
  private Client client;

  /** The request headers container. */
  private Map<String, String> requestHeaders;

  /** The number of times to try after a rate limit. */
  private int rateLimitRetry;

  /** The number of milliseconds to sleep between retries. */
  private int rateLimitSleep;

  /** The subuser to be impersonated. */
  private String subuser;

  /**
   * Construct a new Twilio SendGrid API wrapper.
   * @param apiKey is your Twilio SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   */
  public SendGrid(String apiKey) {
    this(apiKey, new Client());
  }

  /**
   * Construct a new Twilio SendGrid API wrapper.
   * @param apiKey your Twili SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param test true if you are unit testing
   */
  public SendGrid(String apiKey, Boolean test) {
    this(apiKey, new Client((test)));
  }

  /**
   * Construct a new Twilio SendGrid API wrapper.
   * @param apiKey your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param client the Client to use (allows to customize its configuration)
   */
  public SendGrid(String apiKey, Client client) {
    this(apiKey, client, System.getenv());
  }

  /**
   * Construct a new SendGrid API wrapper.
   * @param apiKey your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param client the Client to use (allows to customize its configuration)
   * @param environment the system's environment variables
   */
  SendGrid(String apiKey, Client client, Map<String, String> environment) {
    this.client = client;
    initializeSendGrid(apiKey);
    this.environment.putAll(environment);
  }

  /**
   * Initialize the client.
   * @param apiKey the user's API key.
   */
  public void initializeSendGrid(String apiKey) {
    this.host = "api.sendgrid.com";
    this.version = "v3";
    this.requestHeaders = new HashMap<String, String>();
    this.requestHeaders.put("Authorization", "Bearer " + apiKey);
    this.requestHeaders.put("User-agent", USER_AGENT);
    this.requestHeaders.put("Accept", "application/json");
    this.rateLimitRetry = 5;
    this.rateLimitSleep = 1100;

    this.pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
  }

  /**
   * Retrieve the current library version.
   * @return the current version.
   */
  public String getLibraryVersion() {
    return this.VERSION;
  }

  /**
   * Get the API version.
   * @return the current API versioin (v3 by default).
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Set the API version.
   * @param version the new version.
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * Obtain the request headers.
   * @return the request headers.
   */
  public Map<String, String> getRequestHeaders() {
    return this.requestHeaders;
  }

  /**
   * Add a new request header.
   * @param key the header key.
   * @param value the header value.
   * @return the new set of request headers.
   */
  public Map<String, String> addRequestHeader(String key, String value) {
    this.requestHeaders.put(key, value);
    return getRequestHeaders();
  }

  /**
   * Remove a request header.
   * @param key the header key to remove.
   * @return the new set of request headers.
   */
  public Map<String, String> removeRequestHeader(String key) {
    this.requestHeaders.remove(key);
    return getRequestHeaders();
  }

  /**
   * Get the Twilio SendGrid host (api.sendgrid.com by default).
   * @return the Twilio SendGrid host.
   */
  public String getHost() {
    return this.host;
  }

  /**
   * Set the Twilio SendGrid host.
   * @param host the new Twilio SendGrid host.
   */
  public void setHost(String host) {
    this.host = host;
  }

  /**
   * Get the maximum number of retries on a rate limit response. 
   * The default is 5.
   * @return the number of retries on a rate limit.
   */
  public int getRateLimitRetry() {
    return this.rateLimitRetry;
  }

  /**
   * Set the maximum number of retries on a rate limit response.
   * @param rateLimitRetry the maximum retry count.
   */
  public void setRateLimitRetry(int rateLimitRetry) {
    this.rateLimitRetry = rateLimitRetry;
  }

  /**
   * Get the duration of time (in milliseconds) to sleep between
   * consecutive rate limit retries. The Twilio SendGrid API enforces
   * the rate limit to the second. The default value is 1.1 seconds.
   * @return the sleep duration.
   */
  public int getRateLimitSleep() {
    return this.rateLimitSleep;
  }

  /**
   * Set the duration of time (in milliseconds) to sleep between
   * consecutive rate limit retries.
   * @param rateLimitSleep the sleep duration.
   */
  public void setRateLimitSleep(int rateLimitSleep) {
    this.rateLimitSleep = rateLimitSleep;
  }

  /**
   * Impersonate subuser for subsequent requests
   * @param subuser the subuser to be impersonated
   */
  public void addImpersonateSubuser(String subuser) {
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
   * @return the impersonated subuser
   */
  public String getImpersonateSubuser() {
    return this.subuser; 
  }

  /**
   * Makes the call to the Twilio SendGrid API, override this method for testing.
   * @param request the request to make.
   * @return the response object.
   * @throws IOException in case of a network error.
   */
  public Response makeCall(Request request) throws IOException {
    return client.api(request);
  }

  /**
   * Creates a new request based on the request parameter and calls the Twilio SendGrid REST API.
   * @param request the request object.
   * @return the response object.
   * @throws IOException in case of a network error, or if template checking is enabled,
   *   in the event of malformed JSON in the body of the request or a missing template.
   */
  public Response api(Request request) throws IOException {
    checkTemplate(request);
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

  /**
   * If the endpoint is 'mail/send' and an exception should be thrown for an invalid template id in
   * the body of the request, then if a template_id is specified in the body of the request, check
   * that the template_id is valid by making a request to the SendGrid server.
   *
   * @param mainRequest the main request that is being checked
   * @throws IOException in the event of malformed JSON in the body of the request or a missing
   *   template
   */
  void checkTemplate(Request mainRequest) throws IOException {
    if (endpointIsMailSend(mainRequest) && shouldThrowExceptionsForInvalidTemplateId()) {
      String templateId = extractTemplateId(mainRequest.getBody());
      if (templateId == null) {
        return;
      }
      Request templateGetRequest = new Request();
      templateGetRequest.setMethod(Method.GET);
      templateGetRequest.setEndpoint("templates/" + templateId);
      Response templateGetResponse = makeCall(templateGetRequest);
      int statusCode = templateGetResponse.getStatusCode();
      if (statusCode < 200 || statusCode >= 300) {
        throw new IOException(
            "Error checking template '" + templateId + "', status code = " + statusCode);
      }
    }
  }

  /**
   * Extracts the first template id from {@code jsonText} if one is present.
   *
   * @param jsonText the JSON text to extract the template id from, if present.
   * @return the template id if it exists, otherwise null.
   * @throws IOException in the event of malformed JSON.
   */
  String extractTemplateId(String jsonText) throws IOException {
    JsonFactory jsonFactory = new JsonFactory();
    JsonParser jsonParser = jsonFactory.createParser(jsonText);

    if (jsonParser.nextToken() != JsonToken.START_OBJECT) {
      throw new IOException("Expected body to start with an Object");
    }

    String templateId = null;

    JsonToken jsonToken;
    while ((jsonToken = jsonParser.nextToken()) != null) {
      if (jsonToken == JsonToken.FIELD_NAME) {
        String fieldName = jsonParser.getCurrentName();
        // Move to value.
        jsonParser.nextToken();
        if (fieldName.equals("template_id")) {
          templateId = jsonParser.getText();
          break;
        }
      }
    }

    jsonParser.close();
    return templateId;
  }

  private boolean endpointIsMailSend(Request request) {
    return request.getEndpoint().equals("mail/send");
  }

  private boolean shouldThrowExceptionsForInvalidTemplateId() {
    // Another possibility is to have a specific field in the request body that enables template
    // checks.
    return isTrue(environment.get("SENDGRID_CHECK_TEMPLATES"));
  }

  private boolean isTrue(String value) {
    if (value == null) {
      return false;
    }
    return value.toLowerCase().equals("true");
  }

  /**
   * Attempt an API call. This method executes the API call asynchronously
   * on an internal thread pool. If the call is rate limited, the thread
   * will retry up to the maximum configured time.
   * @param request the API request.
   */
  public void attempt(Request request) {
    this.attempt(request, new APICallback() {
      @Override
      public void error(Exception ex) {
      }

      public void response(Response r) {
      }
    });
  }

  /**
   * Attempt an API call. This method executes the API call asynchronously
   * on an internal thread pool. If the call is rate limited, the thread
   * will retry up to the maximum configured time. The supplied callback
   * will be called in the event of an error, or a successful response.
   * @param request the API request.
   * @param callback the callback.
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
