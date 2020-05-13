package com.sendgrid;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.*;

public class SendGridTest {

  private final String SENDGRID_API_KEY = "";

  public Map<String,String> buildDefaultHeaders() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Map<String,String> requestHeaders = new HashMap<String, String>();
    requestHeaders.put("Authorization", "Bearer " + SENDGRID_API_KEY);
    String USER_AGENT = "sendgrid/" + sg.getLibraryVersion() + ";java";
    requestHeaders.put("User-Agent", USER_AGENT);
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
  public void testConstructWithClient() throws IOException {
    Client client = mock(Client.class);
    SendGrid sg = new SendGrid(SENDGRID_API_KEY, client);
    Request request = new Request();
    sg.makeCall(request);
    verify(client).api(request);
  }

  @Test
  public void testLibraryVersion() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Assert.assertEquals(sg.getLibraryVersion(), "4.5.0");
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
  public void testRateLimitRetry() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    sg.setRateLimitRetry(100);
    Assert.assertEquals(sg.getRateLimitRetry(), 100);
  }

  @Test
  public void testRateLimitSleep() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    sg.setRateLimitSleep(999);
    Assert.assertEquals(sg.getRateLimitSleep(), 999);
  }


  @Test
  public void test_async() {
    final Object sync = new Object();
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

    request.setMethod(Method.GET);
    request.setEndpoint("access_settings/activity");
    request.addQueryParam("limit", "1");
    sg.attempt(request, new APICallback() {
      @Override
      public void error(Exception e) {
        Assert.fail();
        synchronized(sync) {
          sync.notify();
        }
      }

      @Override
      public void response(Response response) {
        Assert.assertEquals(200, response.getStatusCode());
        synchronized(sync) {
          sync.notify();
        }
      }
    });

    try {
      synchronized(sync) {
        sync.wait(2000);
      }
    } catch(InterruptedException ex) {
      Assert.fail(ex.toString());
    }
  }

  @Test
  public void test_async_rate_limit() {
    final Object sync = new Object();
    SendGrid sg = null;
    if(System.getenv("TRAVIS") != null && Boolean.parseBoolean(System.getenv("TRAVIS"))) {
      sg = new SendGrid("SENDGRID_API_KEY");
      sg.setHost(System.getenv("MOCK_HOST"));
    } else {
      sg = new SendGrid("SENDGRID_API_KEY", true);
      sg.setHost("localhost:4010");
    }
    sg.addRequestHeader("X-Mock", "429");

    Request request = new Request();

    request.setMethod(Method.GET);
    request.setEndpoint("access_settings/activity");
    request.addQueryParam("limit", "1");
    sg.attempt(request, new APICallback() {
      @Override
      public void error(Exception e) {
        Assert.assertEquals(e.getClass(), RateLimitException.class);
        sync.notify();
      }

      @Override
      public void response(Response response) {
        Assert.fail();
        sync.notify();
      }
    });

    try {
      synchronized(sync) {
        sync.wait(2000);
      }
    } catch(InterruptedException ex) {
      Assert.fail(ex.toString());
    }
  }

  @Test
  public void test_access_settings_activity_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("access_settings/activity");
    request.addQueryParam("limit", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_access_settings_whitelist_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("access_settings/whitelist");
    request.setBody("{\"ips\":[{\"ip\":\"192.168.1.1\"},{\"ip\":\"192.*.*.*\"},{\"ip\":\"192.168.1.3/32\"}]}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_access_settings_whitelist_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("access_settings/whitelist");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_access_settings_whitelist_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("access_settings/whitelist");
    request.setBody("{\"ids\":[1,2,3]}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_access_settings_whitelist__rule_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("access_settings/whitelist/{rule_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_access_settings_whitelist__rule_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("access_settings/whitelist/{rule_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_alerts_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("alerts");
    request.setBody("{\"type\":\"stats_notification\",\"frequency\":\"daily\",\"email_to\":\"example@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_alerts_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("alerts");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_alerts__alert_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("alerts/{alert_id}");
    request.setBody("{\"email_to\":\"example@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_alerts__alert_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("alerts/{alert_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_alerts__alert_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("alerts/{alert_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_api_keys_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("api_keys");
    request.setBody("{\"sample\":\"data\",\"scopes\":[\"mail.send\",\"alerts.create\",\"alerts.read\"],\"name\":\"My API Key\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_api_keys_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("api_keys");
    request.addQueryParam("limit", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_api_keys__api_key_id__put() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PUT);
    request.setEndpoint("api_keys/{api_key_id}");
    request.setBody("{\"scopes\":[\"user.profile.read\",\"user.profile.update\"],\"name\":\"A New Hope\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_api_keys__api_key_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("api_keys/{api_key_id}");
    request.setBody("{\"name\":\"A New Hope\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_api_keys__api_key_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("api_keys/{api_key_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_api_keys__api_key_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("api_keys/{api_key_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_asm_groups_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("asm/groups");
    request.setBody("{\"is_default\":true,\"description\":\"Suggestions for products our users might like.\",\"name\":\"Product Suggestions\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_asm_groups_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("asm/groups");
    request.addQueryParam("id", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_asm_groups__group_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("asm/groups/{group_id}");
    request.setBody("{\"description\":\"Suggestions for items our users might like.\",\"name\":\"Item Suggestions\",\"id\":103}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_asm_groups__group_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("asm/groups/{group_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_asm_groups__group_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("asm/groups/{group_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_asm_groups__group_id__suppressions_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("asm/groups/{group_id}/suppressions");
    request.setBody("{\"recipient_emails\":[\"test1@example.com\",\"test2@example.com\"]}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_asm_groups__group_id__suppressions_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("asm/groups/{group_id}/suppressions");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_asm_groups__group_id__suppressions_search_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("asm/groups/{group_id}/suppressions/search");
    request.setBody("{\"recipient_emails\":[\"exists1@example.com\",\"exists2@example.com\",\"doesnotexists@example.com\"]}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_asm_groups__group_id__suppressions__email__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("asm/groups/{group_id}/suppressions/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_asm_suppressions_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("asm/suppressions");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_asm_suppressions_global_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("asm/suppressions/global");
    request.setBody("{\"recipient_emails\":[\"test1@example.com\",\"test2@example.com\"]}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_asm_suppressions_global__email__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("asm/suppressions/global/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_asm_suppressions_global__email__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("asm/suppressions/global/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_asm_suppressions__email__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("asm/suppressions/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_browsers_stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("browsers/stats");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("browsers", "test_string");
    request.addQueryParam("limit", "test_string");
    request.addQueryParam("offset", "test_string");
    request.addQueryParam("start_date", "2016-01-01");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_campaigns_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("campaigns");
    request.setBody("{\"custom_unsubscribe_url\":\"\",\"html_content\":\"<html><head><title></title></head><body><p>Check out our spring line!</p></body></html>\",\"list_ids\":[110,124],\"sender_id\":124451,\"subject\":\"New Products for Spring!\",\"plain_content\":\"Check out our spring line!\",\"suppression_group_id\":42,\"title\":\"March Newsletter\",\"segment_ids\":[110],\"categories\":[\"spring line\"],\"ip_pool\":\"marketing\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_campaigns_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("campaigns");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_campaigns__campaign_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("campaigns/{campaign_id}");
    request.setBody("{\"html_content\":\"<html><head><title></title></head><body><p>Check out our summer line!</p></body></html>\",\"subject\":\"New Products for Summer!\",\"title\":\"May Newsletter\",\"categories\":[\"summer line\"],\"plain_content\":\"Check out our summer line!\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_campaigns__campaign_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("campaigns/{campaign_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_campaigns__campaign_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("campaigns/{campaign_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_campaigns__campaign_id__schedules_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("campaigns/{campaign_id}/schedules");
    request.setBody("{\"send_at\":1489451436}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_campaigns__campaign_id__schedules_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("campaigns/{campaign_id}/schedules");
    request.setBody("{\"send_at\":1489771528}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_campaigns__campaign_id__schedules_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("campaigns/{campaign_id}/schedules");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_campaigns__campaign_id__schedules_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("campaigns/{campaign_id}/schedules");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_campaigns__campaign_id__schedules_now_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("campaigns/{campaign_id}/schedules/now");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_campaigns__campaign_id__schedules_test_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("campaigns/{campaign_id}/schedules/test");
    request.setBody("{\"to\":\"your.email@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_categories_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("categories");
    request.addQueryParam("category", "test_string");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_categories_stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("categories/stats");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    request.addQueryParam("start_date", "2016-01-01");
    request.addQueryParam("categories", "test_string");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_categories_stats_sums_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("categories/stats/sums");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("limit", "1");
    request.addQueryParam("sort_by_metric", "test_string");
    request.addQueryParam("offset", "1");
    request.addQueryParam("start_date", "2016-01-01");
    request.addQueryParam("sort_by_direction", "asc");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_clients_stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("clients/stats");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("start_date", "2016-01-01");
    request.addQueryParam("end_date", "2016-04-01");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_clients__client_type__stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("clients/{client_type}/stats");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("start_date", "2016-01-01");
    request.addQueryParam("end_date", "2016-04-01");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_custom_fields_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("contactdb/custom_fields");
    request.setBody("{\"type\":\"text\",\"name\":\"pet\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_contactdb_custom_fields_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/custom_fields");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_custom_fields__custom_field_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/custom_fields/{custom_field_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_custom_fields__custom_field_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "202");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("contactdb/custom_fields/{custom_field_id}");
    Response response = sg.api(request);
    Assert.assertEquals(202, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("contactdb/lists");
    request.setBody("{\"name\":\"your list name\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/lists");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("contactdb/lists");
    request.setBody("[1,2,3,4]");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists__list_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("contactdb/lists/{list_id}");
    request.setBody("{\"name\":\"newlistname\"}");
    request.addQueryParam("list_id", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists__list_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/lists/{list_id}");
    request.addQueryParam("list_id", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists__list_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "202");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("contactdb/lists/{list_id}");
    request.addQueryParam("delete_contacts", "true");
    Response response = sg.api(request);
    Assert.assertEquals(202, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists__list_id__recipients_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("contactdb/lists/{list_id}/recipients");
    request.setBody("[\"recipient_id1\",\"recipient_id2\"]");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists__list_id__recipients_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/lists/{list_id}/recipients");
    request.addQueryParam("page", "1");
    request.addQueryParam("page_size", "1");
    request.addQueryParam("list_id", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists__list_id__recipients__recipient_id__post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("contactdb/lists/{list_id}/recipients/{recipient_id}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_contactdb_lists__list_id__recipients__recipient_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("contactdb/lists/{list_id}/recipients/{recipient_id}");
    request.addQueryParam("recipient_id", "1");
    request.addQueryParam("list_id", "1");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("contactdb/recipients");
    request.setBody("[{\"first_name\":\"Guy\",\"last_name\":\"Jones\",\"email\":\"jones@example.com\"}]");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("contactdb/recipients");
    request.setBody("[{\"age\":25,\"last_name\":\"User\",\"email\":\"example@example.com\",\"first_name\":\"\"},{\"age\":25,\"last_name\":\"User\",\"email\":\"example2@example.com\",\"first_name\":\"Example\"}]");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/recipients");
    request.addQueryParam("page", "1");
    request.addQueryParam("page_size", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("contactdb/recipients");
    request.setBody("[\"recipient_id1\",\"recipient_id2\"]");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients_billable_count_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/recipients/billable_count");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients_count_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/recipients/count");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients_search_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/recipients/search");
    request.addQueryParam("{field_name}", "test_string");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients__recipient_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/recipients/{recipient_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients__recipient_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("contactdb/recipients/{recipient_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_contactdb_recipients__recipient_id__lists_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/recipients/{recipient_id}/lists");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_reserved_fields_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/reserved_fields");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_segments_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("contactdb/segments");
    request.setBody("{\"conditions\":[{\"operator\":\"eq\",\"field\":\"last_name\",\"and_or\":\"\",\"value\":\"Miller\"},{\"operator\":\"gt\",\"field\":\"last_clicked\",\"and_or\":\"and\",\"value\":\"01/02/2015\"},{\"operator\":\"eq\",\"field\":\"clicks.campaign_identifier\",\"and_or\":\"or\",\"value\":\"513\"}],\"name\":\"Last Name Miller\",\"list_id\":4}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_segments_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/segments");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_segments__segment_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("contactdb/segments/{segment_id}");
    request.setBody("{\"conditions\":[{\"operator\":\"eq\",\"field\":\"last_name\",\"and_or\":\"\",\"value\":\"Miller\"}],\"name\":\"The Millers\",\"list_id\":5}");
    request.addQueryParam("segment_id", "test_string");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_segments__segment_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/segments/{segment_id}");
    request.addQueryParam("segment_id", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_contactdb_segments__segment_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("contactdb/segments/{segment_id}");
    request.addQueryParam("delete_contacts", "true");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_contactdb_segments__segment_id__recipients_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("contactdb/segments/{segment_id}/recipients");
    request.addQueryParam("page", "1");
    request.addQueryParam("page_size", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_devices_stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("devices/stats");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("limit", "1");
    request.addQueryParam("start_date", "2016-01-01");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_geo_stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("geo/stats");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("country", "US");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    request.addQueryParam("start_date", "2016-01-01");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("ips");
    request.addQueryParam("subuser", "test_string");
    request.addQueryParam("ip", "test_string");
    request.addQueryParam("limit", "1");
    request.addQueryParam("exclude_whitelabels", "true");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_assigned_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("ips/assigned");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_pools_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("ips/pools");
    request.setBody("{\"name\":\"marketing\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_pools_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("ips/pools");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_pools__pool_name__put() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PUT);
    request.setEndpoint("ips/pools/{pool_name}");
    request.setBody("{\"name\":\"new_pool_name\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_pools__pool_name__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("ips/pools/{pool_name}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_pools__pool_name__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("ips/pools/{pool_name}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_ips_pools__pool_name__ips_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("ips/pools/{pool_name}/ips");
    request.setBody("{\"ip\":\"0.0.0.0\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_ips_pools__pool_name__ips__ip__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("ips/pools/{pool_name}/ips/{ip}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_ips_warmup_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("ips/warmup");
    request.setBody("{\"ip\":\"0.0.0.0\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_warmup_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("ips/warmup");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_warmup__ip_address__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("ips/warmup/{ip_address}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_ips_warmup__ip_address__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("ips/warmup/{ip_address}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_ips__ip_address__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("ips/{ip_address}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_batch_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("mail/batch");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_mail_batch__batch_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail/batch/{batch_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_send_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "202");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    request.setBody("{\"custom_args\":{\"New Argument 1\":\"New Value 1\",\"activationAttempt\":\"1\",\"customerAccountNumber\":\"[CUSTOMER ACCOUNT NUMBER GOES HERE]\"},\"from\":{\"email\":\"sam.smith@example.com\",\"name\":\"Sam Smith\"},\"attachments\":[{\"name\":\"file1\",\"filename\":\"file1.jpg\",\"content\":\"[BASE64 encoded content block here]\",\"disposition\":\"inline\",\"content_id\":\"ii_139db99fdb5c3704\",\"type\":\"jpg\"}],\"personalizations\":[{\"to\":[{\"email\":\"john.doe@example.com\",\"name\":\"John Doe\"}],\"cc\":[{\"email\":\"jane.doe@example.com\",\"name\":\"Jane Doe\"}],\"bcc\":[{\"email\":\"sam.doe@example.com\",\"name\":\"Sam Doe\"}],\"custom_args\":{\"New Argument 1\":\"New Value 1\",\"activationAttempt\":\"1\",\"customerAccountNumber\":\"[CUSTOMER ACCOUNT NUMBER GOES HERE]\"},\"headers\":{\"X-Accept-Language\":\"en\",\"X-Mailer\":\"MyApp\"},\"send_at\":1409348513,\"substitutions\":{\"type\":\"object\",\"id\":\"substitutions\"},\"subject\":\"Hello, World!\"}],\"subject\":\"Hello, World!\",\"ip_pool_name\":\"[YOUR POOL NAME GOES HERE]\",\"content\":[{\"type\":\"text/html\",\"value\":\"<html><p>Hello, world!</p><img src=[CID GOES HERE]></img></html>\"}],\"headers\":{},\"asm\":{\"groups_to_display\":[1,2,3],\"group_id\":1},\"batch_id\":\"[YOUR BATCH ID GOES HERE]\",\"tracking_settings\":{\"subscription_tracking\":{\"text\":\"If you would like to unsubscribe and stop receiveing these emails <% click here %>.\",\"enable\":true,\"html\":\"If you would like to unsubscribe and stop receiving these emails <% clickhere %>.\",\"substitution_tag\":\"<%click here%>\"},\"open_tracking\":{\"enable\":true,\"substitution_tag\":\"%opentrack\"},\"click_tracking\":{\"enable\":true,\"enable_text\":true},\"ganalytics\":{\"utm_campaign\":\"[NAME OF YOUR REFERRER SOURCE]\",\"enable\":true,\"utm_name\":\"[NAME OF YOUR CAMPAIGN]\",\"utm_term\":\"[IDENTIFY PAID KEYWORDS HERE]\",\"utm_content\":\"[USE THIS SPACE TO DIFFERENTIATE YOUR EMAIL FROM ADS]\",\"utm_medium\":\"[NAME OF YOUR MARKETING MEDIUM e.g. email]\"}},\"mail_settings\":{\"footer\":{\"text\":\"Thanks,/n The SendGrid Team\",\"enable\":true,\"html\":\"<p>Thanks</br>The SendGrid Team</p>\"},\"spam_check\":{\"threshold\":3,\"post_to_url\":\"http://example.com/compliance\",\"enable\":true},\"bypass_list_management\":{\"enable\":true},\"sandbox_mode\":{\"enable\":false},\"bcc\":{\"enable\":true,\"email\":\"ben.doe@example.com\"}},\"reply_to\":{\"email\":\"sam.smith@example.com\",\"name\":\"Sam Smith\"},\"sections\":{\"section\":{\":sectionName2\":\"section 2 text\",\":sectionName1\":\"section 1 text\"}},\"template_id\":\"[YOUR TEMPLATE ID GOES HERE]\",\"categories\":[\"category1\",\"category2\"],\"send_at\":1409348513}");
    Response response = sg.api(request);
    Assert.assertEquals(202, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_address_whitelist_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("mail_settings/address_whitelist");
    request.setBody("{\"list\":[\"email1@example.com\",\"example.com\"],\"enabled\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_address_whitelist_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings/address_whitelist");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_bcc_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("mail_settings/bcc");
    request.setBody("{\"enabled\":false,\"email\":\"email@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_bcc_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings/bcc");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_bounce_purge_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("mail_settings/bounce_purge");
    request.setBody("{\"hard_bounces\":5,\"soft_bounces\":5,\"enabled\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_bounce_purge_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings/bounce_purge");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_footer_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("mail_settings/footer");
    request.setBody("{\"html_content\":\"...\",\"enabled\":true,\"plain_content\":\"...\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_footer_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings/footer");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_forward_bounce_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("mail_settings/forward_bounce");
    request.setBody("{\"enabled\":true,\"email\":\"example@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_forward_bounce_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings/forward_bounce");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_forward_spam_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("mail_settings/forward_spam");
    request.setBody("{\"enabled\":false,\"email\":\"\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_forward_spam_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings/forward_spam");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_plain_content_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("mail_settings/plain_content");
    request.setBody("{\"enabled\":false}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_plain_content_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings/plain_content");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_spam_check_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("mail_settings/spam_check");
    request.setBody("{\"url\":\"url\",\"max_score\":5,\"enabled\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_spam_check_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings/spam_check");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_template_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("mail_settings/template");
    request.setBody("{\"html_content\":\"<% body %>\",\"enabled\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mail_settings_template_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mail_settings/template");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_mailbox_providers_stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("mailbox_providers/stats");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("mailbox_providers", "test_string");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    request.addQueryParam("start_date", "2016-01-01");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_partner_settings_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("partner_settings");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_partner_settings_new_relic_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("partner_settings/new_relic");
    request.setBody("{\"enable_subuser_statistics\":true,\"enabled\":true,\"license_key\":\"\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_partner_settings_new_relic_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("partner_settings/new_relic");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_scopes_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("scopes");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_senders_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("senders");
    request.setBody("{\"city\":\"Denver\",\"from\":{\"email\":\"from@example.com\",\"name\":\"Example INC\"},\"zip\":\"80202\",\"country\":\"United States\",\"state\":\"Colorado\",\"address_2\":\"Apt. 456\",\"address\":\"123 Elm St.\",\"reply_to\":{\"email\":\"replyto@example.com\",\"name\":\"Example INC\"},\"nickname\":\"My Sender ID\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_senders_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("senders");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_senders__sender_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("senders/{sender_id}");
    request.setBody("{\"city\":\"Denver\",\"from\":{\"email\":\"from@example.com\",\"name\":\"Example INC\"},\"zip\":\"80202\",\"country\":\"United States\",\"state\":\"Colorado\",\"address_2\":\"Apt. 456\",\"address\":\"123 Elm St.\",\"reply_to\":{\"email\":\"replyto@example.com\",\"name\":\"Example INC\"},\"nickname\":\"My Sender ID\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_senders__sender_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("senders/{sender_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_senders__sender_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("senders/{sender_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_senders__sender_id__resend_verification_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("senders/{sender_id}/resend_verification");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("stats");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("limit", "1");
    request.addQueryParam("start_date", "2016-01-01");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("subusers");
    request.setBody("{\"username\":\"John@example.com\",\"ips\":[\"1.1.1.1\",\"2.2.2.2\"],\"password\":\"johns_password\",\"email\":\"John@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("subusers");
    request.addQueryParam("username", "test_string");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers_reputations_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("subusers/reputations");
    request.addQueryParam("usernames", "test_string");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers_stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("subusers/stats");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    request.addQueryParam("start_date", "2016-01-01");
    request.addQueryParam("subusers", "test_string");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers_stats_monthly_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("subusers/stats/monthly");
    request.addQueryParam("subuser", "test_string");
    request.addQueryParam("limit", "1");
    request.addQueryParam("sort_by_metric", "test_string");
    request.addQueryParam("offset", "1");
    request.addQueryParam("date", "test_string");
    request.addQueryParam("sort_by_direction", "asc");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers_stats_sums_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("subusers/stats/sums");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("limit", "1");
    request.addQueryParam("sort_by_metric", "test_string");
    request.addQueryParam("offset", "1");
    request.addQueryParam("start_date", "2016-01-01");
    request.addQueryParam("sort_by_direction", "asc");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers__subuser_name__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("subusers/{subuser_name}");
    request.setBody("{\"disabled\":false}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_subusers__subuser_name__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("subusers/{subuser_name}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_subusers__subuser_name__ips_put() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PUT);
    request.setEndpoint("subusers/{subuser_name}/ips");
    request.setBody("[\"127.0.0.1\"]");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers__subuser_name__monitor_put() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PUT);
    request.setEndpoint("subusers/{subuser_name}/monitor");
    request.setBody("{\"frequency\":500,\"email\":\"example@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers__subuser_name__monitor_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("subusers/{subuser_name}/monitor");
    request.setBody("{\"frequency\":50000,\"email\":\"example@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers__subuser_name__monitor_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("subusers/{subuser_name}/monitor");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_subusers__subuser_name__monitor_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("subusers/{subuser_name}/monitor");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_subusers__subuser_name__stats_monthly_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("subusers/{subuser_name}/stats/monthly");
    request.addQueryParam("date", "test_string");
    request.addQueryParam("sort_by_direction", "asc");
    request.addQueryParam("limit", "1");
    request.addQueryParam("sort_by_metric", "test_string");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_suppression_blocks_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("suppression/blocks");
    request.addQueryParam("start_time", "1");
    request.addQueryParam("limit", "1");
    request.addQueryParam("end_time", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_suppression_blocks_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("suppression/blocks");
    request.setBody("{\"emails\":[\"example1@example.com\",\"example2@example.com\"],\"delete_all\":false}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_suppression_blocks__email__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("suppression/blocks/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_suppression_blocks__email__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("suppression/blocks/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_suppression_bounces_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("suppression/bounces");
    request.addQueryParam("start_time", "1");
    request.addQueryParam("end_time", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_suppression_bounces_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("suppression/bounces");
    request.setBody("{\"emails\":[\"example@example.com\",\"example2@example.com\"],\"delete_all\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_suppression_bounces__email__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("suppression/bounces/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_suppression_bounces__email__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("suppression/bounces/{email}");
    request.addQueryParam("email_address", "example@example.com");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_suppression_invalid_emails_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("suppression/invalid_emails");
    request.addQueryParam("start_time", "1");
    request.addQueryParam("limit", "1");
    request.addQueryParam("end_time", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_suppression_invalid_emails_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("suppression/invalid_emails");
    request.setBody("{\"emails\":[\"example1@example.com\",\"example2@example.com\"],\"delete_all\":false}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_suppression_invalid_emails__email__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("suppression/invalid_emails/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_suppression_invalid_emails__email__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("suppression/invalid_emails/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_suppression_spam_report__email__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("suppression/spam_report/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_suppression_spam_report__email__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("suppression/spam_report/{email}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_suppression_spam_reports_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("suppression/spam_reports");
    request.addQueryParam("start_time", "1");
    request.addQueryParam("limit", "1");
    request.addQueryParam("end_time", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_suppression_spam_reports_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("suppression/spam_reports");
    request.setBody("{\"emails\":[\"example1@example.com\",\"example2@example.com\"],\"delete_all\":false}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_suppression_unsubscribes_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("suppression/unsubscribes");
    request.addQueryParam("start_time", "1");
    request.addQueryParam("limit", "1");
    request.addQueryParam("end_time", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_templates_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("templates");
    request.setBody("{\"name\":\"example_name\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_templates_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("templates");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_templates__template_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("templates/{template_id}");
    request.setBody("{\"name\":\"new_example_name\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_templates__template_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("templates/{template_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_templates__template_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("templates/{template_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_templates__template_id__versions_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("templates/{template_id}/versions");
    request.setBody("{\"name\":\"example_version_name\",\"html_content\":\"<%body%>\",\"plain_content\":\"<%body%>\",\"active\":1,\"template_id\":\"ddb96bbc-9b92-425e-8979-99464621b543\",\"subject\":\"<%subject%>\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_templates__template_id__versions__version_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("templates/{template_id}/versions/{version_id}");
    request.setBody("{\"active\":1,\"html_content\":\"<%body%>\",\"subject\":\"<%subject%>\",\"name\":\"updated_example_name\",\"plain_content\":\"<%body%>\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_templates__template_id__versions__version_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("templates/{template_id}/versions/{version_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_templates__template_id__versions__version_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("templates/{template_id}/versions/{version_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_templates__template_id__versions__version_id__activate_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("templates/{template_id}/versions/{version_id}/activate");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_tracking_settings_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("tracking_settings");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_tracking_settings_click_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("tracking_settings/click");
    request.setBody("{\"enabled\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_tracking_settings_click_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("tracking_settings/click");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_tracking_settings_google_analytics_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("tracking_settings/google_analytics");
    request.setBody("{\"utm_campaign\":\"website\",\"utm_term\":\"\",\"utm_content\":\"\",\"enabled\":true,\"utm_source\":\"sendgrid.com\",\"utm_medium\":\"email\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_tracking_settings_google_analytics_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("tracking_settings/google_analytics");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_tracking_settings_open_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("tracking_settings/open");
    request.setBody("{\"enabled\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_tracking_settings_open_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("tracking_settings/open");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_tracking_settings_subscription_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("tracking_settings/subscription");
    request.setBody("{\"url\":\"url\",\"html_content\":\"html content\",\"enabled\":true,\"landing\":\"landing page html\",\"replace\":\"replacement tag\",\"plain_content\":\"text content\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_tracking_settings_subscription_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("tracking_settings/subscription");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_account_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/account");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_credits_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/credits");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_email_put() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PUT);
    request.setEndpoint("user/email");
    request.setBody("{\"email\":\"example@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_email_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/email");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_password_put() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PUT);
    request.setEndpoint("user/password");
    request.setBody("{\"new_password\":\"new_password\",\"old_password\":\"old_password\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_profile_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("user/profile");
    request.setBody("{\"city\":\"Orange\",\"first_name\":\"Example\",\"last_name\":\"User\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_profile_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/profile");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_scheduled_sends_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("user/scheduled_sends");
    request.setBody("{\"batch_id\":\"YOUR_BATCH_ID\",\"status\":\"pause\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_user_scheduled_sends_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/scheduled_sends");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_scheduled_sends__batch_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("user/scheduled_sends/{batch_id}");
    request.setBody("{\"status\":\"pause\"}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_user_scheduled_sends__batch_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/scheduled_sends/{batch_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_scheduled_sends__batch_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("user/scheduled_sends/{batch_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_user_settings_enforced_tls_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("user/settings/enforced_tls");
    request.setBody("{\"require_tls\":true,\"require_valid_cert\":false}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_settings_enforced_tls_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/settings/enforced_tls");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_username_put() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PUT);
    request.setEndpoint("user/username");
    request.setBody("{\"username\":\"test_username\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_username_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/username");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_webhooks_event_settings_patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("user/webhooks/event/settings");
    request.setBody("{\"group_resubscribe\":true,\"delivered\":true,\"group_unsubscribe\":true,\"spam_report\":true,\"url\":\"url\",\"enabled\":true,\"bounce\":true,\"deferred\":true,\"unsubscribe\":true,\"dropped\":true,\"open\":true,\"click\":true,\"processed\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_webhooks_event_settings_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/webhooks/event/settings");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_webhooks_event_test_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("user/webhooks/event/test");
    request.setBody("{\"url\":\"url\"}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_user_webhooks_parse_settings_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("user/webhooks/parse/settings");
    request.setBody("{\"url\":\"http://email.myhosthame.com\",\"send_raw\":false,\"hostname\":\"myhostname.com\",\"spam_check\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_user_webhooks_parse_settings_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/webhooks/parse/settings");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_webhooks_parse_settings__hostname__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("user/webhooks/parse/settings/{hostname}");
    request.setBody("{\"url\":\"http://newdomain.com/parse\",\"send_raw\":true,\"spam_check\":false}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_webhooks_parse_settings__hostname__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/webhooks/parse/settings/{hostname}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_user_webhooks_parse_settings__hostname__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("user/webhooks/parse/settings/{hostname}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_user_webhooks_parse_stats_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("user/webhooks/parse/stats");
    request.addQueryParam("aggregated_by", "day");
    request.addQueryParam("limit", "test_string");
    request.addQueryParam("start_date", "2016-01-01");
    request.addQueryParam("end_date", "2016-04-01");
    request.addQueryParam("offset", "test_string");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("whitelabel/domains");
    request.setBody("{\"automatic_security\":false,\"username\":\"john@example.com\",\"domain\":\"example.com\",\"default\":true,\"custom_spf\":true,\"ips\":[\"192.168.1.1\",\"192.168.1.2\"],\"subdomain\":\"news\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/domains");
    request.addQueryParam("username", "test_string");
    request.addQueryParam("domain", "test_string");
    request.addQueryParam("exclude_subusers", "true");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains_default_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/domains/default");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains_subuser_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/domains/subuser");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains_subuser_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("whitelabel/domains/subuser");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains__domain_id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("whitelabel/domains/{domain_id}");
    request.setBody("{\"default\":false,\"custom_spf\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains__domain_id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/domains/{domain_id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains__domain_id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("whitelabel/domains/{domain_id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains__domain_id__subuser_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("whitelabel/domains/{domain_id}/subuser");
    request.setBody("{\"username\":\"jane@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains__id__ips_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("whitelabel/domains/{id}/ips");
    request.setBody("{\"ip\":\"192.168.0.1\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains__id__ips__ip__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("whitelabel/domains/{id}/ips/{ip}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_domains__id__validate_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("whitelabel/domains/{id}/validate");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_ips_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("whitelabel/ips");
    request.setBody("{\"ip\":\"192.168.1.1\",\"domain\":\"example.com\",\"subdomain\":\"email\"}");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_ips_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/ips");
    request.addQueryParam("ip", "test_string");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_ips__id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/ips/{id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_ips__id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("whitelabel/ips/{id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_ips__id__validate_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("whitelabel/ips/{id}/validate");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "201");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("whitelabel/links");
    request.setBody("{\"default\":true,\"domain\":\"example.com\",\"subdomain\":\"mail\"}");
    request.addQueryParam("limit", "1");
    request.addQueryParam("offset", "1");
    Response response = sg.api(request);
    Assert.assertEquals(201, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/links");
    request.addQueryParam("limit", "1");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links_default_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/links/default");
    request.addQueryParam("domain", "test_string");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links_subuser_get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/links/subuser");
    request.addQueryParam("username", "test_string");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links_subuser_delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("whitelabel/links/subuser");
    request.addQueryParam("username", "test_string");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links__id__patch() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.PATCH);
    request.setEndpoint("whitelabel/links/{id}");
    request.setBody("{\"default\":true}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links__id__get() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.GET);
    request.setEndpoint("whitelabel/links/{id}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links__id__delete() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "204");

    Request request = new Request();
    request.setMethod(Method.DELETE);
    request.setEndpoint("whitelabel/links/{id}");
    Response response = sg.api(request);
    Assert.assertEquals(204, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links__id__validate_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("whitelabel/links/{id}/validate");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_whitelabel_links__link_id__subuser_post() throws IOException {
    SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
    sg.setHost("localhost:4010");
    sg.addRequestHeader("X-Mock", "200");

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("whitelabel/links/{link_id}/subuser");
    request.setBody("{\"username\":\"jane@example.com\"}");
    Response response = sg.api(request);
    Assert.assertEquals(200, response.getStatusCode());
  }

  @Test
  public void test_add_impersonate_subuser() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);

    sg.addImpersonateSubuser("subusername");
    Assert.assertEquals(sg.getRequestHeaders().get("on-behalf-of"), "subusername");
  }

  @Test
  public void test_remove_impersonate_subuser() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);

    sg.addImpersonateSubuser("subusername");
    Assert.assertEquals(sg.getRequestHeaders().get("on-behalf-of"), "subusername");

    sg.removeImpersonateSubuser();
    Assert.assertEquals(sg.getRequestHeaders().get("on-behalf-of"), null);
  }

  @Test
  public void test_get_impersonate_subuser() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY);

    sg.addImpersonateSubuser("subusername");
    Assert.assertEquals(sg.getImpersonateSubuser(), "subusername");

    sg.removeImpersonateSubuser();
    Assert.assertEquals(sg.getImpersonateSubuser(), null);
   }
}
