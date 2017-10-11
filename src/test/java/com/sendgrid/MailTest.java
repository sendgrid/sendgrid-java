package com.sendgrid;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MailTest {

    @Test
    public void testHelloWorld() throws IOException {
        Mail mail = new Mail()
            .subject("Sending with SendGrid is Fun")
            .from(new Email()
                .email("test@example.com")
            ).to(new Email()
                .email("test@example.com")
            ).content(new Content()
                .type(ContentType.TEXT_PLAIN)
                .value("and easy to do anywhere, even with Java")
            );

        Assert.assertEquals(mail.build(),
                "{\"from\":{\"email\":\"test@example.com\"},\"subject\":\"Sending with SendGrid is Fun\",\"personalizations\":[{\"to\":[{\"email\":\"test@example.com\"}]}],\"content\":[{\"type\":\"text/plain\",\"value\":\"and easy to do anywhere, even with Java\"}]}");
    }

    @Test
    public void testKitchenSink() throws IOException {
        Mail mail = new Mail()
            .from(new Email()
                .name("Example User")
                .email("test@example.com")
            ).replyTo(new Email()
                .name("Example User")
                .email("test@example.com")
            ).subject("Hello World from the SendGrid Java Library")
            .personalization(new Personalization()
                .to(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).to(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).cc(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).cc(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).bcc(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).bcc(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).subject("Hello World from the Personalized SendGrid Java Library")
                .header("X-Test", "test")
                .header("X-Mock", "true")
                .substitution("%name%", "Example User")
                .substitution("%city%", "Denver")
                .customArg("user_id", "343")
                .customArg("type", "marketing")
                .sendAt(1443636843)
            ).personalization(new Personalization()
                .to(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).to(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).cc(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).cc(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).bcc(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).bcc(new Email()
                    .name("Example User")
                    .email("test@example.com")
                ).subject("Hello World from the Personalized SendGrid Java Library")
                .header("X-Test", "test")
                .header("X-Mock", "true")
                .substitution("%name%", "Example User")
                .substitution("%city%", "Denver")
                .customArg("user_id", "343")
                .customArg("type", "marketing")
                .sendAt(1443636843)
            ).content(new Content()
                .type(ContentType.TEXT_PLAIN)
                .value("some text here")
            ).content(new Content()
                .type(ContentType.TEXT_HTML)
                .value("<html><body>some text here</body></html>")
            ).attachment(new Attachment()
                .content("TG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdC4gQ3JhcyBwdW12")
                .type(ContentType.APPLICATION_PDF)
                .filename("balance_001.pdf")
                .disposition("attachment")
                .contentId("Balance Sheet")
            ).attachment(new Attachment()
                .content("BwdW")
                .type(ContentType.IMAGE_PNG)
                .filename("banner.png")
                .disposition("inline")
                .contentId("Banner")
            ).templateId("13b8f94f-bcae-4ec6-b752-70d6cb59f932")
            .section("%section1%", "Substitution Text for Section 1")
            .section("%section2%", "Substitution Text for Section 2")
            .header("X-Test1", "1")
            .header("X-Test2", "2")
            .category("May")
            .category("2016")
            .customArg("campaign", "welcome")
            .customArg("weekday", "morning")
            .sendAt(1443636842)
            .asm(new ASM()
                .groupId(99)
                .groupsToDisplay(new int[] { 4, 5, 6, 7, 8 })
            ).ipPoolId("23")
            .mailSettings(new MailSettings()
                .bccSettings(new BCCSettings()
                    .enable(true)
                    .email("test@example.com")
                ).sandboxMode(new Setting()
                    .enable(true)
                ).bypassListManagement(new Setting()
                    .enable(true)
                ).footerSettings(new FooterSettings()
                    .enable(true)
                    .text("Footer Text")
                    .html("<html><body>Footer Text</body></html>")
                ).spamCheckSettings(new SpamCheckSettings()
                    .enable(true)
                    .spamThreshold(1)
                    .postToUrl("https://spamcatcher.sendgrid.com")
                )
            ).trackingSettings(new TrackingSettings()
                .clickTrackingSettings(new ClickTrackingSettings()
                    .enable(true)
                    .enableText(true)
                ).openTrackingSettings(new OpenTrackingSettings()
                    .enable(true)
                    .substitutionTag("Optional tag to replace with the open image in the body of the message")
                ).subscriptionTrackingSetting(new SubscriptionTrackingSettings()
                    .enable(true)
                    .text("text to insert into the text/plain portion of the message")
                    .html("<html><body>html to insert into the text/html portion of the message</body></html>")
                    .substitutionTag("Optional tag to replace with the open image in the body of the message")
                ).googleAnalyticsSettings(new GoogleAnalyticsSettings()
                    .enable(true)
                    .campaignSource("some source")
                    .campaignTerm("some term")
                    .campaignContent("some content")
                    .campaignName("some name")
                    .campaignMedium("some medium")
                )
            );

        Assert.assertEquals(mail.build(),
                "{\"from\":{\"name\":\"Example User\",\"email\":\"test@example.com\"},\"subject\":\"Hello World from the SendGrid Java Library\",\"personalizations\":[{\"to\":[{\"name\":\"Example User\",\"email\":\"test@example.com\"},{\"name\":\"Example User\",\"email\":\"test@example.com\"}],\"cc\":[{\"name\":\"Example User\",\"email\":\"test@example.com\"},{\"name\":\"Example User\",\"email\":\"test@example.com\"}],\"bcc\":[{\"name\":\"Example User\",\"email\":\"test@example.com\"},{\"name\":\"Example User\",\"email\":\"test@example.com\"}],\"subject\":\"Hello World from the Personalized SendGrid Java Library\",\"headers\":{\"X-Mock\":\"true\",\"X-Test\":\"test\"},\"substitutions\":{\"%city%\":\"Denver\",\"%name%\":\"Example User\"},\"custom_args\":{\"type\":\"marketing\",\"user_id\":\"343\"},\"send_at\":1443636843},{\"to\":[{\"name\":\"Example User\",\"email\":\"test@example.com\"},{\"name\":\"Example User\",\"email\":\"test@example.com\"}],\"cc\":[{\"name\":\"Example User\",\"email\":\"test@example.com\"},{\"name\":\"Example User\",\"email\":\"test@example.com\"}],\"bcc\":[{\"name\":\"Example User\",\"email\":\"test@example.com\"},{\"name\":\"Example User\",\"email\":\"test@example.com\"}],\"subject\":\"Hello World from the Personalized SendGrid Java Library\",\"headers\":{\"X-Mock\":\"true\",\"X-Test\":\"test\"},\"substitutions\":{\"%city%\":\"Denver\",\"%name%\":\"Example User\"},\"custom_args\":{\"type\":\"marketing\",\"user_id\":\"343\"},\"send_at\":1443636843}],\"content\":[{\"type\":\"text/plain\",\"value\":\"some text here\"},{\"type\":\"text/html\",\"value\":\"<html><body>some text here</body></html>\"}],\"attachments\":[{\"content\":\"TG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdC4gQ3JhcyBwdW12\",\"type\":\"application/pdf\",\"filename\":\"balance_001.pdf\",\"disposition\":\"attachment\",\"content_id\":\"Balance Sheet\"},{\"content\":\"BwdW\",\"type\":\"image/png\",\"filename\":\"banner.png\",\"disposition\":\"inline\",\"content_id\":\"Banner\"}],\"template_id\":\"13b8f94f-bcae-4ec6-b752-70d6cb59f932\",\"sections\":{\"%section1%\":\"Substitution Text for Section 1\",\"%section2%\":\"Substitution Text for Section 2\"},\"headers\":{\"X-Test1\":\"1\",\"X-Test2\":\"2\"},\"categories\":[\"May\",\"2016\"],\"custom_args\":{\"campaign\":\"welcome\",\"weekday\":\"morning\"},\"send_at\":1443636842,\"asm\":{\"group_id\":99,\"groups_to_display\":[4,5,6,7,8]},\"ip_pool_name\":\"23\",\"mail_settings\":{\"bcc\":{\"enable\":true,\"email\":\"test@example.com\"},\"bypass_list_management\":{\"enable\":true},\"footer\":{\"enable\":true,\"text\":\"Footer Text\",\"html\":\"<html><body>Footer Text</body></html>\"},\"sandbox_mode\":{\"enable\":true},\"spam_check\":{\"enable\":true,\"threshold\":1,\"post_to_url\":\"https://spamcatcher.sendgrid.com\"}},\"tracking_settings\":{\"click_tracking\":{\"enable\":true,\"enable_text\":true},\"open_tracking\":{\"enable\":true,\"substitution_tag\":\"Optional tag to replace with the open image in the body of the message\"},\"subscription_tracking\":{\"enable\":true,\"text\":\"text to insert into the text/plain portion of the message\",\"html\":\"<html><body>html to insert into the text/html portion of the message</body></html>\",\"substitution_tag\":\"Optional tag to replace with the open image in the body of the message\"},\"ganalytics\":{\"enable\":true,\"utm_source\":\"some source\",\"utm_term\":\"some term\",\"utm_content\":\"some content\",\"utm_campaign\":\"some name\",\"utm_medium\":\"some medium\"}},\"reply_to\":{\"name\":\"Example User\",\"email\":\"test@example.com\"}}");
    }

    @Test
    public void fromShouldReturnCorrectFrom() {
        Mail mail = new Mail();
        Email from = new Email();
        mail.from(from);

        Assert.assertSame(from, mail.getFrom());
    }
}
