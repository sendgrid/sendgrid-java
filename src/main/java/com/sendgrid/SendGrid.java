package com.sendgrid;

import org.json.JSONObject;
import com.sendgrid.smtpapi.SMTPAPI;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.FileInputStream;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;


public class SendGrid {
  private static final String VERSION           = "1.0.1";
  private static final String USER_AGENT        = "sendgrid/" + VERSION + ";java";

  private static final String PARAM_TO          = "to[%d]";
  private static final String PARAM_TONAME      = "toname[%d]";
  private static final String PARAM_FROM        = "from";
  private static final String PARAM_FROMNAME    = "fromname";
  private static final String PARAM_REPLYTO     = "replyto";
  private static final String PARAM_BCC         = "bcc[%d]";
  private static final String PARAM_SUBJECT     = "subject";
  private static final String PARAM_HTML        = "html";
  private static final String PARAM_TEXT        = "text";
  private static final String PARAM_FILES       = "files[%s]";
  private static final String PARAM_XSMTPAPI    = "x-smtpapi";
  private static final String PARAM_HEADERS     = "headers";

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

    for (int i = 0, len = email.getTos().length; i < len; i++)
      builder.addTextBody(String.format(PARAM_TO, i), email.getTos()[i]);

    for (int i = 0, len = email.getToNames().length; i < len; i++)
      builder.addTextBody(String.format(PARAM_TONAME, i), email.getToNames()[i]);

    for (int i = 0, len = email.getBccs().length; i < len; i++)
      builder.addTextBody(String.format(PARAM_BCC, i), email.getBccs()[i]);
    // Files
    if (email.getAttachments().size() > 0) {
      Iterator it = email.getAttachments().entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry entry = (Map.Entry) it.next();
        builder.addBinaryBody(String.format(PARAM_FILES, entry.getKey()), (InputStream) entry.getValue());
      }
    }

    if (email.getHeaders().size() > 0)
      builder.addTextBody(PARAM_HEADERS, new JSONObject(email.getHeaders()).toString());

    if (email.getFrom() != null && !email.getFrom().isEmpty())
      builder.addTextBody(PARAM_FROM, email.getFrom());

    if (email.getFromName() != null && !email.getFromName().isEmpty())
      builder.addTextBody(PARAM_FROMNAME, email.getFromName());

    if (email.getReplyTo() != null && !email.getReplyTo().isEmpty())
      builder.addTextBody(PARAM_REPLYTO, email.getReplyTo());

    if (email.getSubject() != null && !email.getSubject().isEmpty())
      builder.addTextBody(PARAM_SUBJECT, email.getSubject());

    if (email.getHtml() != null && !email.getHtml().isEmpty())
      builder.addTextBody(PARAM_HTML, email.getHtml());

    if (email.getText() != null && !email.getText().isEmpty())
      builder.addTextBody(PARAM_TEXT, email.getText());

    if (!email.getSMTPAPI().jsonString().equals("{}")) {
      builder.addTextBody(PARAM_XSMTPAPI, email.getSMTPAPI().jsonString());
    }
    return builder.build();
  }

  public SendGrid.Response send(Email email) throws SendGridException {
    HttpPost httppost = new HttpPost(this.url + this.endpoint);
    httppost.setEntity(this.buildBody(email));
    try {
      HttpResponse res = this.client.execute(httppost);
      return new SendGrid.Response(res.getStatusLine().getStatusCode(), EntityUtils.toString(res.getEntity()));
    } catch (IOException e) {
      return new SendGrid.Response(500, "Problem connecting to SendGrid");
    }

  }

  public static class Email {
    private SMTPAPI smtpapi;
    private ArrayList<String> to;
    private ArrayList<String> toname;
    private String from;
    private String fromname;
    private String replyto;
    private String subject;
    private String text;
    private String html;
    private ArrayList<String> bcc;
    private Map attachments;
    private Map headers;

    public Email () {
      this.smtpapi = new SMTPAPI();
      this.to = new ArrayList<String>();
      this.toname = new ArrayList<String>();
      this.bcc = new ArrayList<String>();
      this.attachments = new HashMap();
      this.headers = new HashMap();
    }

    public Email addTo(String to) {
      this.smtpapi.addTo(to);
      this.to.add(to);
      return this;
    }

    public Email addTo(String[] tos) {
      this.smtpapi.addTos(tos);
      this.to.addAll(Arrays.asList(tos));
      return this;
    }

    public Email setTo(String[] tos) {
      this.smtpapi.setTos(tos);
      this.to = new ArrayList(Arrays.asList(tos));
      return this;
    }

    public String[] getTos() {
      return this.to.toArray(new String[this.to.size()]);
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
      this.toname = new ArrayList(Arrays.asList(tonames));
      return this;
    }

    public String[] getToNames() {
      return this.toname.toArray(new String[this.toname.size()]);
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
      this.bcc = new ArrayList(Arrays.asList(bccs));
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

    public Email dropSMTPAPITos() {
      JSONObject oldHeader = new JSONObject(this.smtpapi.jsonString());
      oldHeader.remove("to");
      this.smtpapi = new SMTPAPI(oldHeader);
      return this;
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

    public Map getAttachments() {
      return this.attachments;
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
