package com.sendgrid.typechecker;

import static com.sendgrid.typechecker.MailFieldIds.ASM;
import static com.sendgrid.typechecker.MailFieldIds.ATTACHMENTS;
import static com.sendgrid.typechecker.MailFieldIds.BATCH_ID;
import static com.sendgrid.typechecker.MailFieldIds.BCC;
import static com.sendgrid.typechecker.MailFieldIds.BYPASS_LIST_MANAGEMENT;
import static com.sendgrid.typechecker.MailFieldIds.CATEGORIES;
import static com.sendgrid.typechecker.MailFieldIds.CC;
import static com.sendgrid.typechecker.MailFieldIds.CLICK_TRACKING;
import static com.sendgrid.typechecker.MailFieldIds.CONTENT;
import static com.sendgrid.typechecker.MailFieldIds.CONTENT_ID;
import static com.sendgrid.typechecker.MailFieldIds.CUSTOM_ARGS;
import static com.sendgrid.typechecker.MailFieldIds.DISPOSITION;
import static com.sendgrid.typechecker.MailFieldIds.EMAIL;
import static com.sendgrid.typechecker.MailFieldIds.ENABLE;
import static com.sendgrid.typechecker.MailFieldIds.ENABLE_TEXT;
import static com.sendgrid.typechecker.MailFieldIds.FILENAME;
import static com.sendgrid.typechecker.MailFieldIds.FOOTER;
import static com.sendgrid.typechecker.MailFieldIds.FROM;
import static com.sendgrid.typechecker.MailFieldIds.GANALYTICS;
import static com.sendgrid.typechecker.MailFieldIds.GROUPS_TO_DISPLAY;
import static com.sendgrid.typechecker.MailFieldIds.GROUP_ID;
import static com.sendgrid.typechecker.MailFieldIds.HEADERS;
import static com.sendgrid.typechecker.MailFieldIds.HTML;
import static com.sendgrid.typechecker.MailFieldIds.IP_POOL_NAME;
import static com.sendgrid.typechecker.MailFieldIds.MAIL_SETTINGS;
import static com.sendgrid.typechecker.MailFieldIds.NAME;
import static com.sendgrid.typechecker.MailFieldIds.OPEN_TRACKING;
import static com.sendgrid.typechecker.MailFieldIds.PERSONALIZATIONS;
import static com.sendgrid.typechecker.MailFieldIds.POST_TO_URL;
import static com.sendgrid.typechecker.MailFieldIds.REPLY_TO;
import static com.sendgrid.typechecker.MailFieldIds.SANDBOX_MODE;
import static com.sendgrid.typechecker.MailFieldIds.SECTIONS;
import static com.sendgrid.typechecker.MailFieldIds.SEND_AT;
import static com.sendgrid.typechecker.MailFieldIds.SPAM_CHECK;
import static com.sendgrid.typechecker.MailFieldIds.SUBJECT;
import static com.sendgrid.typechecker.MailFieldIds.SUBSCRIPTION_TRACKING;
import static com.sendgrid.typechecker.MailFieldIds.SUBSTITUTIONS;
import static com.sendgrid.typechecker.MailFieldIds.SUBSTITUTION_TAG;
import static com.sendgrid.typechecker.MailFieldIds.TEMPLATE_ID;
import static com.sendgrid.typechecker.MailFieldIds.TEXT;
import static com.sendgrid.typechecker.MailFieldIds.THRESHOLD;
import static com.sendgrid.typechecker.MailFieldIds.TO;
import static com.sendgrid.typechecker.MailFieldIds.TRACKING_SETTINGS;
import static com.sendgrid.typechecker.MailFieldIds.TYPE;
import static com.sendgrid.typechecker.MailFieldIds.UTM_CAMPAIGN;
import static com.sendgrid.typechecker.MailFieldIds.UTM_CONTENT;
import static com.sendgrid.typechecker.MailFieldIds.UTM_MEDIUM;
import static com.sendgrid.typechecker.MailFieldIds.UTM_SOURCE;
import static com.sendgrid.typechecker.MailFieldIds.UTM_TERM;
import static com.sendgrid.typechecker.MailFieldIds.VALUE;
import static com.sendgrid.typechecker.TypeAsserts.applyAssertions;
import static com.sendgrid.typechecker.TypeAsserts.assertBoolean;
import static com.sendgrid.typechecker.TypeAsserts.assertIntArray;
import static com.sendgrid.typechecker.TypeAsserts.assertInteger;
import static com.sendgrid.typechecker.TypeAsserts.assertObject;
import static com.sendgrid.typechecker.TypeAsserts.assertObjectArray;
import static com.sendgrid.typechecker.TypeAsserts.assertString;
import static com.sendgrid.typechecker.TypeAsserts.assertStringArray;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.Request;

import java.io.IOException;

public class TypeChecker {

  /**
   * Call this method to check it's body parameters types.
   * @param request that should be checked
   * @throws TypeCheckException thrown if type of field is incorrect
   * @throws IOException thrown if json could not be parsed
   */
  public void checkRequest(Request request) throws TypeCheckException, IOException {
    String endpoint = request.getEndpoint();

    switch (endpoint) {
      case "mail/send": {
        String body = request.getBody();
        checkMailParams(body);
        break;
      }
      default: {
        break;
      }
    }
  }

  /**
   * Call this method on json body of mail/send to be sure that all params are of correct type.
   * @param body of mail/send request in json form
   * @throws TypeCheckException thrown if type of field is incorrect
   * @throws IOException thrown if json could not be parsed
   */
  public void checkMailParams(String body) throws TypeCheckException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    final JsonNode root = objectMapper.readTree(body);
    if (root == null) {
      throw new TypeCheckException("No body detected");
    }

    checkPersonalizations(root);

    final JsonNode from = root.get(FROM);
    assertObject(FROM, true, from);

    if (from != null) {
      assertNameAndEmail(from, FROM);
    }

    final JsonNode to = root.get(REPLY_TO);
    assertObject(REPLY_TO, false, to);

    if (to != null) {
      assertNameAndEmail(to, REPLY_TO);
    }

    final JsonNode subject = root.get(SUBJECT);
    assertString(SUBJECT, false, subject);

    checkContent(root);

    checkAttachments(root);

    final JsonNode templateId = root.get(TEMPLATE_ID);
    assertString(TEMPLATE_ID, false, templateId);

    final JsonNode ipPoolName = root.get(IP_POOL_NAME);
    assertString(IP_POOL_NAME, false, ipPoolName);

    final JsonNode categories = root.get(CATEGORIES);
    assertStringArray(CATEGORIES, false, categories);

    final JsonNode customArgs = root.get(CUSTOM_ARGS);
    assertObject(CUSTOM_ARGS, false, customArgs);

    final JsonNode sections = root.get(SECTIONS);
    assertObject(SECTIONS, false, sections);

    final JsonNode headers = root.get(HEADERS);
    assertObject(HEADERS, false, headers);

    final JsonNode sendAt = root.get(SEND_AT);
    assertInteger(SEND_AT, false, sendAt);

    final JsonNode batchId = root.get(BATCH_ID);
    assertString(BATCH_ID, false, batchId);

    checkAsm(root);

    checkMailSettings(root);

    checkTrackingSettings(root);

  }

  private void checkPersonalizations(JsonNode root) throws TypeCheckException {
    final JsonNode personalizations = root.get(PERSONALIZATIONS);
    assertObjectArray(PERSONALIZATIONS, true, personalizations);
    if (personalizations != null) {
      applyAssertions(new TypeAsserts.ThrowingConsumer<JsonNode, TypeCheckException>() {
        @Override
        public void accept(JsonNode el) throws TypeCheckException {
          final JsonNode to = el.get(TO);
          final String personalizationsBase = PERSONALIZATIONS + ".";

          assertObjectArray(personalizationsBase + TO, true, to);
          if (to != null) {
            applyAssertions(new TypeAsserts.ThrowingConsumer<JsonNode, TypeCheckException>() {
              @Override
              public void accept(JsonNode jsonNode) throws TypeCheckException {
                TypeChecker.this.assertNameAndEmail(jsonNode, personalizationsBase + TO);
              }
            }, to);
          }

          final JsonNode cc = el.get(CC);
          assertObjectArray(personalizationsBase + CC, false, cc);
          if (cc != null) {
            applyAssertions(new TypeAsserts.ThrowingConsumer<JsonNode, TypeCheckException>() {
              @Override
              public void accept(JsonNode jsonNode) throws TypeCheckException {
                TypeChecker.this.assertNameAndEmail(jsonNode, personalizationsBase + CC);
              }
            }, cc);
          }

          final JsonNode bcc = el.get(BCC);
          assertObjectArray(personalizationsBase + BCC, false, bcc);
          if (bcc != null) {
            applyAssertions(new TypeAsserts.ThrowingConsumer<JsonNode, TypeCheckException>() {
              @Override
              public void accept(JsonNode jsonNode) throws TypeCheckException {
                TypeChecker.this.assertNameAndEmail(jsonNode, personalizationsBase + BCC);
              }
            }, bcc);
          }

          final JsonNode subject = el.get(SUBJECT);
          assertString(personalizationsBase + SUBJECT, false, subject);

          final JsonNode headers = el.get(HEADERS);
          assertObject(personalizationsBase + HEADERS, false, headers);

          final JsonNode substitutions = el.get(SUBSTITUTIONS);
          assertObject(personalizationsBase + SUBSTITUTIONS, false, substitutions);

          final JsonNode customArgs = el.get(CUSTOM_ARGS);
          assertObject(personalizationsBase + CUSTOM_ARGS, false, customArgs);

          final JsonNode sendAt = el.get(SEND_AT);
          assertInteger(personalizationsBase + SEND_AT, false, sendAt);

        }
      }, personalizations);
    }
  }

  private void checkContent(JsonNode root) throws TypeCheckException {
    final JsonNode content = root.get(CONTENT);
    assertObjectArray(CONTENT, true, content);

    if (content != null) {
      applyAssertions(new TypeAsserts.ThrowingConsumer<JsonNode, TypeCheckException>() {
        @Override
        public void accept(JsonNode el) throws TypeCheckException {
          final JsonNode contentType = el.get(TYPE);
          assertString(CONTENT + "." + TYPE, true, contentType);

          final JsonNode contentValue = el.get(VALUE);
          assertString(CONTENT + "." + VALUE, true, contentValue);
        }
      }, content);
    }
  }

  private void checkAttachments(JsonNode root) throws TypeCheckException {
    final JsonNode attachments = root.get(ATTACHMENTS);
    assertObjectArray(ATTACHMENTS, false, attachments);

    if (attachments != null) {
      applyAssertions(new TypeAsserts.ThrowingConsumer<JsonNode, TypeCheckException>() {
        @Override
        public void accept(JsonNode el) throws TypeCheckException {
          final JsonNode attachmentsContent = el.get(CONTENT);
          assertString(ATTACHMENTS + "." + CONTENT, true, attachmentsContent);

          final JsonNode attachmentsType = el.get(TYPE);
          assertString(ATTACHMENTS + "." + TYPE, false, attachmentsType);

          final JsonNode attachmentsFilename = el.get(FILENAME);
          assertString(ATTACHMENTS + "." + FILENAME, true, attachmentsFilename);

          final JsonNode attachmentsDisposition = el.get(DISPOSITION);
          assertString(ATTACHMENTS + "." + DISPOSITION, false, attachmentsDisposition);

          final JsonNode attachmentsContentId = el.get(CONTENT_ID);
          assertString(ATTACHMENTS + "." + CONTENT_ID, false, attachmentsContentId);
        }
      }, attachments);
    }
  }

  private void checkAsm(JsonNode root) throws TypeCheckException {
    final JsonNode asm = root.get(ASM);
    assertObject(ASM, false, asm);

    if (asm != null) {
      final JsonNode asmGroupId = asm.get(GROUP_ID);
      assertInteger(ASM + "." + GROUP_ID, true, asmGroupId);

      final JsonNode asmGroupsToDisplay = asm.get(GROUPS_TO_DISPLAY);
      assertIntArray(ASM + "." + GROUPS_TO_DISPLAY, false, asmGroupsToDisplay);

    }
  }

  private void checkMailSettings(JsonNode root) throws TypeCheckException {
    final JsonNode mailSettings = root.get(MAIL_SETTINGS);
    assertObject(MAIL_SETTINGS, false, mailSettings);

    if (mailSettings != null) {
      final JsonNode bcc = mailSettings.get(BCC);
      assertObject(MAIL_SETTINGS + "." + BCC, false, bcc);

      if (bcc != null) {
        final JsonNode bccEnable = bcc.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + BCC + "." + ENABLE, false, bccEnable);

        final JsonNode bccEmail = bcc.get(EMAIL);
        assertString(MAIL_SETTINGS + "." + BCC + "." + EMAIL, false, bccEmail);
      }

      final JsonNode bypassListManagement = mailSettings.get(BYPASS_LIST_MANAGEMENT);
      assertObject(MAIL_SETTINGS + "." + BYPASS_LIST_MANAGEMENT, false, bypassListManagement);

      if (bypassListManagement != null) {
        final JsonNode bypassEnable = bypassListManagement.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + BYPASS_LIST_MANAGEMENT + "." + ENABLE,
            false,
            bypassEnable);
      }

      final JsonNode footer = mailSettings.get(FOOTER);
      assertObject(MAIL_SETTINGS + "." + FOOTER, false, footer);

      if (footer != null) {
        final JsonNode footerEnabled = footer.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + FOOTER + "." + ENABLE, false, footerEnabled);

        final JsonNode footerText = footer.get(TEXT);
        assertString(MAIL_SETTINGS + "." + FOOTER + "." + TEXT, false, footerText);

        final JsonNode footerHtml = footer.get(HTML);
        assertString(MAIL_SETTINGS + "." + FOOTER + "." + HTML, false, footerHtml);
      }

      final JsonNode sandbox = mailSettings.get(SANDBOX_MODE);
      assertObject(MAIL_SETTINGS + "." + SANDBOX_MODE, false, sandbox);

      if (sandbox != null) {
        final JsonNode sandboxEnabled = sandbox.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + SANDBOX_MODE + "." + ENABLE, false, sandboxEnabled);
      }

      final JsonNode spamCheck = mailSettings.get(SPAM_CHECK);
      assertObject(MAIL_SETTINGS + "." + SPAM_CHECK, false, spamCheck);

      if (spamCheck != null) {
        final JsonNode spamCheckEnabled = spamCheck.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + SPAM_CHECK + "." + ENABLE, false, spamCheckEnabled);

        final JsonNode spamCheckThreshold = spamCheck.get(THRESHOLD);
        assertInteger(MAIL_SETTINGS + "." + SPAM_CHECK + "." + THRESHOLD,
            false,
            spamCheckThreshold);

        final JsonNode spamCheckUrl = spamCheck.get(POST_TO_URL);
        assertString(MAIL_SETTINGS + "." + SPAM_CHECK + "." + POST_TO_URL, false, spamCheckUrl);
      }

    }
  }

  private void checkTrackingSettings(JsonNode root) throws TypeCheckException {
    final JsonNode trackingSettings = root.get(TRACKING_SETTINGS);
    assertObject(TRACKING_SETTINGS, false, trackingSettings);

    if (trackingSettings != null) {
      final String clickTrackId = TRACKING_SETTINGS + "." + CLICK_TRACKING;
      final JsonNode clickTracking = trackingSettings.get(CLICK_TRACKING);
      assertObject(clickTrackId, false, clickTracking);


      if (clickTracking != null) {
        final JsonNode clickTrackingEnabled = clickTracking.get(ENABLE);
        assertBoolean(clickTrackId + "." + ENABLE, false, clickTrackingEnabled);

        final JsonNode clickTrackingTextEnabled = clickTracking.get(ENABLE_TEXT);
        assertBoolean(clickTrackId + "." + ENABLE_TEXT, false, clickTrackingTextEnabled);
      }

      final String openTrackId = TRACKING_SETTINGS + "." + OPEN_TRACKING;
      final JsonNode openTracking = trackingSettings.get(OPEN_TRACKING);
      assertObject(openTrackId, false, openTracking);

      if (openTracking != null) {
        final JsonNode openTrackingEnabled = openTracking.get(ENABLE);
        assertBoolean(openTrackId + "." + ENABLE, false, openTrackingEnabled);

        final JsonNode openTrackingTag = openTracking.get(SUBSTITUTION_TAG);
        assertString(openTrackId + "." + SUBSTITUTION_TAG, false, openTrackingTag);
      }

      final String subTrackId = TRACKING_SETTINGS + "." + SUBSCRIPTION_TRACKING;
      final JsonNode subscriptionTracking = trackingSettings.get(SUBSCRIPTION_TRACKING);
      assertObject(subTrackId, false, subscriptionTracking);

      if (subscriptionTracking != null) {
        final JsonNode subsTrackEnabled = subscriptionTracking.get(ENABLE);
        assertBoolean(subTrackId + "." + ENABLE, false, subsTrackEnabled);

        final JsonNode subsTrackText = subscriptionTracking.get(TEXT);
        assertString(subTrackId + "." + TEXT, false, subsTrackText);

        final JsonNode subsTrackHtml = subscriptionTracking.get(HTML);
        assertString(subTrackId + "." + HTML, false, subsTrackHtml);

        final JsonNode subsTrackTag = subscriptionTracking.get(SUBSTITUTION_TAG);
        assertString(subTrackId + "." + SUBSTITUTION_TAG, false, subsTrackTag);
      }

      final String ganalyticsId = TRACKING_SETTINGS + "." + GANALYTICS;
      final JsonNode ganalytics = trackingSettings.get(GANALYTICS);
      assertObject(ganalyticsId, false, ganalytics);

      if (ganalytics != null) {
        final JsonNode analyticsEnabled = ganalytics.get(ENABLE);
        assertBoolean(ganalyticsId + "." + ENABLE, false, analyticsEnabled);

        final JsonNode utmSource = ganalytics.get(UTM_SOURCE);
        assertString(ganalyticsId + "." + UTM_SOURCE, false, utmSource);

        final JsonNode utmMedium = ganalytics.get(UTM_MEDIUM);
        assertString(ganalyticsId + "." + UTM_MEDIUM, false, utmMedium);

        final JsonNode utmTerm = ganalytics.get(UTM_TERM);
        assertString(ganalyticsId + "." + UTM_TERM, false, utmTerm);

        final JsonNode utmContent = ganalytics.get(UTM_CONTENT);
        assertString(ganalyticsId + "." + UTM_CONTENT, false, utmContent);

        final JsonNode utmCampaign = ganalytics.get(UTM_CAMPAIGN);
        assertString(ganalyticsId + "." + UTM_CAMPAIGN, false, utmCampaign);
      }
    }
  }

  private void assertNameAndEmail(JsonNode root,  String base)
      throws TypeCheckException {
    assertString(base + "." + EMAIL, true, root.get(EMAIL));
    assertString(base + "." + NAME, false, root.get(NAME));
  }

}
