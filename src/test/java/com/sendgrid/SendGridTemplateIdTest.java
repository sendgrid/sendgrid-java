package com.sendgrid;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class SendGridTemplateIdTest {

  private static final String SENDGRID_API_KEY = "";

  private static final Response FAILED_MAIL_SEND_POST_RESPONSE = new Response();
  private static final Response FAILED_TEMPLATE_GET_RESPONSE = new Response();
  private static final Response SUCCESSFUL_MAIL_SEND_POST_RESPONSE = new Response();
  private static final Response SUCCESSFUL_TEMPLATE_GET_RESPONSE = new Response();

  private static final Map<String, String> FAKE_ENVIRONMENT_TO_ENABLE_TEMPLATE_CHECKS = new HashMap<>();
  private static final Map<String, String> EMPTY_FAKE_ENVIRONMENT_TO_DISABLE_TEMPLATE_CHECKS = new HashMap<>();

  static {
    FAILED_MAIL_SEND_POST_RESPONSE.setStatusCode(400);
    FAILED_TEMPLATE_GET_RESPONSE.setStatusCode(400);
    SUCCESSFUL_MAIL_SEND_POST_RESPONSE.setStatusCode(202);
    SUCCESSFUL_TEMPLATE_GET_RESPONSE.setStatusCode(200);

    FAKE_ENVIRONMENT_TO_ENABLE_TEMPLATE_CHECKS.put("SENDGRID_CHECK_TEMPLATES", "true");
  }

  private static final String LONG_BODY_WITH_TEMPLATE_ID = "{\"custom_args\":"
      + "{\"New Argument 1\":\"New Value 1\",\"activationAttempt\":\"1\","
      + "\"customerAccountNumber\":\"[CUSTOMER ACCOUNT NUMBER GOES HERE]\"},"
      + "\"from\":{\"email\":\"sam.smith@example.com\",\"name\":\"Sam Smith\"},"
      + "\"attachments\":[{\"name\":\"file1\",\"filename\":\"file1.jpg\","
      + "\"content\":\"[BASE64 encoded content block here]\",\"disposition\":\"inline\","
      + "\"content_id\":\"ii_139db99fdb5c3704\",\"type\":\"jpg\"}],"
      + "\"personalizations\":[{"
      + "\"to\":[{\"email\":\"john.doe@example.com\",\"name\":\"John Doe\"}],"
      + "\"cc\":[{\"email\":\"jane.doe@example.com\",\"name\":\"Jane Doe\"}],"
      + "\"bcc\":[{\"email\":\"sam.doe@example.com\",\"name\":\"Sam Doe\"}],"
      + "\"custom_args\":{\"New Argument 1\":\"New Value 1\",\"activationAttempt\":\"1\","
      + "\"customerAccountNumber\":\"[CUSTOMER ACCOUNT NUMBER GOES HERE]\"},"
      + "\"headers\":{\"X-Accept-Language\":\"en\",\"X-Mailer\":\"MyApp\"},\"send_at\":1409348513,"
      + "\"substitutions\":{\"type\":\"object\",\"id\":\"substitutions\"},"
      + "\"subject\":\"Hello, World!\"}],"
      + "\"subject\":\"Hello, World!\",\"ip_pool_name\":\"[YOUR POOL NAME GOES HERE]\","
      + "\"content\":[{\"type\":\"text/html\","
      + "\"value\":\"<html><p>Hello, world!</p><img src=[CID GOES HERE]></img></html>\"}],"
      + "\"headers\":{},\"asm\":{\"groups_to_display\":[1,2,3],\"group_id\":1},"
      + "\"batch_id\":\"[YOUR BATCH ID GOES HERE]\","
      + "\"tracking_settings\":{\"subscription_tracking\":{"
      + "\"text\":\"If you would like to unsubscribe and stop receiving these emails <% click here %>.\","
      + "\"enable\":true,"
      + "\"html\":\"If you would like to unsubscribe and stop receiving these emails <% clickhere %>.\","
      + "\"substitution_tag\":\"<%click here%>\"},"
      + "\"open_tracking\":{\"enable\":true,\"substitution_tag\":\"%opentrack\"},"
      + "\"click_tracking\":{\"enable\":true,\"enable_text\":true},"
      + "\"ganalytics\":{\"utm_campaign\":\"[NAME OF YOUR REFERRER SOURCE]\","
      + "\"enable\":true,"
      + "\"utm_name\":\"[NAME OF YOUR CAMPAIGN]\","
      + "\"utm_term\":\"[IDENTIFY PAID KEYWORDS HERE]\","
      + "\"utm_content\":\"[USE THIS SPACE TO DIFFERENTIATE YOUR EMAIL FROM ADS]\","
      + "\"utm_medium\":\"[NAME OF YOUR MARKETING MEDIUM e.g. email]\"}},"
      + "\"mail_settings\":{\"footer\":{\"text\":\"Thanks,/n The SendGrid Team\",\"enable\":true,"
      + "\"html\":\"<p>Thanks</br>The SendGrid Team</p>\"},"
      + "\"spam_check\":{\"threshold\":3,"
      + "\"post_to_url\":\"http://example.com/compliance\",\"enable\":true},"
      + "\"bypass_list_management\":{\"enable\":true},\"sandbox_mode\":{\"enable\":false},"
      + "\"bcc\":{\"enable\":true,\"email\":\"ben.doe@example.com\"}},"
      + "\"reply_to\":{\"email\":\"sam.smith@example.com\",\"name\":\"Sam Smith\"},"
      + "\"sections\":{\"section\":{\":sectionName2\":\"section 2 text\","
      + "\":sectionName1\":\"section 1 text\"}},"
      + "\"template_id\":\"yourTemplateIdGoesHere\","
      + "\"categories\":[\"category1\",\"category2\"],"
      + "\"send_at\":1409348513}";


  private final Client mockClient = mock(Client.class);

  @Test
  public void test_extractTemplateId__with_invalid_JSON_string() {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient);
    try {
      sg.extractTemplateId("");
      Assert.fail("Expected an IOException");
    } catch (IOException expected) {
    }
  }

  @Test
  public void test_extractTemplateId__with_empty_JSON_string() throws IOException {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient);
    Assert.assertNull(sg.extractTemplateId("{}"));
  }

  @Test
  public void test_extractTemplateId__with_template_id() throws IOException {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        FAKE_ENVIRONMENT_TO_ENABLE_TEMPLATE_CHECKS);
    Assert.assertEquals("123", sg.extractTemplateId("{\"template_id\":\"123\"}"));
  }

  @Test
  public void test_checkTemplate__with_no_template_id() throws IOException {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        FAKE_ENVIRONMENT_TO_ENABLE_TEMPLATE_CHECKS);
    Request mailSendRequest = new Request();
    mailSendRequest.setMethod(Method.GET);
    mailSendRequest.setEndpoint("mail/send");
    mailSendRequest.setBody("{}");

    sg.checkTemplate(mailSendRequest);
    verifyZeroInteractions(mockClient);
  }

  @Test
  public void test_checkTemplate__with_valid_template_id__checks_enabled() throws IOException {
    when(mockClient.api(any(Request.class))).thenReturn(SUCCESSFUL_TEMPLATE_GET_RESPONSE);

    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        FAKE_ENVIRONMENT_TO_ENABLE_TEMPLATE_CHECKS);
    Request mailSendRequest = new Request();
    mailSendRequest.setMethod(Method.GET);
    mailSendRequest.setEndpoint("mail/send");
    mailSendRequest.setBody("{\"template_id\":\"123\"}");

    sg.checkTemplate(mailSendRequest);
    verify(mockClient).api(any(Request.class));
  }

  @Test
  public void test_checkTemplate__with_valid_template_id__checks_disabled() throws IOException {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        EMPTY_FAKE_ENVIRONMENT_TO_DISABLE_TEMPLATE_CHECKS);
    Request mailSendRequest = new Request();
    mailSendRequest.setMethod(Method.GET);
    mailSendRequest.setEndpoint("mail/send");
    mailSendRequest.setBody("{\"template_id\":\"123\"}");

    sg.checkTemplate(mailSendRequest);
    verifyZeroInteractions(mockClient);
  }

  @Test
  public void test_checkTemplate__with_invalid_template_id__checks_enabled() throws IOException {
    when(mockClient.api(any(Request.class))).thenReturn(FAILED_TEMPLATE_GET_RESPONSE);

    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        FAKE_ENVIRONMENT_TO_ENABLE_TEMPLATE_CHECKS);
    Request mailSendRequest = new Request();
    mailSendRequest.setMethod(Method.GET);
    mailSendRequest.setEndpoint("mail/send");
    mailSendRequest.setBody("{\"template_id\":\"123\"}");

    try {
      sg.checkTemplate(mailSendRequest);
      Assert.fail("Expected an IOException");
    } catch (IOException expected) {
    }

    verify(mockClient).api(any(Request.class));
  }

  @Test
  public void test_checkTemplate__with_invalid_template_id__checks_disabled() throws IOException {
    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        EMPTY_FAKE_ENVIRONMENT_TO_DISABLE_TEMPLATE_CHECKS);
    Request mailSendRequest = new Request();
    mailSendRequest.setMethod(Method.GET);
    mailSendRequest.setEndpoint("mail/send");
    mailSendRequest.setBody("{\"template_id\":\"123\"}");

    sg.checkTemplate(mailSendRequest);
    verifyZeroInteractions(mockClient);
  }

  @Test
  public void test_mail_send_post__mock_client__checks_enabled() throws IOException {
    when(mockClient.api(any(Request.class)))
        .thenReturn(SUCCESSFUL_TEMPLATE_GET_RESPONSE, SUCCESSFUL_MAIL_SEND_POST_RESPONSE);

    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        FAKE_ENVIRONMENT_TO_ENABLE_TEMPLATE_CHECKS);

    Request mailSendRequest = new Request();
    mailSendRequest.setMethod(Method.POST);
    mailSendRequest.setEndpoint("mail/send");
    mailSendRequest.setBody(LONG_BODY_WITH_TEMPLATE_ID);
    Response response = sg.api(mailSendRequest);
    Assert.assertEquals(202, response.getStatusCode());
    verify(mockClient, times(2)).api(any(Request.class));
  }

  @Test
  public void test_mail_send_post__mock_client__checks_disabled() throws IOException {
    when(mockClient.api(any(Request.class))).thenReturn(SUCCESSFUL_MAIL_SEND_POST_RESPONSE);

    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        EMPTY_FAKE_ENVIRONMENT_TO_DISABLE_TEMPLATE_CHECKS);

    Request mailSendRequest = new Request();
    mailSendRequest.setMethod(Method.POST);
    mailSendRequest.setEndpoint("mail/send");
    mailSendRequest.setBody(LONG_BODY_WITH_TEMPLATE_ID);
    Response response = sg.api(mailSendRequest);
    Assert.assertEquals(202, response.getStatusCode());
    verify(mockClient, times(1)).api(any(Request.class));
  }

  @Test
  public void test_mail_send_post__invalid_template_id__mock_client__checks_enabled()
      throws IOException {
    when(mockClient.api(any(Request.class)))
        .thenReturn(FAILED_TEMPLATE_GET_RESPONSE, FAILED_MAIL_SEND_POST_RESPONSE);

    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        FAKE_ENVIRONMENT_TO_ENABLE_TEMPLATE_CHECKS);

    Request mailSendRequest = new Request();
    mailSendRequest.setMethod(Method.POST);
    mailSendRequest.setEndpoint("mail/send");
    mailSendRequest.setBody(LONG_BODY_WITH_TEMPLATE_ID);

    try {
      sg.api(mailSendRequest);
      Assert.fail("Expected an IOException");
    } catch (IOException expected) {
    }

    verify(mockClient, times(1)).api(any(Request.class));
  }

  @Test
  public void test_mail_send_post__invalid_template_id__mock_client__checks_disabled()
      throws IOException {
    when(mockClient.api(any(Request.class))).thenReturn(SUCCESSFUL_MAIL_SEND_POST_RESPONSE);

    SendGrid sg = new SendGrid(SENDGRID_API_KEY, mockClient,
        EMPTY_FAKE_ENVIRONMENT_TO_DISABLE_TEMPLATE_CHECKS);

    Request mailSendRequest = new Request();
    mailSendRequest.setMethod(Method.POST);
    mailSendRequest.setEndpoint("mail/send");
    mailSendRequest.setBody(LONG_BODY_WITH_TEMPLATE_ID);

    Response response = sg.api(mailSendRequest);
    Assert.assertEquals(202, response.getStatusCode());
    verify(mockClient, times(1)).api(any(Request.class));
  }
}
