package com.sendgrid;

import org.apache.commons.codec.binary.Base64;

/**
 * This class allows you to quickly and easily send emails through Twilio
 * SendGrid using Java.
 */
public class TwilioEmail extends BaseInterface {

  /**
   * Construct a new Twilio SendGrid API wrapper.
   *
   * @param username your Twilio Email API key SID or Account SID
   * @param password your Twilio Email API key secret or Account Auth Token
   */
  public TwilioEmail(final String username, final String password) {
    initialize(username, password);
  }

  /**
   * Construct a new Twilio SendGrid API wrapper.
   *
   * @param username your Twilio Email API key SID or Account SID
   * @param password your Twilio Email API key secret or Account Auth Token
   * @param client   the Client to use (allows to customize its configuration)
   */
  public TwilioEmail(final String username, final String password, final Client client) {
    super(client);
    initialize(username, password);
  }

  /**
   * Initialize the client.
   *
   * @param username your Twilio Email API key SID or Account SID
   * @param password your Twilio Email API key secret or Account Auth Token
   */
  public void initialize(final String username, final String password) {
    super.initialize(getAuthString(username, password), "email.twilio.com");
  }

  private String getAuthString(final String username, final String password) {
    final String credentials = username + ":" + password;
    final byte[] encodedBytes = Base64.encodeBase64(credentials.getBytes());
    final String encoderString = new String(encodedBytes);

    return "Basic " + encoderString;
  }
}
