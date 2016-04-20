import com.sendgrid.*;

import java.io.*;
import java.util.*;

public class Example {
  public static void main(String[] args) throws IOException {
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    sg.setHost("e9sk3d3bfaikbpdq7.stoplight-proxy.io");
    sg.addHeader("X-Test", "test");
    
    Mail mail = new Mail();
    
    Email fromEmail = new Email();
    fromEmail.setName("Elmer Thomas");
    fromEmail.setEmail("dx@sendgrid.com");
    mail.setFrom(fromEmail);
    
    mail.setSubject("Hello World from the SendGrid Java Library");
    
    Personalization personalization = new Personalization();
    Email to = new Email();
    to.setName("Elmer Thomas");
    to.setEmail("elmer.thomas@sendgrid.com");
    personalization.addTo(to);
    to.setName("Elmer Thomas Alias");
    to.setEmail("elmer.thomas@gmail.com");
    personalization.addTo(to);
    Email cc = new Email();
    cc.setName("Matt Bernier");
    cc.setEmail("matt.bernier@sendgrid.com");
    personalization.addCc(cc);
    cc.setName("Eric Shallock");
    cc.setEmail("eric.shallock@sendgrid.com");
    personalization.addCc(cc);
    Email bcc = new Email();
    bcc.setName("DX Matt Bernier");
    bcc.setEmail("dx+matt@sendgrid.com");
    personalization.addBcc(bcc);
    bcc.setName("DX Eric Shallock");
    bcc.setEmail("dx+eric@sendgrid.com");
    personalization.addBcc(bcc);
    personalization.setSubject("Hello World from the Personalized SendGrid Java Library");
    personalization.addHeader("X-Test", "test");
    personalization.addHeader("X-Mock", "true");
    personalization.addSubstitution("%name%", "Tim");
    personalization.addSubstitution("%city%", "Riverside");
    personalization.addCustomArg("user_id", "343");
    personalization.addCustomArg("type", "marketing");
    personalization.addCategory("marketing");
    personalization.addCategory("business");
    personalization.addCategory("california");
    personalization.setSendAt(1443636843);
    mail.addPersonalization(personalization);
    
    Personalization personalization2 = new Personalization();
    Email to2 = new Email();
    to2.setName("Elmer Thomas");
    to2.setEmail("elmer.thomas@sendgrid.com");
    personalization2.addTo(to2);
    to2.setName("Elmer Thomas Alias");
    to2.setEmail("elmer.thomas@gmail.com");
    personalization2.addTo(to2);
    Email cc2 = new Email();
    cc2.setName("Matt Bernier");
    cc2.setEmail("matt.bernier@sendgrid.com");
    personalization2.addCc(cc2);
    cc2.setName("Eric Shallock");
    cc2.setEmail("eric.shallock@sendgrid.com");
    personalization2.addCc(cc2);
    Email bcc2 = new Email();
    bcc2.setName("DX Matt Bernier");
    bcc2.setEmail("dx+matt@sendgrid.com");
    personalization2.addBcc(bcc2);
    bcc2.setName("DX Eric Shallock");
    bcc2.setEmail("dx+eric@sendgrid.com");
    personalization2.addBcc(bcc2);
    personalization2.setSubject("Hello World from the Personalized SendGrid Java Library");
    personalization2.addHeader("X-Test", "test");
    personalization2.addHeader("X-Mock", "true");
    personalization2.addSubstitution("%name%", "Tim");
    personalization2.addSubstitution("%city%", "Riverside");
    personalization2.addCustomArg("user_id", "343");
    personalization2.addCustomArg("type", "marketing");
    personalization2.addCategory("marketing");
    personalization2.addCategory("business");
    personalization2.addCategory("california");
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
    attachments.setContent("ZZZZZxxxxyyyzz");
    attachments.setType("application/pdf");
    attachments.setFilename("balance_001.pdf");
    attachments.setDisposition("attachment");
    attachments.setContentId("Balance Sheet");
    mail.addAttachments(attachments);
 
    Attachments attachments2 = new Attachments();
    attachments2.setContent("ZZZZZxxxxyyyzz2");
    attachments2.setType("image/png");
    attachments2.setFilename("banner.png");
    attachments2.setDisposition("inline");
    attachments2.setContentId("Banner");
    mail.addAttachments(attachments2);
    
    mail.setTemplateId("sendgrid_template_id");
    
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
    asm.setGroupID(99);
    asm.setGroupsToDisplay(new int[] {4,5,6,7,8});
    mail.setASM(asm);
    
    mail.setBatchId("sendgrid_batch_id");
    
    mail.setIpPoolId(23);
    
    MailSettings mailSettings = new MailSettings();
    BccSettings bccSettings = new BccSettings();
    bccSettings.setEnable(true);
    Email bccSettingsEmail = new Email();
    bccSettingsEmail.setEmail("dx@sendgrid.com");
    bccSettings.setEmail(bccSettingsEmail);
    mailSettings.setBccSettings(bccSettings);
    mail.setMailSettings(mailSettings);
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
    replyTo.setName("Mr. Elmer Thomas");
    replyTo.setEmail("dx+reply@sendgrid.com");
    mail.setReplyTo(replyTo);
    
    System.out.println(mail.build());
  }
}