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

##################################################
# Create a domain whitelabel. #
# POST /whitelabel/domains #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "whitelabel/domains";
      request.requestBody = "{\"automatic_security\":false,\"username\":\"john@example.com\",\"domain\":\"example.com\",\"default\":true,\"custom_spf\":true,\"ips\":[\"192.168.1.1\",\"192.168.1.2\"],\"subdomain\":\"news\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# List all domain whitelabels. #
# GET /whitelabel/domains #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/domains";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("username", "test_string");
      queryParams.put("domain", "test_string");
      queryParams.put("exclude_subusers", "true");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Get the default domain whitelabel. #
# GET /whitelabel/domains/default #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/domains/default";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# List the domain whitelabel associated with the given user. #
# GET /whitelabel/domains/subuser #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/domains/subuser";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Disassociate a domain whitelabel from a given user. #
# DELETE /whitelabel/domains/subuser #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "whitelabel/domains/subuser";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Update a domain whitelabel. #
# PATCH /whitelabel/domains/{domain_id} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PATCH;
      request.endpoint = "whitelabel/domains/{domain_id}";
      request.requestBody = "{\"default\":false,\"custom_spf\":true}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve a domain whitelabel. #
# GET /whitelabel/domains/{domain_id} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/domains/{domain_id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Delete a domain whitelabel. #
# DELETE /whitelabel/domains/{domain_id} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "whitelabel/domains/{domain_id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Associate a domain whitelabel with a given user. #
# POST /whitelabel/domains/{domain_id}/subuser #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "whitelabel/domains/{domain_id}/subuser";
      request.requestBody = "{\"username\":\"jane@example.com\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Add an IP to a domain whitelabel. #
# POST /whitelabel/domains/{id}/ips #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "whitelabel/domains/{id}/ips";
      request.requestBody = "{\"ip\":\"192.168.0.1\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Remove an IP from a domain whitelabel. #
# DELETE /whitelabel/domains/{id}/ips/{ip} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "whitelabel/domains/{id}/ips/{ip}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Validate a domain whitelabel. #
# POST /whitelabel/domains/{id}/validate #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "whitelabel/domains/{id}/validate";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Create an IP whitelabel #
# POST /whitelabel/ips #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "whitelabel/ips";
      request.requestBody = "{\"ip\":\"192.168.1.1\",\"domain\":\"example.com\",\"subdomain\":\"email\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve all IP whitelabels #
# GET /whitelabel/ips #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/ips";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("ip", "test_string");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve an IP whitelabel #
# GET /whitelabel/ips/{id} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/ips/{id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Delete an IP whitelabel #
# DELETE /whitelabel/ips/{id} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "whitelabel/ips/{id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Validate an IP whitelabel #
# POST /whitelabel/ips/{id}/validate #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "whitelabel/ips/{id}/validate";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Create a Link Whitelabel #
# POST /whitelabel/links #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "whitelabel/links";
      request.requestBody = "{\"default\":true,\"domain\":\"example.com\",\"subdomain\":\"mail\"}";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve all link whitelabels #
# GET /whitelabel/links #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/links";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("limit", "1");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve a Default Link Whitelabel #
# GET /whitelabel/links/default #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/links/default";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("domain", "test_string");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve Associated Link Whitelabel #
# GET /whitelabel/links/subuser #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/links/subuser";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("username", "test_string");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Disassociate a Link Whitelabel #
# DELETE /whitelabel/links/subuser #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "whitelabel/links/subuser";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("username", "test_string");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Update a Link Whitelabel #
# PATCH /whitelabel/links/{id} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PATCH;
      request.endpoint = "whitelabel/links/{id}";
      request.requestBody = "{\"default\":true}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve a Link Whitelabel #
# GET /whitelabel/links/{id} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "whitelabel/links/{id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Delete a Link Whitelabel #
# DELETE /whitelabel/links/{id} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "whitelabel/links/{id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Validate a Link Whitelabel #
# POST /whitelabel/links/{id}/validate #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "whitelabel/links/{id}/validate";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Associate a Link Whitelabel #
# POST /whitelabel/links/{link_id}/subuser #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "whitelabel/links/{link_id}/subuser";
      request.requestBody = "{\"username\":\"jane@example.com\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.responseBody);
      System.out.println(response.responseHeaders);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

