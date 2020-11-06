import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;

import java.io.IOException;

public class Example {

  // Fully populated Mail object
  public static Mail buildKitchenSink() {
    Mail mail = new Mail();

    Email fromEmail = new Email();
    fromEmail.setName("Example User");
    fromEmail.setEmail("test@example.com");
    mail.setFrom(fromEmail);

    mail.setSubject("Hello World from the Twilio SendGrid Java Library");

    Personalization personalization = new Personalization();
    Email to = new Email();
    to.setName("Example User");
    to.setEmail("test1@example.com");
    personalization.addTo(to);
    to.setName("Example User");
    to.setEmail("test2@example.com");
    personalization.addTo(to);
    Email cc = new Email();
    cc.setName("Example User");
    cc.setEmail("test3@example.com");
    personalization.addCc(cc);
    cc.setName("Example User");
    cc.setEmail("test4@example.com");
    personalization.addCc(cc);
    Email bcc = new Email();
    bcc.setName("Example User");
    bcc.setEmail("test5@example.com");
    personalization.addBcc(bcc);
    bcc.setName("Example User");
    bcc.setEmail("test6@example.com");
    personalization.addBcc(bcc);
    personalization.setSubject("Hello World from the Personalized Twilio SendGrid Java Library");
    personalization.addHeader("X-Test", "test");
    personalization.addHeader("X-Mock", "true");
    personalization.addSubstitution("%name%", "Example User");
    personalization.addSubstitution("%city%", "Riverside");
    personalization.addCustomArg("user_id", "343");
    personalization.addCustomArg("type", "marketing");
    personalization.setSendAt(1443636843);
    mail.addPersonalization(personalization);

    Personalization personalization2 = new Personalization();
    Email to2 = new Email();
    to2.setName("Example User");
    to2.setEmail("test1@example.com");
    personalization2.addTo(to2);
    to2.setName("Example User");
    to2.setEmail("test2@example.com");
    personalization2.addTo(to2);
    Email cc2 = new Email();
    cc2.setName("Example User");
    cc2.setEmail("test3@example.com");
    personalization2.addCc(cc2);
    cc2.setName("Example User");
    cc2.setEmail("test4@example.com");
    personalization2.addCc(cc2);
    Email bcc2 = new Email();
    bcc2.setName("Example User");
    bcc2.setEmail("test5@example.com");
    personalization2.addBcc(bcc2);
    bcc2.setName("Example User");
    bcc2.setEmail("test6@example.com");
    personalization2.addBcc(bcc2);
    personalization2.setSubject("Hello World from the Personalized Twilio SendGrid Java Library");
    personalization2.addHeader("X-Test", "test");
    personalization2.addHeader("X-Mock", "true");
    personalization2.addSubstitution("%name%", "Example User");
    personalization2.addSubstitution("%city%", "Denver");
    personalization2.addCustomArg("user_id", "343");
    personalization2.addCustomArg("type", "marketing");
    personalization2.setSendAt(1443636843);
    mail.addPersonalization(personalization2);

    Content content = new Content();
    content.setType("text/plain");
    content.setValue("some text here");
    mail.addContent(content);
    content.setType("text/html");
    content.setValue("<html><body>some text here</body></html>");
    mail.addContent(content);

    Attachments attachments = new Attachments();
    attachments.setContent("TG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdC4gQ3JhcyBwdW12");
    attachments.setType("application/pdf");
    attachments.setFilename("balance_001.pdf");
    attachments.setDisposition("attachment");
    attachments.setContentId("Balance Sheet");
    mail.addAttachments(attachments);

    Attachments attachments2 = new Attachments();
    attachments2.setContent("BwdW");
    attachments2.setType("image/png");
    attachments2.setFilename("banner.png");
    attachments2.setDisposition("inline");
    attachments2.setContentId("Banner");
    mail.addAttachments(attachments2);

    mail.setTemplateId("13b8f94f-bcae-4ec6-b752-70d6cb59f932");

    mail.addSection("%section1%", "Substitution Text for Section 1");
    mail.addSection("%section2%", "Substitution Text for Section 2");

    mail.addHeader("X-Test1", "1");
    mail.addHeader("X-Test2", "2");

    mail.addCategory("May");
    mail.addCategory("2016");

    mail.addCustomArg("campaign", "welcome");
    mail.addCustomArg("weekday", "morning");

    mail.setSendAt(1443636842);

    ASM asm = new ASM();
    asm.setGroupId(99);
    asm.setGroupsToDisplay(new int[]{4, 5, 6, 7, 8});
    mail.setASM(asm);

    // This must be a valid [batch ID](https://sendgrid.com/docs/API_Reference/SMTP_API/scheduling_parameters.html) to work
    // mail.setBatchId("sendgrid_batch_id");

    mail.setIpPoolId("23");

    MailSettings mailSettings = new MailSettings();
    BccSettings bccSettings = new BccSettings();
    bccSettings.setEnable(true);
    bccSettings.setEmail("test@example.com");
    mailSettings.setBccSettings(bccSettings);
    Setting sandBoxMode = new Setting();
    sandBoxMode.setEnable(true);
    mailSettings.setSandboxMode(sandBoxMode);
    Setting bypassListManagement = new Setting();
    bypassListManagement.setEnable(true);
    mailSettings.setBypassListManagement(bypassListManagement);
    FooterSetting footerSetting = new FooterSetting();
    footerSetting.setEnable(true);
    footerSetting.setText("Footer Text");
    footerSetting.setHtml("<html><body>Footer Text</body></html>");
    mailSettings.setFooterSetting(footerSetting);
    SpamCheckSetting spamCheckSetting = new SpamCheckSetting();
    spamCheckSetting.setEnable(true);
    spamCheckSetting.setSpamThreshold(1);
    spamCheckSetting.setPostToUrl("https://spamcatcher.sendgrid.com");
    mailSettings.setSpamCheckSetting(spamCheckSetting);
    mail.setMailSettings(mailSettings);

    TrackingSettings trackingSettings = new TrackingSettings();
    ClickTrackingSetting clickTrackingSetting = new ClickTrackingSetting();
    clickTrackingSetting.setEnable(true);
    clickTrackingSetting.setEnableText(true);
    trackingSettings.setClickTrackingSetting(clickTrackingSetting);
    OpenTrackingSetting openTrackingSetting = new OpenTrackingSetting();
    openTrackingSetting.setEnable(true);
    openTrackingSetting.setSubstitutionTag("Optional tag to replace with the open image in the body of the message");
    trackingSettings.setOpenTrackingSetting(openTrackingSetting);
    SubscriptionTrackingSetting subscriptionTrackingSetting = new SubscriptionTrackingSetting();
    subscriptionTrackingSetting.setEnable(true);
    subscriptionTrackingSetting.setText("text to insert into the text/plain portion of the message");
    subscriptionTrackingSetting.setHtml("<html><body>html to insert into the text/html portion of the message</body></html>");
    subscriptionTrackingSetting.setSubstitutionTag("Optional tag to replace with the open image in the body of the message");
    trackingSettings.setSubscriptionTrackingSetting(subscriptionTrackingSetting);
    GoogleAnalyticsSetting googleAnalyticsSetting = new GoogleAnalyticsSetting();
    googleAnalyticsSetting.setEnable(true);
    googleAnalyticsSetting.setCampaignSource("some source");
    googleAnalyticsSetting.setCampaignTerm("some term");
    googleAnalyticsSetting.setCampaignContent("some content");
    googleAnalyticsSetting.setCampaignName("some name");
    googleAnalyticsSetting.setCampaignMedium("some medium");
    trackingSettings.setGoogleAnalyticsSetting(googleAnalyticsSetting);
    mail.setTrackingSettings(trackingSettings);

    Email replyTo = new Email();
    replyTo.setName("Example User");
    replyTo.setEmail("test@example.com");
    mail.setReplyTo(replyTo);

    return mail;
  }

  // API V3 Dynamic Template implementation
  public static Mail buildDynamicTemplate() {
    Mail mail = new Mail();

    Email fromEmail = new Email();
    fromEmail.setName("Example User");
    fromEmail.setEmail("test@example.com");
    mail.setFrom(fromEmail);

    mail.setTemplateId("d-c6dcf1f72bdd4beeb15a9aa6c72fcd2c");

    Personalization personalization = new Personalization();
    personalization.addDynamicTemplateData("name", "Example User");
    personalization.addDynamicTemplateData("city", "Denver");
    personalization.addTo(new Email("test@example.com"));
    mail.addPersonalization(personalization);

    return mail;
  }

  // Minimum required to send an email
  public static Mail buildHelloEmail() {
    Email from = new Email("test@example.com");
    String subject = "Hello World from the Twilio SendGrid Java Library";
    Email to = new Email("test@example.com");
    Content content = new Content("text/plain", "some text here");
    // Note that when you use this constructor an initial personalization object
    // is created for you. It can be accessed via
    // mail.personalization.get(0) as it is a List object
    Mail mail = new Mail(from, subject, to, content);
    Email email = new Email("test2@example.com");
    mail.personalization.get(0).addTo(email);

    return mail;
  }

  public static void baselineExample() throws IOException {
    final Mail helloWorld = buildHelloEmail();
    send(helloWorld);
  }

  public static void kitchenSinkExample() throws IOException {
    final Mail kitchenSink = buildKitchenSink();
    send(kitchenSink);
  }

  public static void dynamicTemplateExample() throws IOException {
    final Mail dynamicTemplate = buildDynamicTemplate();
    send(dynamicTemplate);
  }

  private static void send(final Mail mail) throws IOException {
    final SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    sg.addRequestHeader("X-Mock", "true");

    final Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    request.setBody(mail.build());

    final Response response = sg.api(request);
    System.out.println(response.getStatusCode());
    System.out.println(response.getBody());
    System.out.println(response.getHeaders());
  }

  public static void main(String[] args) throws IOException {
    baselineExample();
    kitchenSinkExample();
    dynamicTemplateExample();
  }
}
