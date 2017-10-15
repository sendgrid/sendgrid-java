package com.sendgrid;

/**
 * Pseudo-enumeration of Content-Types.
 *
 * @author Marcos Barbero
 */
public class ContentType {

    /**
     * Public constant media type that includes all media ranges (i.e. "&#42;/&#42;").
     */
    public static final String ALL = "*/*";

    /**
     * Public constant media type for {@code application/atom+xml}.
     */
    public final static String APPLICATION_ATOM_XML = "application/atom+xml";

    /**
     * Public constant media type for {@code application/x-www-form-urlencoded}.
     */
    public final static String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";

    /**
     * Public constant media type for {@code application/json}.
     */
    public final static String APPLICATION_JSON = "application/json";

    /**
     * Public constant media type for {@code application/json;charset=UTF-8}.
     */
    public final static String APPLICATION_JSON_UTF8 = APPLICATION_JSON + ";charset=UTF-8";

    /**
     * Public constant media type for {@code application/octet-stream}.
     */
    public final static String APPLICATION_OCTET_STREAM = "application/octet-stream";

    /**
     * Public constant media type for {@code application/pdf}.
     */
    public final static String APPLICATION_PDF = "application/pdf";

    /**
     * Public constant media type for {@code application/xhtml+xml}.
     */
    public final static String APPLICATION_XHTML_XML = "application/xhtml+xml";

    /**
     * Public constant media type for {@code application/xml}.
     */
    public final static String APPLICATION_XML = "application/xml";

    /**
     * Public constant media type for {@code image/gif}.
     */
    public final static String IMAGE_GIF = "image/gif";

    /**
     * Public constant media type for {@code image/jpeg}.
     */
    public final static String IMAGE_JPEG = "image/jpeg";

    /**
     * Public constant media type for {@code image/png}.
     */
    public final static String IMAGE_PNG = "image/png";

    /**
     * Public constant media type for {@code multipart/form-data}.
     */
    public final static String MULTIPART_FORM_DATA = "multipart/form-data";

    /**
     * Public constant media type for {@code text/html}.
     */
    public final static String TEXT_HTML = "text/html";

    /**
     * Public constant media type for {@code text/markdown}.
     */
    public final static String TEXT_MARKDOWN = "text/markdown";

    /**
     * Public constant media type for {@code text/plain}.
     */
    public final static String TEXT_PLAIN = "text/plain";

    /**
     * Public constant media type for {@code text/xml}.
     */
    public final static String TEXT_XML = "text/xml";
}
