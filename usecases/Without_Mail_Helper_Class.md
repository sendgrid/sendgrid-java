## Without Mail Helper Class

```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody("{
        \"from\": {\"email\": \"test@example.com\"},
        \"personalizations\":
        [{
          \"to\": [{\"email\": \"test@example.com\"}],
          \"dynamic_template_data\": {\"subject\": \"Testing Templates\",\"name\": \"Example User\", \"city\": \"Denver\"}
        }],
        \"template_id\": \"d-2c214ac919e84170b21855cc129b4a5f\"}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}
```


```java
import com.sendgrid.*;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody("{
        \"personalizations\":
        [{
          \"to\": [{\"email\": \"test@example.com\"}],
          \"substitutions\": {\"-name-\": \"Example User\", \"-city-\": \"Denver\"},
          \"subject\": \"Hello World from the SendGrid Java Library!\"
        }],
        \"from\": {\"email\": \"test@example.com\"},
        \"content\":
        [{
          \"type\": \"text/html\",
          \"value\": \"I'm replacing the <strong>body tag</strong>\"
        }]
        ,\"template_id\": \"13b8f94f-bcae-4ec6-b752-70d6cb59f932\"}");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}
```