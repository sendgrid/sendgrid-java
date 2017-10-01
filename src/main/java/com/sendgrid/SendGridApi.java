package com.sendgrid;

import java.io.IOException;
import java.util.Map;

public interface SendGridApi {

	  public void initializeSendGrid(String apiKey);

	  public String getLibraryVersion();

	  public String getVersion();

	  public void setVersion(String version);

	  public Map<String,String> getRequestHeaders();

	  public Map<String,String> addRequestHeader(String key, String value);

	  public Map<String,String> removeRequestHeader(String key);
	  public String getHost();

	  public void setHost(String host);

	  /**
	    * Class makeCall makes the call to the SendGrid API, override this method for testing.
	    */
	  public Response makeCall(Request request) throws IOException;

	  /**
	    * Class api sets up the request to the SendGrid API, this is main interface.
	    */
	  public Response api(Request request) throws IOException;
}
