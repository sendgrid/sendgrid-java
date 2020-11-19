package com.sendgrid;

/**
 * Class Twilio SendGrid allows for quick and easy access to the Twilio SendGrid API.
 */
public class SendGrid extends BaseInterface {

  /**
   * Construct a new Twilio SendGrid API wrapper.
   *
   * @param apiKey is your Twilio SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   */
  public SendGrid(final String apiKey) {
    initializeSendGrid(apiKey);
  }

  /**
   * Construct a new Twilio SendGrid API wrapper.
   *
   * @param apiKey is your Twilio SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param test   is true if you are unit testing
   */
  public SendGrid(final String apiKey, final Boolean test) {
    super(test);
    initializeSendGrid(apiKey);
  }

  /**
   * Construct a new Twilio SendGrid API wrapper.
   *
   * @param apiKey is your Twilio SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param client the Client to use (allows to customize its configuration)
   */
  public SendGrid(final String apiKey, final Client client) {
    super(client);
    initializeSendGrid(apiKey);
  }

  /**
   * Initialize the client.
   *
   * @param apiKey the user's API key
   */
  public void initializeSendGrid(final String apiKey) {
    this.initialize("Bearer " + apiKey, "api.sendgrid.com");
  }
}
