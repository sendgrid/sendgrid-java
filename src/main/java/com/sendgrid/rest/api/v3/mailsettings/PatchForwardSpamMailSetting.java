/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Mail Settings API
 * The Twilio SendGrid Mail Settings API allows you to retrieve and configure the various Mail Settings available. Mail Settings instruct SendGrid to apply specific settings to every email that you send over [SendGrid’s Web API](https://docs.sendgrid.com/api-reference/mail-send/v3-mail-send) or [SMTP relay](https://sendgrid.com/docs/for-developers/sending-email/building-an-x-smtpapi-header/). These settings include how to embed a custom footer, how to manage blocks, spam, and bounces, and more.  For a full list of Twilio SendGrid's Mail Settings, and what each one does, see [**Mail Settings**](https://sendgrid.com/docs/ui/account-and-settings/mail/).  You can also manage your Mail Settings in the Twilio SendGrid application user interface.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mailsettings;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.mailsettings.models.MailSettingsForwardSpam;
import com.sendgrid.util.JsonUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PatchForwardSpamMailSetting {
    private String onBehalfOf;
    private final MailSettingsForwardSpam mailSettingsForwardSpam;


    public MailSettingsForwardSpam send(final TokenRestClient client) {
        String path = "/v3/mail_settings/forward_spam";
        Request.Builder builder = new Request.Builder(HttpMethod.PATCH, path);
        addHeaderParams(builder);
        body(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "PatchForwardSpamMailSetting creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
        }
        return JsonUtil.fromJson(response.getStream(), MailSettingsForwardSpam.class);
    }


    private void addHeaderParams(Request.Builder builder) {
        if (onBehalfOf != null) {
            builder.addHeaderParams("on-behalf-of", onBehalfOf.toString());
        }

    }


    private void body(final Request.Builder builder) {
        if (mailSettingsForwardSpam != null) {
            builder.body(JsonUtil.toJson(mailSettingsForwardSpam));
        }
    }

}
