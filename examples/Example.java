// SendGridExample.java
import com.sendgrid.*;
import java.io.*;
import java.util.*;

public class Example {
  public static void main(String[] args) throws IOException {
    Map<String,String> opts = new HashMap<String,String>();
    opts.put("host","e9sk3d3bfaikbpdq7.stoplight-proxy.io");
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"), opts);
    try{
        Response response = sg.get("api_keys");
        System.out.println(response.statusCode);
        System.out.println(response.responseBody);
        System.out.println(response.responseHeaders);
    } catch (IOException ex) {
        throw ex;
    }
    
  }
}