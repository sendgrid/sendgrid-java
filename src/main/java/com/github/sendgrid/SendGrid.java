package com.github.sendgrid;

import com.github.kevinsawicki.http.HttpRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class SendGrid {
  private static final String PARAM_API_USER        = "api_user";
  private static final String PARAM_API_KEY         = "api_key";
  private static final String PARAM_TOS             = "to[]";
  private static final String PARAM_TONAMES         = "toname[]";
  private static final String PARAM_BCC             = "bcc";
  private static final String PARAM_FROM            = "from";
  private static final String PARAM_FROMNAME        = "fromname";
  private static final String PARAM_REPLYTO         = "replyto";
  private static final String PARAM_SUBJECT         = "subject";
  private static final String PARAM_HTML            = "html";
  private static final String PARAM_TEXT            = "text";
  private static final String PARAM_FILES           = "files[%s]";
  private static final String PARAM_HEADERS         = "headers";

  private static final String SMTP_API_HEADER       = "X-SMTPAPI";
  private static final String CATEGORY_KEY          = "category";
  private static final String FILTERS_KEY           = "filters";
  private static final String SETTINGS_KEY          = "settings";

  private String username;
  private String password;
  private ArrayList<String> tos = new ArrayList<>();
  private ArrayList<String> tonames = new ArrayList<>();
  private String bcc;
  private String from;
  private String fromname;
  private String replyto;
  private String subject;
  private String text;
  private String html;
  private ArrayList<Attachment> attachments = new ArrayList<Attachment>();
  private JSONObject headers = new JSONObject();
  
  public SendGrid(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String send() {
    return this.web();
  } 

  public String web() {
    HttpRequest request = HttpRequest.post("https://api.sendgrid.com/api/mail.send.json");

    if (this.username != null) {
      request.part(PARAM_API_USER,  this.username);
    }
    if (this.password != null) {
      request.part(PARAM_API_KEY,   this.password);
    }
    for (String to:this.getTos()) {
      request.part(PARAM_TOS,     to);
    }
    for (String toname:this.getToNames()) {
      request.part(PARAM_TONAMES,     toname);
    }
    if (this.getFrom() != null) {
      request.part(PARAM_FROM,      this.getFrom());
    }
    if (this.getFromName() != null) {
      request.part(PARAM_FROMNAME,  this.getFromName());
    }
    if (this.getReplyTo() != null) {
      request.part(PARAM_REPLYTO, this.getReplyTo());
    }
    if (this.getSubject() != null) {
      request.part(PARAM_SUBJECT,   this.getSubject());
    }
    if (this.getText() != null) {
      request.part(PARAM_TEXT,    this.getText());
    }
    if (this.getHtml() != null) {
      request.part(PARAM_HTML,    this.getHtml());
    }
    if (this.getBcc() != null) {
      request.part(PARAM_BCC, this.getBcc());
    }
    for (Attachment attachment:this.getAttachments()) {
      request.part(String.format(PARAM_FILES, attachment.name), attachment.contents);
    }
    request.part(PARAM_HEADERS,   this.getHeaders().toString());

    return request.body();
  }

  public ArrayList<String> getTos() {
    return this.tos;
  }

  public ArrayList<String> getToNames() {
    return this.tonames;
  }

  public String getBcc() {
    return this.bcc;
  }

  public String getFrom() {
    return this.from;
  }

  public String getFromName() {
    return this.fromname;
  }

  public String getReplyTo() {
    return this.replyto;
  }

  public String getSubject() {
    return this.subject;
  }

  public String getText() {
    return this.text;
  }

  public String getHtml() {
    return this.html;
  }

  public ArrayList<Attachment> getAttachments() {
    return this.attachments;
  }

  public JSONObject getHeaders() {
    return this.headers;
  }

  public SendGrid addTo(String email) {
    this.tos.add(email);
    return this;
  }

  public SendGrid addToName(String name) {
    this.tonames.add(name);
    return this;
  }

  public SendGrid setFrom(String email) {
    this.from = email;
    return this;
  }

  public SendGrid setFromName(String name) {
    this.fromname = name;
    return this;
  }

  public SendGrid setReplyTo(String email) {
    this.replyto = email;
    return this;
  }

  public SendGrid setBcc(String bcc) {
    this.bcc = bcc;
    return this;
  }

  public SendGrid setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public SendGrid setText(String text) {
    this.text = text;
    return this;
  }

  public SendGrid setHtml(String html) {
    this.html = html;
    return this;
  }

  public SendGrid addFile(Attachment attachment) {
    this.addAttachment(attachment);
    return this;
  }

  public SendGrid addFile(File file) throws FileNotFoundException {
    this.addAttachment(file);
    return this;
  }

  public SendGrid addAttachment(Attachment attachment) {
    this.attachments.add(attachment);
    return this;
  }

  public SendGrid addAttachment(File file) throws FileNotFoundException {
    SendGrid.Attachment attachment = new SendGrid.Attachment(file);
    this.addAttachment(attachment);
    return this;
  }

  public SendGrid addHeader(String key, String value) {
    try {
      this.headers.put(key, value);
    } catch(Exception e){
      e.printStackTrace();
    }

    return this;
  }

  public static class Attachment {
    public final String name;
    public final InputStream contents;

    public Attachment(File file) throws FileNotFoundException {
      this.name = file.getName();
      this.contents = new FileInputStream(file);
    }

    public Attachment(String name, InputStream contents) {
      this.name = name;
      this.contents = contents;
    }
  }

    /**
     * Adds support for additional filters/apps in the SendGrid API mail model. A filter is also known as an app that
     * integrates with SendGrid, such as <b>Google Analytics</b>. More information on filters/apps that integrate with
     * the SendGrid service can be found in their <a href="http://sendgrid.com/docs/API_Reference/SMTP_API/apps.html">documentation</a>.
     *
     * @param filter String that represents the App
     * @param key    Property to be set for the given filter/app
     * @param value  The value to be set for the property.
     * @return Current instance of the {@link SendGrid} object.
     */
    public SendGrid addFilter(String filter, String key, Object value) throws JSONException {
        JSONObject smtpApiHeader;

        if (!this.getHeaders().has(SMTP_API_HEADER)) {
            final JSONObject individualFilterObject = new JSONObject().put(filter, new JSONObject().put(SETTINGS_KEY, new JSONObject().put(key, value)));

            smtpApiHeader = new JSONObject().accumulate(FILTERS_KEY, individualFilterObject);
        } else {
            smtpApiHeader = new JSONObject(this.getHeaders().get(SMTP_API_HEADER).toString());

            if (!smtpApiHeader.has(FILTERS_KEY)) {
                final JSONObject individualFilterObject = new JSONObject().put(filter, new JSONObject().put(SETTINGS_KEY, new JSONObject().put(key, value)));

                smtpApiHeader.accumulate(FILTERS_KEY, individualFilterObject);
            } else {
                if (smtpApiHeader.get(FILTERS_KEY) instanceof JSONObject) {
                    final JSONObject parentFiltersObject = smtpApiHeader.getJSONObject(FILTERS_KEY);

                    if(!parentFiltersObject.has(filter)) {
                        smtpApiHeader.accumulate(FILTERS_KEY, new JSONObject().put(filter, new JSONObject().put(SETTINGS_KEY, new JSONObject().put(key, value))));
                    } else {
                        parentFiltersObject.getJSONObject(filter).getJSONObject(SETTINGS_KEY).put(key, value);
                    }
                } else {
                    final JSONArray parentFiltersObject = smtpApiHeader.getJSONArray(FILTERS_KEY);

                    for(int i=0; i<parentFiltersObject.length(); i++) {
                        final JSONObject filter1 = parentFiltersObject.getJSONObject(i);

                        if(filter1.keys().next().toString().equalsIgnoreCase(filter)) {
                            filter1.getJSONObject(filter).getJSONObject(SETTINGS_KEY).put(key, value);
                            break;
                        }
                    }
                }
            }
        }

        this.addHeader(SMTP_API_HEADER, smtpApiHeader.toString());

        return this;
    }

    /**
     * Adds an email category to an email flowing through the SendGrid API. This is set individually of filters/apps as
     * categories is in essence its own filter/app with no extra parameters. Handles duplicate categories by simply not
     * adding the category to the list.
     *
     * @param category Name of the category to send to SendGrid.
     * @return Current instance of {@link SendGrid} object.
     */
    public SendGrid addCategory(String category) throws JSONException {
        JSONObject smtpApiHeader;

        if (!this.getHeaders().has(SMTP_API_HEADER)) {
            smtpApiHeader = new JSONObject().put(CATEGORY_KEY, new JSONArray("[" + category + "]"));
        } else {
            smtpApiHeader = new JSONObject(this.getHeaders().get(SMTP_API_HEADER).toString());

            if (smtpApiHeader.has(CATEGORY_KEY)) {

                // Determines if this is a duplicate category.
                boolean isAddable = true;
                final JSONArray array = smtpApiHeader.getJSONArray(CATEGORY_KEY);
                for (int i = 0; i < array.length(); i++) {
                    if (category.equalsIgnoreCase(array.getString(i))) {
                        isAddable = false;
                        break;
                    }
                }

                // Can only add up to 10 categories in one email.
                if (isAddable && array.length() <= 9) {
                    smtpApiHeader.accumulate(CATEGORY_KEY, category);
                }
            } else {
                smtpApiHeader.put(CATEGORY_KEY, new JSONArray("[" + category + "]"));
            }
        }

        this.addHeader(SMTP_API_HEADER, smtpApiHeader.toString());

        return this;
    }
}
