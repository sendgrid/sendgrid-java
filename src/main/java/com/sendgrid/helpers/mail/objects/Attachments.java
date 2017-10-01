package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.codec.binary.Base64;

import java.io.*;

@JsonInclude(Include.NON_DEFAULT)
public class Attachments {
  @JsonProperty("content") private String content;
  @JsonProperty("type") private String type;
  @JsonProperty("filename") private String filename;
  @JsonProperty("disposition") private String disposition;
  @JsonProperty("content_id") private String contentId;

  @JsonProperty("content") 
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
  
  @JsonProperty("type") 
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("filename") 
  public String getFilename() {
    return filename;
  }
  
  public void setFilename(String filename) {
    this.filename = filename;
  }
  
  @JsonProperty("disposition") 
  public String getDisposition() {
    return disposition;
  }
  
  public void setDisposition(String disposition) {
    this.disposition = disposition;
  }

  @JsonProperty("content_id") 
  public String getContentId() {
    return contentId;
  }
  
  public void setContentId(String contentId) {
    this.contentId = contentId;
  }

  @JsonIgnoreType
  public static class Builder {

    private static final int BYTE_BUFFER_SIZE = 4096;

    private String fileName;
    private String content;
    private String type;
    private String disposition;
    private String contentId;

    public Builder(String fileName, InputStream content) {
      if (fileName == null) {
        throw new IllegalArgumentException("File name mustn't be null");
      }

      if (content == null) {
        throw new IllegalArgumentException("Content mustn't be null");
      }

      this.fileName = fileName;
      this.content = encodeToBase64(content);
    }

    public Builder(String fileName, String content) {
      if (fileName == null) {
        throw new IllegalArgumentException("File name mustn't be null");
      }

      if (content == null) {
        throw new IllegalArgumentException("Content mustn't be null");
      }

      this.fileName = fileName;
      this.content = content;
    }

    private String encodeToBase64(InputStream content) {
      int read = 0;
      byte[] bytes = new byte[BYTE_BUFFER_SIZE];
      try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        while ((read = content.read(bytes)) != -1) {
          baos.write(bytes, 0, read);
        }

        return Base64.encodeBase64String(baos.toByteArray());
      } catch (IOException e) {
        throw new RuntimeException("Unable to convert content stream to base 64 encoded string", e);
      }
    }

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withDisposition(String disposition) {
      this.disposition = disposition;
      return this;
    }

    public Builder withContentId(String contentId) {
      this.contentId = contentId;
      return this;
    }

    public Attachments build() {
      Attachments attachments = new Attachments();
      attachments.setContent(content);
      attachments.setFilename(fileName);
      attachments.setDisposition(disposition);
      attachments.setContentId(contentId);
      attachments.setType(type);
      return attachments;
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((content == null) ? 0 : content.hashCode());
    result = prime * result + ((contentId == null) ? 0 : contentId.hashCode());
    result = prime * result + ((disposition == null) ? 0 : disposition.hashCode());
    result = prime * result + ((filename == null) ? 0 : filename.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Attachments other = (Attachments) obj;
    if (content == null) {
      if (other.content != null)
        return false;
    } else if (!content.equals(other.content))
      return false;
    if (contentId == null) {
      if (other.contentId != null)
        return false;
    } else if (!contentId.equals(other.contentId))
      return false;
    if (disposition == null) {
      if (other.disposition != null)
        return false;
    } else if (!disposition.equals(other.disposition))
      return false;
    if (filename == null) {
      if (other.filename != null)
        return false;
    } else if (!filename.equals(other.filename))
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }
}
