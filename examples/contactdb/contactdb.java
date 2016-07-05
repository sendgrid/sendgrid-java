import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Create a Custom Field
// POST /contactdb/custom_fields


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "contactdb/custom_fields";
      request.body = "{\"type\":\"text\",\"name\":\"pet\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve all custom fields
// GET /contactdb/custom_fields


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/custom_fields";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve a Custom Field
// GET /contactdb/custom_fields/{custom_field_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/custom_fields/{custom_field_id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Delete a Custom Field
// DELETE /contactdb/custom_fields/{custom_field_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "contactdb/custom_fields/{custom_field_id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Create a List
// POST /contactdb/lists


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "contactdb/lists";
      request.body = "{\"name\":\"your list name\"}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve all lists
// GET /contactdb/lists


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/lists";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Delete Multiple lists
// DELETE /contactdb/lists


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "contactdb/lists";
      request.body = "[1,2,3,4]";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Update a List
// PATCH /contactdb/lists/{list_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PATCH;
      request.endpoint = "contactdb/lists/{list_id}";
      request.body = "{\"name\":\"newlistname\"}";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("list_id", "1");
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

//////////////////////////////////////////////////////////////////
// Retrieve a single list
// GET /contactdb/lists/{list_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/lists/{list_id}";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("list_id", "1");
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

//////////////////////////////////////////////////////////////////
// Delete a List
// DELETE /contactdb/lists/{list_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "contactdb/lists/{list_id}";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("delete_contacts", "true");
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

//////////////////////////////////////////////////////////////////
// Add Multiple Recipients to a List
// POST /contactdb/lists/{list_id}/recipients


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "contactdb/lists/{list_id}/recipients";
      request.body = "[\"recipient_id1\",\"recipient_id2\"]";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve all recipients on a List
// GET /contactdb/lists/{list_id}/recipients


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/lists/{list_id}/recipients";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("page", "1");
      queryParams.put("page_size", "1");
      queryParams.put("list_id", "1");
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

//////////////////////////////////////////////////////////////////
// Add a Single Recipient to a List
// POST /contactdb/lists/{list_id}/recipients/{recipient_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "contactdb/lists/{list_id}/recipients/{recipient_id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Delete a Single Recipient from a Single List
// DELETE /contactdb/lists/{list_id}/recipients/{recipient_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "contactdb/lists/{list_id}/recipients/{recipient_id}";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("recipient_id", "1");
      queryParams.put("list_id", "1");
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

//////////////////////////////////////////////////////////////////
// Update Recipient
// PATCH /contactdb/recipients


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PATCH;
      request.endpoint = "contactdb/recipients";
      request.body = "[{\"first_name\":\"Guy\",\"last_name\":\"Jones\",\"email\":\"jones@example.com\"}]";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Add recipients
// POST /contactdb/recipients


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "contactdb/recipients";
      request.body = "[{\"age\":25,\"last_name\":\"User\",\"email\":\"example@example.com\",\"first_name\":\"\"},{\"age\":25,\"last_name\":\"User\",\"email\":\"example2@example.com\",\"first_name\":\"Example\"}]";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve recipients
// GET /contactdb/recipients


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/recipients";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("page", "1");
      queryParams.put("page_size", "1");
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

//////////////////////////////////////////////////////////////////
// Delete Recipient
// DELETE /contactdb/recipients


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "contactdb/recipients";
      request.body = "[\"recipient_id1\",\"recipient_id2\"]";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve the count of billable recipients
// GET /contactdb/recipients/billable_count


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/recipients/billable_count";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve a Count of Recipients
// GET /contactdb/recipients/count


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/recipients/count";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve recipients matching search criteria
// GET /contactdb/recipients/search


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/recipients/search";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("%7Bfield_name%7D", "test_string");
      queryParams.put("{field_name}", "test_string");
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

//////////////////////////////////////////////////////////////////
// Retrieve a single recipient
// GET /contactdb/recipients/{recipient_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/recipients/{recipient_id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Delete a Recipient
// DELETE /contactdb/recipients/{recipient_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "contactdb/recipients/{recipient_id}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve the lists that a recipient is on
// GET /contactdb/recipients/{recipient_id}/lists


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/recipients/{recipient_id}/lists";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve reserved fields
// GET /contactdb/reserved_fields


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/reserved_fields";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Create a Segment
// POST /contactdb/segments


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.POST;
      request.endpoint = "contactdb/segments";
      request.body = "{\"conditions\":[{\"operator\":\"eq\",\"field\":\"last_name\",\"and_or\":\"\",\"value\":\"Miller\"},{\"operator\":\"gt\",\"field\":\"last_clicked\",\"and_or\":\"and\",\"value\":\"01/02/2015\"},{\"operator\":\"eq\",\"field\":\"clicks.campaign_identifier\",\"and_or\":\"or\",\"value\":\"513\"}],\"name\":\"Last Name Miller\",\"list_id\":4}";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Retrieve all segments
// GET /contactdb/segments


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/segments";
      Response response = sg.api(request);
      System.out.println(response.statusCode);
      System.out.println(response.body);
      System.out.println(response.headers);
    } catch (IOException ex) {
      throw ex;
    }
  }
}

//////////////////////////////////////////////////////////////////
// Update a segment
// PATCH /contactdb/segments/{segment_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.PATCH;
      request.endpoint = "contactdb/segments/{segment_id}";
      request.body = "{\"conditions\":[{\"operator\":\"eq\",\"field\":\"last_name\",\"and_or\":\"\",\"value\":\"Miller\"}],\"name\":\"The Millers\",\"list_id\":5}";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("segment_id", "test_string");
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

//////////////////////////////////////////////////////////////////
// Retrieve a segment
// GET /contactdb/segments/{segment_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/segments/{segment_id}";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("segment_id", "1");
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

//////////////////////////////////////////////////////////////////
// Delete a segment
// DELETE /contactdb/segments/{segment_id}


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.DELETE;
      request.endpoint = "contactdb/segments/{segment_id}";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("delete_contacts", "true");
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

//////////////////////////////////////////////////////////////////
// Retrieve recipients on a segment
// GET /contactdb/segments/{segment_id}/recipients


public class Example {
  public static void main(String[] args) throws IOException {
    try {
      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
      Request request = new Request();
      request.method = Method.GET;
      request.endpoint = "contactdb/segments/{segment_id}/recipients";
      Map<String,String> queryParams = new HashMap<String, String>();
      queryParams.put("page", "1");
      queryParams.put("page_size", "1");
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

