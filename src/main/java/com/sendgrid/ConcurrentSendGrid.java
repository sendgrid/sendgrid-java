package com.sendgrid;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;


/**
 * Class ConcurrentSendGrid allows for quick, easy, and concurrent access to the SendGrid API.
 */
public class ConcurrentSendGrid implements SendGridAPI {

	  private static final String VERSION = "3.0.0";

	  /** The user agent string to return to SendGrid. */
	  private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";
	  private static final int RATE_LIMIT_RESPONSE_CODE = 429;
	  private static final int THREAD_POOL_SIZE = 8;
	  private Object lock = new Object(); 

	  private ExecutorService pool;

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

	  /** The number of times to try after a rate limit. */
	  private int rateLimitRetry;

	  /** The number of milliseconds to sleep between retries. */
	  private int rateLimitSleep;

	  /**
	   * Construct a new SendGrid API wrapper.
	   * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
	   */
	  public ConcurrentSendGrid(String apiKey) {
		synchronized (lock) {		
	      this.client = new Client();
	      initializeSendGrid(apiKey);
	  	}
	  }

	  /**
	   * Construct a new SendGrid API wrapper.
	   * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
	   * @param test is true if you are unit testing
	   */
	  public ConcurrentSendGrid(String apiKey, Boolean test) {
      synchronized (lock) {
        this.client = new Client(test);
        initializeSendGrid(apiKey);
      }
	  }

	  /**
	   * Construct a new SendGrid API wrapper.
	   * @param apiKey is your SendGrid API Key: https://app.sendgrid.com/settings/api_keys
	   * @param client the Client to use (allows to customize its configuration)
	   */
	  public ConcurrentSendGrid(String apiKey, Client client) {
      synchronized (lock) {
        this.client = client;
        initializeSendGrid(apiKey);
      }
	  }

	  /**
	   * Initialize the client.
	   * @param apiKey the user's API key.
	   */
	  public void initializeSendGrid(String apiKey) {
	    synchronized (lock) {  
  	    this.apiKey = apiKey;
  	    this.host = "api.sendgrid.com";
  	    this.version = "v3";
  	    this.requestHeaders = new ConcurrentHashMap<String, String>();
  	    this.requestHeaders.put("Authorization", "Bearer " + apiKey);
  	    this.requestHeaders.put("User-agent", USER_AGENT);
  	    this.requestHeaders.put("Accept", "application/json");
  	    this.rateLimitRetry = 5;
  	    this.rateLimitSleep = 1100;
  
  	    this.pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
	    }
	  }

	  /**
	   * Retrieve the current library version.
	   * @return the current version.
	   */
	  public String getLibraryVersion() {
	    synchronized (lock) {  
	      return this.VERSION;
	    }
	  }

	  /**
	   * Get the API version.
	   * @return the current API versioin (v3 by default).
	   */
	  public String getVersion() {
	    synchronized (lock) {  
	      return this.version;
	    }
	  }

	  /**
	   * Set the API version.
	   * @param version the new version.
	   */
	  public void setVersion(String version) {
	    synchronized (lock) {  
	      this.version = version;
	    }
	  }

	  /**
	   * Obtain the request headers.
	   * @return the request headers.
	   */
	  public Map<String, String> getRequestHeaders() {
	    synchronized (lock) {  
	      return new ConcurrentHashMap<>(requestHeaders);
	    }
	  }

	  /**
	   * Add a new request header.
	   * @param key the header key.
	   * @param value the header value.
	   * @return the new set of request headers.
	   */
	  public Map<String, String> addRequestHeader(String key, String value) {
	    synchronized (lock) {  
  	    this.requestHeaders.put(key, value);
  	    return getRequestHeaders();
	    }
	  }

	  /**
	   * Remove a request header.
	   * @param key the header key to remove.
	   * @return the new set of request headers.
	   */
	  public Map<String, String> removeRequestHeader(String key) {
	    synchronized (lock) {  
	      this.requestHeaders.remove(key);
	      return getRequestHeaders();
	    }
	  }

	  /**
	   * Get the SendGrid host (api.sendgrid.com by default).
	   * @return the SendGrid host.
	   */
	  public String getHost() {
	    synchronized (lock) {  
	      return this.host;
	    }
	  }

	  /**
	   * Set the SendGrid host.
	   * @param host the new SendGrid host.
	   */
	  public void setHost(String host) {
	    synchronized (lock) {  
	      this.host = host;
	    }
	  }

	  /**
	   * Get the maximum number of retries on a rate limit response. 
	   * The default is 5.
	   * @return the number of retries on a rate limit.
	   */
	  public int getRateLimitRetry() {
	    synchronized (lock) {  
	      return this.rateLimitRetry;
	    }
	  }

	  /**
	   * Set the maximum number of retries on a rate limit response.
	   * @param rateLimitRetry the maximum retry count.
	   */
	  public void setRateLimitRetry(int rateLimitRetry) {
	    synchronized (lock) {  
	      this.rateLimitRetry = rateLimitRetry;
	    }
	  }

	  /**
	   * Get the duration of time (in milliseconds) to sleep between
	   * consecutive rate limit retries. The SendGrid API enforces
	   * the rate limit to the second. The default value is 1.1 seconds.
	   * @return the sleep duration.
	   */
	  public int getRateLimitSleep() {
	    synchronized (lock) {  
	      return this.rateLimitSleep;
	    }
	  }

	  /**
	   * Set the duration of time (in milliseconds) to sleep between
	   * consecutive rate limit retries.
	   * @param rateLimitSleep the sleep duration.
	   */
	  public void setRateLimitSleep(int rateLimitSleep) {
	    synchronized (lock) {  
	      this.rateLimitSleep = rateLimitSleep;
	    }
	  }

	  /**
	   * Makes the call to the SendGrid API, override this method for testing.
	   * @param request the request to make.
	   * @return the response object.
	   * @throws IOException in case of a network error.
	   */
	  public Response makeCall(Request request) throws IOException {
	    synchronized (lock) {  
	      return client.api(request);
	    }
	  }

	  /**
	   * Class api sets up the request to the SendGrid API, this is main interface.
	   * @param request the request object.
	   * @return the response object.
	   * @throws IOException in case of a network error.
	   */
	  public Response api(Request request) throws IOException {
	    Request req = new Request();
	    req.setMethod(request.getMethod());
	    synchronized (lock) {  
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

	  /**
	   * Attempt an API call. This method executes the API call asynchronously
	   * on an internal thread pool. If the call is rate limited, the thread
	   * will retry up to the maximum configured time.
	   * @param request the API request.
	   */
	  public void attempt(Request request) {
	    synchronized (lock) {  
  	    this.attempt(request, new APICallback() {
  	      @Override
  	      public void error(Exception ex) {
  	      }
  
  	      public void response(Response r) {
  	      }
  	    });
	    }
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
	    synchronized (lock) {  
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
}
