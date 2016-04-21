```java
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.Client;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));

Request request = new Request();
try {
  Request request = new Request;
  // Populate the request object, see [Example.java]() for an example.
  Response response = sg.api(request);
  System.out.println(response.statusCode);
  System.out.println(response.responseBody);
  System.out.println(response.responseHeaders);
} catch (IOException ex) {
  throw ex;
} finally {
  request.queryParams = null;
}
```