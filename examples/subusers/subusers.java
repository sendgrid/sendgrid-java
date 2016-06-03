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
# Create Subuser #
# POST /subusers #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "subusers";
      request.body = "{\"username\":\"John@example.com\",\"ips\":[\"1.1.1.1\",\"2.2.2.2\"],\"password\":\"johns_password\",\"email\":\"John@example.com\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# List all Subusers #
# GET /subusers #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "subusers";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("username", "test_string");
      queryParams.put("limit", "0");
      queryParams.put("offset", "0");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve Subuser Reputations #
# GET /subusers/reputations #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "subusers/reputations";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("usernames", "test_string");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve email statistics for your subusers. #
# GET /subusers/stats #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "subusers/stats";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("end_date", "2016-04-01");
      queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("subusers", "test_string");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve monthly stats for all subusers #
# GET /subusers/stats/monthly #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "subusers/stats/monthly";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("subuser", "test_string");
      queryParams.put("limit", "1");
      queryParams.put("sort_by_metric", "test_string");
      queryParams.put("offset", "1");
      queryParams.put("date", "test_string");
      queryParams.put("sort_by_direction", "asc");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
#  Retrieve the totals for each email statistic metric for all subusers. #
# GET /subusers/stats/sums #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "subusers/stats/sums";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("end_date", "2016-04-01");
      queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("sort_by_metric", "test_string");
      queryParams.put("offset", "1");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("sort_by_direction", "asc");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Enable/disable a subuser #
# PATCH /subusers/{subuser_name} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PATCH;
      request.endpoint = "subusers/{subuser_name}";
      request.body = "{\"disabled\":false}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Delete a subuser #
# DELETE /subusers/{subuser_name} #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "subusers/{subuser_name}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Update IPs assigned to a subuser #
# PUT /subusers/{subuser_name}/ips #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PUT;
      request.endpoint = "subusers/{subuser_name}/ips";
      request.body = "[\"127.0.0.1\"]";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Update Monitor Settings for a subuser #
# PUT /subusers/{subuser_name}/monitor #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PUT;
      request.endpoint = "subusers/{subuser_name}/monitor";
      request.body = "{\"frequency\":500,\"email\":\"example@example.com\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Create monitor settings #
# POST /subusers/{subuser_name}/monitor #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "subusers/{subuser_name}/monitor";
      request.body = "{\"frequency\":50000,\"email\":\"example@example.com\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve monitor settings for a subuser #
# GET /subusers/{subuser_name}/monitor #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "subusers/{subuser_name}/monitor";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Delete monitor settings #
# DELETE /subusers/{subuser_name}/monitor #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "subusers/{subuser_name}/monitor";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

##################################################
# Retrieve the monthly email statistics for a single subuser #
# GET /subusers/{subuser_name}/stats/monthly #

public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "subusers/{subuser_name}/stats/monthly";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("date", "test_string");
      queryParams.put("sort_by_direction", "asc");
      queryParams.put("limit", "0");
      queryParams.put("sort_by_metric", "test_string");
      queryParams.put("offset", "1");
      request.queryParams = queryParams;
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

