package com.sendgrid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SendGridTest {

  private final String SENDGRID_API_KEY = "";

  public Map<String,String> buildDefaultHeaders() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Map<String,String> requestHeaders = new HashMap<String, String>();
    requestHeaders.put("Authorization", "Bearer " + SENDGRID_API_KEY);
    String USER_AGENT = "sendgrid/" + sg.getLibraryVersion() + ";java";
    requestHeaders.put("User-agent", USER_AGENT);
    requestHeaders.put("Accept", "application/json");
    return requestHeaders;
  }

  @Test
  public void testInitialization() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Assert.assertEquals(sg.getHost(), "api.sendgrid.com");
    Assert.assertEquals(sg.getVersion(), "v3");
    Map<String,String> requestHeaders = buildDefaultHeaders();
    Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);
  }

  @Test
  public void testLibraryVersion() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Assert.assertEquals(sg.getLibraryVersion(), "3.0.0");
  }

  @Test
  public void testVersion() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    sg.setVersion("v4");
    Assert.assertEquals(sg.getVersion(), "v4");
  }

  @Test
  public void testRequestHeaders() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Map<String,String> requestHeaders = buildDefaultHeaders();

    sg.addRequestHeader("Test", "one");
    requestHeaders.put("Test", "one");
    Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);

    sg.removeRequestHeader("Test");
    requestHeaders.remove("Test");
    Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);
  }

  @Test
  public void testHost() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    sg.setHost("api.new.com");
    Assert.assertEquals(sg.getHost(), "api.new.com");
  }


  @Test
  public void test_access_settings_activity_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "access_settings/activity";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("limit", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_access_settings_whitelist_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "access_settings/whitelist";
    request.body = "{\"ips\":[{\"ip\":\"192.168.1.1\"},{\"ip\":\"192.*.*.*\"},{\"ip\":\"192.168.1.3/32\"}]}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_access_settings_whitelist_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "access_settings/whitelist";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_access_settings_whitelist_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "access_settings/whitelist";
    request.body = "{\"ids\":[1,2,3]}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_access_settings_whitelist__rule_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "access_settings/whitelist/{rule_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_access_settings_whitelist__rule_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "access_settings/whitelist/{rule_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_alerts_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "alerts";
    request.body = "{\"type\":\"stats_notification\",\"frequency\":\"daily\",\"email_to\":\"example@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_alerts_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "alerts";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_alerts__alert_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "alerts/{alert_id}";
    request.body = "{\"email_to\":\"example@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_alerts__alert_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "alerts/{alert_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_alerts__alert_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "alerts/{alert_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_api_keys_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "api_keys";
    request.body = "{\"sample\":\"data\",\"scopes\":[\"mail.send\",\"alerts.create\",\"alerts.read\"],\"name\":\"My API Key\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_api_keys_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "api_keys";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("limit", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_api_keys__api_key_id__put() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PUT;
    request.endpoint = "api_keys/{api_key_id}";
    request.body = "{\"scopes\":[\"user.profile.read\",\"user.profile.update\"],\"name\":\"A New Hope\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_api_keys__api_key_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "api_keys/{api_key_id}";
    request.body = "{\"name\":\"A New Hope\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_api_keys__api_key_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "api_keys/{api_key_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_api_keys__api_key_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "api_keys/{api_key_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_asm_groups_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "asm/groups";
    request.body = "{\"is_default\":true,\"description\":\"Suggestions for products our users might like.\",\"name\":\"Product Suggestions\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_asm_groups_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "asm/groups";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("id", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_asm_groups__group_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "asm/groups/{group_id}";
    request.body = "{\"description\":\"Suggestions for items our users might like.\",\"name\":\"Item Suggestions\",\"id\":103}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_asm_groups__group_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "asm/groups/{group_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_asm_groups__group_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "asm/groups/{group_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_asm_groups__group_id__suppressions_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "asm/groups/{group_id}/suppressions";
    request.body = "{\"recipient_emails\":[\"test1@example.com\",\"test2@example.com\"]}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_asm_groups__group_id__suppressions_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "asm/groups/{group_id}/suppressions";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_asm_groups__group_id__suppressions_search_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "asm/groups/{group_id}/suppressions/search";
    request.body = "{\"recipient_emails\":[\"exists1@example.com\",\"exists2@example.com\",\"doesnotexists@example.com\"]}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_asm_groups__group_id__suppressions__email__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "asm/groups/{group_id}/suppressions/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_asm_suppressions_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "asm/suppressions";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_asm_suppressions_global_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "asm/suppressions/global";
    request.body = "{\"recipient_emails\":[\"test1@example.com\",\"test2@example.com\"]}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_asm_suppressions_global__email__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "asm/suppressions/global/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_asm_suppressions_global__email__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "asm/suppressions/global/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_asm_suppressions__email__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "asm/suppressions/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_browsers_stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "browsers/stats";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("end_date", "2016-04-01");
      queryParams.put("aggregated_by", "day");
      queryParams.put("browsers", "test_string");
      queryParams.put("limit", "test_string");
      queryParams.put("offset", "test_string");
      queryParams.put("start_date", "2016-01-01");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_campaigns_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "campaigns";
    request.body = "{\"custom_unsubscribe_url\":\"\",\"html_content\":\"<html><head><title></title></head><body><p>Check out our spring line!</p></body></html>\",\"list_ids\":[110,124],\"sender_id\":124451,\"subject\":\"New Products for Spring!\",\"plain_content\":\"Check out our spring line!\",\"suppression_group_id\":42,\"title\":\"March Newsletter\",\"segment_ids\":[110],\"categories\":[\"spring line\"],\"ip_pool\":\"marketing\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_campaigns_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "campaigns";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("limit", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_campaigns__campaign_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "campaigns/{campaign_id}";
    request.body = "{\"html_content\":\"<html><head><title></title></head><body><p>Check out our summer line!</p></body></html>\",\"subject\":\"New Products for Summer!\",\"title\":\"May Newsletter\",\"categories\":[\"summer line\"],\"plain_content\":\"Check out our summer line!\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_campaigns__campaign_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "campaigns/{campaign_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_campaigns__campaign_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "campaigns/{campaign_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_campaigns__campaign_id__schedules_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "campaigns/{campaign_id}/schedules";
    request.body = "{\"send_at\":1489451436}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_campaigns__campaign_id__schedules_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "campaigns/{campaign_id}/schedules";
    request.body = "{\"send_at\":1489771528}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_campaigns__campaign_id__schedules_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "campaigns/{campaign_id}/schedules";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_campaigns__campaign_id__schedules_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "campaigns/{campaign_id}/schedules";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_campaigns__campaign_id__schedules_now_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "campaigns/{campaign_id}/schedules/now";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_campaigns__campaign_id__schedules_test_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "campaigns/{campaign_id}/schedules/test";
    request.body = "{\"to\":\"your.email@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_categories_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "categories";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("category", "test_string");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_categories_stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "categories/stats";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("end_date", "2016-04-01");
      queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("categories", "test_string");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_categories_stats_sums_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "categories/stats/sums";
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
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_clients_stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "clients/stats";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("aggregated_by", "day");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("end_date", "2016-04-01");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_clients__client_type__stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "clients/{client_type}/stats";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("aggregated_by", "day");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("end_date", "2016-04-01");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_custom_fields_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "contactdb/custom_fields";
    request.body = "{\"type\":\"text\",\"name\":\"pet\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_contactdb_custom_fields_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/custom_fields";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_custom_fields__custom_field_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/custom_fields/{custom_field_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_custom_fields__custom_field_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "202");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "contactdb/custom_fields/{custom_field_id}";
    Response response = sg.api(request);
    Assert.assertEquals(202, response.statusCode);
  }

  @Test
  public void test_contactdb_lists_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "contactdb/lists";
    request.body = "{\"name\":\"your list name\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_contactdb_lists_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/lists";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_lists_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "contactdb/lists";
    request.body = "[1,2,3,4]";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_contactdb_lists__list_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "contactdb/lists/{list_id}";
    request.body = "{\"name\":\"newlistname\"}";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("list_id", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_lists__list_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/lists/{list_id}";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("list_id", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_lists__list_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "202");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "contactdb/lists/{list_id}";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("delete_contacts", "true");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(202, response.statusCode);
  }

  @Test
  public void test_contactdb_lists__list_id__recipients_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "contactdb/lists/{list_id}/recipients";
    request.body = "[\"recipient_id1\",\"recipient_id2\"]";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_contactdb_lists__list_id__recipients_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/lists/{list_id}/recipients";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("page", "1");
      queryParams.put("page_size", "1");
      queryParams.put("list_id", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_lists__list_id__recipients__recipient_id__post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "contactdb/lists/{list_id}/recipients/{recipient_id}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_contactdb_lists__list_id__recipients__recipient_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "contactdb/lists/{list_id}/recipients/{recipient_id}";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("recipient_id", "1");
      queryParams.put("list_id", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "contactdb/recipients";
    request.body = "[{\"first_name\":\"Guy\",\"last_name\":\"Jones\",\"email\":\"jones@example.com\"}]";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "contactdb/recipients";
    request.body = "[{\"age\":25,\"last_name\":\"User\",\"email\":\"example@example.com\",\"first_name\":\"\"},{\"age\":25,\"last_name\":\"User\",\"email\":\"example2@example.com\",\"first_name\":\"Example\"}]";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/recipients";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("page", "1");
      queryParams.put("page_size", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "contactdb/recipients";
    request.body = "[\"recipient_id1\",\"recipient_id2\"]";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients_billable_count_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/recipients/billable_count";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients_count_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/recipients/count";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients_search_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/recipients/search";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("%7Bfield_name%7D", "test_string");
      queryParams.put("{field_name}", "test_string");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients__recipient_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/recipients/{recipient_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients__recipient_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "contactdb/recipients/{recipient_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_contactdb_recipients__recipient_id__lists_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/recipients/{recipient_id}/lists";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_reserved_fields_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/reserved_fields";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_segments_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "contactdb/segments";
    request.body = "{\"conditions\":[{\"operator\":\"eq\",\"field\":\"last_name\",\"and_or\":\"\",\"value\":\"Miller\"},{\"operator\":\"gt\",\"field\":\"last_clicked\",\"and_or\":\"and\",\"value\":\"01/02/2015\"},{\"operator\":\"eq\",\"field\":\"clicks.campaign_identifier\",\"and_or\":\"or\",\"value\":\"513\"}],\"name\":\"Last Name Miller\",\"list_id\":4}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_segments_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/segments";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_segments__segment_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "contactdb/segments/{segment_id}";
    request.body = "{\"conditions\":[{\"operator\":\"eq\",\"field\":\"last_name\",\"and_or\":\"\",\"value\":\"Miller\"}],\"name\":\"The Millers\",\"list_id\":5}";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("segment_id", "test_string");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_segments__segment_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/segments/{segment_id}";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("segment_id", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_contactdb_segments__segment_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "contactdb/segments/{segment_id}";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("delete_contacts", "true");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_contactdb_segments__segment_id__recipients_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "contactdb/segments/{segment_id}/recipients";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("page", "1");
      queryParams.put("page_size", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_devices_stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "devices/stats";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("end_date", "2016-04-01");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_geo_stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "geo/stats";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("end_date", "2016-04-01");
      queryParams.put("country", "US");
      queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      queryParams.put("start_date", "2016-01-01");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "ips";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("subuser", "test_string");
      queryParams.put("ip", "test_string");
      queryParams.put("limit", "1");
      queryParams.put("exclude_whitelabels", "true");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_assigned_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "ips/assigned";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_pools_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "ips/pools";
    request.body = "{\"name\":\"marketing\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_pools_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "ips/pools";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_pools__pool_name__put() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PUT;
    request.endpoint = "ips/pools/{pool_name}";
    request.body = "{\"name\":\"new_pool_name\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_pools__pool_name__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "ips/pools/{pool_name}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_pools__pool_name__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "ips/pools/{pool_name}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_ips_pools__pool_name__ips_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "ips/pools/{pool_name}/ips";
    request.body = "{\"ip\":\"0.0.0.0\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_ips_pools__pool_name__ips__ip__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "ips/pools/{pool_name}/ips/{ip}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_ips_warmup_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "ips/warmup";
    request.body = "{\"ip\":\"0.0.0.0\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_warmup_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "ips/warmup";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_warmup__ip_address__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "ips/warmup/{ip_address}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_ips_warmup__ip_address__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "ips/warmup/{ip_address}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_ips__ip_address__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "ips/{ip_address}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_batch_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "mail/batch";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_mail_batch__batch_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail/batch/{batch_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_send_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "202");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "mail/send";
    request.body = "{\"custom_args\":{\"New Argument 1\":\"New Value 1\",\"activationAttempt\":\"1\",\"customerAccountNumber\":\"[CUSTOMER ACCOUNT NUMBER GOES HERE]\"},\"from\":{\"email\":\"sam.smith@example.com\",\"name\":\"Sam Smith\"},\"attachments\":[{\"name\":\"file1\",\"filename\":\"file1.jpg\",\"content\":\"[BASE64 encoded content block here]\",\"disposition\":\"inline\",\"content_id\":\"ii_139db99fdb5c3704\",\"type\":\"jpg\"}],\"personalizations\":[{\"to\":[{\"email\":\"john.doe@example.com\",\"name\":\"John Doe\"}],\"cc\":[{\"email\":\"jane.doe@example.com\",\"name\":\"Jane Doe\"}],\"bcc\":[{\"email\":\"sam.doe@example.com\",\"name\":\"Sam Doe\"}],\"custom_args\":{\"New Argument 1\":\"New Value 1\",\"activationAttempt\":\"1\",\"customerAccountNumber\":\"[CUSTOMER ACCOUNT NUMBER GOES HERE]\"},\"headers\":{\"X-Accept-Language\":\"en\",\"X-Mailer\":\"MyApp\"},\"send_at\":1409348513,\"substitutions\":{\"type\":\"object\",\"id\":\"substitutions\"},\"subject\":\"Hello, World!\"}],\"subject\":\"Hello, World!\",\"ip_pool_name\":\"[YOUR POOL NAME GOES HERE]\",\"content\":[{\"type\":\"text/html\",\"value\":\"<html><p>Hello, world!</p><img src=[CID GOES HERE]></img></html>\"}],\"headers\":{},\"asm\":{\"groups_to_display\":[1,2,3],\"group_id\":1},\"batch_id\":\"[YOUR BATCH ID GOES HERE]\",\"tracking_settings\":{\"subscription_tracking\":{\"text\":\"If you would like to unsubscribe and stop receiveing these emails <% click here %>.\",\"enable\":true,\"html\":\"If you would like to unsubscribe and stop receiving these emails <% clickhere %>.\",\"substitution_tag\":\"<%click here%>\"},\"open_tracking\":{\"enable\":true,\"substitution_tag\":\"%opentrack\"},\"click_tracking\":{\"enable\":true,\"enable_text\":true},\"ganalytics\":{\"utm_campaign\":\"[NAME OF YOUR REFERRER SOURCE]\",\"enable\":true,\"utm_name\":\"[NAME OF YOUR CAMPAIGN]\",\"utm_term\":\"[IDENTIFY PAID KEYWORDS HERE]\",\"utm_content\":\"[USE THIS SPACE TO DIFFERENTIATE YOUR EMAIL FROM ADS]\",\"utm_medium\":\"[NAME OF YOUR MARKETING MEDIUM e.g. email]\"}},\"mail_settings\":{\"footer\":{\"text\":\"Thanks,/n The SendGrid Team\",\"enable\":true,\"html\":\"<p>Thanks</br>The SendGrid Team</p>\"},\"spam_check\":{\"threshold\":3,\"post_to_url\":\"http://example.com/compliance\",\"enable\":true},\"bypass_list_management\":{\"enable\":true},\"sandbox_mode\":{\"enable\":false},\"bcc\":{\"enable\":true,\"email\":\"ben.doe@example.com\"}},\"reply_to\":{\"email\":\"sam.smith@example.com\",\"name\":\"Sam Smith\"},\"sections\":{\"section\":{\":sectionName2\":\"section 2 text\",\":sectionName1\":\"section 1 text\"}},\"template_id\":\"[YOUR TEMPLATE ID GOES HERE]\",\"categories\":[\"category1\",\"category2\"],\"send_at\":1409348513}";
    Response response = sg.api(request);
    Assert.assertEquals(202, response.statusCode);
  }

  @Test
  public void test_mail_settings_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("limit", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_address_whitelist_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "mail_settings/address_whitelist";
    request.body = "{\"list\":[\"email1@example.com\",\"example.com\"],\"enabled\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_address_whitelist_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings/address_whitelist";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_bcc_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "mail_settings/bcc";
    request.body = "{\"enabled\":false,\"email\":\"email@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_bcc_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings/bcc";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_bounce_purge_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "mail_settings/bounce_purge";
    request.body = "{\"hard_bounces\":5,\"soft_bounces\":5,\"enabled\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_bounce_purge_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings/bounce_purge";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_footer_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "mail_settings/footer";
    request.body = "{\"html_content\":\"...\",\"enabled\":true,\"plain_content\":\"...\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_footer_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings/footer";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_forward_bounce_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "mail_settings/forward_bounce";
    request.body = "{\"enabled\":true,\"email\":\"example@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_forward_bounce_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings/forward_bounce";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_forward_spam_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "mail_settings/forward_spam";
    request.body = "{\"enabled\":false,\"email\":\"\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_forward_spam_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings/forward_spam";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_plain_content_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "mail_settings/plain_content";
    request.body = "{\"enabled\":false}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_plain_content_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings/plain_content";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_spam_check_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "mail_settings/spam_check";
    request.body = "{\"url\":\"url\",\"max_score\":5,\"enabled\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_spam_check_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings/spam_check";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_template_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "mail_settings/template";
    request.body = "{\"html_content\":\"<% body %>\",\"enabled\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mail_settings_template_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mail_settings/template";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_mailbox_providers_stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "mailbox_providers/stats";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("end_date", "2016-04-01");
      queryParams.put("mailbox_providers", "test_string");
      queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
      queryParams.put("start_date", "2016-01-01");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_partner_settings_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "partner_settings";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("limit", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_partner_settings_new_relic_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "partner_settings/new_relic";
    request.body = "{\"enable_subuser_statistics\":true,\"enabled\":true,\"license_key\":\"\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_partner_settings_new_relic_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "partner_settings/new_relic";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_scopes_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "scopes";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "stats";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "1");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("end_date", "2016-04-01");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "subusers";
    request.body = "{\"username\":\"John@example.com\",\"ips\":[\"1.1.1.1\",\"2.2.2.2\"],\"password\":\"johns_password\",\"email\":\"John@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "subusers";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("username", "test_string");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers_reputations_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "subusers/reputations";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("usernames", "test_string");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers_stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

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
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers_stats_monthly_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

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
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers_stats_sums_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

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
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers__subuser_name__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "subusers/{subuser_name}";
    request.body = "{\"disabled\":false}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_subusers__subuser_name__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "subusers/{subuser_name}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_subusers__subuser_name__ips_put() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PUT;
    request.endpoint = "subusers/{subuser_name}/ips";
    request.body = "[\"127.0.0.1\"]";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers__subuser_name__monitor_put() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PUT;
    request.endpoint = "subusers/{subuser_name}/monitor";
    request.body = "{\"frequency\":500,\"email\":\"example@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers__subuser_name__monitor_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "subusers/{subuser_name}/monitor";
    request.body = "{\"frequency\":50000,\"email\":\"example@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers__subuser_name__monitor_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "subusers/{subuser_name}/monitor";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_subusers__subuser_name__monitor_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "subusers/{subuser_name}/monitor";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_subusers__subuser_name__stats_monthly_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "subusers/{subuser_name}/stats/monthly";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("date", "test_string");
      queryParams.put("sort_by_direction", "asc");
      queryParams.put("limit", "1");
      queryParams.put("sort_by_metric", "test_string");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_suppression_blocks_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "suppression/blocks";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("start_time", "1");
      queryParams.put("limit", "1");
      queryParams.put("end_time", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_suppression_blocks_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "suppression/blocks";
    request.body = "{\"emails\":[\"example1@example.com\",\"example2@example.com\"],\"delete_all\":false}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_suppression_blocks__email__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "suppression/blocks/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_suppression_blocks__email__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "suppression/blocks/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_suppression_bounces_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "suppression/bounces";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("start_time", "1");
      queryParams.put("end_time", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_suppression_bounces_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "suppression/bounces";
    request.body = "{\"emails\":[\"example@example.com\",\"example2@example.com\"],\"delete_all\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_suppression_bounces__email__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "suppression/bounces/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_suppression_bounces__email__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "suppression/bounces/{email}";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("email_address", "example@example.com");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_suppression_invalid_emails_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "suppression/invalid_emails";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("start_time", "1");
      queryParams.put("limit", "1");
      queryParams.put("end_time", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_suppression_invalid_emails_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "suppression/invalid_emails";
    request.body = "{\"emails\":[\"example1@example.com\",\"example2@example.com\"],\"delete_all\":false}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_suppression_invalid_emails__email__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "suppression/invalid_emails/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_suppression_invalid_emails__email__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "suppression/invalid_emails/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_suppression_spam_report__email__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "suppression/spam_report/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_suppression_spam_report__email__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "suppression/spam_report/{email}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_suppression_spam_reports_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "suppression/spam_reports";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("start_time", "1");
      queryParams.put("limit", "1");
      queryParams.put("end_time", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_suppression_spam_reports_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "suppression/spam_reports";
    request.body = "{\"emails\":[\"example1@example.com\",\"example2@example.com\"],\"delete_all\":false}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_suppression_unsubscribes_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "suppression/unsubscribes";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("start_time", "1");
      queryParams.put("limit", "1");
      queryParams.put("end_time", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_templates_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "templates";
    request.body = "{\"name\":\"example_name\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_templates_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "templates";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_templates__template_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "templates/{template_id}";
    request.body = "{\"name\":\"new_example_name\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_templates__template_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "templates/{template_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_templates__template_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "templates/{template_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_templates__template_id__versions_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "templates/{template_id}/versions";
    request.body = "{\"name\":\"example_version_name\",\"html_content\":\"<%body%>\",\"plain_content\":\"<%body%>\",\"active\":1,\"template_id\":\"ddb96bbc-9b92-425e-8979-99464621b543\",\"subject\":\"<%subject%>\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_templates__template_id__versions__version_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "templates/{template_id}/versions/{version_id}";
    request.body = "{\"active\":1,\"html_content\":\"<%body%>\",\"subject\":\"<%subject%>\",\"name\":\"updated_example_name\",\"plain_content\":\"<%body%>\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_templates__template_id__versions__version_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "templates/{template_id}/versions/{version_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_templates__template_id__versions__version_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "templates/{template_id}/versions/{version_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_templates__template_id__versions__version_id__activate_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "templates/{template_id}/versions/{version_id}/activate";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_tracking_settings_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "tracking_settings";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("limit", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_tracking_settings_click_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "tracking_settings/click";
    request.body = "{\"enabled\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_tracking_settings_click_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "tracking_settings/click";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_tracking_settings_google_analytics_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "tracking_settings/google_analytics";
    request.body = "{\"utm_campaign\":\"website\",\"utm_term\":\"\",\"utm_content\":\"\",\"enabled\":true,\"utm_source\":\"sendgrid.com\",\"utm_medium\":\"email\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_tracking_settings_google_analytics_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "tracking_settings/google_analytics";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_tracking_settings_open_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "tracking_settings/open";
    request.body = "{\"enabled\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_tracking_settings_open_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "tracking_settings/open";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_tracking_settings_subscription_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "tracking_settings/subscription";
    request.body = "{\"url\":\"url\",\"html_content\":\"html content\",\"enabled\":true,\"landing\":\"landing page html\",\"replace\":\"replacement tag\",\"plain_content\":\"text content\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_tracking_settings_subscription_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "tracking_settings/subscription";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_account_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/account";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_credits_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/credits";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_email_put() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PUT;
    request.endpoint = "user/email";
    request.body = "{\"email\":\"example@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_email_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/email";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_password_put() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PUT;
    request.endpoint = "user/password";
    request.body = "{\"new_password\":\"new_password\",\"old_password\":\"old_password\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_profile_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "user/profile";
    request.body = "{\"city\":\"Orange\",\"first_name\":\"Example\",\"last_name\":\"User\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_profile_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/profile";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_scheduled_sends_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "user/scheduled_sends";
    request.body = "{\"batch_id\":\"YOUR_BATCH_ID\",\"status\":\"pause\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_user_scheduled_sends_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/scheduled_sends";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_scheduled_sends__batch_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "user/scheduled_sends/{batch_id}";
    request.body = "{\"status\":\"pause\"}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_user_scheduled_sends__batch_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/scheduled_sends/{batch_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_scheduled_sends__batch_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "user/scheduled_sends/{batch_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_user_settings_enforced_tls_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "user/settings/enforced_tls";
    request.body = "{\"require_tls\":true,\"require_valid_cert\":false}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_settings_enforced_tls_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/settings/enforced_tls";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_username_put() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PUT;
    request.endpoint = "user/username";
    request.body = "{\"username\":\"test_username\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_username_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/username";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_webhooks_event_settings_patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "user/webhooks/event/settings";
    request.body = "{\"group_resubscribe\":true,\"delivered\":true,\"group_unsubscribe\":true,\"spam_report\":true,\"url\":\"url\",\"enabled\":true,\"bounce\":true,\"deferred\":true,\"unsubscribe\":true,\"dropped\":true,\"open\":true,\"click\":true,\"processed\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_webhooks_event_settings_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/webhooks/event/settings";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_webhooks_event_test_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "user/webhooks/event/test";
    request.body = "{\"url\":\"url\"}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_user_webhooks_parse_settings_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "user/webhooks/parse/settings";
    request.body = "{\"url\":\"http://email.myhosthame.com\",\"send_raw\":false,\"hostname\":\"myhostname.com\",\"spam_check\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_user_webhooks_parse_settings_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/webhooks/parse/settings";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_webhooks_parse_settings__hostname__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "user/webhooks/parse/settings/{hostname}";
    request.body = "{\"url\":\"http://newdomain.com/parse\",\"send_raw\":true,\"spam_check\":false}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_webhooks_parse_settings__hostname__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/webhooks/parse/settings/{hostname}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_user_webhooks_parse_settings__hostname__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "user/webhooks/parse/settings/{hostname}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_user_webhooks_parse_stats_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "user/webhooks/parse/stats";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("aggregated_by", "day");
      queryParams.put("limit", "test_string");
      queryParams.put("start_date", "2016-01-01");
      queryParams.put("end_date", "2016-04-01");
      queryParams.put("offset", "test_string");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "whitelabel/domains";
    request.body = "{\"automatic_security\":false,\"username\":\"john@example.com\",\"domain\":\"example.com\",\"default\":true,\"custom_spf\":true,\"ips\":[\"192.168.1.1\",\"192.168.1.2\"],\"subdomain\":\"news\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

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
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains_default_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "whitelabel/domains/default";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains_subuser_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "whitelabel/domains/subuser";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains_subuser_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "whitelabel/domains/subuser";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains__domain_id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "whitelabel/domains/{domain_id}";
    request.body = "{\"default\":false,\"custom_spf\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains__domain_id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "whitelabel/domains/{domain_id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains__domain_id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "whitelabel/domains/{domain_id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains__domain_id__subuser_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "whitelabel/domains/{domain_id}/subuser";
    request.body = "{\"username\":\"jane@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains__id__ips_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "whitelabel/domains/{id}/ips";
    request.body = "{\"ip\":\"192.168.0.1\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains__id__ips__ip__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "whitelabel/domains/{id}/ips/{ip}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_domains__id__validate_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "whitelabel/domains/{id}/validate";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_ips_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "whitelabel/ips";
    request.body = "{\"ip\":\"192.168.1.1\",\"domain\":\"example.com\",\"subdomain\":\"email\"}";
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_whitelabel_ips_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "whitelabel/ips";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("ip", "test_string");
      queryParams.put("limit", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_ips__id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "whitelabel/ips/{id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_ips__id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "whitelabel/ips/{id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_whitelabel_ips__id__validate_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "whitelabel/ips/{id}/validate";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_links_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "whitelabel/links";
    request.body = "{\"default\":true,\"domain\":\"example.com\",\"subdomain\":\"mail\"}";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("limit", "1");
      queryParams.put("offset", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(201, response.statusCode);
  }

  @Test
  public void test_whitelabel_links_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "whitelabel/links";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("limit", "1");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_links_default_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "whitelabel/links/default";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("domain", "test_string");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_links_subuser_get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "whitelabel/links/subuser";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("username", "test_string");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_links_subuser_delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "whitelabel/links/subuser";
    Map<String,String> queryParams = new HashMap<String, String>();
    queryParams.put("username", "test_string");
    request.queryParams = queryParams;
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_whitelabel_links__id__patch() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.PATCH;
    request.endpoint = "whitelabel/links/{id}";
    request.body = "{\"default\":true}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_links__id__get() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.GET;
    request.endpoint = "whitelabel/links/{id}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_links__id__delete() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.method = Method.DELETE;
    request.endpoint = "whitelabel/links/{id}";
    Response response = sg.api(request);
    Assert.assertEquals(204, response.statusCode);
  }

  @Test
  public void test_whitelabel_links__id__validate_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "whitelabel/links/{id}/validate";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

  @Test
  public void test_whitelabel_links__link_id__subuser_post() throws IOException {
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.method = Method.POST;
    request.endpoint = "whitelabel/links/{link_id}/subuser";
    request.body = "{\"username\":\"jane@example.com\"}";
    Response response = sg.api(request);
    Assert.assertEquals(200, response.statusCode);
  }

}
