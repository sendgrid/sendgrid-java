package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.codec.binary.Base64;

import java.io.*;

/**
 * A JSON-serializable model of an email attachment.
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
     * disposition is set to {@code "inline"} and the attachment
     * is an image, allowing the file to be displayed within 
     * the body of your email.
     */
    @JsonProperty("content_id")
    private String contentId;

    /**
     * Gets the attachment content.
     *
     * @return the content.
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * Sets the attachment content.
     *
     * @param content the content.
     * @return {@code this} for chaining.
     */
    public Attachment content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Gets the mime type of the content you are attaching. For example,
     * {@link ContentType#TEXT_PLAIN} or {@link ContentType#TEXT_HTML}.
     *
     * @return the mime type.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Sets the mime type of the content.
     *
     * @param type the mime type.
     * @return {@code this} for chaining.
     */
    public Attachment type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Gets the filename for this attachment.
     *
     * @return the file name.
     */
    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the filename for this attachment.
     *
     * @param filename the filename.
     * @return {@code this} for chaining.
     */
    public Attachment filename(String filename) {
        this.filename = filename;
        return this;
    }

    /**
     * Gets the content-disposition of the attachment specifying
     * how you would like the attachment to be displayed. 
     * For example, {@code "inline"} results in the attached file
     * being displayed automatically within the message 
     * while {@code “attachment”} results in the attached file
     * requiring some action to be taken before it is 
     * displayed (e.g. opening or downloading the file).
     *
     * @return the disposition.
     */
    @JsonProperty("disposition")
    public String getDisposition() {
        return disposition;
    }

    /**
     * Sets the content-disposition of the attachment.
     *
     * @param disposition the disposition.
     * @return {@code this} for chaining.
     */
    public Attachment disposition(String disposition) {
        this.disposition = disposition;
        return this;
    }

    /**
     * Gets the attachment content ID. This is used when the
     * disposition is set to {@code "inline"} and the attachment
     * is an image, allowing the file to be displayed within 
     * the body of your email.
     *
     * @return the content ID.
     */
    @JsonProperty("content_id")
    public String getContentId() {
        return contentId;
    }

    /**
     * Sets the content ID.
     *
     * @param contentId the content ID.
     * @return {@code this} for chaining.
     */
    public Attachment contentId(String contentId) {
        this.contentId = contentId;
        return this;
    }

    /**
     * A builder for creating {@link Attachment}s.
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
         * Creates a new builder, for creating an {@link Attachment}.
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
         * Creates a new builder, for creating an {@link Attachment}.
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
         * Sets the type of this attachment builder.
         *
         * @param type the attachment type.
         * @return {@code this} for chaining.
         */
        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        /**
         * Sets the disposition of this attachment builder.
         *
         * @param disposition the disposition.
         * @return {@code this} for chaining.
         */
        public Builder withDisposition(String disposition) {
            this.disposition = disposition;
            return this;
        }

        /**
         * Sets the content ID of this attachment builder.
         *
         * @param contentId the content ID.
         * @return {@code this} for chaining.
         */
        public Builder withContentId(String contentId) {
            this.contentId = contentId;
            return this;
        }

        /**
         * Creates the attachment model, from the specified arguments.
         *
         * @return the constructed attachment model.
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
