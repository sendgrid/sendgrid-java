package com.sendgrid;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class SendGrid implements Versionable {

    private static final String VERSION = "2.1.0";

    private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";

    private static final String DEFAULT_ENDPOINT = "/api/mail.send.json";

    private static final String DEFAULT_URL = "https://api.sendgrid.com";

    private static final String CONTENT_TYPE_MIME_TYPE = "text/plain";

    private static final String CONTENT_TYPE_CHARSET = "UTF-8";

    private static final String PARAM_TO = "to[%d]";

    private static final String PARAM_TONAME = "toname[%d]";

    private static final String PARAM_CC = "cc[%d]";

    private static final String PARAM_FROM = "from";

    private static final String PARAM_FROMNAME = "fromname";

    private static final String PARAM_REPLYTO = "replyto";

    private static final String PARAM_BCC = "bcc[%d]";

    private static final String PARAM_SUBJECT = "subject";

    private static final String PARAM_HTML = "html";

    private static final String PARAM_TEXT = "text";

    private static final String PARAM_FILES = "files[%s]";

    private static final String PARAM_CONTENTS = "content[%s]";

    private static final String PARAM_XSMTPAPI = "x-smtpapi";

    private static final String PARAM_HEADERS = "headers";

    private String username;

    private String password;

    private String url;

    private String endpoint;

    private CloseableHttpClient client;

    public SendGrid(String username, String password) {
        this.username = username;
        this.password = password;
        this.url = DEFAULT_URL;
        this.endpoint = DEFAULT_ENDPOINT;
        this.client = HttpClientBuilder.create().setUserAgent(USER_AGENT).build();
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    public SendGrid setUrl(String url) {
        this.url = url;
        return this;
    }

    public SendGrid setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public SendGrid setClient(CloseableHttpClient client) {
        this.client = client;
        return this;
    }

    public HttpEntity buildBody(Email email) {

        final MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        builder.addTextBody("api_user", this.username);
        builder.addTextBody("api_key", this.password);

        final ContentType contentType = ContentType.create(CONTENT_TYPE_MIME_TYPE, CONTENT_TYPE_CHARSET);

        handleTo(email, builder, contentType);
        handleToNames(email, builder, contentType);
        handleCC(email, builder, contentType);
        handleBCC(email, builder, contentType);
        handleAttachments(email, builder);
        handleContentIds(email, builder);
        handleHeaders(email, builder, contentType);
        handleFrom(email, builder, contentType);
        handleFromName(email, builder, contentType);
        handleReplyTo(email, builder, contentType);
        handleSubject(email, builder, contentType);
        handleHTML(email, builder, contentType);
        handleText(email, builder, contentType);
        handleX_SMTP_API(email, builder, contentType);

        return builder.build();
    }

    public Response send(Email email) throws SendGridException {
        HttpPost httppost = new HttpPost(this.url + this.endpoint);
        httppost.setEntity(this.buildBody(email));
        try {
            HttpResponse res = this.client.execute(httppost);
            return new Response(res.getStatusLine().getStatusCode(), EntityUtils.toString(res.getEntity()));
        } catch (IOException e) {
            throw new SendGridException(e);
        }

    }

    private void handleX_SMTP_API(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        if (!email.getSmtpapi().jsonString().equals("{}")) {
            builder.addTextBody(PARAM_XSMTPAPI, email.getSmtpapi().jsonString(), contentType);
        }
    }

    private void handleText(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        if (email.getText() != null && !email.getText().isEmpty()) {
            builder.addTextBody(PARAM_TEXT, email.getText(), contentType);
        }
    }

    private void handleHTML(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        if (email.getHtml() != null && !email.getHtml().isEmpty()) {
            builder.addTextBody(PARAM_HTML, email.getHtml(), contentType);
        }
    }

    private void handleSubject(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        if (email.getSubject() != null && !email.getSubject().isEmpty()) {
            builder.addTextBody(PARAM_SUBJECT, email.getSubject(), contentType);
        }
    }

    private void handleReplyTo(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        if (email.getReplyTo() != null && !email.getReplyTo().isEmpty()) {
            builder.addTextBody(PARAM_REPLYTO, email.getReplyTo(), contentType);
        }
    }

    private void handleFromName(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        if (email.getFromName() != null && !email.getFromName().isEmpty()) {
            builder.addTextBody(PARAM_FROMNAME, email.getFromName(), contentType);
        }
    }

    private void handleFrom(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        if (email.getFrom() != null && !email.getFrom().isEmpty()) {
            builder.addTextBody(PARAM_FROM, email.getFrom(), contentType);
        }
    }

    private void handleHeaders(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        if (!email.getHeaders().isEmpty()) {
            builder.addTextBody(PARAM_HEADERS, new JSONObject(email.getHeaders()).toString(), contentType);
        }
    }

    private void handleTo(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        // If SMTPAPI Header is used, To is still required. #workaround.
        String[] tos = email.getTos();
        if (tos.length == 0) {
            builder.addTextBody(String.format(PARAM_TO, 0), email.getFrom(), contentType);
        }
        for (int i = 0, len = tos.length; i < len; i++) {
            builder.addTextBody(String.format(PARAM_TO, i), tos[i], contentType);
        }
    }

    private void handleToNames(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        String[] tonames = email.getToNames();
        for (int i = 0, len = tonames.length; i < len; i++) {
            builder.addTextBody(String.format(PARAM_TONAME, i), tonames[i], contentType);
        }
    }

    private void handleCC(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        String[] ccs = email.getCcs();
        for (int i = 0, len = ccs.length; i < len; i++) {
            builder.addTextBody(String.format(PARAM_CC, i), ccs[i], contentType);
        }
    }

    private void handleBCC(Email email, final MultipartEntityBuilder builder, final ContentType contentType) {
        String[] bccs = email.getBccs();
        for (int i = 0, len = bccs.length; i < len; i++) {
            builder.addTextBody(String.format(PARAM_BCC, i), bccs[i], contentType);
        }
    }

    private void handleContentIds(Email email, final MultipartEntityBuilder builder) {
        if (!email.getContentIds().isEmpty()) {
            for (final String contentIdsKey : email.getContentIds().keySet()) {
                builder.addTextBody(String.format(PARAM_CONTENTS, contentIdsKey),
                        email.getContentIds().get(contentIdsKey));
            }
        }
    }

    private void handleAttachments(Email email, final MultipartEntityBuilder builder) {
        if (!email.getAttachments().isEmpty()) {
            for (final String attachmentKey : email.getAttachments().keySet()) {
                builder.addBinaryBody(String.format(PARAM_FILES, attachmentKey),
                        email.getAttachments().get(attachmentKey));
            }
        }
    }

}
