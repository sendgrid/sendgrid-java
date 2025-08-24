package com.sendgrid;

/**
 * Class Twilio SendGrid allows for quick and easy access to the Twilio SendGrid API.
 */
public class SendGrid extends BaseInterface {

  private static final String SENDGRID_HOST_NAME = "api.sendgrid.com";
  public static final String BEARER = "Bearer ";

  /**
   * Construct a new Twilio SendGrid API wrapper.
   *
   * @param apiKey is your Twilio SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   */
  public SendGrid(final String apiKey) {
    initializeSendGrid(apiKey);
  }

  /**
   * Construct a new Twilio SendGrid API wrapper with custom thread pool size
   *
   * @param apiKey is your Twilio SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param threadPoolSize the pool size to initialize for sending email asynchronously
   */
  public SendGrid(final String apiKey, final int threadPoolSize) {
    initializeSendGrid(apiKey, threadPoolSize);
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
   * Construct a new Twilio SendGrid API wrapper with custom thread pool size
   *
   * @param apiKey is your Twilio SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param test   is true if you are unit testing
   * @param threadPoolSize the pool size to initialize for sending email asynchronously
   */
  public SendGrid(final String apiKey, final Boolean test, final int threadPoolSize) {
    super(test);
    initializeSendGrid(apiKey, threadPoolSize);
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
   * Construct a new Twilio SendGrid API wrapper with custom thread pool size
   *
   * @param apiKey is your Twilio SendGrid API Key: https://app.sendgrid.com/settings/api_keys
   * @param client the Client to use (allows to customize its configuration)
   * @param threadPoolSize the pool size to initialize for sending email asynchronously
   */
  public SendGrid(final String apiKey, final Client client, final int threadPoolSize) {
    super(client);
    initializeSendGrid(apiKey, threadPoolSize);
  }

  /**
   * Initialize the client
   *
   * @param apiKey the user's API key
   */
  public void initializeSendGrid(final String apiKey) {
    this.initialize(BEARER + apiKey, SENDGRID_HOST_NAME);
  }

  /**
   * Initialize the client with custom thread pool size with custom thread pool size
   *
   * @param apiKey the user's API key
   * @param threadPoolSize the pool size to initialize for sending email asynchronously
   */
  public void initializeSendGrid(final String apiKey, final int threadPoolSize) {
    this.initialize(BEARER + apiKey, SENDGRID_HOST_NAME, threadPoolSize);
  }
}
