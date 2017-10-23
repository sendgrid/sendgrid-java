package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.codec.binary.Base64;

import java.io.*;

/**
 * An attachment object.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Attachment {

    @JsonProperty("content")
    private String content;

    @JsonProperty("type")
    private String type;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("disposition")
    private String disposition;

    /** 
     * The attachment content ID. This is used when the 
     * disposition is set to “inline” and the attachment 
     * is an image, allowing the file to be displayed within 
     * the body of your email. 
     */
    @JsonProperty("content_id")
    private String contentId;

    /**
     * Get the attachment's content.
     * @return the content.
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * Set the attachment's content.
     * @param content the content.
     * @return this object.
     */
    public Attachment content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Get the mime type of the content you are attaching. For example, 
     * “text/plain” or “text/html”.
     * @return the mime type.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Set the mime type of the content.
     * @param type the mime type.
     * @return this object.
     */
    public Attachment type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the filename for this attachment.
     * @return the file name.
     */
    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    /**
     * Set the filename for this attachment.
     * @param filename the filename.
     * @return this object.
     */
    public Attachment filename(String filename) {
        this.filename = filename;
        return this;
    }

    /**
     * Get the content-disposition of the attachment specifying 
     * how you would like the attachment to be displayed. 
     * For example, “inline” results in the attached file 
     * being displayed automatically within the message 
     * while “attachment” results in the attached file 
     * requiring some action to be taken before it is 
     * displayed (e.g. opening or downloading the file).
     * @return the disposition.
     */
    @JsonProperty("disposition")
    public String getDisposition() {
        return disposition;
    }

    /**
     * Set the content-disposition of the attachment.
     * @param disposition the disposition.
     * @return this object.
     */
    public Attachment disposition(String disposition) {
        this.disposition = disposition;
        return this;
    }

    /**
     * Get the attachment content ID. This is used when the 
     * disposition is set to “inline” and the attachment 
     * is an image, allowing the file to be displayed within 
     * the body of your email. 
     * @return the content ID.
     */
    @JsonProperty("content_id")
    public String getContentId() {
        return contentId;
    }

    /**
     * Set the content ID.
     * @param contentId the content ID.
     * @return this object.
     */
    public Attachment contentId(String contentId) {
        this.contentId = contentId;
        return this;
    }

    /**
     * A helper object to construct usable attachment.
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
         * @param type the attachment type.
         */
        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        /**
         * Set the disposition of this attachment builder.
         * @param disposition the disposition.
         */
        public Builder withDisposition(String disposition) {
            this.disposition = disposition;
            return this;
        }

        /**
         * Set the content ID of this attachment builder.
         * @param contentId the content ID.
         */
        public Builder withContentId(String contentId) {
            this.contentId = contentId;
            return this;
        }

        /**
         * Construct the attachment object.
         */
        public Attachment build() {
            Attachment attachment = new Attachment()
                .content(content)
                .filename(fileName)
                .disposition(disposition)
                .contentId(contentId)
                .type(type);
            return attachment;
        }
    }
}
