package com.sendgrid;

import static java.util.Objects.requireNonNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.sendgrid.smtpapi.SMTPAPI;

public class SendGrid implements AutoCloseable {
    private static final String VERSION = "2.2.2";
    private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";

    private static final String PARAM_TO = "to[]";
    private static final String PARAM_TONAME = "toname[]";
    private static final String PARAM_CC = "cc[]";
    private static final String PARAM_BCC = "bcc[]";

    private static final String PARAM_FROM = "from";
    private static final String PARAM_FROMNAME = "fromname";
    private static final String PARAM_REPLYTO = "replyto";
    private static final String PARAM_SUBJECT = "subject";
    private static final String PARAM_HTML = "html";
    private static final String PARAM_TEXT = "text";
    private static final String PARAM_FILES = "files[%s]";
    private static final String PARAM_CONTENTS = "content[%s]";
    private static final String PARAM_XSMTPAPI = "x-smtpapi";
    private static final String PARAM_HEADERS = "headers";
    private static final String TEXT_PLAIN = "text/plain";
    private static final String UTF_8 = "UTF-8";

    private String username;
    private String password;
    private String url;
    private String endpoint;

    private final HttpAsyncClient client;
    private final boolean closingNeeded;

    private SendGrid(HttpAsyncClient client, boolean closingNeeded) {
        this.url = "https://api.sendgrid.com";
        this.endpoint = "/api/mail.send.json";
        this.client = requireNonNull(client);
        this.closingNeeded = closingNeeded;
        if(closingNeeded) {
            ((CloseableHttpAsyncClient) client).start();
        }
    }

    /**
     * Constructor for using a username and password
     *
     * @param username SendGrid username
     * @param password SendGrid password
     * @param client   HTTP client
     */
    public SendGrid(String username, String password, HttpAsyncClient client) {
        this(client, false);
        this.username = requireNonNull(username);
        this.password = requireNonNull(password);
    }

    /**
     * Constructor for using a username and password
     *
     * @param username SendGrid username
     * @param password SendGrid password
     */
    public SendGrid(String username, String password) {
        this(HttpAsyncClientBuilder.create().build(), true);
        this.username = requireNonNull(username);
        this.password = requireNonNull(password);
    }

    /**
     * Constructor for using an API key
     *
     * @param apiKey SendGrid api key
     * @param client HTTP client
     */
    public SendGrid(String apiKey, CloseableHttpAsyncClient client) {
        this(client, false);
        this.password = requireNonNull(apiKey);
        this.username = null;
    }


    /**
     * Constructor for using an API key
     *
     * @param apiKey SendGrid api key
     */
    public SendGrid(String apiKey) {
        this(HttpAsyncClientBuilder.create().build(), true);
        this.password = requireNonNull(apiKey);
        this.username = null;

    }

    @Override
    public void close() throws IOException {
        if (closingNeeded) {
            ((CloseableHttpAsyncClient) client).close();
        }
    }

    public SendGrid setUrl(String url) {
        this.url = requireNonNull(url);
        return this;
    }

    public SendGrid setEndpoint(String endpoint) {
        this.endpoint = requireNonNull(endpoint);
        return this;
    }

    public String getVersion() {
        return VERSION;
    }

    public HttpEntity buildBody(Email email) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        // We are using an API key
        if (this.username != null) {
            builder.addTextBody("api_user", this.username);
            builder.addTextBody("api_key", this.password);
        }

        String[] tos = email.getTos();
        String[] tonames = email.getToNames();
        String[] ccs = email.getCcs();
        String[] bccs = email.getBccs();

        // If SMTPAPI Header is used, To is still required. #workaround.
        if (tos.length == 0) {
            builder.addTextBody(String.format(PARAM_TO, 0), email.getFrom(), ContentType.create(TEXT_PLAIN, UTF_8));
        }
        for (String to : tos) {
            builder.addTextBody(PARAM_TO, to, ContentType.create("text/plain", "UTF-8"));
        }
        for (String toname : tonames) {
            builder.addTextBody(PARAM_TONAME, toname, ContentType.create("text/plain", "UTF-8"));
        }
        for (String cc : ccs) {
            builder.addTextBody(PARAM_CC, cc, ContentType.create("text/plain", "UTF-8"));
        }
        for (String bcc : bccs) {
            builder.addTextBody(PARAM_BCC, bcc, ContentType.create(TEXT_PLAIN, UTF_8));
        }
        // Files
        if (email.getAttachments().size() > 0) {
            email.getAttachments().forEach((String name, InputStream content) -> {
                builder.addBinaryBody(String.format(PARAM_FILES, name), content);
            });
        }

        if (email.getContentIds().size() > 0) {
            email.getContentIds().forEach((String name, String contentId) -> {
                builder.addTextBody(String.format(PARAM_CONTENTS, name), contentId);
            });
        }

        if (email.getHeaders().size() > 0) {
            builder.addTextBody(PARAM_HEADERS, new JSONObject(email.getHeaders()).toString(),
                    ContentType.create(TEXT_PLAIN, UTF_8));
        }

        if (email.getFrom() != null && !email.getFrom().isEmpty()) {
            builder.addTextBody(PARAM_FROM, email.getFrom(), ContentType.create(TEXT_PLAIN, UTF_8));
        }

        if (email.getFromName() != null && !email.getFromName().isEmpty()) {
            builder.addTextBody(PARAM_FROMNAME, email.getFromName(), ContentType.create(TEXT_PLAIN, UTF_8));
        }

        if (email.getReplyTo() != null && !email.getReplyTo().isEmpty()) {
            builder.addTextBody(PARAM_REPLYTO, email.getReplyTo(), ContentType.create(TEXT_PLAIN, UTF_8));
        }

        if (email.getSubject() != null && !email.getSubject().isEmpty()) {
            builder.addTextBody(PARAM_SUBJECT, email.getSubject(), ContentType.create(TEXT_PLAIN, UTF_8));
        }

        if (email.getHtml() != null && !email.getHtml().isEmpty()) {
            builder.addTextBody(PARAM_HTML, email.getHtml(), ContentType.create(TEXT_PLAIN, UTF_8));
        }

        if (email.getText() != null && !email.getText().isEmpty()) {
            builder.addTextBody(PARAM_TEXT, email.getText(), ContentType.create(TEXT_PLAIN, UTF_8));
        }

        String tmpString = email.smtpapi.jsonString();
        if (!tmpString.equals("{}")) {
            builder.addTextBody(PARAM_XSMTPAPI, tmpString, ContentType.create(TEXT_PLAIN, UTF_8));
        }

        return builder.build();
    }

    public CompletionStage<SendGrid.Response> send(Email email) {
        final CompletableFuture<SendGrid.Response> cf = new CompletableFuture<SendGrid.Response>();
        HttpPost httppost = new HttpPost(this.url + this.endpoint);
        httppost.setHeader("User-Agent", USER_AGENT);
        // Using an API key
        if (this.username == null) {
            httppost.setHeader("Authorization", "Bearer " + this.password);
        }

        try {
            httppost.setEntity(this.buildBody(email));
        } catch (Exception e) {
            cf.completeExceptionally(e);
            return cf;
        }

        this.client.execute(httppost, new FutureCallback<HttpResponse>() {

            @Override
            public void failed(Exception e) {
                cf.completeExceptionally(e);
            }

            @Override
            public void completed(HttpResponse res) {
                try {
                    cf.complete(new SendGrid.Response(res.getStatusLine().getStatusCode(),
                            EntityUtils.toString(res.getEntity())));
                } catch (ParseException | IOException e) {
                    cf.completeExceptionally(e);
                }
            }

            @Override
            public void cancelled() {
                cf.completeExceptionally(new InterruptedException());
            }
        });
        return cf;
    }

    public static class Email {
        private SMTPAPI smtpapi;
        private ArrayList<String> to;
        private ArrayList<String> toname;
        private ArrayList<String> cc;
        private String from;
        private String fromname;
        private String replyto;
        private String subject;
        private String text;
        private String html;
        private ArrayList<String> bcc;
        private Map<String, InputStream> attachments;
        private Map<String, String> contents;
        private Map<String, String> headers;

        public Email() {
            this.smtpapi = new SMTPAPI();
            this.to = new ArrayList<String>();
            this.toname = new ArrayList<String>();
            this.cc = new ArrayList<String>();
            this.bcc = new ArrayList<String>();
            this.attachments = new HashMap<String, InputStream>();
            this.contents = new HashMap<String, String>();
            this.headers = new HashMap<String, String>();
        }

        public Email addTo(String to) {
            this.to.add(to);
            return this;
        }

        public Email addTo(String[] tos) {
            this.to.addAll(Arrays.asList(tos));
            return this;
        }

        public Email addTo(String to, String name) {
            this.addTo(to);
            return this.addToName(name);
        }

        public Email setTo(String[] tos) {
            this.to = new ArrayList<String>(Arrays.asList(tos));
            return this;
        }

        public String[] getTos() {
            return this.to.toArray(new String[this.to.size()]);
        }

        public Email addSmtpApiTo(String to) {
            this.smtpapi.addTo(to);
            return this;
        }

        public Email addSmtpApiTo(String[] to) {
            this.smtpapi.addTos(to);
            return this;
        }

        public Email addToName(String toname) {
            this.toname.add(toname);
            return this;
        }

        public Email addToName(String[] tonames) {
            this.toname.addAll(Arrays.asList(tonames));
            return this;
        }

        public Email setToName(String[] tonames) {
            this.toname = new ArrayList<String>(Arrays.asList(tonames));
            return this;
        }

        public String[] getToNames() {
            return this.toname.toArray(new String[this.toname.size()]);
        }

        public Email addCc(String cc) {
            this.cc.add(cc);
            return this;
        }

        public Email addCc(String[] ccs) {
            this.cc.addAll(Arrays.asList(ccs));
            return this;
        }

        public Email setCc(String[] ccs) {
            this.cc = new ArrayList<String>(Arrays.asList(ccs));
            return this;
        }

        public String[] getCcs() {
            return this.cc.toArray(new String[this.cc.size()]);
        }

        public Email setFrom(String from) {
            this.from = from;
            return this;
        }

        public String getFrom() {
            return this.from;
        }

        public Email setFromName(String fromname) {
            this.fromname = fromname;
            return this;
        }

        public String getFromName() {
            return this.fromname;
        }

        public Email setReplyTo(String replyto) {
            this.replyto = replyto;
            return this;
        }

        public String getReplyTo() {
            return this.replyto;
        }

        public Email addBcc(String bcc) {
            this.bcc.add(bcc);
            return this;
        }

        public Email addBcc(String[] bccs) {
            this.bcc.addAll(Arrays.asList(bccs));
            return this;
        }

        public Email setBcc(String[] bccs) {
            this.bcc = new ArrayList<String>(Arrays.asList(bccs));
            return this;
        }

        public String[] getBccs() {
            return this.bcc.toArray(new String[this.bcc.size()]);
        }

        public Email setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public String getSubject() {
            return this.subject;
        }

        public Email setText(String text) {
            this.text = text;
            return this;
        }

        public String getText() {
            return this.text;
        }

        public Email setHtml(String html) {
            this.html = html;
            return this;
        }

        public String getHtml() {
            return this.html;
        }

        public Email addSubstitution(String key, String[] val) {
            this.smtpapi.addSubstitutions(key, val);
            return this;
        }

        public JSONObject getSubstitutions() {
            return this.smtpapi.getSubstitutions();
        }

        public Email addUniqueArg(String key, String val) {
            this.smtpapi.addUniqueArg(key, val);
            return this;
        }

        public JSONObject getUniqueArgs() {
            return this.smtpapi.getUniqueArgs();
        }

        public Email addCategory(String category) {
            this.smtpapi.addCategory(category);
            return this;
        }

        public String[] getCategories() {
            return this.smtpapi.getCategories();
        }

        public Email addSection(String key, String val) {
            this.smtpapi.addSection(key, val);
            return this;
        }

        public JSONObject getSections() {
            return this.smtpapi.getSections();
        }

        public Email addFilter(String filter_name, String parameter_name, String parameter_value) {
            this.smtpapi.addFilter(filter_name, parameter_name, parameter_value);
            return this;
        }

        public JSONObject getFilters() {
            return this.smtpapi.getFilters();
        }

        public Email setASMGroupId(int val) {
            this.smtpapi.setASMGroupId(val);
            return this;
        }

        public Integer getASMGroupId() {
            return this.smtpapi.getASMGroupId();
        }

        public Email setSendAt(int sendAt) {
            this.smtpapi.setSendAt(sendAt);
            return this;
        }

        public int getSendAt() {
            return this.smtpapi.getSendAt();
        }

        /**
         * Convenience method to set the template
         *
         * @param templateId The ID string of your template
         * @return this
         */
        public Email setTemplateId(String templateId) {
            this.getSMTPAPI().addFilter("templates", "enable", 1);
            this.getSMTPAPI().addFilter("templates", "template_id", templateId);
            return this;
        }

        public Email addAttachment(String name, File file) throws IOException, FileNotFoundException {
            return this.addAttachment(name, new FileInputStream(file));
        }

        public Email addAttachment(String name, String file) throws IOException {
            return this.addAttachment(name, new ByteArrayInputStream(file.getBytes()));
        }

        public Email addAttachment(String name, InputStream file) throws IOException {
            this.attachments.put(name, file);
            return this;
        }

        public Map<String, InputStream> getAttachments() {
            return this.attachments;
        }

        public Email addContentId(String attachmentName, String cid) {
            this.contents.put(attachmentName, cid);
            return this;
        }

        public Map<String, String> getContentIds() {
            return this.contents;
        }

        public Email addHeader(String key, String val) {
            this.headers.put(key, val);
            return this;
        }

        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public SMTPAPI getSMTPAPI() {
            return this.smtpapi;
        }
    }

    public static class Response {
        private int code;
        private boolean success;
        private String message;

        public Response(int code, String msg) {
            this.code = code;
            this.success = code == 200;
            this.message = msg;
        }

        public int getCode() {
            return this.code;
        }

        public boolean getStatus() {
            return this.success;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
