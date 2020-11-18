package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary.Base64;

/**
 * An attachment object.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Attachments {

  /** The attachment content. */
  @JsonProperty("content")
  private String content;

  /**
   * The mime type of the content you are attaching. For example, “text/plain” or “text/html”.
   */
  @JsonProperty("type")
  private String type;

  /** The attachment file name. */
  @JsonProperty("filename")
  private String filename;

  /** The attachment disposition. */
  @JsonProperty("disposition")
  private String disposition;

  /**
   * The attachment content ID. This is used when the disposition is set to “inline” and the
   * attachment is an image, allowing the file to be displayed within the body of your email.
   */
  @JsonProperty("content_id")
  private String contentId;

  /**
   * Get the attachment's content.
   *
   * @return the content.
   */
  @JsonProperty("content")
  public String getContent() {
    return content;
  }

  /**
   * Set the attachment's content.
   *
   * @param content the content.
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Get the mime type of the content you are attaching. For example, “text/plain” or “text/html”.
   *
   * @return the mime type.
   */
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  /**
   * Set the mime type of the content.
   *
   * @param type the mime type.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Get the filename for this attachment.
   *
   * @return the file name.
   */
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }

  /**
   * Set the filename for this attachment.
   *
   * @param filename the filename.
   */
  public void setFilename(String filename) {
    this.filename = filename;
  }

  /**
   * Get the content-disposition of the attachment specifying how you would like the attachment to
   * be displayed. For example, “inline” results in the attached file being displayed automatically
   * within the message while “attachment” results in the attached file requiring some action to be
   * taken before it is displayed (e.g. opening or downloading the file).
   *
   * @return the disposition.
   */
  @JsonProperty("disposition")
  public String getDisposition() {
    return disposition;
  }

  /**
   * Set the content-disposition of the attachment.
   *
   * @param disposition the disposition.
   */
  public void setDisposition(String disposition) {
    this.disposition = disposition;
  }

  /**
   * Get the attachment content ID. This is used when the disposition is set to “inline” and the
   * attachment is an image, allowing the file to be displayed within the body of your email.
   *
   * @return the content ID.
   */
  @JsonProperty("content_id")
  public String getContentId() {
    return contentId;
  }

  /**
   * Set the content ID.
   *
   * @param contentId the content ID.
   */
  public void setContentId(String contentId) {
    this.contentId = contentId;
  }

  /**
   * A helper object to construct usable attachments.
   */
  @JsonIgnoreType
  public static class Builder {

    private static final int BYTE_BUFFER_SIZE = 4096;

    private String fileName;
    private String content;
    private String type;
    private String disposition;
    private String contentId;

    /**
     * Construct a new attachment builder.
     *
     * @param fileName the filename to include.
     * @param content an input stream for the content.
     * @throws IllegalArgumentException in case either the fileName or the content is null.
     */
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

    /**
     * Construct a new attachment builder.
     *
     * @param fileName the filename to include.
     * @param content an input string for the content.
     * @throws IllegalArgumentException in case either the fileName or the content is null.
     */
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
      try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        while ((read = content.read(bytes)) != -1) {
          baos.write(bytes, 0, read);
        }

        return Base64.encodeBase64String(baos.toByteArray());
      } catch (IOException e) {
        throw new RuntimeException("Unable to convert content stream to base 64 encoded string", e);
      }
    }

    /**
     * Set the type of this attachment builder.
     *
     * @param type the attachment type.
     * @return attachment builder object.
     */
    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the disposition of this attachment builder.
     *
     * @param disposition the disposition.
     * @return attachment builder object.
     */
    public Builder withDisposition(String disposition) {
      this.disposition = disposition;
      return this;
    }

    /**
     * Set the content ID of this attachment builder.
     *
     * @param contentId the content ID.
     * @return attachment builder object.
     */
    public Builder withContentId(String contentId) {
      this.contentId = contentId;
      return this;
    }

    /**
     * Construct the attachments object.
     * @return the attachments object constructed.
     */
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
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Attachments other = (Attachments) obj;
    if (content == null) {
      if (other.content != null) {
        return false;
      }
    } else if (!content.equals(other.content)) {
      return false;
    }
    if (contentId == null) {
      if (other.contentId != null) {
        return false;
      }
    } else if (!contentId.equals(other.contentId)) {
      return false;
    }
    if (disposition == null) {
      if (other.disposition != null) {
        return false;
      }
    } else if (!disposition.equals(other.disposition)) {
      return false;
    }
    if (filename == null) {
      if (other.filename != null) {
        return false;
      }
    } else if (!filename.equals(other.filename)) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }
    return true;
  }
}
