package com.sendgrid;

import com.sendgrid.smtpapi.SMTPAPI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SendGrid {
    private static final String VERSION = "2.1.0";
    private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";

    private static final String PARAM_TO            = "to[%d]";
    private static final String PARAM_TONAME        = "toname[%d]";
    private static final String PARAM_CC            = "cc[%d]";
    private static final String PARAM_FROM          = "from";
    private static final String PARAM_FROMNAME      = "fromname";
    private static final String PARAM_REPLYTO       = "replyto";
    private static final String PARAM_BCC           = "bcc[%d]";
    private static final String PARAM_SUBJECT       = "subject";
    private static final String PARAM_HTML          = "html";
    private static final String PARAM_TEXT          = "text";
    private static final String PARAM_FILES         = "files[%s]";
    private static final String PARAM_CONTENTS      = "content[%s]";
    private static final String PARAM_XSMTPAPI      = "x-smtpapi";
    private static final String PARAM_HEADERS       = "headers";
    private static final String PARAM_AUTHORIZATION = "AUTHORIZATION";

    private static final String TEXT_PLAIN          = "text/plain";
    private static final String UTF_8               = "UTF-8";

    private String username;
    private String password;
    private String url;
    private String port;
    private String endpoint;
    private CloseableHttpClient client;

    public SendGrid(String username, String password) {
        this.username = username;
        this.password = password;
        this.url = "https://api.sendgrid.com";
        this.endpoint = "/api/mail.send.json";
        this.client = HttpClientBuilder.create().setUserAgent(USER_AGENT).build();
    }

    public SendGrid setUrl(String url) {
        this.url = url;
        return this;
    }

    public SendGrid setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public String getVersion() {
        return VERSION;
    }

    public SendGrid setClient(CloseableHttpClient client) {
        this.client = client;
        return this;
    }

    public HttpEntity buildBody(Email email) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        builder.addTextBody("api_user", this.username);
        builder.addTextBody("api_key", this.password);

        String[] tos = email.getTos();
        String[] tonames = email.getToNames();
        String[] ccs = email.getCcs();
        String[] bccs = email.getBccs();

        // If SMTPAPI Header is used, To is still required. #workaround.
        if (tos.length == 0) {
            builder.addTextBody(String.format(PARAM_TO, 0), email.getFrom(), ContentType.create(TEXT_PLAIN, UTF_8));
        }
        for (int i = 0, len = tos.length; i < len; i++)
            builder.addTextBody(String.format(PARAM_TO, i), tos[i], ContentType.create(TEXT_PLAIN, UTF_8));
        for (int i = 0, len = tonames.length; i < len; i++)
            builder.addTextBody(String.format(PARAM_TONAME, i), tonames[i], ContentType.create(TEXT_PLAIN, UTF_8));
        for (int i = 0, len = ccs.length; i < len; i++)
            builder.addTextBody(String.format(PARAM_CC, i), ccs[i], ContentType.create(TEXT_PLAIN, UTF_8));
        for (int i = 0, len = bccs.length; i < len; i++)
            builder.addTextBody(String.format(PARAM_BCC, i), bccs[i], ContentType.create(TEXT_PLAIN, UTF_8));
        // Files
        if (email.getAttachments().size() > 0) {
            for (Object o : email.getAttachments().entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                builder.addBinaryBody(String.format(PARAM_FILES, entry.getKey()), (InputStream) entry.getValue());
            }
        }

        if (email.getContentIds().size() > 0) {
            for (Object o : email.getContentIds().entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                builder.addTextBody(String.format(PARAM_CONTENTS, entry.getKey()), (String) entry.getValue());
            }
        }

        if (email.getHeaders().size() > 0)
            builder.addTextBody(PARAM_HEADERS, new JSONObject(email.getHeaders()).toString(), ContentType.create(TEXT_PLAIN, UTF_8));

        if (email.getFrom() != null && !email.getFrom().isEmpty())
            builder.addTextBody(PARAM_FROM, email.getFrom(), ContentType.create(TEXT_PLAIN, UTF_8));

        if (email.getFromName() != null && !email.getFromName().isEmpty())
            builder.addTextBody(PARAM_FROMNAME, email.getFromName(), ContentType.create(TEXT_PLAIN, UTF_8));

        if (email.getReplyTo() != null && !email.getReplyTo().isEmpty())
            builder.addTextBody(PARAM_REPLYTO, email.getReplyTo(), ContentType.create(TEXT_PLAIN, UTF_8));

        if (email.getSubject() != null && !email.getSubject().isEmpty())
            builder.addTextBody(PARAM_SUBJECT, email.getSubject(), ContentType.create(TEXT_PLAIN, UTF_8));

        if (email.getHtml() != null && !email.getHtml().isEmpty())
            builder.addTextBody(PARAM_HTML, email.getHtml(), ContentType.create(TEXT_PLAIN, UTF_8));

        if (email.getText() != null && !email.getText().isEmpty())
            builder.addTextBody(PARAM_TEXT, email.getText(), ContentType.create(TEXT_PLAIN, UTF_8));

        if (!email.smtpapi.jsonString().equals("{}") || email.isUseActiveTemplate()) {
            if(email.isUseActiveTemplate()) {
                Template activeTemplate = this.getActiveTemplate();
                if(activeTemplate != null) {
                    email.getSMTPAPI().addFilter("templates", "enabled", 1);
                    email.getSMTPAPI().addFilter("templates", "template_id", activeTemplate.getId());
                }
            }
            builder.addTextBody(PARAM_XSMTPAPI, email.smtpapi.jsonString(), ContentType.create(TEXT_PLAIN, UTF_8));
        }

        return builder.build();
    }

    /**
     * Gets a template which has one active version
     * @return A {@link com.sendgrid.SendGrid.Template}
     */
    private Template getActiveTemplate() {
        try {
            List<Template> templates = this.getTemplates();
            for(Template template : templates) {
                for(Template.Version version : template.getVersions()) {
                    if(version.isActive()) {
                        return template;
                    }
                }
            }
        } catch (SendGridException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get all the created Templates
     * @return List of available templates
     * @throws SendGridException
     */
    public List<SendGrid.Template> getTemplates() throws SendGridException {
        List<Template> availableTemplates = null;
        HttpGet httpGet = new HttpGet(this.url+"/v3/templates");
        httpGet.addHeader(PARAM_AUTHORIZATION, "Basic "+ Base64.getEncoder()
                .encodeToString((this.username+":"+this.password).getBytes()));
        try {
            HttpResponse response = this.client.execute(httpGet);
            String responseJson = EntityUtils.toString(response.getEntity());
            System.out.println(responseJson);
            // Checks if it is 100 something or 200 something and
            // more importantly it is not 40 something or 500 something
            if (response.getStatusLine().getStatusCode()<300) {
                JSONObject jsonObject = new JSONObject(responseJson);
                JSONArray templatesArray = jsonObject.getJSONArray("templates");
                if (templatesArray.length()>0) {
                    availableTemplates = new ArrayList<Template>();
                    for(int i=0; i<templatesArray.length(); i++) {
                        JSONObject templateJson = templatesArray.getJSONObject(i);
                        Template template = convertToTemplate(templateJson);
                        availableTemplates.add(template);
                    }
                }
            }
        } catch (IOException e) {
            throw new SendGridException(e);
        } catch (ParseException e) {
            throw new SendGridException(e);
        }
        return availableTemplates;
    }

    /**
     * Converts the JSON object of {@link com.sendgrid.SendGrid.Template} to <code>Template</code> object
     * @param templateJson    JSON of the template object
     * @return The Template object
     * @throws ParseException
     */
    private Template convertToTemplate(JSONObject templateJson) throws ParseException {
        Template template = new Template(templateJson.getString("id"));
        template.name = templateJson.getString("name");
        JSONArray versionsArray = templateJson.getJSONArray("versions");
        for(int i=0; i<versionsArray.length(); i++) {
            JSONObject versionJson = versionsArray.getJSONObject(i);
            Template.Version version = new Template.Version(versionJson.getString("id"));
            version.templateId = versionJson.getString("template_id");
            version.active = versionJson.getInt("active") == 1;
            version.name = versionJson.getString("name");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            version.updatedAt = dateFormat.parse(versionJson.getString("updated_at"));
            template.getVersions().add(version);
        }
        return template;
    }

    public SendGrid.Response send(Email email) throws SendGridException {
        HttpPost httppost = new HttpPost(this.url + this.endpoint);
        httppost.setEntity(this.buildBody(email));
        try {
            HttpResponse res = this.client.execute(httppost);
            return new SendGrid.Response(res.getStatusLine().getStatusCode(), EntityUtils.toString(res.getEntity()));
        } catch (IOException e) {
            throw new SendGridException(e);
        }
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
        private boolean useActiveTemplate;
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

        public Email addAttachment(String name, File file) throws IOException {
            return this.addAttachment(name, new FileInputStream(file));
        }

        public Email addAttachment(String name, String file) throws IOException {
            return this.addAttachment(name, new ByteArrayInputStream(file.getBytes()));
        }

        public Email addAttachment(String name, InputStream file) throws IOException {
            this.attachments.put(name, file);
            return this;
        }

        public Map getAttachments() {
            return this.attachments;
        }

        public Email addContentId(String attachmentName, String cid) {
            this.contents.put(attachmentName, cid);
            return this;
        }

        public Map getContentIds() {
            return this.contents;
        }

        public Email addHeader(String key, String val) {
            this.headers.put(key, val);
            return this;
        }

        public Map getHeaders() {
            return this.headers;
        }

        public SMTPAPI getSMTPAPI() {
            return this.smtpapi;
        }

        public boolean isUseActiveTemplate() {
            return this.useActiveTemplate;
        }

        public void setUseActiveTemplate(boolean useActiveTemplate) {
            this.useActiveTemplate = useActiveTemplate;
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

    public static class Template {
        private String id;
        private String name;
        private List<Version> versions;

        public Template(String id) {
            this.id = id;
            this.versions = new ArrayList<Version>();
        }

        public static class Version {
            private String id;
            private String templateId;
            private boolean active;
            private String name;
            private Date updatedAt;

            public Version(String id) {
                this.id = id;
            }

            public String getId() {
                return this.id;
            }

            public String getTemplateId() {
                return this.templateId;
            }

            public boolean isActive() {
                return this.active;
            }

            public String getName() {
                return this.name;
            }

            public Date getUpdatedAt() {
                return this.updatedAt;
            }
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public List<Version> getVersions() {
            return this.versions;
        }
    }
}
