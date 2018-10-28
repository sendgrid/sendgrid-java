package com.sendgrid.typechecker;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.Request;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.io.IOException;

import static com.sendgrid.typechecker.MailFieldIds.*;
import static com.sendgrid.typechecker.TypeAsserts.*;

public class TypeChecker {

  public void checkRequest(@NotNull Request request) throws TypeCheckException, IOException {
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

  public void checkMailParams(@Nullable String body) throws TypeCheckException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode root = objectMapper.readTree(body);
    if (root == null) throw new TypeCheckException("No body detected");

    checkPersonalizations(root);

    JsonNode from = root.get(FROM);
    assertObject(FROM, true, from);

    if (from != null) {
      assertNameAndEmail(from, FROM);
    }

    JsonNode to = root.get(REPLY_TO);
    assertObject(REPLY_TO, false, to);

    if (to != null) {
      assertNameAndEmail(to, REPLY_TO);
    }

    JsonNode subject = root.get(SUBJECT);
    assertString(SUBJECT, false, subject);

    checkContent(root);

    checkAttachments(root);

    JsonNode templateId = root.get(TEMPLATE_ID);
    assertString(TEMPLATE_ID, false, templateId);

    JsonNode ipPoolName = root.get(IP_POOL_NAME);
    assertString(IP_POOL_NAME, false, ipPoolName);

    JsonNode categories = root.get(CATEGORIES);
    assertStringArray(CATEGORIES, false, categories);

    JsonNode customArgs = root.get(CUSTOM_ARGS);
    assertObject(CUSTOM_ARGS, false, customArgs);

    JsonNode sections = root.get(SECTIONS);
    assertObject(SECTIONS, false, sections);

    JsonNode headers = root.get(HEADERS);
    assertObject(HEADERS, false, headers);

    JsonNode sendAt = root.get(SEND_AT);
    assertInteger(SEND_AT, false, sendAt);

    JsonNode batchId = root.get(BATCH_ID);
    assertString(BATCH_ID, false, batchId);

    checkAsm(root);

    checkMailSettings(root);

    checkTrackingSettings(root);

  }

  private void checkPersonalizations(JsonNode root) throws TypeCheckException {
    JsonNode personalizations = root.get(PERSONALIZATIONS);
    assertObjectArray(PERSONALIZATIONS, true, personalizations);
    if (personalizations != null) {
      applyAssertions((el) -> {
        JsonNode to = el.get(TO);
        String personalizationsBase = PERSONALIZATIONS + ".";

        assertObjectArray(personalizationsBase + TO, true, to);
        if (to != null) {
          applyAssertions((node) -> assertNameAndEmail(node, personalizationsBase + TO), to);
        }

        JsonNode cc = el.get(CC);
        assertObjectArray(personalizationsBase + CC, false, cc);
        if (cc != null) {
          applyAssertions((node) -> assertNameAndEmail(node, personalizationsBase + CC), cc);
        }

        JsonNode bcc = el.get(BCC);
        assertObjectArray(personalizationsBase + BCC, false, bcc);
        if (bcc != null) {
          applyAssertions((node) -> assertNameAndEmail(node, personalizationsBase + BCC), bcc);
        }

        JsonNode subject = el.get(SUBJECT);
        assertString(personalizationsBase + SUBJECT, false, subject);

        JsonNode headers = el.get(HEADERS);
        assertObject(personalizationsBase + HEADERS, false, headers);

        JsonNode substitutions = el.get(SUBSTITUTIONS);
        assertObject(personalizationsBase + SUBSTITUTIONS, false, substitutions);

        JsonNode customArgs = el.get(CUSTOM_ARGS);
        assertObject(personalizationsBase + CUSTOM_ARGS, false, customArgs);

        JsonNode sendAt = el.get(SEND_AT);
        assertInteger(personalizationsBase + SEND_AT, false, sendAt);

      }, personalizations);
    }
  }

  private void checkContent(JsonNode root) throws TypeCheckException {
    JsonNode content = root.get(CONTENT);
    assertObjectArray(CONTENT, true, content);

    if (content != null) {
      applyAssertions((el) -> {
        JsonNode contentType = el.get(TYPE);
        assertString(CONTENT + "." + TYPE, true, contentType);

        JsonNode contentValue = el.get(VALUE);
        assertString(CONTENT + "." + VALUE, true, contentValue);
      }, content);
    }
  }

  private void checkAttachments(JsonNode root) throws TypeCheckException {
    JsonNode attachments = root.get(ATTACHMENTS);
    assertObjectArray(ATTACHMENTS, false, attachments);

    if (attachments != null) {
      applyAssertions((el) -> {
        JsonNode attachmentsContent = el.get(CONTENT);
        assertString(ATTACHMENTS + "." + CONTENT, true, attachmentsContent);

        JsonNode attachmentsType = el.get(TYPE);
        assertString(ATTACHMENTS + "." + TYPE, false, attachmentsType);

        JsonNode attachmentsFilename = el.get(FILENAME);
        assertString(ATTACHMENTS + "." + FILENAME, true, attachmentsFilename);

        JsonNode attachmentsDisposition = el.get(DISPOSITION);
        assertString(ATTACHMENTS + "." + DISPOSITION, false, attachmentsDisposition);

        JsonNode attachmentsContentId = el.get(CONTENT_ID);
        assertString(ATTACHMENTS + "." + CONTENT_ID, false, attachmentsContentId);
      }, attachments);
    }
  }

  private void checkAsm(JsonNode root) throws TypeCheckException {
    JsonNode asm = root.get(ASM);
    assertObject(ASM, false, asm);

    if (asm != null) {
      JsonNode asmGroupId = asm.get(GROUP_ID);
      assertInteger(ASM + "." + GROUP_ID, true, asmGroupId);

      JsonNode asmGroupsToDisplay = asm.get(GROUPS_TO_DISPLAY);
      assertIntArray(ASM + "." + GROUPS_TO_DISPLAY, false, asmGroupsToDisplay);

    }
  }

  private void checkMailSettings(JsonNode root) throws TypeCheckException {
    JsonNode mailSettings = root.get(MAIL_SETTINGS);
    assertObject(MAIL_SETTINGS, false, mailSettings);

    if (mailSettings != null) {
      JsonNode bcc = mailSettings.get(BCC);
      assertObject(MAIL_SETTINGS + "." + BCC, false, bcc);

      if (bcc != null) {
        JsonNode bccEnable = bcc.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + BCC + "." + ENABLE, false, bccEnable);

        JsonNode bccEmail = bcc.get(EMAIL);
        assertString(MAIL_SETTINGS + "." + BCC + "." + EMAIL, false, bccEmail);
      }

      JsonNode bypassListManagement = mailSettings.get(BYPASS_LIST_MANAGEMENT);
      assertObject(MAIL_SETTINGS + "." + BYPASS_LIST_MANAGEMENT, false, bypassListManagement);

      if (bypassListManagement != null) {
        JsonNode bypassEnable = bypassListManagement.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + BYPASS_LIST_MANAGEMENT + "." + ENABLE, false, bypassEnable);
      }

      JsonNode footer = mailSettings.get(FOOTER);
      assertObject(MAIL_SETTINGS + "." + FOOTER, false, footer);

      if (footer != null) {
        JsonNode footerEnabled = footer.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + FOOTER + "." + ENABLE, false, footerEnabled);

        JsonNode footerText = footer.get(TEXT);
        assertString(MAIL_SETTINGS + "." + FOOTER + "." + TEXT, false, footerText);

        JsonNode footerHtml = footer.get(HTML);
        assertString(MAIL_SETTINGS + "." + FOOTER + "." + HTML, false, footerHtml);
      }

      JsonNode sandbox = mailSettings.get(SANDBOX_MODE);
      assertObject(MAIL_SETTINGS + "." + SANDBOX_MODE, false, sandbox);

      if (sandbox != null) {
        JsonNode sandboxEnabled = sandbox.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + SANDBOX_MODE + "." + ENABLE, false, sandboxEnabled);
      }

      JsonNode spamCheck = mailSettings.get(SPAM_CHECK);
      assertObject(MAIL_SETTINGS + "." + SPAM_CHECK, false, spamCheck);

      if (spamCheck != null) {
        JsonNode spamCheckEnabled = spamCheck.get(ENABLE);
        assertBoolean(MAIL_SETTINGS + "." + SPAM_CHECK + "." + ENABLE, false, spamCheckEnabled);

        JsonNode spamCheckThreshold = spamCheck.get(THRESHOLD);
        assertInteger(MAIL_SETTINGS + "." + SPAM_CHECK + "." + THRESHOLD, false, spamCheckThreshold);

        JsonNode spamCheckUrl = spamCheck.get(POST_TO_URL);
        assertString(MAIL_SETTINGS + "." + SPAM_CHECK + "." + POST_TO_URL, false, spamCheckUrl);
      }

    }
  }

  private void checkTrackingSettings(JsonNode root) throws TypeCheckException {
    JsonNode trackingSettings = root.get(TRACKING_SETTINGS);
    assertObject(TRACKING_SETTINGS, false, trackingSettings);

    if (trackingSettings != null) {
      String clickTrackId = TRACKING_SETTINGS + "." + CLICK_TRACKING;
      JsonNode clickTracking = trackingSettings.get(CLICK_TRACKING);
      assertObject(clickTrackId, false, clickTracking);


      if (clickTracking != null) {
        JsonNode clickTrackingEnabled = clickTracking.get(ENABLE);
        assertBoolean(clickTrackId + "." + ENABLE, false, clickTrackingEnabled);

        JsonNode clickTrackingTextEnabled = clickTracking.get(ENABLE_TEXT);
        assertBoolean(clickTrackId + "." + ENABLE_TEXT, false, clickTrackingTextEnabled);
      }

      String openTrackId = TRACKING_SETTINGS + "." + OPEN_TRACKING;
      JsonNode openTracking = trackingSettings.get(OPEN_TRACKING);
      assertObject(openTrackId, false, openTracking);

      if (openTracking != null) {
        JsonNode openTrackingEnabled = openTracking.get(ENABLE);
        assertBoolean(openTrackId + "." + ENABLE, false, openTrackingEnabled);

        JsonNode openTrackingTag = openTracking.get(SUBSTITUTION_TAG);
        assertString(openTrackId + "." + SUBSTITUTION_TAG, false, openTrackingTag);
      }

      String subTrackId = TRACKING_SETTINGS + "." + SUBSCRIPTION_TRACKING;
      JsonNode subscriptionTracking = trackingSettings.get(SUBSCRIPTION_TRACKING);
      assertObject(subTrackId, false, subscriptionTracking);

      if (subscriptionTracking != null) {
        JsonNode subsTrackEnabled = subscriptionTracking.get(ENABLE);
        assertBoolean(subTrackId + "." + ENABLE, false, subsTrackEnabled);

        JsonNode subsTrackText = subscriptionTracking.get(TEXT);
        assertString(subTrackId + "." + TEXT, false, subsTrackText);

        JsonNode subsTrackHtml = subscriptionTracking.get(HTML);
        assertString(subTrackId + "." + HTML, false, subsTrackHtml);

        JsonNode subsTrackTag = subscriptionTracking.get(SUBSTITUTION_TAG);
        assertString(subTrackId + "." + SUBSTITUTION_TAG, false, subsTrackTag);
      }

      String gAnalyticsId = TRACKING_SETTINGS + "." + GANALYTICS;
      JsonNode gAnalytics = trackingSettings.get(GANALYTICS);
      assertObject(gAnalyticsId, false, gAnalytics);

      if (gAnalytics != null) {
        JsonNode analyticsEnabled = gAnalytics.get(ENABLE);
        assertBoolean(gAnalyticsId + "." + ENABLE, false, analyticsEnabled);

        JsonNode utmSource = gAnalytics.get(UTM_SOURCE);
        assertString(gAnalyticsId + "." + UTM_SOURCE, false, utmSource);

        JsonNode utmMedium = gAnalytics.get(UTM_MEDIUM);
        assertString(gAnalyticsId + "." + UTM_MEDIUM, false, utmMedium);

        JsonNode utmTerm = gAnalytics.get(UTM_TERM);
        assertString(gAnalyticsId + "." + UTM_TERM, false, utmTerm);

        JsonNode utmContent = gAnalytics.get(UTM_CONTENT);
        assertString(gAnalyticsId + "." + UTM_CONTENT, false, utmContent);

        JsonNode utmCampaign = gAnalytics.get(UTM_CAMPAIGN);
        assertString(gAnalyticsId + "." + UTM_CAMPAIGN, false, utmCampaign);
      }
    }
  }

  private void assertNameAndEmail(@NotNull JsonNode root, @NotNull String base) throws TypeCheckException {
    assertString(base + "." + EMAIL, true, root.get(EMAIL));
    assertString(base + "." + NAME, false, root.get(NAME));
  }

}
